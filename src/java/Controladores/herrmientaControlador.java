/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.HerramientaDAO;
import Datos.Herramientas;

/**
 *
 * @author james
 */
public class herrmientaControlador extends HttpServlet {

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
            
            
                   HerramientaDAO herramientadao = new HerramientaDAO();
    
                int lols= Integer.parseInt(request.getParameter("idDispositivo"));
                
                 int idmantenimiento= Integer.parseInt(request.getParameter("idMantenimiento"));
            
                  int serial1= Integer.parseInt(request.getParameter("noSerial"));
                
                   int idinventario= Integer.parseInt(request.getParameter("idInventario"));
                
                String nombreHerramienta= request.getParameter("nombreHerramienta");
                char[] nombre=  nombreHerramienta.toCharArray();
                
                String descripcion= request.getParameter("descripcionHerramienta");
                char[] descrip=  descripcion.toCharArray();
                
                  String statusHerramienta= request.getParameter("statusHerramienta");
                char[] status=  statusHerramienta.toCharArray();
             
                int cantidadArreglos= Integer.parseInt(request.getParameter("cantidadArreglos"));
                
                 Herramientas herramienta= new Herramientas(lols,idmantenimiento,idinventario,serial1,nombre,descrip,status,cantidadArreglos);
                
                herramientadao.insertar(herramienta);
                herramientadao.destructor();
                 response.sendRedirect("herramienta.jsp"); 
            
 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet herrmientaControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet herrmientaControlador at " + request.getContextPath() + "</h1>");
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
