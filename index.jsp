<%@page import="java.util.Scanner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC</title>
    </head>
    <body bgcolor="Red">
<!--        <form >
        <label>Name: </label>
        <input type="text" id="nam" name="username">
        <input type="submit" value="Submit">
        </form>
        <%
        String name = request.getParameter("username");
        %>
        
        <h3>Welcome <%= name %>!</h3>
        -->
            <h1>Add Student</h1>
            <form>
                <label>Id: </label>
                <input type="number" class="UserId" name="uid">
                <br><br>
                <label>Name: </label>
                <input type="text" class="Username" name="uname">
                <br><br>
                <label>Marks: </label>
                <input type="number" class="UserMarks" name="unum">
                <br><br>
                <input type="submit" value="Submit" name="Submit" />
                
            </form>
            <%
            String uid = request.getParameter("uid");
            String uname = request.getParameter("uname");
            String unum = request.getParameter("unum");
            %>
            
            
            <p>Id: <% 
                int id = 0;
                   if(uid != null){
                       id = Integer.parseInt(uid);
                   }
                   
                %><%= id %></p><br><br>
            <p>Name: <%=uname %></p><br><br>
            <p>MArks:  <% 
                int marks = 0;
                   if(unum != null){
                       marks = Integer.parseInt(unum);
                   }
                   
                %><%= marks %></p>
        
    </body>
</html>
