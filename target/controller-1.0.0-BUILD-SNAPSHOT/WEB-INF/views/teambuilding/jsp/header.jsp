<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<nav class="navbar navbar-inverse fixed-top menu_bar">
		<div class="container-fluid">
				<div class="navbar-header">
					<a href="/"><img src="/resources/image/logo/logoBox.png" class="title_logo_box"></a>
					<a href="/"><img src="/resources/image/logo/logoText.png" class="title_logo_text"></a>
				</div>
			<ul class="nav nav_menu_list">
				<li class="nav_menu">
					<a class="nav-link menu_link" href="/teamSearch">팀</a>
				</li>
				<li class="nav_menu"><a class="nav-link menu_link" href="/member">회원</a></li>
				<li class="nav_menu"><a class="nav-link menu_link" href="/portfolio">포트폴리오</a></li>
				<li class="nav_menu"><a class="nav-link menu_link commingSoon">공모전</a></li>
			</ul>
		</div>
	</nav>

	<button type="button" class="btn btn-primary" id="btn_modal" data-toggle="modal" data-target="#exampleModalCenter" style="display: none;"></button>
	<div class="modal fade bd-example-modal-sm" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<img src="/resources/image/logo/logoText.png" class="title_logo_text">
					</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body modal_text" style="text-align: center;">공모전 안내 서비스는 준비중입니다!</div>
			</div>
		</div>
	</div>

</body>
</html>