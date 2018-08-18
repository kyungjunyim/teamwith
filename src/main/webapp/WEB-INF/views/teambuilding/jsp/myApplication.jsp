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
<link rel="stylesheet"
	href="/resources/teambuilding/css/myApplication.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="home_container">
		<div class="row row_whole" style="min-height: 593px;">
			<div class="col-xs-6 col_container">
				<div class="row main_title">
					<div class="col">
						<span class="text_orange">나의</span> <span class="text_blue">지원</span>
					</div>
				</div>
				<div class="row table_whole">
					<table class="table table-hover text-truncate" id="applicationTable">
						<tr>
							<th>사진</th>
							<th>팀명</th>
							<th>모집분야</th>
							<th>지원날짜</th>
							<th>부가정보</th>
							<th>지원상태</th>
							<th></th>
						</tr>
						<c:if test="${not empty myApplicationList }">
							<c:forEach items="${myApplicationList }" var="myApplication">
								<form action="teamDetail.do" method="post" id="form${myApplication.teamId }">
									<input type="hidden" name="teamId" value="${myApplication.teamId }">
								</form>
								<tr>
									<td id="${myApplication.teamId }" onclick="javascript:clickTrEvent(this)"><img src="${myApplication.teamPic }"
										class="rounded-circle team_image"></td>
									<td id="${myApplication.teamId }" onclick="javascript:clickTrEvent(this)">${myApplication.teamName }</td>
									<td id="${myApplication.teamId }" onclick="javascript:clickTrEvent(this)">${applicationScope.roleList[myApplication.roleId] }</td>
									<td id="${myApplication.teamId }" onclick="javascript:clickTrEvent(this)">${fn:substring(myApplication.applicationDate, 0, 10) }</td>
									<td>
										<button type="button" class="btn btn_color btn_color_small"	data-toggle="modal"	data-target="#myModal${myApplication.applicationId }">보기</button>
									</td>
									<td id="applicationStatus${myApplication.applicationId }">
										<c:choose>
											<c:when test="${myApplication.applicationStatus == 0}">지원 완료</c:when>
											<c:when test="${myApplication.applicationStatus == 1}">합류</c:when>
											<c:when test="${myApplication.applicationStatus == 2}">탈락</c:when>
											<c:when test="${myApplication.applicationStatus == 3}">취소</c:when>
										</c:choose>
									</td>
									<c:if test="${myApplication.applicationStatus != 3}">
										<td class="btn_change_apply">
											<button type="button" class="btn btn-md btn_submit_small" data-toggle="modal" data-target="#cancelModal${myApplication.applicationId }" id="call_cancel_modal${myApplication.applicationId }">취소</button>
										</td>
									</c:if>
									<c:if test="${myApplication.applicationStatus == 3}">
										<td class="btn_change_apply btn_cancel">
											<button type="button" class="btn btn-md btn_disable" disabled>취소</button>
										</td>
									</c:if>
								</tr>
								<div class="modal fade bd-example-modal-sm"	id="myModal${myApplication.applicationId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title text_orange"	id="exampleModalLongTitle">간단면접</h5>
											</div>
											<div class="modal-body modal_text">
												<c:forEach items="${interviewMap }" var="entry">
													<c:if test="${entry.key == myApplication.applicationId }">
														<c:forEach items="${entry.value }" var="interview"
															varStatus="status">
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
											<div class="modal-body modal_text">${myApplication.applicationFreewriting }</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-md btn_color_small"
													data-dismiss="modal">확인</button>
											</div>
										</div>
									</div>
								</div>
								
								<div class="modal fade bd-example-modal-sm"	id="cancelModal${myApplication.applicationId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title text_orange"	id="exampleModalLongTitle">
													<img src="/resources/image/logo/logoText.png" class="title_logo_text">
												</h5>
											</div>
											<div class="modal-body modal_text">
												정말로 취소하시겠습니까?<br />
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-md btn_color_small btn_apply_cancel" value="${myApplication.applicationId }" data-dismiss="modal">확인</button>
												<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">취소</button>
											</div>
										</div>
									</div>
								</div>								
							</c:forEach>
						</c:if>
					</table>
				</div>
				<c:if test="${empty myApplicationList }">
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
<script src="/resources/teambuilding/js/myApplication.js"></script>
</html>