
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsoSession", urlPatterns = {"/UsoSession"})
public class UsoSession extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsoSession</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsoSession at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         try{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsoSession</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session = request.getSession (true);
            //Datos session
            Date created = new Date (session.getLastAccessedTime());
            Date accessed = new Date (session.getLastAccessedTime());
            out.println("ID: " + session.getId() + "<br>");
            out.println("Creado: " + created + "<br>");
            out.println("Ultimo acceso: " + accessed + "<br>");
            //Introducier un dato session
            String nomDato = request.getParameter("nomDato");
            if(nomDato != null && nomDato.length() > 0 ){
                String valor = request.getParameter("valor");
                session.setAttribute(nomDato, valor);
                
            
            }
         
            //Mostrar datos de la session
             Enumeration<String> e = session.getAttributeNames();
            while (e.hasMoreElements()){
                String nombre = (String) e.nextElement();
                String valor = session.getAttribute(nombre).toString();
                out.println(nombre + " = " + valor + "<br>");
            }
                    out.println("</body>");
                    out.println("</html>");
         
         
         }finally{
         
         out.close();
         
         }
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
}
