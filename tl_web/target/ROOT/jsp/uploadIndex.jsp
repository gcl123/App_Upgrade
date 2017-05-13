<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-04-20
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        //String absPath = application.getRealPath(request.getRequestURI());
    %>
    <base href="<%=basePath%>"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css"/>
    <!--link rel="stylesheet" type="text/css" href="easyui/demo/demo.css"/-->
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/JQuery-formui.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/common.js"></script>
    <script>
        var fso;
        var curDrive;
        var nodeId = 0;
        var fileId = 65535;
        fso = new ActiveXObject("Scripting.FileSystemObject");
        //==============================================================================================================
        //  函数功能:初始化文件磁盘列表
        //  参数说明:无
        //  函数返回:无
        //  作者: 张旭煜
        //  日期: 2017-5-5
        //==============================================================================================================
        function initDirves()
        {
            var s, e, x, n;
            curDrive = "C:";
            //alert("begin...");
            //fso = new ActiveXObject("Scripting.FileSystemObject");
            e = new Enumerator(fso.Drives);
            s = "";
            for (; !e.atEnd(); e.moveNext())
            {
                x = e.item();
                s = s + x.DriveLetter;
                s += ":";
                if (x.DriveType == 3)
                    n = x.ShareName;
                else if (x.IsReady)
                    n = x.VolumeName;
                else
                    n = "[unknow]";
                s +=   n + ",";
            }
            var drives = s.split(",");
            var tableDrives = document.getElementById("drives");
            for ( var i = 0; i < drives.length-1; i++ )
            {
                var option = document.createElement("option");
                drives[i].split(":");
                option.value = drives[i].split(":")[0]+":";
                option.text = "["+drives[i].split(":")[0]+":]"+drives[i].split(":")[1];
                tableDrives.add(option);
            }
        }

        //==============================================================================================================
        //  函数功能:删除树指定结点下的内容
        //  参数说明:tree-树; node-结点
        //  函数返回:无
        //  作者: 张旭煜
        //  日期: 2017-5-5
        //==============================================================================================================
        function removeTreeNode(tree, node)
        {
            if(node)
            {
                var childrenNodes = tree.tree('getChildren', node.target);
                var childrenNode;
                for (i=0; i < childrenNodes.length; i++)
                {
                    childrenNode = childrenNodes[i];
                    tree.tree('remove', childrenNode.target);
                }
            }
        }

        //==============================================================================================================
        //  函数功能:增加树指定结点下的内容
        //  参数说明:tree-树; node-结点; nodes-结点列表
        //  函数返回:无
        //  作者: 张旭煜
        //  日期: 2017-5-5
        //==============================================================================================================
        function addTreeNodes(tree, node, nodes)
        {
            //var node = $('#tt').tree('getSelected');
            if (node)
            {
                removeTreeNode(tree, node);
                tree.tree('append', {parent:node.target, data:nodes});
            }
        }

        //==============================================================================================================
        //  函数功能:获取树指定结点所对应的绝对路径
        //  参数说明:tree-树; node-结点;
        //  函数返回:文件或目录的绝对路径
        //  作者: 张旭煜
        //  日期: 2017-5-5
        //==============================================================================================================
        function getDir(tree, node)
        {
            var sDir = "";
            if(node)
            {
                var parentNode = tree.tree('getParent', node.target);
                while (parentNode)
                {
                    sDir = parentNode.text + "\\\\" + sDir;
                    parentNode = tree.tree('getParent', parentNode.target);
                }
            }
            return sDir;
        }

        //==============================================================================================================
        //  函数功能:磁盘目录转换为树
        //  参数说明:tree-树; node-结点;
        //  函数返回:文件或目录的绝对路径
        //  作者: 张旭煜
        //  日期: 2017-5-5
        //==============================================================================================================
        function listDirAndFile(tree, node)
        {
            if(node)
            {
                var sDir = node.text + "\\";
                nodeId = node.id;

                if (nodeId > 65535)
                {
                    return 0;
                }
                var parentNode = tree.tree('getParent', node.target);
                while (parentNode)
                {
                    sDir = parentNode.text + "\\\\" + sDir;
                    parentNode = tree.tree('getParent', parentNode.target);
                }
                //alert(sDir);

                var o = fso.GetFolder(sDir);
                var e;
                var itemName, sJson = "";
                //add dir
                e = new Enumerator(o.SubFolders);

                while(!e.atEnd())
                {
                    nodeId++;
                    itemName = e.item().name;
                    sJson += "{\"id\":" + nodeId + ",\"text\":\"" + itemName + "\",\"iconCls\":\"icon-doc\"},";
                    e.moveNext();
                }
                //add file
                e = new Enumerator(o.Files);
                while(!e.atEnd())
                {
                    fileId++;
                    itemName = e.item().name;
                    sJson += "{\"id\":" + fileId + ",\"text\":\"" + itemName + "\"},";
                    e.moveNext();
                }
                //alert(sJson);
                if(sJson.length > 5)
                {
                    sJson = "[" + sJson.substr(0, sJson.length-1) + "]";
                    var myJson = eval("(" + sJson + ")");
                    addTreeNodes(tree, node, myJson);
                }
            }//if(node) end
        }

        //选择磁盘
        function driveChange()
        {
            var index = document.all.drives.options.selectedIndex;
            if (index>=0)
            {
                curDrive = document.all.drives.options[index].value;
                var tree = $('#tt2');
                treeData = "[{\"id\": 1,\"text\":\"" + curDrive + "\"}]";
                var myJson = eval("(" + treeData + ")");
                tree.tree({data: myJson});
                var childrenNodes = tree.tree('getChildren', null);
                //alert(childrenNodes.length);
                if (childrenNodes.length > 0)
                {
                    var firstNode = childrenNodes[0];
                    listDirAndFile(tree, firstNode);
                }
            }
        }

        //选中文件加入传输队列
        function listFile(tree)
        {
            var nodes = tree.tree('getChecked');
            var sJson = "";
            var total = 0;
            var fileName = "";
            //var file;
            if (nodes.length > 0)
            {
                for(var i=0; i<nodes.length; i++)
                {
                    if (nodes[i].id > 65535)
                    {
                        //append row
                        total++;
                        fileName = getDir(tree, nodes[i])  + nodes[i].text;
                        //alert(fileName);
                        var  file = fso.getfile(fileName);
                        if(file)
                            sJson += "{\"fileName\":\"" + fileName + "\",\"size\":" + file.size + "},";
                        else
                            sJson += "{\"fileName\":\"" + fileName + "\",\"size\":0},";

                    }
                }
                sJson = "[" + sJson.substring(0, sJson.length - 1) + "]";

            }
            else
            {
                sJson = "[]"
            }
            //alert(sJson);
            var json = eval("(" + sJson + ")");//JSON.parse(sJson);
            $("#tbFileList").datagrid('loadData', {total:total, rows:json});
        }

        function fmAddFile(fileName)
        {
           var s = "<input type='file' name='file' value='" + fileName + "'>";
            $("#fileArea").append(s);
        }

        function uploadFile()
        {
           // $('#file').innerHTML = "";
           /* alert("o.innerHTML");
            var o = getElementById("fileArea");
            alert(o.innerHTML);*/
            var  file = fso.getfile("d:\\1.bmp");
            var url='<%=basePath%>file/upload.action?fileName=' + file.name;

            document.getElementById("bytesRead").textContent = file.size;
            console.log("1");
           /* $.ajax({
                type: "post",
                url: url,


                data:file,
                processData:false,
                contentType: false,//"json",//text/html
                error : function(event,request, settings)
                {
                    // $.messager.alert("提示消息", "请求失败!", "info");
                    // window.location.href="jsp/main.jsp";
                    console.log("upload error:" + file.name);
                    alert("error.");

                },
                success : function(data)
                {
                    console.log("upload complete:" + file.name);
                    alert("ok.");

                }
            });
            return 0;*/
            var reader = new FileReader();
            console.log("1");
            reader.onloadstart = function() {
                // 这个事件在读取开始时触发
                console.log("onloadstart");
                document.getElementById("bytesTotal").textContent = file.size;
            }
            /*reader.onprogress = function(p) {
                // 这个事件在读取进行中定时触发
                console.log("onprogress");
                document.getElementById("bytesRead").textContent = p.loaded;
            }*/
            reader.onload = function() {
                // 这个事件在读取成功结束后触发
                console.log("load complete");
            }

            reader.onloadend = function()
            {
                // 这个事件在读取结束后，无论成功或者失败都会触发
                if (reader.error) {
                    console.log(reader.error);
                } else
                {

                    // 构造 XMLHttpRequest 对象，发送文件 Binary 数据
                    //var xhr = new XMLHttpRequest();
                    var xhr;
                    if(window.XMLHttpRequest){
                        xhr=new XMLHttpRequest();
                        if(xhr.overrideMimeType){
                           ; //xhr.overrideMimeType("text/xml");
                        }
                    }else if(window.ActiveXObject){
                        var activeName=["MSXML2.XMLHTTP","Microsoft.XMLHTTP"];
                        for(var i=0;i<activeName.length;i++){
                            try{
                                xhr=new ActiveXObject(activeName[i]);
                                break;
                            }catch(e){

                            }
                        }
                    }
                    xhr.open("POST",url);
                    xhr.overrideMimeType("application/octet-stream");
                    xhr.sendAsBinary(reader.result);
                    xhr.onreadystatechange = function() {
                        if (xhr.readyState == 4) {
                            if (xhr.status == 200) {
                                console.log("upload complete");
                                console.log("response: " + xhr.responseText);
                            }
                        }
                    }
                }
            }

            var blob = file.slice(0,file.size()-1);
            reader.readAsArrayBuffer(blob);
        }

    </script>
    
