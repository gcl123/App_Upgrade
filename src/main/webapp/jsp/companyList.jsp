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
    <title>公司列表</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        //String absPath = application.getRealPath(request.getRequestURI());
    %>
    <base href="<%=basePath%>"/>
    <!--js&css-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/demo/demo.css">
    <style type="text/css">
        #fm {
            margin: 0;
            padding: 10px 30px;
        }

        .ftitle {
            font-size: 14px;
            font-weight: bold;
            color: #666;
            padding: 5px 0;
            margin-bottom: 10px;
            border-bottom: 1px solid #ccc;
        }

        .fitem {
            margin-bottom: 5px;
        }

        .fitem label {
            display: inline-block;
            width: 80px;
        }
    </style>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
    <!--http://bbs.csdn.net/topics/390160429-->
    <script type="text/javascript">
        var url;
        function addCompany() {
            $('#dlg').dialog('open').dialog('setTitle', '新增');
            $('#fm').form('clear');
            url = '<%=basePath%>company/add.action';
        }
        function editCompany() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $('#dlg').dialog('open').dialog('setTitle', 'Edit company');
                $('#fm').form('load', row);
                url = '<%=basePath%>company/update.action?id=' + row.id;
            }
        }

        function saveCompany() {
            $('#fm').form('submit', {
                url: url,
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $('#dlg').dialog('close');		// close the dialog
                        $('#dg').datagrid('reload');	// reload the user data
                    } else {
                        $.messager.show({
                            title: 'Error',
                            msg: result.msg
                        });
                    }
                }
            });
        }
        function removeCompany() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('请确认', '确定要删除吗?', function (r) {
                    if (r) {
                        $.post("company/delete.action", {id: row.id}, function (result) {
                            if (result.success) {
                                $('#dg').datagrid('reload');	// reload the user data
                            } else {
                                $.messager.show({	// show error message
                                    title: 'msg',
                                    msg: result.msg
                                });
                            }
                        }, 'json');
                    }
                });
            }
        }
    </script>

</head>
<!--http://blog.csdn.net/shiyong1949/article/details/52815378-->
<table id="dg" title="公司列表" class="easyui-datagrid" style="width:1100px;height:450px"
       url='<%=basePath%>company/selectPageUseDyc.action'
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="45">记录ID</th>
        <th field="code" width="55">公司代码</th>
        <th field="name" width="120">公司名称</th>
        <th field="shortName" width="80">公司简称</th>
        <th field="mobile" width="100">联系电话</th>
        <th field="contact" width="100">联系人</th>
        <th field="url" width="200">公司网址</th>
        <th field="description" width="200">公司描述</th>
        <th field="remark" width="200">备注</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addCompany()">新增</a>
    <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCompany()">编辑</a>
    <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeCompany()">删除</a>
</div>

<!--div>%=Mm.GetProperties("dataUrl")%></div>

<div id="win" class="easyui-window" title="My Window" style="width:300px;height:100px;padding:5px;">
  test
</div-->
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　

<div id="dlg" class="easyui-dialog" style="width:400px;height:420px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">公司信息</div>
    <form id="fm" method="post" novalidate>
        　
        <div class="fitem">
            <label>公司代码:</label>
            <input name="code" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>公司名称:</label>
            <input name="name"/>
        </div>
        <div class="fitem">
            <label>公司简称:</label>
            <input name="shortName" required="true"/>
        </div>

        <div class="fitem">
            <label>公司名称:</label>
            <input name="name"/>
        </div>
        <div class="fitem">
            <label>联系电话:</label>
            <input name="mobile"/>
        </div>
        <div class="fitem">
            <label>联系人:</label>
            <input name="contact"/>
        </div>
        <div class="fitem">
            <label>公司网址:</label>
            <input name="url"/>

            <div class="fitem">
                <label>公司描述:</label>
                <input name="description"/>
            </div>
            <div class="fitem">
                <label>备注:</label>
                <input name="remark"/>
            </div>
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveCompany()">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

</body>
</html>
