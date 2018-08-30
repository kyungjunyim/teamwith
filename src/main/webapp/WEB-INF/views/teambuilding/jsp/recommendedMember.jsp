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
		<div class="team_detail_row_title team_detail_title_content_font">
			추천 팀원
			<button type="button" class="btn btn-md btn_info" data-toggle="modal" data-target="#infoModal">?</button>
		</div>
		<div class="modal fade bd-example-modal-sm" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-md modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<img src="/resources/image/logo/logoText.png" class="title_logo_text">
					</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body modal_text" style="text-align: center;">
					<span class="text_blue">추천 팀원은 팀장이 입력한</span><br>
					<span class="text_orange">지역, 관심 분야, 요구 기술, 역할</span><!----><span class="text_blue"> 등에 따라<br>
					자동으로 추천되는 회원 목록입니다.<br>
					더욱 정확한 추천을 위해</span><span class="text_orange"> 팀의 정보를 업데이트 해보세요!</span>
				</div>
			</div>
		</div>
	</div>
		<div class="row coworker_row">
			<c:forEach items="${recommendedMemberList }" var="recommendedMember">
				<c:if test="${teamInfo.memberId != recommendedMember.memberId }">
				<div id="teamMember" class="coworker_col" onclick="location = '/polog/${recommendedMember.memberId }'">
					<div><img src="${recommendedMember.memberPic }" class="team_detail_img_sm"></div>
					<div><label class="coworker_text">${recommendedMember.memberName }님</label></div>
					<div><label class="coworker_text text_orange">일치율 ${fn:substring(recommendedMember.rate, 0, 4) }%</label></div>
					<div><label class="coworker_text" style="font-size: 14px;">${applicationScope.roleList[recommendedMember.roleId] }</label></div>
				</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>


	