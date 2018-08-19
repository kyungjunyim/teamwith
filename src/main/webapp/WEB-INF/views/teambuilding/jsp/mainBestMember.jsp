<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="row main_title">
		<div class="col">
			<span class="text_orange">우수</span>
			<span class="text_blue">회원</span>
		</div>
	</div>
	<c:if test="${empty bestMemberList }">
		<div class="row main_row_whole">
			<label class="label_no_exist">
				아직 등록된 회원이 없습니다!
			</label>
		</div>	
	</c:if>
	<c:if test="${not empty bestMemberList }">
	<div class="row best_member_row_whole">
		<c:forEach items="${bestMemberList }" var="bestMember" begin="0" end="3">
		<form action="polog.do" method="post" id="bestMemberForm${bestMember.memberId }">
			<input type="hidden" name="memberId" value="${bestMember.memberId }">
			<div class="col-xs-6 main_content_col" onclick="$('#bestMemberForm${bestMember.memberId }').submit()">
				<div class="row member_image_row">
					<img src="${bestMember.memberPic }" class="member_image">
				</div>
				<div class="row member_content_text">
					<div class="row member_text">
						<label class="member_text">${bestMember.memberName }님</label>
					</div>
					<div class="row member_text">
						<label class="member_text member_praise_text">${bestMember.totalPraiseCnt }회 칭찬</label>
					</div>
				</div>
			</div>
		</form>
		</c:forEach>
	</div>
	</c:if>
</body>
</html>