<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="col-xs-6 team_regist_form_layout">
		<div class="row team_regist_whole">
			<div class="row team_regist_form_title">
				<label class="team_regist_text_title team_regist_text_blue">
					팀 수정 </label>
			</div>
			<hr class="team_regist_hr">
			<form id="updateForm"
				action="/teamInfo/edit/${fn:substringAfter(teamInfo.teamId, 'team-') }"
				method="post" class="team_regist_whole"
				enctype="multipart/form-data">
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">프로젝트
						제목</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input class="form-control team_regist_form_inputbox_mendatory"
							name="teamProjectName" type="text"
							value="${teamInfo.teamProjectName }">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
						명</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input value="${teamInfo.teamName }" name="teamName" type="text"
							class="form-control team_regist_form_inputbox_mendatory">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
						개요</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input value="${teamInfo.teamSummary }" name="teamSummary"
							type="text"
							class="form-control team_regist_form_inputbox_mendatory">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
						소개</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<textarea name="teamContent"
							class="form-control team_regist_form_inputbox_mendatory"
							style="resize: none">
							${teamInfo.teamContent }
							</textarea>
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
						소개 사진</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input name="teamPicFile" type="file"
							class="form-control team_regist_form_inputbox">
					</div>
				</div>
				<hr class="team_regist_hr">
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">참여
						공모전 이름</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input value="${teamInfo.teamContestName }" name="teamContestName"
							type="text" class="form-control team_regist_form_inputbox">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">참여
						공모전 링크</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input value="${teamInfo.teamContestLink }" name="teamContestLink"
							type="text" class="form-control team_regist_form_inputbox">
					</div>
				</div>
				<hr class="team_regist_hr">
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
						분야</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<button type="button" class="btn btn-md team_regist_btn_color"
							data-toggle="modal" data-target="#categoryModal">분야 선택</button>
					</div>
					<!-- 분야 선택 모달 -->
					<div class="modal team_regist_modal_font" id="categoryModal">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header team_regist_modal_title">분야 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<c:forEach items="${applicationScope.projectList }"
										var="project" varStatus="i">
										<c:if test="${(i.index mod 3) eq 0}">
											<div class="row team_regist_big_modal_interval">
										</c:if>
										<div class="col team_regist_modal_element">
											<input name="projectCategoryId" type="radio"
												class="form-check-input" value="${project.key }"
												<c:if test="${teamInfo.projectCategoryId eq project.key }">checked="checked"</c:if>>${project.value }
										</div>
										<c:if test="${(i.index mod 3) eq 2}">
								</div>
								</c:if>
								</c:forEach>
								<div class="row">
									<button type="button"
										class="btn btn-mid team_regist_btn_color team_regist_big_modal_btn_position"
										data-dismiss="modal">확인</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 분야 선택 모달 끝 -->
		</div>
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
				활동지역</div>
			<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
				<button type="button" class="btn btn-md team_regist_btn_color"
					data-toggle="modal" data-target="#regionModal">지역 선택</button>
			</div>
		</div>
		<!-- 활동 지역 선택 모달 -->
		<div class="modal team_regist_modal_font" id="regionModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header team_regist_modal_title">활동지역 선택</div>
					<!-- Modal body -->
					<div class="modal-body">
						<c:forEach items="${applicationScope.regionList }" var="region"
							varStatus="i">
							<c:if test="${(i.index mod 3) eq 0}">
								<div class="row team_regist_big_modal_interval">
							</c:if>
							<div class="col team_regist_modal_element">
								<input name="regionId" type="radio" class="form-check-input"
									value="${region.key }"
									<c:if test="${teamInfo.regionId eq region.key }">checked="checked"</c:if>>${region.value }
							</div>
							<c:if test="${(i.index mod 3) eq 2}">
					</div>
					</c:if>
					</c:forEach>
					<c:if test="${(i.index mod 3) eq 1 }">
						<div class="col team_regist_modal_element"></div>
						<div class="col team_regist_modal_element"></div>
				</div>
				</c:if>
				<c:if test="${(i.index mod 3) eq 0 }">
					<div class="col team_regist_modal_element"></div>
			</div>
			</c:if>
			<div class="row">
				<button type="button"
					class="btn btn-mid team_regist_btn_color team_regist_modal_btn_position"
					data-dismiss="modal">확인</button>
			</div>
		</div>
	</div>
	</div>
	</div>
	<!-- 활동 지역 선택 모달 끝 -->
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
			지원 마감 일자</div>
		<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
			<input value="${fn:substring(teamInfo.teamEndDate,0,10) }"
				name="teamEndDate" type="date"
				class="form-control team_regist_form_inputbox_mendatory">
		</div>
	</div>
	<hr class="team_regist_hr">
	<div id="faq" class="faq">
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">FAQ
				Question</div>
			<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
				<input name="faqQuestions" type="text"
					class="form-control team_regist_form_inputbox"
					<c:if test="${fn:length(faqList) ge 1}">value="${faqList[0].faqQuestion }"</c:if>>
				<input type="hidden" name="faqIds" value="${faqList[0].faqId }">
			</div>
		</div>
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">FAQ
				Answer</div>
			<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
				<input name="faqAnswers" type="text"
					class="form-control team_regist_form_inputbox"
					<c:if test="${fn:length(faqList) ge 1}">value="${faqList[0].faqAnswer }"</c:if>>
				<button type="button" class="btn btn-md team_regist_btn_color"
					id="btn_remove_faq" onclick="remove_faq(this)">삭제하기</button>
			</div>
		</div>
	</div>
	<div id="addFaq">
		<c:if test="${fn:length(faqList) ge 2 }">
			<div>
				<hr class="team_regist_hr">
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">FAQ
						Question</div>
					<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
						<input name="faqQuestions" type="text"
							class="form-control team_regist_form_inputbox"
							<c:if test="${fn:length(faqList) ge 2}">value="${faqList[1].faqQuestion }"</c:if>>
						<input type="hidden" name="faqIds" value="${faqList[1].faqId }">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">FAQ
						Answer</div>
					<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
						<input name="faqAnswers" type="text"
							class="form-control team_regist_form_inputbox"
							<c:if test="${fn:length(faqList) ge 2}">value="${faqList[1].faqAnswer }"</c:if>>
						<button type="button" class="btn btn-md team_regist_btn_color"
							id="btn_remove_faq" onclick="remove_faq(this)">삭제하기</button>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${fn:length(faqList) ge 3 }">
			<div>
				<hr class="team_regist_hr">
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">FAQ
						Question</div>
					<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
						<input name="faqQuestions" type="text"
							class="form-control team_regist_form_inputbox"
							<c:if test="${fn:length(faqList) ge 3}">value="${faqList[2].faqQuestion }"</c:if>>
						<input type="hidden" name="faqIds" value="${faqList[2].faqId }">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">FAQ
						Answer</div>
					<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
						<input name="faqAnswers" type="text"
							class="form-control team_regist_form_inputbox"
							<c:if test="${fn:length(faqList) ge 3}">value="${faqList[2].faqAnswer }"</c:if>>
						<button type="button" class="btn btn-md team_regist_btn_color"
							id="btn_remove_faq" onclick="remove_faq(this)">삭제하기</button>
					</div>
				</div>
			</div>
		</c:if>
	</div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text"></div>
		<div class="col-xs-6 team_regist_form_col">
			<button type="button" class="btn"
				style="background-color: white; color: blue;" onclick="add_faq()">추가하기</button>
		</div>
	</div>
	<hr class="team_regist_hr">
	<div id="interview" class="interview">
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">간단
				면접 질문</div>
			<div class="col-xs-6 team_regist_form_col team_regist_form_input">
				<input name="interviewQuestionContents" type="text"
					class="form-control team_regist_form_inputbox"
					<c:if test="${fn:length(interviewList) ge 1}">value="${interviewList[0].interviewQuestionContent }"</c:if>>
				<button type="button" class="btn btn-md team_regist_btn_color"
					id="btn_remove_interview" onclick="remove_interview(this)">삭제하기</button>
			</div>
		</div>
	</div>
	<div id="addInterview">
		<c:if test="${fn:length(interviewList) ge 2 }">
			<div>
				<hr class="team_regist_hr">
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">간단
						면접 질문</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input name="interviewQuestionContents" type="text"
							class="form-control team_regist_form_inputbox"
							<c:if test="${fn:length(interviewList) ge 2}">value="${interviewList[1].interviewQuestionContent }"</c:if>>
						<button type="button" class="btn btn-md team_regist_btn_color"
							id="btn_remove_interview" onclick="remove_interview(this)">삭제하기</button>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${fn:length(interviewList) ge 3 }">
			<div>
				<hr class="team_regist_hr">
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">간단
						면접 질문</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input name="interviewQuestionContents" type="text"
							class="form-control team_regist_form_inputbox"
							<c:if test="${fn:length(interviewList) ge 3}">value="${interviewList[2].interviewQuestionContent }"</c:if>>
						<button type="button" class="btn btn-md team_regist_btn_color"
							id="btn_remove_interview" onclick="remove_interview(this)">삭제하기</button>
					</div>
				</div>
			</div>
		</c:if>
	</div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text"></div>
		<div class="col-xs-6 team_regist_form_col">
			<button type="button" class="btn"
				style="background-color: white; color: blue;"
				onclick="add_interview()">추가하기</button>
		</div>
	</div>
	<hr class="team_regist_hr">
	<div id="role" class="role">
		<div id="recruit">
			<div class="row team_regist_row">
				<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
					분야</div>
				<div class="col-xs-6 team_regist_form_col">
					<button type="button" class="btn btn-md team_regist_btn_color"
						data-toggle="modal" data-target="#recruitCategoryModal1">모집
						분야 선택</button>
				</div>
			</div>
		</div>
		<!-- 모집 분야 선택 모달 -->
		<div class="recruitCategoryModal modal team_regist_modal_font"
			id="recruitCategoryModal1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header team_regist_modal_title">모집 분야 선택</div>
					<!-- Modal body -->
					<div class="modal-body">
						<c:forEach items="${applicationScope.roleList }" var="role"
							varStatus="i">
							<c:if test="${(i.index mod 2) eq 0}">
								<div class="row">
							</c:if>
							<div class="col team_regist_modal_element">
								<input class="form-check-input" type="radio" name="role1"
									value="${role.key }"
									<c:if test="${(fn:length(recruitList) ge 1) and recruitList[0].roleId eq role.key}">checked="checked"</c:if>>${role.value }
							</div>
							<c:if test="${(i.index mod 2) eq 1}">
					</div>
					</c:if>
					</c:forEach>
					<div class="row">
						<button type="button"
							class="btn btn-mid team_regist_btn_color team_regist_modal_btn_position"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 모집 분야 선택 모달 끝 -->
	<div id="a">
		<div class="row team_regist_row" id="recruitPeopleNumDiv">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
				인원</div>
			<div class="col-xs-6 team_regist_form_col team_regist_form_input">
				<input name="recruitPeopleNum" type="number"
					<c:if test="${fn:length(recruitList) ge 1}">value="${recruitList[0].recruitPeopleNum }"</c:if>
					class="form-control team_regist_form_inputbox"> <input
					name="recruitIds" type="hidden"
					value="${recruitList[0].recruitId }">
			</div>
		</div>
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">필요
				역량</div>
			<div class="col-xs-6 team_regist_form_col team_regist_form_input">
				<button type="button" class="btn btn-md team_regist_btn_color"
					data-toggle="modal" data-target="#skillModal1">필요 역량 선택</button>
			</div>
		</div>
	</div>
	<!-- 필요 역량 선택 모달 -->
	<div class="modal fade bd-example-modal-sm dd" id="skillModal1"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text_orange" id="exampleModalLongTitle">개발
						역량</h5>
				</div>
				<div class="modal-body modal_text">
					<c:forEach items="${applicationScope.developerSkillList }"
						var="skills" varStatus="status">
						<c:if test="${status.index % 3 == 0 }">
							<div class="row">
						</c:if>
						<div class="col" style="margin-left: 20px;">
							<input type="checkbox" class="form-check-input modal_check_box"
								name="skill1" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[0].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
						</div>
						<c:if test="${status.index % 3 == 2 }">
				</div>
				</c:if>
				<c:set var="index" value="${status.index }" />
				</c:forEach>
				<c:if test="${index % 3 == 1 }">
					<div class="col" style="margin-left: 20px;"></div>
			</div>
			</c:if>
			<c:if test="${index % 3 == 0 }">
				<div class="col" style="margin-left: 20px;"></div>
				<div class="col" style="margin-left: 20px;"></div>
		</div>
		</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">디자인
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.designerSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
								name="skill1" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[0].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">기획
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.plannerSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
								name="skill1" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[0].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">기타
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.etcSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
								name="skill1" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[0].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-md btn_color_small"
			data-dismiss="modal">확인</button>
	</div>
	</div>
	</div>
	</div>
	<!-- 필요 역량 선택 모달 끝 -->
	<div id="b">
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">우대
				조건</div>
			<div class="col-xs-6 team_regist_form_col team_regist_form_input">
				<input name="recruitPreferences" type="text"
					class="form-control team_regist_form_inputbox"
					<c:if test="${fn:length(recruitList) ge 1}">value="${recruitList[0].recruitPreference }"</c:if>>
			</div>
		</div>
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
				상세 설명</div>
			<div class="col-xs-6 team_regist_form_col team_regist_form_input">
				<textarea name="recruitExplains"
					class="form-control team_regist_form_inputbox" style="resize: none"><c:if
						test="${fn:length(recruitList) ge 1}">${recruitList[0].recruitExplain} </c:if></textarea>
				<button type="button" class="btn btn-md team_regist_btn_color"
					id="btn_remove_role" onclick="remove_item(this)">삭제하기</button>
			</div>
		</div>
	</div>
	</div>
	<div id="addRole">
		<c:if test="${fn:length(recruitList) ge 2 }">
			<div name="recruitDIV" class="skill0">
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
						분야</div>
					<div class="col-xs-6 team_regist_form_col">
						<button type="button" class="btn btn-md team_regist_btn_color"
							data-toggle="modal" data-target="#recruitCategoryModal2">모집
							분야 선택</button>
					</div>
				</div>
				<div name="recruitCategoryModal"
					class=" modal team_regist_modal_font" id="recruitCategoryModal2">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header team_regist_modal_title">모집 분야 선택</div>
							<!-- Modal body -->
							<div class="modal-body">
								<c:forEach items="${applicationScope.roleList }" var="role"
									varStatus="i">
									<c:if test="${(i.index mod 2) eq 0}">
										<div class="row">
									</c:if>
									<div class="col team_regist_modal_element">
										<input class="form-check-input" type="radio" name="role2"
											value="${role.key }"
											<c:if test="${recruitList[1].roleId eq role.key}">checked="checked"</c:if>>${role.value }
									</div>
									<c:if test="${(i.index mod 2) eq 1}">
							</div>
		</c:if>
		</c:forEach>
		<div class="row">
			<button type="button"
				class="btn btn-mid team_regist_btn_color team_regist_modal_btn_position"
				data-dismiss="modal">확인</button>
		</div>
	</div>
	</div>
	</div>
	</div>
	<!-- ------------------ recruitCategoryModal1을 가져왔따!!! 위에 디브 닫는거 개수 의심할것-->
	<div class="row team_regist_row" id="recruitPeopleNumDiv">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
			인원</div>
		<div class="col-xs-6 team_regist_form_col team_regist_form_input">
			<input name="recruitPeopleNum" type="number"
				class="form-control team_regist_form_inputbox"
				value="${recruitList[1].recruitPeopleNum }"> <input
				name="recruitIds" type="hidden" value="${recruitList[1].recruitId }">
		</div>
	</div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">필요
			역량</div>
		<div class="col-xs-6 team_regist_form_col team_regist_form_input">
			<button type="button" class="btn btn-md team_regist_btn_color"
				data-toggle="modal" data-target="#skillModal2">필요 역량 선택</button>
		</div>
	</div>
	<div name="selectSkill" class="modal fade bd-example-modal-sm"
		id="skillModal2" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text_orange" id="exampleModalLongTitle">개발
						역량</h5>
				</div>
				<div class="modal-body modal_text">
					<c:forEach items="${applicationScope.developerSkillList }"
						var="skills" varStatus="status">
						<c:if test="${status.index % 3 == 0 }">
							<div class="row">
						</c:if>
						<div class="col" style="margin-left: 20px;">
							<input type="checkbox" class="form-check-input modal_check_box"
								name="skill2" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[1].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
						</div>
						<c:if test="${status.index % 3 == 2 }">
				</div>
				</c:if>
				<c:set var="index" value="${status.index }" />
				</c:forEach>
				<c:if test="${index % 3 == 1 }">
					<div class="col" style="margin-left: 20px;"></div>
			</div>
			</c:if>
			<c:if test="${index % 3 == 0 }">
				<div class="col" style="margin-left: 20px;"></div>
				<div class="col" style="margin-left: 20px;"></div>
		</div>
		</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">디자인
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.designerSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
					name="skill2" id="${skills.key }" value="${skills.value }"
					<c:forEach items="${requireSkillList[1].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">기획
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.plannerSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
					name="skill2" id="${skills.key }" value="${skills.value }"
					<c:forEach items="${requireSkillList[1].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">기타
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.etcSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
								name="skill2" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[1].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-md btn_color_small"
			data-dismiss="modal">확인</button>
	</div>
	</div>
	</div>
	</div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">우대
			조건</div>
		<div class="col-xs-6 team_regist_form_col team_regist_form_input">
			<input name="recruitPreferences" type="text"
				class="form-control team_regist_form_inputbox"
				<c:if test="${fn:length(recruitList) ge 1}">value="${recruitList[1].recruitPreference }"</c:if>>
		</div>
	</div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
			상세 설명</div>
		<div class="col-xs-6 team_regist_form_col team_regist_form_input">
			<textarea name="recruitExplains"
				class="form-control team_regist_form_inputbox" style="resize: none"><c:if
					test="${fn:length(recruitList) ge 1}">${recruitList[1].recruitExplain} </c:if></textarea>
			<button type="button" class="btn btn-md team_regist_btn_color"
				id="btn_remove_role" onclick="remove_item(this)">삭제하기</button>
		</div>
	</div>
	</div>
	</c:if>
	<c:if test="${fn:length(recruitList) ge 3 }">
		<div name="recruitDIV" class="skill0">
			<div class="row team_regist_row">
				<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
					분야</div>
				<div class="col-xs-6 team_regist_form_col">
					<button type="button" class="btn btn-md team_regist_btn_color"
						data-toggle="modal" data-target="#recruitCategoryModal3">모집
						분야 선택</button>
				</div>
			</div>
			<div name="recruitCategoryModal"
				class=" modal team_regist_modal_font" id="recruitCategoryModal3">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header team_regist_modal_title">모집 분야 선택</div>
						<!-- Modal body -->
						<div class="modal-body">
							<c:forEach items="${applicationScope.roleList }" var="role"
								varStatus="i">
								<c:if test="${(i.index mod 2) eq 0}">
									<div class="row">
								</c:if>
								<div class="col team_regist_modal_element">
									<input class="form-check-input" type="radio" name="role3"
										value="${role.key }"
										<c:if test="${recruitList[2].roleId eq role.key}">checked="checked"</c:if>>${role.value }
								</div>
								<c:if test="${(i.index mod 2) eq 1}">
						</div>
	</c:if>
	</c:forEach>
	<div class="row">
		<button type="button"
			class="btn btn-mid team_regist_btn_color team_regist_modal_btn_position"
			data-dismiss="modal">확인</button>
	</div>
	</div>
	</div>
	</div>
	</div>
	<!-- ------------------ recruitCategoryModal1을 가져왔따!!! 위에 디브 닫는거 개수 의심할것-->
	<div class="row team_regist_row" id="recruitPeopleNumDiv">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
			인원</div>
		<div class="col-xs-6 team_regist_form_col team_regist_form_input">
			<input name="recruitPeopleNum" type="number"
				class="form-control team_regist_form_inputbox"
				value="${recruitList[2].recruitPeopleNum }"> <input
				name="recruitIds" type="hidden" value="${recruitList[3].recruitId }">
		</div>
	</div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">필요
			역량</div>
		<div class="col-xs-6 team_regist_form_col team_regist_form_input">
			<button type="button" class="btn btn-md team_regist_btn_color"
				data-toggle="modal" data-target="#skillModal3">필요 역량 선택</button>
		</div>
	</div>
	<div name="selectSkill" class="modal fade bd-example-modal-sm"
		id="skillModal3" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text_orange" id="exampleModalLongTitle">개발
						역량</h5>
				</div>
				<div class="modal-body modal_text">
					<c:forEach items="${applicationScope.developerSkillList }"
						var="skills" varStatus="status">
						<c:if test="${status.index % 3 == 0 }">
							<div class="row">
						</c:if>
						<div class="col" style="margin-left: 20px;">
							<input type="checkbox" class="form-check-input modal_check_box"
								name="skill3" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[2].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
						</div>
						<c:if test="${status.index % 3 == 2 }">
				</div>
				</c:if>
				<c:set var="index" value="${status.index }" />
				</c:forEach>
				<c:if test="${index % 3 == 1 }">
					<div class="col" style="margin-left: 20px;"></div>
			</div>
			</c:if>
			<c:if test="${index % 3 == 0 }">
				<div class="col" style="margin-left: 20px;"></div>
				<div class="col" style="margin-left: 20px;"></div>
		</div>
		</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">디자인
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.designerSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
								name="skill3" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[2].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">기획
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.plannerSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
								name="skill3" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[2].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-header">
		<h5 class="modal-title text_orange" id="exampleModalLongTitle">기타
			역량</h5>
	</div>
	<div class="modal-body modal_text">
		<c:forEach items="${applicationScope.etcSkillList }" var="skills"
			varStatus="status">
			<c:if test="${status.index % 3 == 0 }">
				<div class="row">
			</c:if>
			<div class="col" style="margin-left: 20px;">
				<input type="checkbox" class="form-check-input modal_check_box"
								name="skill3" id="${skills.key }" value="${skills.value }"
								<c:forEach items="${requireSkillList[2].skillIds }" var="skill">
								<c:if test="${skill eq skills.key }">checked="checked"</c:if>
								</c:forEach>>${skills.value }
			</div>
			<c:if test="${status.index % 3 == 2 }">
	</div>
	</c:if>
	<c:set var="index" value="${status.index }" />
	</c:forEach>
	<c:if test="${index % 3 == 1 }">
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	<c:if test="${index % 3 == 0 }">
		<div class="col" style="margin-left: 20px;"></div>
		<div class="col" style="margin-left: 20px;"></div>
		</div>
	</c:if>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-md btn_color_small"
			data-dismiss="modal">확인</button>
	</div>
	</div>
	</div>
	</div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">우대
			조건</div>
		<div class="col-xs-6 team_regist_form_col team_regist_form_input">
			<input name="recruitPreferences" type="text"
				class="form-control team_regist_form_inputbox"
				<c:if test="${fn:length(recruitList) ge 2}">value="${recruitList[2].recruitPreference }"</c:if>>
		</div>
	</div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
			상세 설명</div>
		<div class="col-xs-6 team_regist_form_col team_regist_form_input">
			<textarea name="recruitExplains"
				class="form-control team_regist_form_inputbox" style="resize: none"><c:if
					test="${fn:length(recruitList) ge 2}">${recruitList[2].recruitExplain} </c:if></textarea>
			<button type="button" class="btn btn-md team_regist_btn_color"
				id="btn_remove_role" onclick="remove_item(this)">삭제하기</button>
		</div>
	</div>
	</div>
	</c:if>
	</div>
	</form>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text"></div>
		<div class="col-xs-6 team_regist_form_col">
			<button type="button" class="btn"
				style="background-color: white; color: blue;" onclick="add_item()">추가하기</button>
		</div>
	</div>
	<div class="row team_regist_row team_regist_row_btns">
		<button type="button" class="btn btn-md team_regist_btn_cancel">취소하기</button>
		<button id="updateBtn" type="button"
			class="btn btn-md team_regist_btn_submit">수정하기</button>
	</div>
	</div>
	</div>
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$("#updateBtn").click(function(e) {
			$('#updateForm').submit();
		});
	});
	var recruitNum = 0;

	function add_item() {
		if ($("#addRole").children().length == 2) {
			alert("생성할 수 없습니다.");
		} else {
			recruitNum = recruitNum + 1;
			var div = document.createElement('div');
			div.setAttribute("name", "recruitDIV");
			div.setAttribute("class", "skill"+ $("#addRole").children().length);
			div.innerHTML = '<hr class="team_regist_hr">'
					+ '<div class="row team_regist_row">	<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집 분야</div>'
					+ '<div class="col-xs-6 team_regist_form_col"> <button type="button" class="btn btn-md team_regist_btn_color" data-toggle="modal" data-target="#recruitCategoryModal'
					+ ($("#addRole").children().length + 2)
					+ '">모집 분야 선택</button></div></div>'
					+ '<div name="recruitCategoryModal" class=" modal team_regist_modal_font" id="recruitCategoryModal'
					+ ($("#addRole").children().length + 2)
					+ '">'
					+ document.getElementById('recruitCategoryModal1').innerHTML
					+ '</div>'
					+ '<div class="row team_regist_row" id="recruitPeopleNumDiv"><div class="col-xs-6 team_regist_form_col team_regist_form_text">모집 인원</div>'
					+ '<div class="col-xs-6 team_regist_form_col team_regist_form_input"> <input name="recruitPeopleNum" type="number" class="form-control team_regist_form_inputbox">'
					+ '</div></div><div class="row team_regist_row"><div class="col-xs-6 team_regist_form_col team_regist_form_text">필요 역량</div>'
					+ '<div class="col-xs-6 team_regist_form_col team_regist_form_input"> <button type="button" class="btn btn-md team_regist_btn_color" data-toggle="modal" data-target="#skillModal'
					+ ($("#addRole").children().length + 2)
					+ '">필요 역량 선택</button></div></div>'
					+ '<div name="selectSkill" class="modal fade bd-example-modal-sm" id="skillModal'
					+ ($("#addRole").children().length + 2)
					+ '" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">'
					+ document.getElementById('skillModal1').innerHTML
					+ '</div>' + document.getElementById('b').innerHTML;
			document.getElementById('addRole').appendChild(div);
			if ($("#addRole").children().length == 1) {
				$('#addRole > div > div[name=selectSkill] input[type=checkbox]')
						.attr("name", "skill2");
				$(
						'#addRole > div > div[name=recruitCategoryModal] input[type=radio]')
						.attr("name", "role2");//원본이 복사되는 순간 이름이 같은 라디오 버튼에 체크가 두개가 되면서 앞에 체크된게 사라진다.
			} else if ($("#addRole").children().length == 2) {
				$(
						'#addRole > div:nth-child(2) >div[name=selectSkill] input[type=checkbox]')
						.attr("name", "skill3");
				$(
						'#addRole > div:nth-child(2) >div[name=recruitCategoryModal] input[type=radio]')
						.attr("name", "role3");
			}
		}
	}

	function remove_item(obj) {
		if (obj.parentNode.parentNode.parentNode.parentNode.id == 'role') {
			alert("삭제할 수 없습니다.");
		} else {
			console
					.log($('#addRole > div > div[name=selectSkill] input[type=checkbox]'));
			$('#addRole > div > div[name=selectSkill] input[type=checkbox]')
					.attr("name", "skill2");
			$(
					'#addRole > div > div[name=recruitCategoryModal] input[type=radio]')
					.attr("name", "role2");
			obj.parentNode.parentNode.parentNode.remove();
		}
	}

	function add_interview() {
		if ($("#addInterview").children().length == 2) {
			alert("생성할 수 없습니다.");
		} else {
			var div = document.createElement('div');
			div.innerHTML = '<hr class="team_regist_hr">'
					+ document.getElementById('interview').innerHTML;
			document.getElementById('addInterview').appendChild(div);
		}
	}

	function remove_interview(obj) {
		if (obj.parentNode.parentNode.parentNode.id == 'interview') {
			alert("삭제할 수 없습니다.");
		} else {
			obj.parentNode.parentNode.parentNode.remove();
		}
	}

	function add_faq() {
		if ($("#addFaq").children().length == 2) {
			alert("생성할 수 없습니다.");
		} else {
			var div = document.createElement('div');
			div.innerHTML = '<hr class="team_regist_hr">'
					+ document.getElementById('faq').innerHTML;
			document.getElementById('addFaq').appendChild(div);
		}
	}

	function remove_faq(obj) {
		if (obj.parentNode.parentNode.parentNode.id == 'faq') {
			alert("삭제할 수 없습니다.");
		} else {
			obj.parentNode.parentNode.parentNode.remove();
		}
	}
</script>
</html>