<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-04-14
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="width:100%;height:100%;overflow:hidden">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        //String absPath = application.getRealPath(request.getRequestURI());
    %>
    <base href="<%=basePath%>"/>

    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">

    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/JQuery-formui.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/common.js"></script>
</head>

<body style="height:100%;width:100%;overflow:hidden;border:none;visibility:visible;">
<div id="mainwindow" class="easyui-window"
     style="width:500px;height:300px;background:#fafafa;overflow:hidden"
     title="登录" border="false" resizable="false" draggable="false"
     minimizable="false" maximizable="false">
    <div class="header" style="height:35px;">
        <div class="toptitle" style="margin-top: 25px; font-size:20px; margin-left:60px;">
            <!--%=PublicinformationUtil.GetProperties("projectname")%-->软件发布管理
        </div>
    </div>
    <div style="padding:60px 0;">
        <div id="loginForm">
            <div style="padding-left:150px">
                <table cellpadding="0" cellspacing="3">
                    <tr>
                        <td>登录帐号</td>
                        <td><input id="LOGINNAME" style="width:114px;"/>
                        </td>
                    </tr>
                    <tr>
                        <td>登录密码</td>
                        <td><input id="PASSWORD" type="password" style="width:114px;"/>
                        </td>
                    </tr>
                    <tr>

                        <td>&nbsp;<!--img src="<%=basePath%>css/images/check.png" /--></td>
                        <td>&nbsp;<!--%=basePath%--> </td>

                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <a id="btnLogin" class="easyui-linkbutton">登 录</a>
                            <a class="easyui-linkbutton" onclick="clearAll()">重 置</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    function clearAll() {
        document.getElementById('LOGINNAME').value = "";
        document.getElementById('PASSWORD').value = "";
    }
    $("#PASSWORD").keydown(function (event) {
        if (event.keyCode == 13)
            $("#btnLogin").click();
    });

    $("#btnLogin").click(function () {
        var LOGINNAME = $("#LOGINNAME").val();
        var PASSWORD = $("#PASSWORD").val();
        if (JUDGE.isNull(LOGINNAME) || JUDGE.isNull(PASSWORD)) {
            $.messager.alert("提示消息", "用户名、密码都不能为空!", "info");
            return;
        }

        var condition = {"LOGINNAME": LOGINNAME, "PASSWORD": PASSWORD};
        condition = JSON.stringify(condition);
        condition = escape(encodeURIComponent(condition));
        var url = 'user_login.action?condition=' + condition;

        $.ajax({
            type: "post",
            url: url,
            contentType: "json",//text/html
            error: function (event, request, settings) {
                $.messager.alert("提示消息", "请求失败!", "info");
                window.location.href = "jsp/main.jsp";
            },
            success: function (data) {

                window.location.href = "jsp/main.jsp";
                return;
                if (data.total > 0) {
                    window.location.href = "jsp/main.jsp";
                }
                else {
                    $.messager.alert("提示消息", data, "info");
                    $.messager.alert("提示消息", "用户名或密码错误!", "info");
                }
            }
        });

        // window.location.href="jsp/login.jsp";
    });
</script>

</body>
</html>
