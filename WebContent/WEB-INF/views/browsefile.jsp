<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Browse Files</title>
</head>
<body>
<h1>Welcome to baba photo sharing app!!</h1>
<br>
<a href="viewuploadedimages.jsp">View Album</a>
<br>
<form:form modelAttribute="imageFile" name="frm" method="post"
	enctype="multipart/form-data">
	<fieldset><legend>Upload File</legend>
	<table>
		<tr>
			<td><form:label for="imageFileData" path="imageFileData">File</form:label><br />
			</td>
			<td><form:input path="imageFileData" id="image" type="file" /></td>
		</tr>
		<tr>
			<td><br />
			</td>
			<td><input type="submit" value="Upload" /></td>
		</tr>
	</table>
	</fieldset>
</form:form>
</body>
</html>