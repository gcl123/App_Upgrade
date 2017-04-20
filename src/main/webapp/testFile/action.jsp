<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <c:set var="proPath" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css" href="${proPath}/static/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="${proPath}/static/css/icon.css">
    <script type="text/javascript" src="${proPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${proPath}/static/js/jquery.easyui.min.js"></script>


    <title>My JSP 'json.jsp' starting page</title>
    <script type="text/javascript">
        $(function () {
                    $("#bt1").click(
                            function () {
                                $.post(
                                        "action/query.action",
                                        {code: "111111111", name: "w", vaild: "1"},
                                        function (jsonResult) {
                                            for (i in jsonResult) {
                                                str = JSON.stringify(jsonResult[i]);
                                                alert(str);
                                            }
                                        },
                                        "json"
                                );
                            }
                    );
                }
        );

    </script>
    <script type="text/javascript">
        $(function () {
                    $("#bt2").click(
                            function () {
                                $.post(
                                        "action/add.action",
                                        {code: "31", name: "tooooo", vaild: "1"},
                                        function (jsonResult) {
                                            for (i in jsonResult) {
                                                str = JSON.stringify(jsonResult[i]);
                                                alert(str);
                                            }
                                        },
                                        "json"
                                );
                            }
                    );
                }
        );

    </script>
    <script type="text/javascript">
        $(function () {
                    $("#bt3").click(
                            function () {
                                $.post(
                                        "action/delete.action",
                                        {code: "31", name: "tooooo", vaild: "1"},
                                        function (jsonResult) {
                                            for (i in jsonResult) {
                                                str = JSON.stringify(jsonResult[i]);
                                                alert(str);
                                            }
                                        },
                                        "json"
                                );
                            }
                    );
                }
        );

    </script>
    <script type="text/javascript">
        $(function () {
                    $("#bt4").click(
                            function () {
                                $.post(
                                        "action/update.action",
                                        {code: "00", name: "tooooo", vaild: "1"},
                                        function (jsonResult) {
                                            for (i in jsonResult) {
                                                str = JSON.stringify(jsonResult[i]);
                                                alert(str);
                                            }
                                        },
                                        "json"
                                );
                            }
                    );
                }
        );

    </script>
</head>
<body>
<button id="bt1">query</button>
<button id="bt2">add</button>
<button id="bt3">delete</button>
<button id="bt4">update</button>
</body>
</html>