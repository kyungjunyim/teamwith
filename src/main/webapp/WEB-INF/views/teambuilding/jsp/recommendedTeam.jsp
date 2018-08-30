<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>
	<div class="row main_title">
		<div class="col">
			<span class="text_orange">추천</span> <span class="text_blue">팀</span>
			<button type="button" class="btn btn-md btn_info" data-toggle="modal"
				data-target="#infoModal">?</button>
		</div>
	</div>

	<div class="modal fade bd-example-modal-sm" id="infoModal"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-md modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<img src="/resources/image/logo/logoText.png"
							class="title_logo_text">
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body modal_text" style="text-align: center;">
					<span class="text_blue">추천 팀은 회원님이 입력하신</span><br> <span
						class="text_orange">지역, 관심 분야, 보유 기술, 역할</span><span
						class="text_blue"> 등에 따라<br> 자동으로 추천되는 팀입니다.<br>
						더욱 정확한 추천을 위해
					</span><span class="text_orange"> 프로필을 업데이트 해보세요!</span>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${empty recommendedTeamList }">
		<div class="row main_row_whole">
			<label class="label_no_exist"> 추천할 팀이 없습니다! </label>
		</div>
	</c:if>
	<c:if test="${not empty recommendedTeamList }">
		<c:forEach items="${recommendedTeamList }" var="recommendedTeam"
			varStatus="status">
			<c:if test="${status.index % 2 == 0 }">
				<div class="row main_row_whole">
			</c:if>
			<div class="col-xs-6 main_content_row"
				onclick="location = 'teamSearch/${fn:substringAfter(recommendedTeam.teamId, 'team-') }'">
				<div class="row main_content">
					<div class="col-xs-6 main_image_col">
						<img src="${recommendedTeam.teamPic }" class="main_image">
					</div>
					<div class="col-xs-6 main_content_text">
						<div class="row main_text">
							<label class="text-truncate main_text">${recommendedTeam.teamProjectName }</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text">${applicationScope.projectList[recommendedTeam.projectCategoryId] }</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text main_text_team_name">일치율:
								${fn:substring(recommendedTeam.rate, 0, 2) }%</label>
						</div>
					</div>
				</div>
			</div>
			<c:if test="${status.index % 2 != 0 }">
				</div>
			</c:if>
			<c:set var="lastIndex" value="${status.index }" />
		</c:forEach>
		<c:if test="${lastIndex % 2 == 0 }">
			</div>
		</c:if>
	</c:if>
</body>