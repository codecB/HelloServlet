<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Servlet Introduction</title>
    </head>
    <body>
        <h1>What are Servlets?</h1>
        <p>
            Java Servlets are programs that run on a Web or Application server and act as a middle layer between a request coming from a Web browser or other HTTP client and databases or applications on the HTTP server.
        </p>
        <p>
            Using Servlets, you can collect input from users through web page forms, present records from a database or another source, and create web pages dynamically.
        </p>
        <p>
            Java Servlets often serve the same purpose as programs implemented using the Common Gateway Interface (CGI). But Servlets offer several advantages in comparison with the CGI.
        </p>

        <form action="${pageContext.request.contextPath}/hello" method="post">
            <input type="submit" name="button1" value="Servlet" />
        </form>

        <form action="${pageContext.request.contextPath}/time" method="post">
            <input type="submit" name="button1" value="Time" />
        </form>

    </body>
</html>
