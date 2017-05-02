<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/common.jspf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>文件上传下载</title>
</head>
<body>
<form action="${proPath}/file/upload.action" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file" width="120px">
    <input type="submit" value="上传">
</form>
<hr>
<form action="${proPath}/file/down.action" method="get">
    <input type="submit" value="下载">
</form>
</body>
</html>


<%--<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<%--<html>--%>
<%--<head>--%>

    <%--<c:set var="proPath" value="http://127.0.0.1:8080/${pageContext.request.contextPath}"/>--%>
    <%--<link rel="stylesheet" type="text/css" href="${proPath}/static/css/easyui.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="${proPath}/static/css/icon.css">--%>
    <%--<script type="text/javascript" src="${proPath}/static/js/jquery.min.js"></script>--%>
    <%--<script type="text/javascript" src="${proPath}/static/js/jquery.easyui.min.js"></script>--%>


    <%--<title>My JSP 'json.jsp' starting page</title>--%>
    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
                    <%--$("#bt1").click(--%>
                            <%--function () {--%>
                                <%--$.post(--%>
                                        <%--"company/query.action",--%>
                                        <%--{code: "8", name: "", vaild: "1"},--%>
                                        <%--function (jsonResult) {--%>
                                            <%--for (i in jsonResult) {--%>
                                                <%--str = JSON.stringify(jsonResult[i]);--%>
                                                <%--alert(str);--%>

                                            <%--}--%>

                                        <%--},--%>
                                        <%--"json"--%>
                                <%--);--%>
                            <%--}--%>
                    <%--);--%>
                <%--}--%>
        <%--);--%>

    <%--</script>--%>
    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
                    <%--$("#bt2").click(--%>
                            <%--function () {--%>
                                <%--$.post(--%>
                                        <%--"company/add.action",--%>
                                        <%--{code: "81", name: "tooooo", vaild: "1"},--%>
                                        <%--function (jsonResult) {--%>
                                            <%--for (i in jsonResult) {--%>
                                                <%--str = JSON.stringify(jsonResult[i]);--%>
                                                <%--alert(str);--%>
                                            <%--}--%>
                                        <%--},--%>
                                        <%--"json"--%>
                                <%--);--%>
                            <%--}--%>
                    <%--);--%>
                <%--}--%>
        <%--);--%>

    <%--</script>--%>
    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
                    <%--$("#bt3").click(--%>
                            <%--function () {--%>
                                <%--$.post(--%>
                                        <%--"company/delete.action",--%>
                                        <%--{code: "31", name: "tooooo", vaild: "1"},--%>
                                        <%--function (jsonResult) {--%>
                                            <%--for (i in jsonResult) {--%>
                                                <%--str = JSON.stringify(jsonResult[i]);--%>
                                                <%--alert(str);--%>
                                            <%--}--%>
                                        <%--},--%>
                                        <%--"json"--%>
                                <%--);--%>
                            <%--}--%>
                    <%--);--%>
                <%--}--%>
        <%--);--%>

    <%--</script>--%>
    <%--<script type="text/javascript">--%>
        <%--$(function () {--%>
                    <%--$("#bt4").click(--%>
                            <%--function () {--%>
                                <%--$.post(--%>
                                        <%--"company/update.action",--%>
                                        <%--{code: "81", name: "tooooo", vaild: "1"},--%>
                                        <%--function (jsonResult) {--%>
                                            <%--for (i in jsonResult) {--%>
                                                <%--str = JSON.stringify(jsonResult[i]);--%>
                                                <%--alert(str);--%>
                                            <%--}--%>

                                        <%--},--%>
                                        <%--"json"--%>
                                <%--);--%>
                            <%--}--%>
                    <%--);--%>
                <%--}--%>
        <%--);--%>

    <%--</script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<button id="bt1">query</button>--%>
<%--<button id="bt2">add</button>--%>
<%--<button id="bt3">delete</button>--%>
<%--<button id="bt4">update</button>--%>
<%--</body>--%>
<%--</html>--%>