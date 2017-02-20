package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registroInscripciones_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Registro De Inscripciones</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom Fonts -->\n");
      out.write("    <link href=\"font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("        <!-- Navigation -->\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"home.jsp\">Home</a>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->\n");
      out.write("            <div class=\"collapse navbar-collapse navbar-ex1-collapse\">\n");
      out.write("                <ul class=\"nav navbar-nav side-nav\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"registroPersonas.jsp\"><i class=\"fa fa-fw fa-dashboard\"></i> Registro de Personas</a>\n");
      out.write("                    </li>\n");
      out.write("                     <li>\n");
      out.write("                        <a href=\"registroCursos.jsp\"><i class=\"fa fa-fw fa-dashboard\"></i> Registro de Cursos</a>\n");
      out.write("                    </li>\n");
      out.write("                     <li>\n");
      out.write("                        <a href=\"registroInscripciones.jsp\"><i class=\"fa fa-fw fa-dashboard\"></i> Registro de Inscripciones</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"javascript:;\" data-toggle=\"collapse\" data-target=\"#demo\"><i class=\"fa fa-fw fa-arrows-v\"></i> CRUD <i class=\"fa fa-fw fa-caret-down\"></i></a>\n");
      out.write("                        <ul id=\"demo\" class=\"collapse\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"crudEstudiantes.jsp\">Estudiantes</a>\n");
      out.write("                            </li>\n");
      out.write("                             <li>\n");
      out.write("                                <a href=\"crudInscripciones.jsp\">Inscripciones</a>\n");
      out.write("                            </li>\n");
      out.write("                        \n");
      out.write("                             <li>\n");
      out.write("                                <a href=\"crudProfesores.jsp\">Profesores</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"crudCursos.jsp\">Cursos</a>\n");
      out.write("                            </li>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("                <!-- Page Heading -->\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <h1 class=\"page-header\">\n");
      out.write("                            Registro de Inscripciones\n");
      out.write("                        </h1>\n");
      out.write("                        <ol class=\"breadcrumb\">\n");
      out.write("                            <li>\n");
      out.write("                                <i class=\"fa fa-dashboard\"></i>  <a href=\"home.html\">Inicio</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"active\">\n");
      out.write("                                <i class=\"fa fa-desktop\"></i> Modo Privilegiado\n");
      out.write("                            </li>\n");
      out.write("                        </ol>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /.row -->\n");
      out.write("\n");
      out.write("                <!-- Main jumbotron for a primary marketing message or call to action -->\n");
      out.write("                <div class=\"jumbotron\">\n");
      out.write("                      <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("\n");
      out.write("                        <form action=\"RegistroInscripcionesControlador\" method=\"POST\"> <!--ATENCION: la palabra action indica el tipo de acción que va a realizar el formulario-->\n");
      out.write("            \n");
      out.write("                                \n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label><h3>Numero de Inscripcion</h3>\n");
      out.write("                                </label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"noInscripcion\">\n");
      out.write("                                <p class=\"help-block\">Ej: 1056373.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label><h3>ID del Estudiante</h3>\n");
      out.write("                                </label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"idEstudiante\">\n");
      out.write("                                <p class=\"help-block\">Ej: Carlos</p>\n");
      out.write("                            </div>\n");
      out.write("                               <div class=\"form-group\">\n");
      out.write("                                <label><h3>Codigo curso</h3>\n");
      out.write("                                </label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"codigoCurso\">\n");
      out.write("                                <p class=\"help-block\">Ej: Carlos</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label><h3>Fecha de Inscripcion</h3>\n");
      out.write("                                </label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"fechaIncripcion\">\n");
      out.write("                                <p class=\"help-block\">Ej: 15</p>\n");
      out.write("                            </div>\n");
      out.write("                              <div class=\"form-group\">\n");
      out.write("                                <label><h3>Fecha Finalizacion</h3>\n");
      out.write("                                </label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"fechaFinalizacion\">\n");
      out.write("                                <p class=\"help-block\">Ej: 15</p>\n");
      out.write("                            </div>\n");
      out.write("                             <div class=\"form-group\">\n");
      out.write("                                <label><h3>Nota</h3>\n");
      out.write("                                </label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nota\">\n");
      out.write("                                <p class=\"help-block\">Ej: 5</p>\n");
      out.write("                            </div>\n");
      out.write("                      <input type=\"submit\" name=\"Registrar\" value=\"Registrar\" class=\"btn btn-primary btn-lg\" role=\"button\"  >\n");
      out.write("                         <input type=\"reset\" name=\"reset\" value=\"reset\" class=\"btn btn-primary btn-lg\" role=\"button\"  >\n");
      out.write("                      \n");
      out.write("                      </div>\n");
      out.write("                           \n");
      out.write("                             \n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"page-header\">\n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("            </div>\n");
      out.write("            <!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /#page-wrapper -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /#wrapper -->\n");
      out.write("\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"js/jquery.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <!-- Script para mostrar elementos --> \n");
      out.write("     <script src=\"js/showhide.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
