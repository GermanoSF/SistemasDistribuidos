
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;
import model.Servidor;

public class ServerUDP {

    Random gerador = new Random();
    Servidor servidor = new Servidor();

    public ServerUDP() {

        recebeSolicitacoes();
        
    }

    private void recebeSolicitacoes() {
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
                    enviaToken(
                            pacote.getAddress().getHostAddress(),
                            pacote.getPort()
                    );
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

    private void enviaToken(String endereco, int porta) {

        Integer token = gerador.nextInt(10000);

        try {
            Thread.sleep(500);

            DatagramPacket pacote = ComunicadorUDP.montaMensagem(
                    String.valueOf(token), endereco, porta
            );

            ComunicadorUDP.enviaMensagem(socket, pacote);

            System.out.println("Token enviado: " + token);

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void iniciarConexaoCliente() {
        try {
            socket = new DatagramSocket(1234);
        } catch (Exception ex) {
            System.out.println("Erro ao criar o socket: " + ex.getMessage());
        }
    }
    
}
