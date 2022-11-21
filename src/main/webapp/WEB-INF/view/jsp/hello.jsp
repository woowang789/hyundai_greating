<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Hello Servlet</h1>
<form action="/v1/test" method="post">
<input type="hidden" value='1' name="hiddenInput" readonly/>
<button>전송</button>
<%=application.getServerInfo() %>
<%=application.getMajorVersion()%>.<%= application.getMinorVersion() %>
<%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
</form>
</body>
</html>