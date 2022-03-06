<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.home.club.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<c:forEach items="${datas}" var="d">
				
				<div onclick="view(${d.c_id})">
					<input type="hidden" name="c_id" value="${d.c_id}">
					<img alt="" src="${d.c_photo}" width="100" height="100">
					<strong>${d.c_name}</strong>
				</div>
			</c:forEach>
				<c:out value="${path}" />
</body>
	<script type="text/javascript">
	function view(value) {
		location.href = "./viewDetail?c_id="+value;
	}
	</script>
</html>