<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>上传图片</title>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		//String absPath = application.getRealPath(request.getRequestURI());
	%>
	<base href="<%=basePath%>"/>
<link href="<%=basePath%>css/basic.css" rel="stylesheet" />
<link href="<%=basePath%>css/dropzone.css" rel="stylesheet" />
<script src="<%=basePath%>js/dropzone.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/file/upload.action" method="post" enctype="multipart/form-data"
		class="dropzone" id="dropzoneForm">
		<!-- <input type="file" name="file" /> 
		<input type="submit" value="Submit" />
		 -->
	</form>
	<script type="text/javascript">
		Dropzone.options.dropzoneForm = {
			init : function() {
				this.on("complete", function(data) {
					var res = eval('(' + data.xhr.responseText + ')');
					alert(" success : "+ res.success +"\n" + " msg : "+ res.msg +"\n"
					+ " path : "+ res.path +"\n" + " md5_name : "+ res.md5_name+"\n"
					+ " ori_name : "+ res.ori_name+"\n" + " url : "+ res.url);
				});
			}
		};
	</script>
</body>
</html>