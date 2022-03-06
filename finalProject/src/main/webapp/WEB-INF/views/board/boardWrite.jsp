<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src = "<c:url value="/resources/ckeditor/ckeditor.js"/>"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	<div>
		<img src="<c:url value="/resources/img/board/boardWrite.png"/>" alt="글쓰기" 
		data-toggle="modal" data-target="#myModal" style="width:500px; border:2px solid gray;" />
	</div>
<!-- 	<a data-toggle="modal" data-target="#myModal">모달 창</a> -->
	<div class="modal fade" id="myModal" role="dialog"> 
		<div class="modal-dialog modal-lg" > 
			<div class="modal-content" style="width:80%; height:70%"> 
				<div class="modal-header">
				 	<h5 class="modal-title">게시판 글쓰기</h5>
				 	<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-body">
				  	<form method = "post" action = "./boardWrite" >
						<div class="form-group">
							<input name ="name" id = "title" class="form-control" size = "60" placeholder = "글제목을 입력하세요" value="">
						</div>
						<textarea id = "description" name = "content" rows ="80" cols = "180"  placeholder= "글내용을 적어주세요." value=""></textarea> 
						<div style = "text-align:right;" >
							<button type = "submit" class="btn btn-primary" name = "submit">게시글쓰기</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
				  	<p>팝업 footer</p>
				</div>
		    </div>
	    </div>
	</div>

<script>


//에디터 사용
CKEDITOR.replace("description",{
    filebrowserUploadUrl : "${pageContext.request.contextPath}/boardWrite",
    	width : '600px',  
        height : '300px',  
        	// ,  startupFocus : false
        extraPlugins : 'confighelper'

});

$('#myModal').on('hidden.bs.modal', function (e) {
    console.log('modal close');
  $(this).find('form')[0].reset()
});

$('#myModal').modal({backdrop: 'static', keyboard: false}) ;

$('.close').on('click', function(){
	if(confirm('정말 글쓰기 창을 닫으시겠습니까? 작성된 내용은 삭제됩니다.')){
		CKEDITOR.instances.description.setData('');	
	}
});

CKEDITOR.config.resize_enabled = false; 
</script>
</body>
</html>