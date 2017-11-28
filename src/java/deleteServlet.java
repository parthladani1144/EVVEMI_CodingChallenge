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
public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            java.sql.Statement st=con.createStatement();
            String id=request.getParameter("id");
            String s = "select * from student where id='"+id+"'";
            ResultSet rs = st.executeQuery(s);
            if(!rs.next())
            {
                out.print("Data not Present!");
            }
            else
            {
                String s1 = "delete from student where id='"+id+"'";
                String s2 = "delete from course where id='"+id+"'";
                st.executeUpdate(s1);
                st.executeUpdate(s2);
                out.println("Deleted Successfully!");
            }
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
              rd.include(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
