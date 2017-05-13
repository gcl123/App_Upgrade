<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--
request.getContextPath()  获得当前项目的跟目录
String basePath ==  http://localhost:8080
1、request.getScheme() 返回协议的名称 http，和后面的"://" 拼起来就成了 http://
2、request.getServerName() 这是获取你的服务器的名称，如果你的应用部署在本机那么其就返回localhost或者127.0.0.1
3、request.getServerPort() 是你应用使用的端口，比如8080或者80等等
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--<html>--%>
<%--<head>--%>
    <%----><title>首页</title>--%>
<%--</head>--%>

<%--<body>--%>
<%--<br/><br/>--%>
<%--<form action="<%=basePath%>user/userInfo.action">--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>用户名</td>--%>
            <%--<td><input type="text" name="userName"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><input type="submit" value="登录"></td>--%>
            <%--<td><input type="reset" value="取消"></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>--%>

<%--</body>--%>
<%--<html>--%>
<html>
<head>
    <title>文件上传</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/file/upload.action?appId=101&versionId=123&filePath=/aa/bb"
      enctype="multipart/form-data" method="post" >
      上传用户：<input type="text" name="username"><br/>
上传文件1：<input type="file" name="file"><br/>
<input type="submit" value="提交">
</form>


<br>curApp=${sessionScope.curApp}
<br>appParams=${sessionScope.appParams}
<br>companyParams=${sessionScope.companyParams}
<br>statusParams=${sessionScope.statusParams}
<br>curVersion=${sessionScope.curVersion}


</body>
</html>