package com.servletcode;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainServlet extends HttpServlet{
    public void service(HttpServletRequest req, HttpServletResponse res){
        try{
        String n = req.getParameter("name");
        PrintWriter output = res.getWriter();
        output.print("Hello " + n);
    
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
