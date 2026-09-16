package com.cookiesservlet;

import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesServlet extends HttpServlet{
    public void service(HttpServletRequest req, HttpServletResponse res){
        try{
            String name = req.getParameter("name");
            boolean userVisit = false;
            Cookie[] cookiesarr = req.getCookies();
            PrintWriter out = res.getWriter();
            if(cookiesarr != null){
                for(int i=0;i<cookiesarr.length;i++){
                    Cookie c = cookiesarr[i];
                    String naam = c.getName();
                    String val = c.getValue();
                    if(naam.equals("Keyname") && val.equals("Value12")){
                        out.print("Welcome back " + name);
                        userVisit = true;
                        break;
                    }
                    
                }
            }
            if(userVisit == false){
                out.print("Welcome " + name);
                Cookie c1 = new Cookie("Keyname","Value12");
                res.addCookie(c1);
            }
            
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
