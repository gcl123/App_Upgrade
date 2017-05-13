<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">
<head>
    <title>标题</title>
    <link rel="stylesheet" type="text/css"
          href="${staticPath}/static/css/index.css?v=${staticVersion}"/>
    <script type="text/javascript"
            src="${staticPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript"
            src="${staticPath}/static/js/template.js"></script>
    <script type="text/javascript"
            src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script type="text/javascript"
            src="${staticPath}/static/js/index.js?v=${staticVersion}"></script>
</head>

<body ontouchstart="">
<script type="text/javascript">
    var global_config = JSON.parse('${jsGlobal}');
    var jssdk_config = {
        'appId': '${wxJSApi.appId}',
        'timestamp': ${wxJSApi.timestamp},
        'nonceStr': '${wxJSApi.nonceStr}',
        'signature': '${wxJSApi.signature}'
    };
</script>
<div class="mod_container" style="position: relative;">
    <div class="headBar clearfix">


    </div>
    <div class="scrollTop" style="display: block;"></div>
</div>
</div>


<script type="text/javascript"
        src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"
        charset="utf-8">
</script>


</body>
</html>