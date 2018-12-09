<%@ page contentType="text/html; ISO-8859-1" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    public void jspInit(){
        System.out.println("initialize jsp");
    }
    public void jspDestroy(){
        System.out.println("destroy jsp");
    }
%>
</body>
</html>