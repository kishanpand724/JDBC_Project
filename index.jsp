<%@page import="java.util.Scanner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC</title>
    </head>
    <body bgcolor="Red">
        <form >
        <label>Name: </label>
        <input type="text" id="nam" name="username">
        <input type="submit" value="Submit">
        </form>
        <%
        String name = request.getParameter("username");
        %>
        
        <h3>Welcome <%= name %>!</h3>
        
<!--            <h1>Fill Details</h1>
            <form>
                <label>Id: </label>
                <input type="number" class="UserId">
                <br>
                <label>Name: </label>
                <input type="text" class="Username">
                <br>
                <label>Marks: </label>
                <input type="number" class="UserMarks">
                <br>
                <input type="submit" value="Submit" name="Submit" />
                
            </form>-->
        
    </body>
</html>
