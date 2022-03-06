<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:url var="jq_url" value="/static/jq"/>
<script type="text/javascript" src="${jq_url}/jquery-3.6.0.min.js"></script>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$(".enter").click(function(){
				var tr = $(this);
				var td = tr.children();
				
				var band_id = td.eq(0).text()
				var nickname = $('#nickname').val()
				
				console.log(nickname)
				console.log(band_id)
				
				var form1 = document.createElement('form');
				form1.name='form';
				form1.method='get';
				form1.action='./chat';
				
				var band = document.createElement('input');
				band.setAttribute("type","text");
				band.setAttribute("name","band_id");
				band.setAttribute("value",band_id);
				
				var name = document.createElement('input');
				name.setAttribute("type","hidden");
				name.setAttribute("name","nickname");
				name.setAttribute("value",nickname);
				
				form1.appendChild(band);
				form1.appendChild(name);
				document.body.appendChild(form1);
				form1.submit();
			})
		});
	</script>
</head>
<body>
	<div>
		<h2>방 만들기</h2>
		<form action="./chat" method="get">
			<label>방번호 : </label><input type="number" name="band_id"> 
			<label>이름 : </label><input type="text" name="nickname" id="nickname">
			<button >입장</button>
		</form>
	</div>
	<div>
		<h1>방 목록</h1>
		<table>
			<tr>
				<th>번호</th>
			</tr>
			<c:forEach var="room" items="${rooms }">
				<tr class="enter">
					<td>${room.roomId}</td>
				</tr>
			</c:forEach>		
		</table>
	</div>
</body>
</html>
