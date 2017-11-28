/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ParthLadani
 */
public class readData extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<html><body>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            java.sql.Statement st=con.createStatement();
            
            String s1 = "select student.id, student.name , course.cid, course.cname from student,course where student.id=course.id";
            ResultSet rs = st.executeQuery(s1);
             out.println("<table border=1>");
             out.println("<tr><th>Student ID</th><th>Student Name</th><th>Course ID</th><th>Course Name</th><tr>");    
            while(rs.next())
            {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String cid = rs.getString("cid");
                String cname = rs.getString("cname");
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + cid + "</td><td>" + cname + "</td></tr>");       
                
            }
            out.println("</table>");
            out.println("</html></body>");
            con.close();
            rs.close();
           
            
            
            
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
              rd.include(request, response);

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
