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
	$('document').ready(function(e){
		$('#updateBtn').click(function(e){
			location.href="/teamInfo/edit/${fn:substringAfter(teamInfo.teamId, 'team-')}";
		});
		$(".overlap_recruit").click(function(e) {
			var id = this.id.substring(11);
			$("#applyTry" + id).click();
		})
	});
</script>
</head>
<body>
	<!-- 팀 상세 정보 페이지 시작 -->
	<div class="col-xs-6 col_content team_detail_text_font">
		<div class="row team_detail_row team_detail_row_content team_detail_box_content team_detail_main">
			<!-- 팀 간략 정보 시작 -->
			<div class="row team_detail_interval team_detail_row">
				<!-- 팀 사진 시작 -->
				<div class="col">
					<img class="team_detail_img_big" src="${teamInfo.teamPic }">
				</div>
				<!-- 팀 사진 끝 -->
				<!-- 팀 정보(팀명, 분야 등) 시작 -->
				<div class="col team_detail_main_text">
					<div>
						<label class="teamDetail">[ ${applicationScope.projectList[teamInfo.projectCategoryId] } </label> &nbsp;&nbsp;/&nbsp;
						<label class="teamDetail">${applicationScope.regionList[teamInfo.regionId] } ]</label>
					</div>				
					<div>
						<label class="teamDetail">${teamInfo.teamProjectName }</label>
					</div>
					<div>
						<label class="teamDetail text_orange" >${teamInfo.teamName } 팀</label>
					</div>
					<div style="line-height: 30px; margin-top: 11px; text-align: center">
					<c:choose>
						<c:when test="${teamInfo.teamStatus == 1 }">
							<label class="label_dDay_text">모집 완료</label>
						</c:when>
						<c:otherwise>
							<c:if test="${dDay == 0 }">
								<label class="label_dDay_text text_blue">모집 중</label>&nbsp;&nbsp;<label class="label_dDay">D-day</label>
							</c:if>
							<c:if test="${dDay < 0 }">
								<label class="label_dDay_text text_blue">모집 중</label>&nbsp;&nbsp;<label class="label_dDay">D${dDay}</label>
							</c:if>
							<c:if test="${dDay > 0 }">
								<label class="label_dDay_text">모집 완료</label>
							</c:if>
						</c:otherwise>
					</c:choose>
					</div>
				</div>
				<!-- 팀 정보(팀명, 분야 등) 끝 -->
				<c:if test="${sessionScope.memberSimpleVO.memberId eq requestScope.teamInfo.memberId }">
					<div class="col team_detail_button_height">
						<div>
							<button type="button" class="btn team_detail_btn btn-md team_detail_btn_color btn_apply_member" id="myApplicants" onclick="location='/teamInfo/applicant/${fn:substringAfter(teamInfo.teamId, 'team-') }'">지원자 보기</button>
							<button type="button" class="btn team_detail_btn btn-md team_detail_btn_color" id="updateBtn">정보 수정</button>
						</div>
						<div>
							<c:if test="${sessionScope.memberSimpleVO.memberId eq requestScope.teamInfo.memberId }">
								<c:if test="${teamInfo.teamStatus eq 0 }">
									<button type="button" class="btn team_detail_btn btn-md team_detail_btn_color" data-toggle="modal" data-target="#closeModal">모집 완료</button>
									<div class="modal fade bd-example-modal-sm"	id="closeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
										<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title text_orange"	id="exampleModalLongTitle">
														<img src="/resources/image/logo/logoText.png" class="title_logo_text">
													</h5>
												</div>
												<div class="modal-body modal_text">
													모집 완료시 되돌릴 수 없습니다.<br />
													정말 모집을 완료하시겠습니까?
												</div>
												<div class="modal-footer">
													<button type="submit" class="btn btn-md btn_color_small btn_apply_join" onclick="location='/team/close/${fn:substringAfter(teamInfo.teamId, 'team-') }'">확인</button>
													<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">취소</button>
												</div>
											</div>
										</div>
									</div>								
								</c:if>
								<c:if test="${teamInfo.teamStatus eq 1 }">
									<button type="button" class="btn btn-md team_detail_btn_disable" disabled>모집 완료</button>
								</c:if>
							</c:if>
							<button type="button" class="btn team_detail_btn btn-md team_detail_btn_color" data-toggle="modal" data-target="#deleteModal" style="color: red;">팀 삭제</button>
							<div class="modal fade bd-example-modal-sm"	id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
								<div class="modal-dialog modal-sm modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title text_orange"	id="exampleModalLongTitle">
												<img src="/resources/image/logo/logoText.png" class="title_logo_text">
											</h5>
										</div>
										<div class="modal-body modal_text">
											팀 삭제시 되돌릴 수 없습니다.<br />
											정말 삭제하시겠습니까?
										</div>
										<div class="modal-footer">
											<button type="submit" class="btn btn-md btn_color_small btn_apply_join" onclick="location = '/team/remove/${fn:substringAfter(teamInfo.teamId, 'team-') }'">확인</button>
											<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">취소</button>
										</div>
									</div>
								</div>
							</div>		
						</div>
					</div>
				</c:if>
				<c:if test="${sessionScope.memberSimpleVO.memberId ne requestScope.teamInfo.memberId }">
				<div class="team_leader_info" onclick="location = '/polog/${teamInfo.memberId }'">
					<div class="col">
						<img src="${teamInfo.memberPic }" class="team_detail_img_mid">
					</div>
					<div style="line-height: 25px;">
						<div>
							<label class="label_team_leader text_orange">팀장</label><label class="label_team_leader text_blue">&nbsp;${teamInfo.memberName }님</label>
						</div>
						<div>
							<label class="label_team_leader text_blue">${applicationScope.roleList[teamInfo.roleId] }</label>
						</div>
					</div>
				</div>
				</c:if>
			</div>
			<!-- 팀 간략 정보 끝 -->
			
			<div class="team_detail_row team_detail_content_interval">
				<div class="team_detail_row_title team_detail_title_content_font">팀 개요</div>
				<div class="team_detail_row_text">${teamInfo.teamSummary }</div>
			</div>
			<div class="team_detail_row team_detail_content_interval">
				<div class="team_detail_row_title team_detail_title_content_font">팀 소개</div>
				<div class="team_detail_row_text" style="padding-right:6%">${teamInfo.teamContent }</div>
			</div>
			<hr class="team_detail_my_hr">
			
			<c:if test="${not empty recruitInfo }">
				<div class="team_detail_row team_deail_content_interval" style="margin-bottom: 0px;">
					<div class="team_detail_row_title team_detail_title_content_font">모집 팀원</div>
				</div>
				<c:forEach items="${recruitInfo}" var="recruit">
				<c:choose>
					<c:when test="${sessionScope.memberSimpleVO.memberId ne requestScope.teamInfo.memberId && canApply == true }">
						<div class="team_detail_row team_detail_content_interval team_detail_recruit_effect">
							<div class="overlap_recruit" id="recruit_div${recruit.recruitId }">
								<div class="overlap_text">지원하기</div>
							</div>
							<button type="button" data-toggle="modal" data-target="#applyModal${recruit.recruitId }" id="applyTry${recruit.recruitId }" style="display: none;"></button>
								<!-- 지원하기 모달 -->
							<div class="modal fade bd-example-modal-sm" id="applyModal${recruit.recruitId }" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered modal-md" role="document">
									<div class="modal-content">
										<form action="/application/apply/${fn:substringAfter(teamInfo.teamId, 'team-') }" method="post">
											<input type="hidden" name="recruitId" value="${recruit.recruitId}">
											<input type="hidden" name="roleId" value="${recruit.roleId}">				
											<div class="modal-header">
												<h5 class="modal-title text_orange" id="exampleModalLongTitle">지원하기</h5>
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<label class="recruit_label">지원 분야 : ${applicationScope.roleList[recruit.roleId] }</label>
											</div>
											<c:if test="${not empty interviewInfo }">
											<div class="modal-header">
												<h5 class="modal-title text_orange" id="exampleModalLongTitle">간단 면접</h5>
											</div>
											<div class="modal-body">
												<c:forEach items="${interviewInfo }" var="interview">
													<input type="hidden" name="interviewQuestionId" value="${interview.interviewQuestionId }">
													<div class="recruit_label">Q: ${interview.interviewQuestionContent }</div>
													<textarea class="recruit_input" id="interviewAnswer" name="interviewAnswer" rows="3"></textarea><br>
												</c:forEach>
											</div>				
											</c:if>
											<div class="modal-header">
												<h5 class="modal-title text_orange" id="exampleModalLongTitle">하고 싶은 말</h5>
											</div>					
											<div class="modal-body">
												<div class="recruit_label">팀장에게 하고 싶은 말을 입력하세요</div>
												<textarea class="recruit_input" id="freewriting" name="applicationFreewriting" rows="3"></textarea><br>
											</div>					
											<div class="modal-footer">
												<button type="submit" class="btn btn-md btn_submit"	style="margin: auto;">지원하기</button>
											</div>
										</form>
									</div>
								</div>
							</div>								
					</c:when>
					<c:otherwise>
						<div class="team_detail_row team_detail_content_interval team_detail_recruit">
					</c:otherwise>
				</c:choose>
						<div class="team_detail_row_text team_recruit_text">모집 역할 : ${applicationScope.roleList[recruit.roleId]}</div>			
						<div class="team_detail_row_text team_recruit_text">모집 인원 : ${recruit.recruitPeopleNum }</div>
						<c:if test="${not empty recruit.recruitPreference }">
							<div class="team_detail_row_text team_recruit_text">우대 조건 : ${recruit.recruitPreference }</div>
						</c:if>
						<c:if test="${not empty recruit.recruitExplain }">
							<div class="team_detail_row_text team_recruit_text">역할 설명 : ${recruit.recruitExplain }</div>
						</c:if>
						<c:if test="${not empty requireSkills }">
							<div class="team_detail_row_text team_recruit_text">
								요구 기술 :
								<c:forEach items="${requireSkills }" var="requireSkill">
									<c:if test="${requireSkill.recruitId eq recruit.recruitId }">
										<c:forEach items="${requireSkill.skillIds }" var="skillId">
											<c:set value="${applicationScope.skillList[skillId] }" var="skillName" />
											<label class="label_dDay">${skillName[0] }</label> &nbsp;
										</c:forEach>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
					</div>
				</c:forEach>
			</c:if>
			<div class="team_detail_row team_detail_content_interval">
				<div
					class="team_detail_row_title team_detail_title_content_font">공모전	정보</div>
				<div class="team_detail_row_text">공모전 명 : ${teamInfo.teamContestName }</div>
				<div class="team_detail_row_text">
					공모전 url : <a href="${teamInfo.teamContestLink }">${teamInfo.teamContestLink }</a>
				</div>
			</div>
			<hr class="team_detail_my_hr">
			<jsp:include page="coworker.jsp" />
			<hr class="team_detail_my_hr">
			<jsp:include page="faq.jsp" />
			<hr class="team_detail_my_hr">
			<jsp:include page="recommendedMember.jsp" />
		</div>
	</div>
	<!-- 팀 상세 정보 페이지 끝 -->
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</html>