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

<script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            $('#ff').form('submit', {
                url: '${proPath}/company/insert.action',
                onSubmit: function () {
                    return true;
                },
                success: function (count) {
                    //可以定义为对应消息框
                    if (count > 0) {
                        alert("添加成功！");
                    } else {
                        alert("添加失败！");
                    }
                }
            });

        })

    });

</script>
</body>
</html>
