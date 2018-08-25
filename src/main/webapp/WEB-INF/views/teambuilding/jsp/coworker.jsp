<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#teamMember').click(function(e) {
			$('#${member.memberId}').submit();
		});
	});
</script>
</head>

<body>
	<div class="team_detail_row team_detail_content_interval">
		<div class="team_detail_row_title team_detail_title_content_font">합류한 팀원</div>
		<c:if test="${empty teamMembers }">
			<div class="team_detail_row_detail team_detail_row_text team_detail_content_interval">
				<label class="team_detail_img_small_text">합류한 팀원이 없습니다.</label>
			</div>
		</c:if>
		<div class="row coworker_row">
		<c:forEach items="${teamMembers }" var="member">
			<form action="polog.do" method="post" id="${member.memberId }">
				<input type="hidden" name="memberId" value="${member.memberId }">
				<div id="teamMember" class="coworker_col" onclick="$('#${member.memberId}').submit()">
					<div><img src="${member.memberPic }" class="team_detail_img_sm"></div>
					<div><label class="coworker_text">${member.memberName }님</label></div>
					<div><label class="coworker_text text_orange" style="font-size: 14px;">${applicationScope.roleList[member.roleId] }</label></div>
				</div>
			</form>
		</c:forEach>
		</div>
	</div>
</body>
</html>