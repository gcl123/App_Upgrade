<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-04-20
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //String absPath = application.getRealPath(request.getRequestURI());
  %>
  <base href="<%=basePath%>"/>
    <title></title>
</head>
<body style="background:url('<%=basePath%>css/images/FooterBG.jpg') no-repeat right bottom;">
<div style=" margin:20px; text-align:center; font-size:28px;">错误:404</div><!--%=PublicinformationUtil.GetProperties("sysname")%-->
<div>&nbsp;&nbsp;&nbsp;&nbsp;您访问的页面不存在。</div>

</body>
</html>
