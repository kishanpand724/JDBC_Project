package com.servletcode;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainServlet extends HttpServlet{
    // service -> doGet + doPost
    public void service(HttpServletRequest req, HttpServletResponse res){ // instead of service we can right doPost/doGet
        try{
            String n = req.getParameter("name");
            req.setAttribute("Keyyy", n);
            PrintWriter output = res.getWriter();
            RequestDispatcher rd = req.getRequestDispatcher("secondPage");
            rd.forward(req, res);
    
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
