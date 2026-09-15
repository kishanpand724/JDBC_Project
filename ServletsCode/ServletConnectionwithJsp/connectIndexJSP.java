package com.indexjspconnection;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class connectIndexJSP extends HttpServlet{
    public void service(HttpServletRequest req, HttpServletResponse res){
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int marks = Integer.parseInt(req.getParameter("marks"));
            req.setAttribute("idKey", id);
            req.setAttribute("nameKey", name);
            req.setAttribute("marksKey", marks);
            RequestDispatcher rd = req.getRequestDispatcher("new.jsp");
            rd.forward(req, res);
            PrintWriter pw = res.getWriter();
//            pw.print("Hello");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
