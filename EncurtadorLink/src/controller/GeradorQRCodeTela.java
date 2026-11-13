package controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class GeradorQRCodeTela extends JFrame implements Runnable{

    private String link;
    private volatile JLabel label;
    
    public GeradorQRCodeTela(String link, JLabel label) {
        
        this.link = link;
        this.label = label;
        
    }
    
    @Override
    public void run(){
        
        int largura = 300;
        int altura = 300;

        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            // Gera a matriz de bits usando apenas o core
            BitMatrix matrizBits = new MultiFormatWriter().encode(
                    link, 
                    BarcodeFormat.QR_CODE, 
                    largura, 
                    altura, 
                    hints
            );

            // Cria a imagem manualmente pixel por pixel (sem precisar do javase)
            int w = matrizBits.getWidth();
            int h = matrizBits.getHeight();
            BufferedImage imagemQrCode = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            
            for (int x = 0; x < w; x++) {
                for (int y = 0; y < h; y++) {
                    imagemQrCode.setRGB(x, y, matrizBits.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            // Exibe a imagem na tela
            label.setText(null); // Remove o texto anterior
            label.setIcon(new ImageIcon(imagemQrCode)); // Define a nova imagem
            label.setHorizontalAlignment(JLabel.CENTER);
            
            // Força o Swing a redesenhar o componente na tela instantaneamente
            label.repaint();

        } catch (WriterException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }

}