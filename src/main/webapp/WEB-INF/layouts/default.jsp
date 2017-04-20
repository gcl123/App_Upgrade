<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemesh"
           uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title><sitemesh:title/></title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=yes">

    <link rel="shortcut icon" type="image/x-icon"
          href="${staticPath}/static/img/favicon.ico">
    <link rel="stylesheet" type="text/css"
          href="${staticPath}/static/css/common.css?v=${staticVersion}"/>
    <script type="text/javascript"
            src="${staticPath}/static/js/api/jquery-1.11.0.min.js"></script>
    <script type="text/javascript"
            src="${staticPath}/static/js/template.js"></script>
    <script type="text/javascript"
            src="${staticPath}/static/js/common.js?v=${staticVersion}"></script>
    <sitemesh:head/>

</head>
<body>

<div class="mod_tips" id="mod_tips" style="display: none;"></div>

<sitemesh:body/>

<div id="datePlugin"></div>

<div id="loadingPlugin" style="display: none;">
    <div class="loadingWrapper">
        <img src="${staticPath}/static/img/loading.gif">
        <span id="loadingMsg"></span>
    </div>
</div>

<div id="popupTipMod" style="display: none">
    <div id="popupTipContent">
        <img src="/static/img/error/zaizhebao_icon_popup_warn.png"/>

        <p id="tip"></p>
        <a id="btn" class="btn" href="javascript:void(0);"
           onclick="common.hidePopupTip();">我知道了</a>
    </div>
</div>

<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?58b06db1e193384da2eeeace8bc719db";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

</body>
</html>
