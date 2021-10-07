
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UsoCookies", urlPatterns = {"/UsoCookies"})
public class UsoCookies extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsoCookies</title>");  
            out.println("</head>");
            out.println("<body>");
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++){
                Cookie c = cookies[i];
                String name = c.getName();
                String value = c.getValue();
                out.println(name + " = " + value + "<br>");
            
            }
            //Adicionar cookie 
            String name = request.getParameter("nombre");
            if(name != null && name.length() > 0){
                String value = request.getParameter("valor");
                Cookie c = new Cookie (name, value);
                c.setMaxAge(3600);
                response.addCookie(c);
            }
            out.println("</body>");
            out.println("</html>");
        
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

 
}
