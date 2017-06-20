<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<%-- <div class="generic-container" style="margin-left: 9%; margin-top: 2%;">
	<a  href="<c:url value='/${fileList.name}' />"><span style="text-align: center; word-wrap: break-word;">Back</span></a>
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default" style="overflow: hidden; overflow:scroll;">
			  <!-- Default panel contents -->
			  <h3>${name}</h3>
			  <div class="panel panel-default">
				  <c:forEach items="${fileList.folder}" var="folder">
				  <div class="col-md-1 col-sm-4 col-xs-6 wrapper" style="display: block">
				  	<img class="img-responsive imgClip" alt="" src="http://pngimg.com/uploads/folder/folder_PNG8773.png">
				  	<p><a  href="<c:url value='/${folder.name}' />"><span style="text-align: center; word-wrap: break-word;">${folder.name}</span></a></p>
				  </div>
				  </c:forEach>
				  <c:forEach items="${fileList.file}" var="file">
				  <div class="col-md-1 col-sm-4 col-xs-6 wrapper" style="display: block">
				  	<img class="img-responsive imgClip" alt="" src="https://wiki.inspired-lua.org/images/b/b0/File.png">
				  	<p><a href="${file.path}"><span style="text-align: center; word-wrap: break-word;">${file.name}</span></a></p>
				  </div>
				  </c:forEach>
			  </div>
			  
		</div>
	</div> --%>

</body>
</html>