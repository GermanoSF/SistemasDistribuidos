/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author laboratorio
 */
public class EncurtarLink {
    
    public static String encurtar(String linkComprido){
        
        linkComprido = linkComprido.trim();

        if (linkComprido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe uma URL para encurtar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return "ERRO";
        }

        // Garante que o protocolo esteja presente (TinyURL rejeita URLs sem http/https)
        if (!linkComprido.startsWith("http://") && !linkComprido.startsWith("https://")) {
            linkComprido = "https://" + linkComprido;
        }

        try {
            String urlCodificada = URLEncoder.encode(linkComprido, StandardCharsets.UTF_8);
            String endpoint = "https://tinyurl.com/api-create.php?url=" + urlCodificada;

            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .timeout(Duration.ofSeconds(10))
                    .GET()
                    .build();

            // .send() bloqueia até receber a resposta e devolve o resultado na hora
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String linkCurto = response.body().trim();
            
            return linkCurto;
                            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato de URL inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return "ERRO";
        }
        
    }
    
}
