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
                                        "appFiles/add.action",
                                        {appVersionId: "2", fileId: "2"},
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
                                        "appFiles/delete.action",
                                        {appVersionId: "2", fileId: "2"}, function (jsonResult) {
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
                                        "appFiles/update.action",
                                        {appVersionId: "1", fileId: "1"}, function (jsonResult) {
                                            alert(jsonResult)
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
                                        "appFiles/queryVersion.action",
                                        {appVersionId: "2", fileId: "2"}, function (jsonResult) {
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
                    $("#bt5").click(
                            function () {
                                $.post(
                                        "appFiles/queryFiles.action",
                                        {appVersionId: "2", fileId: "1"}, function (jsonResult) {
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
<button id="bt1">add</button>
<button id="bt2">delete</button>
<button id="bt3">update</button>
<button id="bt4">queryVersion</button>
<button id="bt5">queryFiles</button>

</body>
</html>