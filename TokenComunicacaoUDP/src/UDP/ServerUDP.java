
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Servidor;
import thread.ClienteThread;

public class ServerUDP implements Runnable{

    public static volatile List<String> remocoesPendentes = new ArrayList<>();
    static List<ClienteThread> clientes;
    Random gerador = new Random();
    static Servidor servidor = new Servidor();
    DatagramSocket socket;
    String retorno;
    
    public ServerUDP(List<ClienteThread> clientes) {
        
        this.clientes = clientes;
        iniciarConexaoCliente();
        
    }
    
    public static synchronized void removerToken(String token){
        
        clientes.removeIf(c -> c.getToken().equals(token));
        servidor.removeToken(Integer.parseInt(token));
        
    }

    @Override
    public void run() {
        try {
            while (true) {
                
                byte[] dados = new byte[1024];

                DatagramPacket pacote = new DatagramPacket(
                        dados, dados.length
                );

                socket.receive(pacote);

                String mensagem = new String(
                        pacote.getData(), 0, pacote.getLength()
                );

                System.out.println("Solicitacao recebida: " + mensagem);

                if (mensagem.equals("PEDIR_TOKEN")) {
                    clientes.add(new ClienteThread(enviaToken(
                                                            pacote.getAddress().getHostAddress(),
                                                            pacote.getPort()
                                                            )
                                                   )
                                );
                    clientes.get(clientes.size()-1).start();
                }
                else{

                    retorno = "Erro";
                    
                    for (int i = 0; i < clientes.size(); i++){

                        if (clientes.get(i).equals(mensagem.substring(0,4))){
                            
                            clientes.get(i).addDados(mensagem.substring(4,mensagem.length()));
                            i = clientes.size();
                            
                            retorno = "Certo";
                            
                        }

                    }
                    
                    DatagramPacket resposta = ComunicadorUDP.montaMensagem(
                                                                        retorno, 
                                                                        pacote.getAddress().getHostAddress(),
                                                                        pacote.getPort()
                                                                          );
                    ComunicadorUDP.enviaMensagem(socket, resposta);

                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao receber solicitacao: " + ex.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    private String enviaToken(String endereco, int porta) {

        DatagramPacket pacote = ComunicadorUDP.montaMensagem(
                String.valueOf(servidor.addToken()), endereco, porta
        );
        ComunicadorUDP.enviaMensagem(socket, pacote);
        System.out.println("Token enviado: " + servidor.uToken());
        
        return servidor.uToken().toString();
        
    }

    private void iniciarConexaoCliente() {
        try {
            socket = new DatagramSocket(1234);
        } catch (Exception ex) {
            System.out.println("Erro ao criar o socket: " + ex.getMessage());
        }
    }
    
}
