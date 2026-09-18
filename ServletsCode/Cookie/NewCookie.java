package com.cookiesservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCookie extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String name = req.getParameter("name");
        PrintWriter out = res.getWriter();
        boolean eixts = false;
        Cookie[] cook = req.getCookies();
        if(cook != null){
            for(int i=0;i<cook.length;i++){
                Cookie c = cook[i];
                String n = c.getName();
                String v = c.getValue();
                if(n.equals("Username")){
                    if(v.contains(name)){
                    out.print("Welcome back " +name);
                    eixts = true;
                    break;
                }
                else{
                    String newValue = v + "|" + name;  
                    Cookie c1 = new Cookie("Username", newValue);
                    
                    res.addCookie(c1);
                    out.print("Welcome " + name);
                    eixts = true;
                    break;
                    }
                }
                }
            }
        if(eixts == false){
            out.print("Welcome "+name);
            Cookie c1 = new Cookie("Username", name);
            res.addCookie(c1);
        }
    }
}
