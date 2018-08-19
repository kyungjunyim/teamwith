<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#leader').click(function(e) {
			$('#leaderForm').submit();
		});
		//		$('#applyBtn').click(function(e) {
		//			$('#applyTry').text("지원 취소");
		//			$('#applyTry2').text("지원 취소");
		//		});
		$('#closeBtn').click(function(e) {
			$('#closeForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="col-xs-6 col_content team_detail_text_font">
		<div
			class="row team_detail_row team_detail_row_content team_detail_box_content team_detail_main">
			<div class="team_detail_interval row team_detail_row ">
				<div class="col">
					<img class="team_detail_img_big" src="${teamInfo.teamPic }">
				</div>
				<div class="col team_detail_main_text">
					<div>
						<label class="teamDetail">${teamInfo.teamProjectName }</label>
					</div>
					<div>
						<label>${teamInfo.teamName } 팀</label>
					</div>
				</div>
				<c:if
					test="${sessionScope.memberSimpleVO.memberId eq requestScope.teamInfo.memberId }">
					<div class="col team_detail_button_height">
						<div>
							<button type="button"
								class="btn team_detail_btn btn-md team_detail_btn_color">정보
								수정</button>
							<button type="button"
								class="btn team_detail_btn btn-md team_detail_btn_color"
								data-toggle="modal" data-target="#deleteModal"
								style="color: red;">팀 삭제</button>

							<!-- 팀 삭제 모달 -->
							<div class="modal team_detail_modal_font" id="deleteModal">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header team_detail_modal_title">주의</div>
										<!-- Modal body -->
										<div class="modal-body">
											<div class="row team_detail_row_text">팀 삭제시 되돌릴 수 없습니다.</div>
											<div
												class="row team_detail_row_text team_detail_text_color_red">정말
												삭제하시겠습니까?</div>
											<div class="row">
												<button type="button"
													class="btn team_detail_btn btn-mid team_detail_btn_submit team_detail_modal_btn_position"
													data-dismiss="modal">취소</button>
												<button type="button"
													class="btn team_detail_btn btn-mid team_detail_btn_submit team_detail_modal_btn_position"
													data-dismiss="modal">확인</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 팀 삭제 모달 끝 -->

						</div>
						<!-- 지원자 보기 버튼 -->
						<div>
							<form action="/teaminfo/applicant/${fn:substringAfter(teamInfo.teamId, 'team-') }" method="post">
								<input type="hidden" name="teamId" value="${teamInfo.teamId }">
								<input type="hidden" name="job" value="myApplicant">
								<button type="submit"
									class="btn team_detail_btn btn-md team_detail_btn_color btn_apply_member"
									id="myApplicants">지원자보기</button>
							</form>
						</div>
						<!-- 지원자 보기 버튼 끝 -->
					</div>
				</c:if>
			</div>
			<!-- 팀에 대한 정보 -->
			<div class="row team_detail_row team_detail_leader">
				<form action="polog.do" method="post" id="leaderForm">
					<input type="hidden" name="memberId" value="${teamInfo.memberId }">
					<div class="team_detail_opacity_height team_detail_hover_opacity">
						<div class="col team_detail_leader_effect">
							<div class="row team_detail_leader_width" id="leader">
								<div class="col">
									<img src="${teamInfo.memberPic }" class="team_detail_img_mid">
								</div>
								<div class="col team_detail_button_height">
									<div>
										<label class="text_orange">팀장</label> ${teamInfo.memberName }
										님
									</div>
									<div>${applicationScope.roleList[teamInfo.roleId] }</div>
								</div>
							</div>
						</div>
					</div>
				</form>

				<div class="col team_detail_sub">
					<div style="margin-top: 10px">
						<div>${applicationScope.projectList[teamInfo.projectCategoryId] }</div>
						<div>${applicationScope.regionList[teamInfo.regionId] }
							&nbsp;&nbsp;&nbsp;
							<c:if test="${teamInfo.teamStatus eq 0 }">모집 중 &nbsp;&nbsp;&nbsp;D${dDay}</c:if>
							<c:if test="${teamInfo.teamStatus eq 1 }">모집 완료</c:if>
						</div>
					</div>
				</div>
			</div>
			<!-- 팀에 대한 정보 끝 -->

			<!-- 지원하기, 모집완료 버튼 -->
			<div class="row team_detail_row team_detail_interval">
				<c:if	test="${sessionScope.memberSimpleVO.memberId ne requestScope.teamInfo.memberId }">
					<c:if test="${canApply == true }">
						<button type="button"
							class="btn team_detail_btn btn-md team_detail_btn_submit team_detail_btn_center"
							data-toggle="modal" data-target="#applyModal" id="applyTry">지원하기</button>
					</c:if>
				</c:if>
				<c:if
					test="${sessionScope.memberSimpleVO.memberId eq requestScope.teamInfo.memberId }">
					<c:if test="${teamInfo.teamStatus eq 0 }">
					<button id="closeBtn" type="button"
						class="btn team_detail_btn btn-md team_detail_btn_submit team_detail_btn_center">모집
						완료</button>
					<form action="closeTeam.do" method="post" id="closeForm">
						<input type="hidden" name="teamId" value="${requestScope.teamInfo.teamId }">
					</form>
					</c:if>
				</c:if>

			</div>
			<!-- 지원하기, 모집완료 버튼 끝 -->

			<div class="team_detail_row team_detail_content_interval">
				<div
					class="row team_detail_row_title team_detail_title_content_font">팀
					개요</div>
				<div class="row team_detail_row_text">${teamInfo.teamSummary }</div>
			</div>
			<div class="team_detail_row team_detail_content_interval">
				<div
					class="row team_detail_row_title team_detail_title_content_font">팀
					소개</div>
				<div class="row team_detail_row_text">${teamInfo.teamContent }</div>
			</div>
			<hr class="team_detail_my_hr">
			<c:if test="${not empty recruitInfo }">
				<c:forEach items="${recruitInfo}" var="recruit">
					<div class="team_detail_row team_detail_content_interval">
						<div
							class="row team_detail_row_title team_detail_title_content_font">모집
							팀원</div>
						<div class="row team_detail_row_text">모집 역할
							:${applicationScope.roleList[recruit.roleId]}</div>
						<div class="row team_detail_row_text">모집 인원
							:${recruit.recruitPeopleNum }</div>
						<c:if test="${not empty recruit.recruitPreference }">
							<div class="row team_detail_row_text">우대 조건
								:${recruit.recruitPreference }</div>
						</c:if>
						<c:if test="${not empty recruit.recruitExplain }">
							<div class="row team_detail_row_text">역할 설명
								:${recruit.recruitExplain }</div>
						</c:if>
						<c:forEach items="${skillInfo }" var="skill">
							<c:if test="${skill.recruitId eq recruitInfo.recruitId }">
								<div class="row team_detail_row_text">
									요구 기술 :
									<c:forEach items="${skill.skills }" var="skillId">
										${applicationScope.skillList[skillId] } &nbsp;
									</c:forEach>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</c:forEach>
			</c:if>
			<hr class="team_detail_hr">
			<div class="team_detail_row team_detail_content_interval">
				<div
					class="row team_detail_row_title team_detail_title_content_font">공모전
					정보</div>
				<div class="row team_detail_row_text">공모전
					명:${teamInfo.teamContestName }</div>
				<div class="row team_detail_row_text">
					공모전 url:&nbsp;&nbsp;<a href="${teamInfo.teamContestLink }">${teamInfo.teamContestLink }</a>
				</div>
			</div>

			<hr class="team_detail_hr">
			<jsp:include page="coworker.jsp" />
			<hr class="team_detail_hr">
			<jsp:include page="faq.jsp" />
			<hr class="team_detail_hr">
			<jsp:include page="recommendedMember.jsp" />

			<!-- 지원하기 모달 -->
			<div class="modal team_detail_modal_font" id="applyModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header team_detail_modal_title">지원하기</div>
						<!-- Modal body -->
						<div class="modal-body">
							<form action="./apply.do" method="post" id="applyForm">
								<input type="hidden" name="teamId" value="${teamInfo.teamId }">
								<div class="row team_detail_row_text">
									지원 분야 <select class="team_detail_modal_element" id="role"
										name="roleId">
										<c:forEach items="${recruitInfo }" var="recruit">
											<option value="${recruit.roleId }">${applicationScope.roleList[recruit.roleId] }</option>
										</c:forEach>
									</select>
								</div>
								<c:if test="${not empty interviewInfo }">
									<div class="row team_detail_row_text team_detail_interval">간단면접</div>
									<c:forEach items="${interviewInfo }" var="interview">
										<input type="hidden" name="interviewQuestionId"
											value="${interview.interviewQuestionId }">
										<div class="row team_detail_row_text team_detail_indent">Q:${interview.interviewQuestionContent }</div>
										<div class="row team_detail_row_text">
											<textarea class="team_detail_textarea" id="interviewAnswer"
												name="interviewAnswer"></textarea>
										</div>
									</c:forEach>
								</c:if>
								<div
									class="row team_detail_row_text team_detail_content_interval">하고싶은
									말</div>
								<div class="row team_detail_row_text">
									<textarea class="team_detail_textarea" id="freewriting"
										name="applicationFreewriting"></textarea>
								</div>
								<div class="row">
									<button type="button"
										class="team_detail_btn btn-mid team_detail_btn_submit team_detail_modal_btn_position"
										data-dismiss="modal">취소</button>
									<button type="submit" id="applyBtn"
										class="team_detail_btn btn-mid team_detail_btn_submit team_detail_modal_btn_position">확인</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 내용끝 -->
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(".btn_apply_member").click(function(e) {
		location.href = "test.jsp";
	})
</script>

</html>