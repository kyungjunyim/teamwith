<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>
	<div class="row main_title">
		<div class="col">
			<span class="text_orange">검색</span> <span class="text_blue">결과</span>
		</div>
	</div>

	<c:if test="${empty resultTeamList }">
		<div class="row main_row_whole">
			<label class="label_no_exist"> 일치하는 팀이 없습니다! </label>
		</div>
	</c:if>
	<c:if test="${not empty resultTeamList }">
		<c:forEach items="${resultTeamList }" var="resultTeam" varStatus="status">
		<c:if test="${status.index % 2 == 0 }">
		<div class="row main_row_whole">
		</c:if>
			<div class="col-xs-6 main_content_row" onclick="location = 'teamSearch/${fn:substringAfter(resultTeam.teamId, 'team-') }'">
				<div class="row main_content">
					<div class="col-xs-6 main_image_col">
						<img src="${resultTeam.teamPic }" class="main_image">
					</div>
					<div class="col-xs-6 main_content_text">
						<div class="row main_text">
							<label class="text-truncate main_text">${resultTeam.teamProjectName }</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text">${applicationScope.projectList[resultTeam.projectCategoryId] }</label>
						</div>
						<div class="row main_text">
							<label class="text-truncate main_text main_text_team_name">${resultTeam.teamName }</label>
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
		
	<!-- 페이징 처리 -->
	<c:if test="${not empty resultTeamList }">
		<div class="row best_member_row_whole">
			<ul class="pagination justify-content-center" style="margin: 0 auto;">
				<c:choose>
					<c:when test="${fn:length(resultTeamList) < 10 }">
						<li class="active page-item my_page_item"><a href="#" class="page-link my_page_link">1</a></li>
					</c:when>
					<c:otherwise>
						<li class="active page-item my_page_item"><a href="#" class="page-link my_page_link">1</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">2</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">3</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">4</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">5</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">&gt;&gt;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:if>
</body>