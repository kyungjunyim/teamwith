<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<div class="col footer_col_whole">
		<div class="row footer_row">
			<div class="col footer_col">
				<img src="/resources/image/logo/teamLogoText.png"
					class="footer_logo_text">
			</div>
			<c:if test="${not empty sessionScope.memberSimpleVO }">
			<div class="col footer_col footer_col_text" style="text-align: right; line-height: 90px;">
				<label style="font-size: 12px; cursor: pointer">고객 센터</label>&nbsp;
				<label style="font-size: 12px; cursor: pointer">1:1 문의하기</label>&nbsp;
				<label style="font-size: 12px; cursor: pointer">공지사항</label>&nbsp;
				<label style="font-size: 12px; cursor: pointer">신고하기</label>&nbsp;
				<label style="font-size: 12px; cursor: pointer" id="label_remove_member">회원 탈퇴</label>
			</div>
			</c:if>
			<div class="col footer_col footer_col_text">
				<span>렉토피아 전문가 과정 16기</span><br /> <span>황규진, 김종승, 임경준, 조란</span>
			</div>
		</div>
	</div>
</body>
</html>