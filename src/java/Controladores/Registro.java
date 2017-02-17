/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ProfesorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.Profesor;

/**
 *
 * @author james
 */
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                    
        
            String tipoPersona=request.getParameter("tipoPersona");
            
            if("1".equals(tipoPersona)){
                int id = Integer.parseInt(request.getParameter("idpersona"));
                
                int telefono = Integer.parseInt(request.getParameter("telefono"));
                
                String n= request.getParameter("nombre");
                char[] nombre=  n.toCharArray();
                
                String a= request.getParameter("apellido");
                char[] apellido=  n.toCharArray();
                
            }else if("2".equals(tipoPersona)){
                
                ProfesorDAO profesordao = new ProfesorDAO();
            ArrayList<Profesor> profesores =new ArrayList<Profesor>();
                
                int id = Integer.parseInt(request.getParameter("idpersona"));
                
                   int ext= Integer.parseInt(request.getParameter("extension"));
                   
                   String n= request.getParameter("nombre");
                char[] nombre=  n.toCharArray();
                
                String a= request.getParameter("apellido");
                char[] apellido=  n.toCharArray();
                
                Profesor profesor= new Profesor(id,nombre,apellido,ext);
 
                profesordao.insertar(profesor); 
                profesordao.destructor();
                response.sendRedirect("registroPersonas.jsp"); 
                
               
            }
            
            
         
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");  
            
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
