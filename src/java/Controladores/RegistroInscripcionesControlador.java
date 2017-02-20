/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.InscripcionesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.Inscripciones;

/**
 *
 * @author james
 */
@WebServlet(name = "registroInscripciones", urlPatterns = {"/registroInscripciones"})
public class RegistroInscripcionesControlador extends HttpServlet {

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
                              
                InscripcionesDAO inscripciondao = new InscripcionesDAO();
            ArrayList<Inscripciones> inscripciones =new ArrayList<Inscripciones>();
            
                
                int numeroInscripciones = Integer.parseInt(request.getParameter("noInscripcion"));
                
                int idest = Integer.parseInt(request.getParameter("idEstudiante"));
                
                int codigoCurso = Integer.parseInt(request.getParameter("codigoCurso"));
                
                String n= request.getParameter("fechaInscripcion");
                char[] fechains=  n.toCharArray();
                
                String a= request.getParameter("fechaFinalizacion");
                char[] fechafinal=  n.toCharArray();
                
                float nota = Float.parseFloat(request.getParameter("nota"));
                
                Inscripciones inscri= new Inscripciones(numeroInscripciones,idest,codigoCurso,fechains,fechafinal,nota);
                inscripciondao.insertar(inscri);
                inscripciondao.destructor();
                 response.sendRedirect("registroInscripciones.jsp"); 
               
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registroInscripciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registroInscripciones at " + request.getContextPath() + "</h1>");
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
