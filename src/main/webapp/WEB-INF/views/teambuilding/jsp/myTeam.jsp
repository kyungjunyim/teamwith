<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/teambuilding/css/frame.css">
<link rel="stylesheet" href="/resources/teambuilding/css/myTeam.css">
<style>
.txt_line {
 

  overflow:hidden;
   text-overflow:ellipsis;
    white-space:nowrap; 
    }

</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="home_container">
		<div class="row row_whole" style="min-height: 593px;">
			<div class="col-xs-6 col_container">
				<div class="row main_title">
					<div class="col">
						<span class="text_orange">나의</span> <span class="text_blue">팀</span>
					</div>
				</div>
				<div class="row table_whole">
					<table class="table table-hover text-truncate">
						<tr>
							<th>사진</th>
							<th>팀명</th>
							<th>프로젝트명</th>
							<th>모집분야</th>
							<th>마감날짜</th>
							<th></th>
						</tr>
						<c:if test="${not empty myTeamList }">
							<c:forEach items="${myTeamList }" var="myTeam">
								<tr>
									<td id="${fn:substringAfter(myTeam.teamId, 'team-') }" onclick="javascript:clickTrEvent(this)"><img src="${myTeam.teamPic }"
										class="rounded-circle team_image"></td>
									<td id="${fn:substringAfter(myTeam.teamId, 'team-') }" onclick="javascript:clickTrEvent(this)"><div class="txt_line" style="width:150px;height:100%">${myTeam.teamName }</div></td>
									<td id="${fn:substringAfter(myTeam.teamId, 'team-') }" onclick="javascript:clickTrEvent(this)"><div class="txt_line" style="width:150px;height:100%">${myTeam.teamProjectName }</div></td>
									<td id="${fn:substringAfter(myTeam.teamId, 'team-') }" onclick="javascript:clickTrEvent(this)">${applicationScope.projectList[myTeam.projectCategoryId] }</td>
									<td id="${fn:substringAfter(myTeam.teamId, 'team-') }" onclick="javascript:clickTrEvent(this)">${fn:substring(myTeam.teamEndDate, 0, 10) }</td>
									<td class="btn_change_apply btn_cancel">
										<button type="button" class="btn btn-md btn_submit_small" data-toggle="modal" data-target="#deleteModal${myTeam.teamId }" id="call_delete_modal${myTeam.teamId }">삭제</button>
									</td>
								</tr>
								<div class="modal fade bd-example-modal-sm"	id="deleteModal${myTeam.teamId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title text_orange"	id="exampleModalLongTitle">
													<img src="/resources/image/logo/logoText.png" class="title_logo_text">
												</h5>
											</div>
											<div class="modal-body modal_text">
												정말로 삭제하시겠습니까?<br />
											</div>
											<div class="modal-footer">
												<form action="/team/remove/${fn:substringAfter(myTeam.teamId, 'team-') }" method="post" id="form${myTeam.teamId }">
													<input type="hidden" name="where" value="myTeam">
													<input type="hidden" name="teamId" value="${myTeam.teamId }">
													<button type="button" class="btn btn-md btn_color_small btn_team_delete" data-dismiss="modal" value="${myTeam.teamId }">확인</button>
													<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">취소</button>
												</form>
												
											</div>
										</div>
									</div>
								</div>			
							</c:forEach>
						</c:if>
					</table>
				</div>
				<c:if test="${empty myTeamList }">
					<div class="row my_application_row">
						<div class="text_blue my_application_empty">
							<span>등록한 팀이 없습니다</span><br /> <br />
							<button type="button" class="btn btn-md btn_submit">팀
								등록하기</button>
						</div>
					</div>
				</c:if>
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
	<jsp:include page="modalSet.jsp" />
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/teambuilding/js/frame.js"></script>
<script src="/resources/teambuilding/js/myTeam.js"></script>
</html>