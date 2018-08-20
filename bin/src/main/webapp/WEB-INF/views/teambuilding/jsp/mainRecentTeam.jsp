<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>
	<div class="row main_title">
		<div class="col">
			<span class="text_orange">최근 등록</span> <span class="text_blue">팀</span>
		</div>
	</div>
	<c:if test="${empty recentTeamList }">
		<div class="row main_row_whole">
			<label class="label_no_exist"> 아직 등록된 팀이 없습니다! </label>
		</div>
	</c:if>
	<c:if test="${not empty recentTeamList }">
		<c:forEach items="${recentTeamList }" var="recentTeam" begin="0"
			end="3" varStatus="status">
			<c:if test="${status.index % 2 == 0 }">
				<div class="row main_row_whole">
			</c:if>
			<div class="col-xs-6 main_content_row"
				onclick="location = 'teamSearch/${fn:substringAfter(recentTeam.teamId, 'team-') }'">
				<div class="row main_content">
					<div class="col-xs-6 main_image_col">
						<img src="${recentTeam.teamPic }" class="main_image">
					</div>
					<div class="col-xs-6 main_content_text">
						<div class="row main_text">
							<label class="text-truncate main_text">${recentTeam.teamProjectName }</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text">${applicationScope.projectList[recentTeam.projectCategoryId] }</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text main_text_team_name">${recentTeam.teamName }</label>
						</div>
					</div>
				</div>
			</div>
			<c:if test="${status.index % 2 != 0 }">
				</div>
			</c:if>
		</c:forEach>
	</c:if>
</body>