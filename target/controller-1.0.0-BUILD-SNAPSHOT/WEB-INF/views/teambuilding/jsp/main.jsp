<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/teambuilding/css/frame.css">
<link rel="stylesheet" href="/resources/teambuilding/css/main.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="home_container">
		<div class="row row_whole">
			<div class="col-xs-6 main_container">
				<c:if test="${not empty sessionScope.memberSimpleVO}">
					<div class="row main_row">
						<jsp:include page="mainMyTeam.jsp" />
					</div>
				</c:if>
				<div class="row main_row">
					<jsp:include page="mainRecentTeam.jsp" />
				</div>
				<div class="row main_row" style="margin-bottom: 0px;">
					<jsp:include page="mainBestMember.jsp" />
				</div>
			</div>
			<div class="col-xs-6 side_container">
				<c:if test="${empty sessionScope.memberSimpleVO }">
					<div class="row side_row_whole">
						<jsp:include page="mainLogin.jsp" />
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.memberSimpleVO}">
					<div class="row side_row_whole">
						<jsp:include page="mainProfile.jsp" />
					</div>
				</c:if>
				<div class="row side_row_whole">
					<jsp:include page="mainPortfolio.jsp" />
				</div>
			</div>
		</div>
		<div class="row row_whole">
			<jsp:include page="footer.jsp" />
		</div>
	</div>

	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#memberRegisterModal" id="btn_member_register" style="display: none;"></button>
	<div class="modal fade bd-example-modal-sm" id="memberRegisterModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-md" role="document">
			<div class="modal-content">
				<form action="/account/register" method="post">
					<div class="modal-header">
						<h5 class="modal-title text_orange" id="exampleModalLongTitle">회원	가입</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<label class="register_label">아이디</label>
						<input type="text" placeholder="아이디" id="id" class="register_input" name="memberId" required><br>
						<label class="register_label">비밀번호</label> 
						<input type="password" id="pwd" placeholder="비밀번호" class="register_input" name="memberPassword" required><br>
						<label class="register_label">비밀번호 확인</label>
						<input type="password" id="pwd2" placeholder="비밀번호 확인" class="register_input" required><br>
						<label class="register_label">이름</label>
						<input type="text" placeholder="이름" class="register_input" name="memberName" required><br> 
						<label class="register_label">이메일</label>
						<input type="email" placeholder="이메일" class="register_input" name="memberEmail" required><br>
						<label class="register_label">생년월일</label> 
						<input type="date" placeholder="생년월일" class="register_input" name="memberBirth" required><br> 
						<label class="register_label">핸드폰번호</label>
						<input type="number" placeholder="핸드폰번호" class="register_input" name="memberPhone" required><br>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-md btn_submit"
							style="margin: auto;">회원 가입</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#findAccountModal" id="btn_find_account" style="display: none;"></button>
	<div class="modal fade bd-example-modal-sm" id="findAccountModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-md" role="document">
			<div class="modal-content">
				<form action="/account/findId" method="post">
					<div class="modal-header">
						<h5 class="modal-title text_orange" id="exampleModalLongTitle">아이디 찾기</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<label class="register_label">이메일</label>
						<input type="email" placeholder="이메일" class="register_input" name="memberEmail" required><br>
						<label class="register_label">생년월일</label> 
						<input type="date" placeholder="생년월일" class="register_input" name="memberBirth" required><br>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-md btn_submit" style="margin: auto;">아이디 찾기</button>
					</div>
				</form>
				<form action="/account/findPwd" method="post">
					<div class="modal-header">
						<h5 class="modal-title text_orange" id="exampleModalLongTitle">비밀번호 찾기</h5>
					</div>
					<div class="modal-body">
						<label class="register_label">아이디</label>
						<input type="text" placeholder="아이디" id="id" class="register_input" name="memberId" required><br>
						<label class="register_label">이메일</label>
						<input type="email" placeholder="이메일" class="register_input" name="memberEmail" required><br>
						<label class="register_label">생년월일</label> 
						<input type="date" placeholder="생년월일" class="register_input" name="memberBirth" required><br>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-md btn_submit" style="margin: auto;">비밀번호 찾기</button>
					</div>
				</form>
			</div>
		</div>
	</div>	

</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/teambuilding/js/frame.js"></script>
<script>
	var loginResult = "${loginResult }";
	if (loginResult == 'false') {
		alert("로그인 실패!");
	}
	var regResult = "${regResult }";
	if (regResult == 'success') {
		alert("회원가입을 축하합니다!");
	} else if (regResult == 'fail') {
		alert("죄송합니다. 회원가입에 실패하였습니다. 다시 시도해주세요.");
	}

	$(document).ready(function() {
		$('#pwd2').blur(function() {
			if ($('#pwd').val() != $('#pwd2').val()) {
				alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
			}else{
				alert('일치');
			}
		});
		
		$('#id').blur(function() {
			$.ajax({
				method : 'post',
				url : '/account/isDuple',
				traditional : true,
				data : {
					'actor' : '${sessionScope.memberSimpleVO.memberId }',
					'target' : '${memberVO.memberId }',
					'praise' : pr
				},

				success : function(data) {
					var i = 1; 
					$(data).each(function(){
						$('#praise' + i + '_cnt')[0].innerHTML=this.praiseCnt;
						console.log($('#praise' + i + '_cnt'));
						i++;
				});
					}

			});
			//ajax end
		});
	});
</script>
</html>