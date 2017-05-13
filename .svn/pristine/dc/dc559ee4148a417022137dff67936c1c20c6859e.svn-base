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
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        //String absPath = application.getRealPath(request.getRequestURI());
    %>
    <base href="<%=basePath%>"/>
    <title></title>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/JQuery-formui.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/common.js"></script>
    <script>
            $(document).ready( function() {
            alert("fsafd");
            $('#container_id').fileTree({ root: 'd:\\' }, function(file) {
                alert(file);
            });
        });
    </script>
</head>
<body style="background:url('<%=basePath%>css/images/FooterBG.jpg') no-repeat right bottom;">
<div style=" margin:20px; text-align:center; font-size:28px;">关于我们</div>
<!--%=PublicinformationUtil.GetProperties("sysname")%-->
<div>&nbsp;&nbsp;&nbsp;&nbsp;浙江通览科技有限公司</div>
<h2>测试</h2>
<div id="container_id">

</div>

</body>
</html>
