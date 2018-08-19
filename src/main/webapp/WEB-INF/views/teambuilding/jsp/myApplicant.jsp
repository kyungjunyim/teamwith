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
<link rel="stylesheet" href="/resources/teambuilding/css/myApplicant.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="home_container">
		<div class="row row_whole" style="min-height: 593px;">
			<div class="col-xs-6 col_container">
				<div class="row main_title">
					<div class="col">
						<span class="text_orange">지원자</span> <span class="text_blue">보기</span>
					</div>
				</div>
				<div class="row table_whole">
					<div class="row row_team">
						<div class="team_pic_div"><img src="${teamInfo.teamPic }" class="team_pic"></div>
						<div class="team_info">
							<div class="team_info_text text_blue">${teamInfo.teamProjectName }</div>
							<div class="team_info_text text_orange">${teamInfo.teamName }</div>
							<div class="team_info_text text_blue">${applicationScope.projectList[teamInfo.projectCategoryId] }</div>
						</div>
					</div>
					<table class="table table-hover text-truncate">
						<tr>
							<th>사진</th>
							<th>이름</th>
							<th>지원분야</th>
							<th>지원날짜</th>
							<th>부가정보</th>
							<th>지원상태</th>
							<th></th>
						</tr>
						<c:if test="${not empty applicantList }">
							<c:forEach items="${applicantList }" var="applicant">
								<form action="polog.do" method="post" id="form${applicant.memberId }">
									<input type="hidden" name="memberId" value="${applicant.memberId }">
								</form>
								<tr>
									<td id="${applicant.memberId }" onclick="javascript:clickTrEvent(this)"><img src="${applicant.memberPic }"
										class="rounded-circle team_image"></td>
									<td id="${applicant.memberId }" onclick="javascript:clickTrEvent(this)">${applicant.memberName }</td>
									<td id="${applicant.memberId }" onclick="javascript:clickTrEvent(this)">${applicationScope.roleList[applicant.roleId] }</td>
									<td id="${applicant.memberId }" onclick="javascript:clickTrEvent(this)">${fn:substring(applicant.applicationDate, 0, 10) }</td>
									<td>
										<button type="button" class="btn btn_color btn_color_small"	data-toggle="modal"	data-target="#myModal${applicant.applicationId }">보기</button>
									</td>
									<td id="applicationStatus${applicant.applicationId }" style="cursor: default;">
										<c:choose>
											<c:when test="${applicant.applicationStatus == 0}">지원 완료</c:when>
											<c:when test="${applicant.applicationStatus == 1}">합류</c:when>
											<c:when test="${applicant.applicationStatus == 2}">탈락</c:when>
											<c:when test="${applicant.applicationStatus == 3}">취소</c:when>
										</c:choose>
									</td>
									<c:if test="${applicant.applicationStatus == 0 }">
										<td class="btn_change_status">
											<button type="button" class="btn btn-md btn_submit_small" data-toggle="modal" data-target="#joinModal${applicant.applicationId }" id="call_join_modal${applicant.applicationId }">합류</button>
											<button type="button" class="btn btn-md btn_submit_small" data-toggle="modal" data-target="#dropModal${applicant.applicationId }" id="call_drop_modal${applicant.applicationId }">탈락</button>
										</td>
									</c:if>
									<c:if test="${applicant.applicationStatus != 0 }">
										<td class="btn_change_status">
											<button type="button" class="btn btn-md btn_disable" disabled>합류</button>
											<button type="button" class="btn btn-md btn_disable" disabled>탈락</button>
										</td>
									</c:if>
								</tr>
								<div class="modal fade bd-example-modal-sm"	id="myModal${applicant.applicationId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title text_orange"	id="exampleModalLongTitle">간단면접</h5>
											</div>
											<div class="modal-body modal_text">
												<c:forEach items="${interviewMap }" var="entry">
													<c:if test="${entry.key == applicant.applicationId }">
														<c:forEach items="${entry.value }" var="interview" varStatus="status">
															<c:if test="${status.index != 0 }">
																<br />
															</c:if>
															<div class="row">
																<div class="col">Q:
																	${interview.interviewQuestionContent }</div>
															</div>
															<div class="row">
																<div class="col">&nbsp;&nbsp;A:
																	${interview.interviewAnswerContent }</div>
															</div>
														</c:forEach>
													</c:if>
												</c:forEach>
											</div>
											<div class="modal-header">
												<h5 class="modal-title text_orange"
													id="exampleModalLongTitle">하고싶은 말</h5>
											</div>
											<div class="modal-body modal_text">${applicant.applicationFreewriting }</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-md btn_color_small"
													data-dismiss="modal">확인</button>
											</div>
										</div>
									</div>
								</div>
								
								<div class="modal fade bd-example-modal-sm"	id="joinModal${applicant.applicationId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title text_orange"	id="exampleModalLongTitle">
													<img src="/resources/image/logo/logoText.png" class="title_logo_text">
												</h5>
											</div>
											<div class="modal-body modal_text">
												${applicant.memberName }님을 팀에 합류하시겠습니까?<br />
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-md btn_color_small btn_apply_join" value="${applicant.applicationId }" data-dismiss="modal">확인</button>
												<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">취소</button>
											</div>
										</div>
									</div>
								</div>		
								
								<div class="modal fade bd-example-modal-sm"	id="dropModal${applicant.applicationId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title text_orange"	id="exampleModalLongTitle">
													<img src="/resources/image/logo/logoText.png" class="title_logo_text">
												</h5>
											</div>
											<div class="modal-body modal_text">
												${applicant.memberName }님을 탈락시키겠습니까?<br />
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-md btn_color_small btn_apply_drop" value="${applicant.applicationId }" data-dismiss="modal">확인</button>
												<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">취소</button>
											</div>
										</div>
									</div>
								</div>																
							</c:forEach>
						</c:if>
					</table>
				</div>
				<c:if test="${empty applicantList }">
					<div class="row my_application_row">
						<div class="text_blue my_application_empty">
							<span>지원 내역이 없습니다</span><br /> <br />
							<button type="button" class="btn btn-md btn_submit">팀
								둘러보기</button>
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
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/teambuilding/js/frame.js"></script>
<script src="/resources/teambuilding/js/myApplicant.js"></script>
</html>