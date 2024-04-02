package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RespCVS", urlPatterns = {"/RespCSV"})
public class RespCSV extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("application/csv");
         response.setHeader("Content-Disposition","attachment;filename=archivo.csv");
        PrintWriter out = response.getWriter();
            try {
            
            out.println("id;tnombre;apellidos;edad");
            out.println("1;Pepito;Autalio;23");
            out.println("2;Eva;Gomez;45");
            out.println("3;Pascual;Castillo;60");
            
        }finally{
                out.close();
            }
        
    }
    
    }
    