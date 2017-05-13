<!--%@page import="com.manage.platform.entity.MANAGE_USEREntity"%-->
<!--%@page import="com.manage.platform.entity.MANAGE_AREAEntity"%-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        //String absPath = application.getRealPath(request.getRequestURI());
    %>
    <base href="<%=basePath%>"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>通览软件发布管理平台</title>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/tree_themes/SimpleTree.css"/>

    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/common.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/main.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/SimpleTree.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".st_tree").SimpleTree({
                click: function (a) {
                    //if(!$(a).attr("hasChild"))
                    //alert($(a).attr("ref"));
                    var sref;
                    sref = $(a).attr("ref");
                    if ("welcome" == sref) {
                        addTab('首页', 'jsp/welcome.jsp');
                        $("#curMd").text('首页');

                    }
                    else if ("user" == sref) {
                        addTab('用户管理', 'jsp/error404.jsp');
                        $("#curMd").text('系统管理 > 用户管理');
                    }
                    else if ("company" == sref) {
                        addTab('公司列表', 'jsp/companyList.jsp');
                        $("#curMd").text('系统管理 > 公司列表');
                    }
                    else if ("cfg" == sref) {
                        addTab('参数设置', 'jsp/error404.jsp');
                        $("#curMd").text('系统管理 > 参数设置');
                    }
                    else if ("appList" == sref) {
                        addTab('项目列表', 'jsp/appList.jsp');
                        $("#curMd").text('项目管理 > 项目列表');
                    }
                    else if ("appAppend" == sref) {
                        addTab('新增项目', 'jsp/error404.jsp');
                        $("#curMd").text('项目管理 > 新增项目');
                    }
                    else if ("about" == sref) {
                        addTab('关于', 'jsp/about.jsp');
                        $("#curMd").text('关于');
                    }

                }
            });
        });
    </script>

</head>
<body style="border:none;visibility:visible;width: 100%;height: 100%;" onload="showTime();">
<div id="cc" class="easyui-layout" style="width:100%;height:100%;">
    <!-- 页面顶部top及菜单栏 -->
    <div region="north" style="height:96px;width: 100%;">
        <div class="header" style="background:#fff url('<%=basePath%>css/images/banner.jpg');">
            <div style="text-align: right; padding-right: 20px; padding-top: 30px; padding-bottom: 14px;">
                <span style="color:#FDFDFD" id="loginuserInfo">欢迎你，zxyu
                    <!--%=((MANAGE_USEREntity)session.getAttribute("user")).getNAME()%--></span>
                <span style="color:#FDFDFD" id="loginuserArea">@tonlan
                    <!--%=((MANAGE_AREAEntity)session.getAttribute("area")).getNAME()%--></span>
                <span style="color:#FDFDFD" id="timeInfo"></span>
                <a href="<%=basePath%>jsp/login.jsp" style="color:#FDFDFD;text-decoration:none;">退出</a>
            </div>
            <div class="maintitle" style="top: 12px;font-size:20px;color:#FDFDFD; margin-left:5px;">通览软件发布管理平台</div>
        </div>
        <div id="topmenu" class="topmenu"
             style="height:34px;background:url('<%=basePath%>css/images/maintop.png');color:#fff;font-size:14px;font-weight:bold;">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a id="curMd">首页</a>

            <!--
            <span id="curMd"  style="top:17px; margin-left:15px;"> 首页</span>
            a href="javascript:addTab('首页','pages/welcome.html')" >首&nbsp;&nbsp;页</a>
            <a href="javascript:addTab('我的项目','project.html')" >我的项目</a>
            <a href="javascript:addTab('关于','about.html')" >关于</a-->
        </div>
    </div>
    <!-- 页面底部信息 -->
    <div region="south" style="height: 18px;">
        <center>
        </center>
    </div>
    <!-- 左侧导航菜单 -->
    <div region="west" title="导航菜单栏" style="width:180px;"><!--easyui-tree-->
        <div class="st_tree">
            <ul>
                <li><a ref="welcome">首页</a></li>
                <li><a ref="#">基础数据</a></li>
                <ul show="true">
                    <li><a ref="user">用户管理</a></li>
                    <li><a ref="company">公司列表</a></li>
                    <li><a ref="cfg">参数设置</a></li>
                </ul>
                <li><a ref="">项目管理</a></li>
                <ul show="true">
                    <li><a ref="appList">项目列表</a></li>
                    <li><a ref="appAppend">新增项目</a></li>
                 </ul>
                <li><a ref="">当前项目</a></li>
                <ul show="true">
                    <li><a ref="appList">项目信息</a></li>
                    <li><a ref="appList">文件上传</a></li>
                    <li><a ref="appAppend">文件管理</a></li>
                    <li><a ref="appAppend">安装脚本制作</a></li>
                    <li><a ref="appAppend">安装脚本测试</a></li>
                </ul>
                <li><a ref="about">关于</a></li>
            </ul>
        </div>
        <!--ul id="tt1" class="st_tree" data-options="animate:true,dnd:true,lines:true"></ul>
            <li><a href="">首页</a></li>
            <li><span>我的项目</span>
                <ul>
                    <li><a href="">浏览项目</a></li>
                    <li><a href="">新增项目</a></li>
                </ul>
            </li>
            <li><a href="">关于</a></li-->
    </div>
    <!-- 主显示区域选项卡界面 -->
    <div region="center">
        <div class="easyui-tabs" fit="true" id="tt">
            <div title="首页" data-options="closable:true">
                <iframe width='100%' height='100%' id='iframe' name='iframe' frameborder='0' scrolling='auto'
                        src='jsp/welcome.jsp'></iframe>
            </div>
        </div>
    </div>
    <div id="dd"></div>
</div>
</body>
</html>