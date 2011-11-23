<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<h2><a href="browsefile.jsp">Upload More Files</a></h2>
<h3>Uploaded images:</h3>
    <table border="0">
	    <c:forEach items="${imagesPath}" var="imagePath">
	    <tr>
	    	<td>
	    		<!--  <img
					src="${imagePath}"
					alt="Upload Image" /> -->				    	
	    		<c:out value="${imagePath}"/>
	    		
	    	</td> 
	    <tr>
	    </c:forEach>
	    
    </table>
    <img
	src="<%= session.getAttribute("sessionImage")%>"
	alt="Upload Image" />
    
<br>
<br>
<br>
<br>
</body>
</html>