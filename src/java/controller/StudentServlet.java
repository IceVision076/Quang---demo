package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Randomchar;
import model.Student;
import model.ListStudent;
import model.RandomDate;

/**
 *
 * @author quang
 */
public class StudentServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        String num = request.getParameter("num");
        if (num != null && ListStudent.students.isEmpty()) {

            try {
                int numStudent = Integer.parseInt(num);;
            for (int i = 0; i < numStudent; i++) {
                Student st = new Student(); 
                st.setId(i);
                st.setName(Randomchar.randomString());
                st.setGender(Randomchar.randomBoolean());
                st.setDob(RandomDate.randomDate());
                ListStudent.students.add(st);
            }
            request.setAttribute("studentList",ListStudent.students);
            request.getRequestDispatcher("student.jsp").forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("student.jsp");
            }
            
        } else if (num != null && !ListStudent.students.isEmpty()) {
            try {
                int numStudent = Integer.parseInt(num);
                ListStudent.listSize = numStudent;
            for (int i = ListStudent.students.size(); i < numStudent; i++) {
                Student st = new Student(); 
                st.setId(i);
                st.setName(Randomchar.randomString());
                st.setGender(Randomchar.randomBoolean());
                st.setDob(RandomDate.randomDate());
                ListStudent.students.add(st);
            }
            request.setAttribute("studentList",ListStudent.students);
            request.setAttribute("num", num);
            request.getRequestDispatcher("student.jsp").forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("student.jsp");
            }
        }
        
        
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
