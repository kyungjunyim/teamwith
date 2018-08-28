<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<div class="col footer_col_whole">
		<div class="row footer_row">
			<div class="col footer_col">
				<img src="/resources/image/logo/teamLogoText.png"
					class="footer_logo_text">
			</div>

			<div class="col footer_col footer_col_text"
				style="text-align: right; padding-top: 35px;">
				<label class="label_footer">고객 센터</label>&nbsp; <label
					class="label_footer">1:1 문의하기</label>&nbsp; <label
					class="label_footer">공지사항</label>&nbsp; <label class="label_footer">신고하기</label>&nbsp;
				<c:if test="${not empty sessionScope.memberSimpleVO }">
					<label class="label_footer" id="label_remove_member">회원 탈퇴</label>
				</c:if>
			</div>

			<div class="col footer_col footer_col_text">
				<span>렉토피아 전문가 과정 16기</span><br /> <span>황규진, 김종승, 임경준, 조란</span>
			</div>
		</div>
	</div>
</body>
</html>