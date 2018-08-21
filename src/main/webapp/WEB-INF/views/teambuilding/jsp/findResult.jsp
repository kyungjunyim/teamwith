<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/teambuilding/css/frame.css">
</head>
<body>
			<div class="modal-content" style="width: 500px; margin: auto; margin-top:300px;">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<img src="/resources/image/logo/logoText.png" class="title_logo_text">
					</h5>
				</div>
				<div class="modal-body modal_text" style="text-align: center;">${msg }</div><br />
				<button type="button" class="btn btn-md btn_submit" onclick="location='/'" style="margin: 0 auto; margin-bottom: 30px;">홈으로 가기</button>
			</div>
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script>
</script>
</html>