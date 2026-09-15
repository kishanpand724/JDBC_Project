<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link rel ="stylesheet" href="resultjsp.css">
    </head>
    <body>
        <%
            int id = (int)request.getAttribute("idKey");
            String name = (String)request.getAttribute("nameKey");
            int marks = (int)request.getAttribute("marksKey");
            String status;
            
            if(marks >= 45 ){
                status = "Pass";
            }
            else{
                status = "Fail";
            }
             
        %>
        <div class="result_box">
        <p class="wlcmsg">Welcome <%=name %></p> 
        <p class="data">id: <%=id %></p>
        <p class="data">marks: <%=marks %></p>
        <p class="data">Status: <%=status %></p>
        </div>        
        
    </body>
</html>
