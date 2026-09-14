package com.servletcode;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class secondServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        try{
            String name = (String)req.getAttribute("Keyyy");   // type casting bxz it's return tye is  object
            PrintWriter pw = res.getWriter();
            pw.print("Hello " + name);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