</head>
<body onload="initDirves()" style="background:url('<%=basePath%>css/images/FooterBG.jpg') no-repeat right bottom;">
<!--div style=" margin:20px; text-align:center; font-size:28px;">文件上传</div-->
<!--%=PublicinformationUtil.GetProperties("sysname")%-->
<div id="pnlAppInfo" class="easyui-panel" style="width:1144px;height:54px;padding:4px;"
     data-options="title:'App信息'">
    <b>AppCode：Updater;&nbsp;&nbsp;&nbsp;&nbsp;
        App名称：App下载器&nbsp;&nbsp;&nbsp;&nbsp;
        所属公司：浙江通览科技有限公司&nbsp;&nbsp;&nbsp;&nbsp;
        最新版本：1.0.0.1</b>
</div>

<div id="container_id">
<!--ul>
    <li><a href="tonlan://upload?type=1&appInfo='123456789'">一键上传</a></li>
    <li><a href="tonlan://upload?type=2&appInfo='123456789'">选择上传</a></li>
</ul-->
</div>

<div style="width:1200px;float:left">

    <div style="width:484px;float:left">
        <!--dir list-->
        <div class="easyui-panel" title="选择文件" style="width:484px;height:604px;">

            <select id="drives" name="drives" style="width:450px" onchange="driveChange()"></select>

            <ul id="tt2" class="easyui-tree" data-options="checkbox:true" onClick="listDirAndFile($('#tt2'), $('#tt2').tree('getSelected'))"></ul>

        </div>
    </div>

    <div style="width:704px;float:left">
        <!--file list table-->

        <table id="tbFileList" class="easyui-datagrid" title=" " style="width:660px;height:604px"
               data-options="rownumbers:true,singleSelect:true, toolbar:'#tb'">
            <thead>
            <tr>
                <th data-options="field:'fileName',width:500">FileName</th>
                <th data-options="field:'size',width:100,align:'right'">Size</th>
            </tr>
            </thead>
        </table>
        <!--tool bar-->
        <div id="tb" style="padding:2px 50px;">
            <a class="easyui-linkbutton" iconCls="icon-ok" onclick="listFile($('#tt2'))">加入队列</a>
            <a class="easyui-linkbutton" iconCls="icon-ok" onclick="uploadFile()">上传</a>
            <span id="bytesRead"/>${pageContext.request.contextPath} <span id="bytesTotal"/>
            <form id="fmFiles" action="<%=basePath%>/file/upload.action?id=111&versionid=123"
                  enctype="multipart/form-data" method="post" >
                <span id="fileArea"><input type="file" name="file" id="file" value="d:\\1.bmp"/></span>  <input type="submit" value="提交"/>
            </form>
        </div>


        <!--/div-->
    </div>

</div>




</body>
</html>
