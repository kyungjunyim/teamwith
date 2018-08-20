<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀 등록하기</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/teambuilding/css/frame.css">
<link rel="stylesheet" href="/resources/teambuilding/css/teamRegister.css">

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="home_container">
		<div class="row row_whole">
			<div class="col-xs-6 main_container">
				<div class="row main_row">
					<jsp:include page="teamRegisterForm.jsp" />
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
</body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/teambuilding/js/frame.js"></script>
</html>