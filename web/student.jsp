<%-- 
    Document   : student.jsp
    Created on : Feb 3, 2023, 12:54:57 PM
    Author     : quang
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.ListStudent"%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="studentservlet" method = "post">
            Number of Students:<input type="text" name = "num"><input type="submit" value="Submit">
        </form>
        <%

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


        %>


    </body>
    <%--
            
    --%>
</html>
