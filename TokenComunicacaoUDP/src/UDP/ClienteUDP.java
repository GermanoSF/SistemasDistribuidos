
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//Se basear aqui, aqui e feito com thread
public class ClienteUDP implements Runnable{

    DatagramSocket socket;
    private String token;
    private boolean [] tokenB;
    private boolean [] enviarB;
    private boolean[] fecharConexaoB;
    private String[] dadosS;

    @Override 
    public void run(){
        
        while (true){
            if (tokenB[0]){
                try {
                    DatagramPacket pedido = ComunicadorUDP.montaMensagem(
                            "PEDIR_TOKEN", "localhost", 1234
                    );

                    ComunicadorUDP.enviaMensagem(socket, pedido);

                    byte[] dados = new byte[1024];
                    DatagramPacket resposta = new DatagramPacket(
                            dados, dados.length
                    );

                    socket.setSoTimeout(10000);
                    socket.receive(resposta);

                    token = new String(
                            resposta.getData(), 0, resposta.getLength()
                    );

                    dadosS[2] = token;
                    
                    tokenB[0] = false;

                } catch (Exception ex) {
                    System.out.println("Erro ao receber token: " + ex.getMessage());
                }            
            }
            
            if (enviarB[0] == true){
            
                //falta fazer aqui para enviar mensagem (DatagramPacket) para o servidor
                enviarB[0] = false;
            
            }
            
            if (fecharConexaoB[0]){
                
                socket.close();
                
            }
            
        }
        
    }
    
    public ClienteUDP(boolean[] tokenB, boolean[] enviarB, String[] dadosS, boolean[] fecharConexaoB){
        this.tokenB = tokenB;
        this.enviarB = enviarB;
        this.dadosS = dadosS;
        this.fecharConexaoB = fecharConexaoB;
        
        criaClientSocket();

        if (socket == null) {
            return;
        }
       
    }

    private void criaClientSocket() {
        try {
            socket = new DatagramSocket();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
