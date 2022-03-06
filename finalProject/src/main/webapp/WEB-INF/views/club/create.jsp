<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.home.club.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:url var="choicePhoto" value="resources/imgUpload/insert/download" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/club/create.css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/jquery-3.6.0.min.js"></script>
<title>모임 만들기</title>
</head>
<body class="createBody">
	<c:import url="../header.jsp" />
	<form action="./create" method="POST" enctype="multipart/form-data">
		<div class="coverMain">
			<div class="mainName">
				<h4>모임이름</h4>
				<input type="text" name="c_name" class="clubName" maxlength="50" placeholder="모임 이름 입력">
			</div>
			<div class="select_img"><img id="c_photo" name="c_photo" src="${choicePhoto}1-1.jpg" width="300" height="225">
			</div>
			<div class="coverList">
				<div class="coverChoice">
					<h4>커버 선택</h4>
					<div class="navi">
						<span class="paging">
							<strong id="pageNum" style="color:#2ecc71">1</strong>
							/ 6
						</span>
						<span>
							 <button type="button" class="btnPrevious" id="previousPage2" onclick="previousPage()"></button>
		           			<button type="button" class="btnNext" id="nextPage3" onclick="nextPage()"></button>
						</span>	
					</div>
				</div>
				<div id="pagination-div" class="wrap_con" id="listPage">
					<ul>
						<li>
							<label>
								<input type="file" id="addPhoto" name="file" accept="image/gif, image/jpeg, image/png" style="display:none" />
								<input type="text" id="src_info" name="src_info" value="" style="display:none" />
								<img class="pictures" src="${choicePhoto}Add.jpg">
							</label>
						</li>
					</ul>
					<div id="list1">
						<ul class="con on" style="display: block">
								<li><a><img class="pictures" src="${choicePhoto}1-1.jpg" onclick="imgChange(this.src)"></a></li>
								<li><a><img class="pictures" src="${choicePhoto}1-2.jpg" onclick="imgChange(this.src)"></a></li>
								<li><a><img class="pictures" src="${choicePhoto}1-3.jpg" onclick="imgChange(this.src)"></a></li>
								<li><a><img class="pictures" src="${choicePhoto}1-4.jpg" onclick="imgChange(this.src)"></a></li>
								<li><a><img class="pictures" src="${choicePhoto}1-5.jpg" onclick="imgChange(this.src)"></a></li>
								<li><a><img class="pictures" src="${choicePhoto}1-6.jpg" onclick="imgChange(this.src)"></a></li>
								<li><a><img class="pictures" src="${choicePhoto}1-7.jpg" onclick="imgChange(this.src)"></a></li>
						</ul>
					</div>
					<div id="list2" style="display: none">
						<ul class="con">
							<li><a><img class="pictures" src="${choicePhoto}2-1.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}2-2.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}2-3.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}2-4.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}2-5.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}2-6.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}2-7.jpg" onclick="imgChange(this.src)"></a></li>
						</ul>
					</div>
					<div id="list3" style="display: none">
						<ul class="con">
							<li><a><img class="pictures" src="${choicePhoto}3-1.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}3-2.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}3-3.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}3-4.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}3-5.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}3-6.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}3-7.jpg" onclick="imgChange(this.src)"></a></li>
						</ul>
					</div>
					<div id="list4" style="display: none">
						<ul class="con">
							<li><a><img class="pictures" src="${choicePhoto}4-1.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}4-2.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}4-3.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}4-4.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}4-5.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}4-6.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}4-7.jpg" onclick="imgChange(this.src)"></a></li>
						</ul>
					</div>
					<div id="list5" style="display: none">
						<ul class="con">
							<li><a><img class="pictures" src="${choicePhoto}5-1.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}5-2.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}5-3.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}5-4.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}5-5.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}5-6.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}5-7.jpg" onclick="imgChange(this.src)"></a></li>
						</ul>
					</div>
					<div id="list6" style="display: none">
						<ul class="con">
							<li><a><img class="pictures" src="${choicePhoto}6-1.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}6-2.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}6-3.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}6-4.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}6-5.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}6-6.jpg" onclick="imgChange(this.src)"></a></li>
							<li><a><img class="pictures" src="${choicePhoto}6-7.jpg" onclick="imgChange(this.src)"></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="makeArea">
			<p class="makeText">모임이름과 사진은 개설 후에도 변경할 수 있어요</p>
		</div>
		<div class="makeType">
			<h4 class="title">밴드 공개</h4>
			<div class="clubType">
				<ul class="typeList">
					<li class="typeListItem">
						<input type="radio" value="N" name="c_open" id="N" class="checkInput" checked="checked">
						<span class="checkLabel">
							<strong>모임명 공개 모임</strong>
							<span class="msg">
								누구나 모임을 검색으로 찾아 모임 소개를 볼 수 있지만, 게시글은 멤버만 볼 수 있습니다.
							</span>
						</span>	
					</li>
					<li class="typeListItem">
						<input type="radio" value="Y" name="c_open" id="Y" class="checkInput">
						<span class="checkLabel">
							<strong>공개 모임</strong>
						</span>
						<span class="msg">
							누구나 모임을 검색으로 찾을 수 있고, 모임 소개와 게시글을 볼 수 있습니다.
						</span>
					</li>
				</ul>
			</div>
			<input type="hidden" id="cg_id" name="cg_id" value="">
			<div class="btnArea">
				<button type="button" class="btnCancel" onclick="location.href='/category'">취소</button>
				<button type="submit" class="btnConfirm">완료</button>
			</div>
		</div>	
	</form>
	<script>

		function getParameterByName(name) {
		    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
		    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
		        results = regex.exec(location.search);
		    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
		}
		var cg_id = getParameterByName("cg_id");
		document.getElementById("cg_id").value = cg_id;

		
		
		$("#addPhoto").change(function(e){
			if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) {
			  	 	$(".select_img img").attr("src", data.target.result).width(300).height(225);        
			    }
			    reader.readAsDataURL(this.files[0]);
			}
		});

		function imgChange(src) {
			document.getElementById("c_photo").src=src;
			document.getElementById("src_info").value=src;
		}	
		
		let currentPage = document.getElementById("pageNum");
		
		function previousPage() {
			if (Number(currentPage.innerText) !== 1) {
				hideList();
				currentPage.innerText = Number(currentPage.innerText) - 1;
				showList();
			}
		}
		
		function nextPage() {
			if (Number(currentPage.innerText) !== 6) {
				hideList();
				currentPage.innerText = Number(currentPage.innerText) + 1;
				showList();
			}
		}
		
		function showList() {
			document.getElementById(
				"list" + [currentPage.innerText]
			).style.display = "block";
		}
		
		function hideList() {
	       	document.getElementById(
				"list" + [currentPage.innerText]
			).style.display = "none";
	       }
	</script>
</body>
</html>