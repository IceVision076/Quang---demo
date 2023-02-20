package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import model.ListStudent;
import model.Student;
import java.util.ArrayList;

public final class student_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"studentservlet\" method = \"post\">\n");
      out.write("            Number of Students:<input type=\"text\" name = \"num\"><input type=\"submit\" value=\"Submit\">\n");
      out.write("        </form>\n");
      out.write("        ");


            try {
                ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("studentList");
                String format = "MMM dd,yyyy";
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                if (students != null) {
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td>ID</td>");
                    out.println("<td>Name</td>");
                    out.println("<td>Gender</td>");
                    out.println("<td>DOB</td>");
                    out.println("</tr>");

                    for (int i = 0; i < ListStudent.listSize; i++) {
                        out.println("<tr>");
                        out.println("<input type=\"hidden\" value = \"" + ListStudent.students.get(i).getId() + "\" name = \"updateNum\"/>");
                        out.println("<td> " + ListStudent.students.get(i).getId() + " </td>");
                        out.println("<td> " + ListStudent.students.get(i).getName() + " </td>");
                        if (ListStudent.students.get(i).getGender()) {
                            out.println("<td><input type = \"checkbox\" checked = checked onclick=\"return false;\">  </td>");

                        } else {
                            out.println("<td><input type = \"checkbox\" onclick=\"return false;\"> </td>");
                        }
                        String dob = dateFormat.format(ListStudent.students.get(i).getDob());
                        out.println("<td> " + dob + " </td>");
                        out.println("<td><a href =\"update?updateNum=" + ListStudent.students.get(i).getId() + "\">update</a></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");

                } else {
                    
                }
            } catch (Exception e) {

            }


        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    ");
      out.write("\n");
      out.write("</html>\n");
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
