/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import UDP.ClienteUDP;
import UDP.ComunicadorUDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClienteGUI.class.getName());
    public volatile boolean[] tokenB;
    public volatile boolean[] enviarB;
    public volatile String[] dadosS;
    public volatile boolean[] fecharConexaoB;
    ClienteUDP cliente;
    
    public ClienteGUI() {
        initComponents();
        
        dadosS = new String[4];
        
        fecharConexaoB = new boolean[1];
        tokenB = new boolean[1];
        enviarB = new boolean[1];
        fecharConexaoB[0] = false;
        tokenB[0] = false;
        enviarB[0] = false;
        cliente = new ClienteUDP(tokenB,enviarB,dadosS,fecharConexaoB);
        new Thread(cliente).start();
  
    }

    DatagramSocket socket;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tokenRecbTxt = new javax.swing.JTextPane();
        dataEnvTxt = new javax.swing.JScrollPane();
        EmailEnvTxt = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeLb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        emailTxt = new javax.swing.JTextPane();
        enviarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nomeEnvTxt = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        nomeTxt = new javax.swing.JTextPane();
        limparbtn = new javax.swing.JButton();
        btnToken = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tokenRecbTxt.setEditable(false);
        jScrollPane2.setViewportView(tokenRecbTxt);

        EmailEnvTxt.setEditable(false);
        dataEnvTxt.setViewportView(EmailEnvTxt);

        jLabel2.setText("Nome completo enviado");

        jLabel3.setText("Token Recebido");

        nomeLb.setText("Digite seu nome completo : ");

        jLabel4.setText("Email Enviado :");

        jLabel1.setText("Digite Seu Email :");

        jScrollPane4.setViewportView(emailTxt);

        enviarBtn.setText("ENVIAR PARA O SERVIDOR");
        enviarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarBtnActionPerformed(evt);
            }
        });

        nomeEnvTxt.setEditable(false);
        jScrollPane1.setViewportView(nomeEnvTxt);

        jScrollPane5.setViewportView(nomeTxt);

        limparbtn.setText("Limpar");
        limparbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparbtnActionPerformed(evt);
            }
        });

        btnToken.setText("Pedir Token");
        btnToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel3)
                        .addGap(197, 197, 197)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomeLb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane5)))
                                .addGap(18, 18, 18)
                                .addComponent(enviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dataEnvTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(limparbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(enviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeLb))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(dataEnvTxt)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(29, 29, 29)
                .addComponent(limparbtn)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarBtnActionPerformed

        String nome = nomeTxt.getText();
        String email = emailTxt.getText();
        dadosS[0] = nome;
        dadosS[1] = email;
        enviarB[0] = true;
        
        try {
            Thread.sleep(500);
            if (dadosS[3].equals("Certo")){
            
                nomeEnvTxt.setText(nome);
                EmailEnvTxt.setText(email);
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");

            }
            else{

                JOptionPane.showMessageDialog(null, "Erro ao enviar dados, solicite um novo token!");

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteGUI.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
    }//GEN-LAST:event_enviarBtnActionPerformed

    private void limparbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparbtnActionPerformed
        nomeEnvTxt.setText("");
        EmailEnvTxt.setText("");
        tokenRecbTxt.setText("");

    }//GEN-LAST:event_limparbtnActionPerformed

    private void btnTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokenActionPerformed
    
            dadosS[2] = null;
            tokenB[0] = true;
            while(dadosS[2]==null);
            tokenRecbTxt.setText(dadosS[2]);
            

    }//GEN-LAST:event_btnTokenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ClienteGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane EmailEnvTxt;
    private javax.swing.JButton btnToken;
    private javax.swing.JScrollPane dataEnvTxt;
    private javax.swing.JTextPane emailTxt;
    private javax.swing.JButton enviarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton limparbtn;
    private javax.swing.JTextPane nomeEnvTxt;
    private javax.swing.JLabel nomeLb;
    private javax.swing.JTextPane nomeTxt;
    private javax.swing.JTextPane tokenRecbTxt;
    // End of variables declaration//GEN-END:variables
}
