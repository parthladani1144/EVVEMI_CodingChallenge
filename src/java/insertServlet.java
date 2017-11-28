/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class insertServlet extends HttpServlet {
    

    
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
            String name=request.getParameter("name");
            String cid=request.getParameter("cid");
            String cname=request.getParameter("cname");
            String s1="insert into student(id,name) values('"+id+"','"+name+"')"; 
            String s2="insert into course(id,cid,cname) values('"+id+"','"+cid+"','"+cname+"')"; 
            st.executeUpdate(s1);
            st.executeUpdate(s2);
            out.println("Inserted Successfully!");
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
              rd.include(request, response);

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
