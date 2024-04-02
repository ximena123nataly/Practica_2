package com.emergentes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@WebServlet(name = "RespPDF", urlPatterns = {"/RespPDF"})
public class RespPDF extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Establecer el tipo de contenido de la respuesta como application/pdf
        response.setContentType("application/pdf");
        
        try {
            // Obtener el OutputStream de la respuesta para escribir el PDF
            OutputStream out = response.getOutputStream();
            
            // Escribir el contenido del PDF en el OutputStream
            out.write(generarPDF());
            
            // Cerrar el OutputStream
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para generar el contenido del PDF
    private byte[] generarPDF() {
        String contenidoPDF = "%PDF-1.5\n1 0 obj\n<< /Type /Catalog\n/Pages 2 0 R\n>>\nendobj\n2 0 obj\n<< /Type /Pages\n/Kids [3 0 R]\n/Count 1\n>>\nendobj\n3 0 obj\n<< /Type /Page\n/MediaBox [0 0 612 792]\n/Parent 2 0 R\n/Contents 4 0 R\n>>\nendobj\n4 0 obj\n<< /Length 5 0 R\n>>\nstream\nBT\n/F1 12 Tf\n100 700 Td\n(Hello, World!) Tj\nET\nendstream\nendobj\n5 0 obj\n14\nendobj\nxref\n0 6\n0000000000 65535 f \n0000000009 00000 n \n0000000054 00000 n \n0000000102 00000 n \n0000000170 00000 n \n0000000217 00000 n \ntrailer\n<< /Size 6\n/Root 1 0 R\n>>\nstartxref\n280\n%%EOF";
        return contenidoPDF.getBytes();
    }
}

