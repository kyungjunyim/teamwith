<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/teamwith15/css/bootstrap.min.css">
<link rel="stylesheet" href="/teamwith15/teambuilding/css/frame.css">
<link rel="stylesheet" href="/teamwith15/teambuilding/css/main.css">
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
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/teamwith15/js/bootstrap.min.js"></script>
<script src="/teamwith15/teambuilding/js/frame.js"></script>
</html>