<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e){
		$('#img').click(function(e){
			$('#recommendForm').submit();
		});
		
	});
</script>
</head>
<body>
	<div class="team_detail_row team_detail_content_interval">
		<div class="team_detail_row_title team_detail_title_content_font">추천 팀원</div>
		<div class="row coworker_row">
			<c:forEach items="${recommendedMemberList }" var="recommendedMember">
				<div id="teamMember" class="coworker_col" onclick="location = '/polog/${recommendedMember.memberId }'">
					<div><img src="${recommendedMember.memberPic }" class="team_detail_img_sm"></div>
					<div><label class="coworker_text">${recommendedMember.memberName }님</label></div>
					<div><label class="coworker_text text_orange">일치율 ${fn:substring(recommendedMember.rate, 0, 4) }%</label></div>
					<div><label class="coworker_text" style="font-size: 14px;">${applicationScope.roleList[recommendedMember.roleId] }</label></div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>