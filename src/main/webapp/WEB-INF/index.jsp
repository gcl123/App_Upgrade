<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!--
request.getContextPath() 获得当前项目的跟目录
String basePath == http://localhost:8080
1、request.getScheme() 返回协议的名称 http，和后面的"://" 拼起来就成了 http://
2、request.getServerName() 这是获取你的服务器的名称，如果你的应用部署在本机那么其就返回localhost或者127.0.0.1
3、request.getServerPort() 是你应用使用的端口，比如8080或者80等等
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>首页</title>
</head>

<body>
浙江通览科技有限公司
<form action="<%=basePath%>user/userInfo.action" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function request_json() {
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath }/user/testJson.action",
            contentType: "application/json;charset=utf-8",
            data: '{"userName":"hello","id":99}',
            success: function (data) {
                alert(data);
            }
        });
    }
</script>
</body>
</html>
