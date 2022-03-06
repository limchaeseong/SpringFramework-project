<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<c:url var="jq_url" value="/static/jq"/>
<script type="text/javascript" src="${jq_url}/jquery-3.6.0.min.js"></script>
<title>성공</title>
</head>
<body>
	<script>
	$(function(){
		opener.parent.location.reload();
		window.close();
	})
	</script>
</body>
</html>