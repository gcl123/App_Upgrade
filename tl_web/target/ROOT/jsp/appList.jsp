<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>项目列表</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>"/>
    <!--js&css-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/demo/demo.css"/>
    <link rel="stylesheet" type="text/css" href="css/mycss.css"/>

    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>

    <!--http://bbs.csdn.net/topics/390160429-->
    <script type="text/javascript">

        var url;
       /* var orgCount = 0;
        function initCombo() {
            $('#orgCombo').combobox({
                url: 'fetchOrgs.do',
                valueField: 'id',
                textField: 'text',
                editable:false,
                onLoadSuccess: function(data){
                    orgCount = data.length;
                },
                onShowPanel: function() {
                    // 动态调整高度
                    if (orgCount > 13) {
                        $(this).combobox('panel').height(285);
                    }
                }
            });
        }*/
        function addApp() {
            $('#dlg').dialog('open').dialog('setTitle', '新增');
            $('#fm').form('clear');
            url = '<%=basePath%>app/add.action';
        }
        function editApp() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $('#dlg').dialog('open').dialog('setTitle', 'Edit App');
                $('#fm').form('load', row);
                url = '<%=basePath%>app/update.action?id=' + row.id;
            }
        }

        function saveApp() {
            $('#fm').form('submit', {
                url: url,
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if( parseInt(result.code) == 0){
                        $('#dlg').dialog('close');		// close the dialog
                        $('#dg').datagrid('reload');
                    }
                    $.messager.show({
                        title: '提示',
                        msg: result.msg
                    });
                }
            });
        }
        function removeApp() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('请确认', '确定要删除吗?', function (r) {
                    if (r) {
                        $.post("app/delete.action", {id: row.id}, function (result) {
                            if( parseInt(result.code) == 0){
                                $('#dg').datagrid('reload');
                            }
                            $.messager.show({
                                title: '提示',
                                msg: result.msg
                            });
                        }, 'json');
                    }
                });
            }
        }

        function setActive() {
            var row = $('#dg').datagrid('getSelected');
            if(row){
                $.post("app/curApp.action", {id: row.id}, function (result) {
                    $.messager.show({	// show error message
                        title: '提示',
                        msg: result.msg
                    });
                }, 'json');
            }
        }

        function manageVersion() {
            var row = $('#dg').datagrid('getSelected');
            if(row){
                $.post("app/curApp.action", {id: row.id}, function (result) {
                    $.messager.show({	// show error message
                        title: '提示',
                        msg: result.msg
                    });
                    if(parseInt(result.code)== 0){
                        goAppVersionList();
                    }
                }, 'json');
            }
        }
        function goAppVersionList() {
            var row = $('#dg').datagrid('getSelected');
            if(row){
                window.location.href="jsp/appVersionList.jsp";
            }else {
                alert("请选择软件");
            }
        }

    </script>

</head>
<body>
<!--http://blog.csdn.net/shiyong1949/article/details/52815378-->
<table id="dg" title="项目列表" class="easyui-datagrid" style="width:1100px;height:450px"
       url='<%=basePath%>app/selectPageUseDyc.action'
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">

    <thead>
    <tr>
        <th field="id" width="45">记录ID</th>
        <th field="appCode" width="45">软件代码</th>
        <th field="appName" width="55">软件名称</th>
        <th field="latestVersion" width="120" >最新版本号</th>
        <th field="limitVersion" width="80">最小可用版本</th>
        <th field="description" width="100">软件描述</th>
        <th field="companyName" width="100">所属公司</th>　
        <th field="remark" width="200">备注</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addApp()">新增</a>
    <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editApp()">编辑</a>
    <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeApp()">删除</a>
    <a class="easyui-linkbutton" iconCls="icon-selected" plain="true" onclick="setActive()">置为当前项目</a>
    <a class="easyui-linkbutton" iconCls="icon-selected" plain="true" onclick="manageVersion()">版本管理</a>
</div>

<!--div>%=Mm.GetProperties("dataUrl")%></div>

<div id="win" class="easyui-window" title="My Window" style="width:300px;height:100px;padding:5px;">
  test
</div-->
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　

<div id="dlg" class="easyui-dialog" style="width:400px;height:420px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">项目列表</div>
    <form id="fm" method="post" novalidate>
        　
        <div class="fitem">
            <label>软件代码:</label>
            <input name="appCode" class="easyui-validatebox" required="true"/>
        </div>
        <div class="fitem">
            <label>软件名称:</label>
            <input name="appName"/>
        </div>
        <div class="fitem">
            <label>最新版本号:</label>
            <input name="latestVersion" required="true"/>
        </div>

        <div class="fitem">
            <label>最小可用版本:</label>
            <input name="limitVersion"/>
        </div>
        <div class="fitem">
            <label>软件描述:</label>
            <input name="description"/>
        </div>
        <div class="fitem">
            <label>所属公司:</label>
            <select name='companyId' style='width:100px'>
                <option value=" " selected >所属公司</option>
                <c:forEach var="company" items="${sessionScope.companyParams}">
                    <option value="${company.id}">${company.name}</option>
                </c:forEach>
            </select>
            <!--input name="companyId"/-->
            <%--<select class="easyui-combobox" name="companyId" style="width:150px;">--%>
                <%--<option value="1" selected>通览科技</option>--%>
                <%--<option value="2">中天软件</option>--%>
<%--　          </select>--%>
            <div class="fitem">
                <label>备注:</label>
                <input name="remark"/>
            </div>
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveApp()">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
</body>
</html>