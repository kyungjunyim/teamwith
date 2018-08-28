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
				<c:if test="${not empty bestMemberList }">
				<div class="row main_row" style="margin-bottom: 0px;">
					<jsp:include page="mainBestMember.jsp" />
				</div>
				</c:if>
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
		<div class="row row_whole" style="margin-top: 0;">
			<jsp:include page="footer.jsp" />
		</div>
	</div>
	<jsp:include page="modalSet.jsp" />
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