<%@ page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <%@ include file="/common/common.jspf" %>
    <title>My JSP</title>
</head>
<body class="mybody">

<form id="ff" class="myfm" method="post">
    <div class="myftitle">
        hello
    </div>
    <div class="myfitem">
        <label for="code">代码:</label>
        <input type="text" name="code"/>
    </div>
    <div class="myfitem">
        <label for="name">名称</label>
        <input type="text" name="name"/>
    </div>

    <div class="myfitem">
        <a id="#btn" href="${proPath}/company/insert.action" class="easyui-linkbutton">提交</a>
    </div>
</form>

</body>
</html>
