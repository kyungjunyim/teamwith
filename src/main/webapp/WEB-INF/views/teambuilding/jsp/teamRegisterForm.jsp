<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<c:if test="${empty teamInfo }">
						팀 등록
					</c:if> <c:if test="${not empty teamInfo}">
						팀 수정
					</c:if>
				</label>
			</div>
			<hr class="team_regist_hr">
			<form id="registForm" action="register" method="post"
				class="team_regist_whole" enctype="multipart/form-data">
				<c:if test="${empty teamInfo }">
					<input type="hidden" name="job" value="addTeam">
				</c:if>
				<c:if test="${not empty teamInfo }">
					<input type="hidden" name="job" value="updateTeam">
				</c:if>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">프로젝트
						제목</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input
							<c:if test="${not empty teamInfo }">
							value="${teamInfo.teamProjectName }"
						</c:if>
							name="teamProjectName" type="text"
							class="form-control team_regist_form_inputbox_mendatory">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
						명</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input
							<c:if test="${not empty teamInfo }">
							value="${teamInfo.teamName }"
						</c:if>
							name="teamName" type="text"
							class="form-control team_regist_form_inputbox_mendatory">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">팀
						개요</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input
							<c:if test="${not empty teamInfo }">
							value="${teamInfo.teamSummary }"
						</c:if>
							name="teamSummary" type="text"
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
							<c:if test="${not empty teamInfo }">
							${teamInfo.teamContent }
							</c:if>
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
						<input
							<c:if test="${not empty teamInfo }">
							value="${teamInfo.teamContestName }"
						</c:if>
							name="teamContestName" type="text"
							class="form-control team_regist_form_inputbox">
					</div>
				</div>
				<div class="row team_regist_row">
					<div class="col-xs-6 team_regist_form_col team_regist_form_text">참여
						공모전 링크</div>
					<div class="col-xs-6 team_regist_form_col team_regist_form_input">
						<input
							<c:if test="${not empty teamInfo }">
							value="${teamInfo.teamContestLink }"
						</c:if>
							name="teamContestLink" type="text"
							class="form-control team_regist_form_inputbox">
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
												class="form-check-input" value="${project.key }">${project.value }
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
									value="${region.key }">${region.value }
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
			<input
				<c:if test="${not empty teamInfo }">
							value="${teamInfo.teamEndDate }"
						</c:if>
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
					class="form-control team_regist_form_inputbox">
			</div>
		</div>
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">FAQ
				Answer</div>
			<div class="col-xs-6 team_regist_form_col  team_regist_form_input">
				<input name="faqAnswers" type="text"
					class="form-control team_regist_form_inputbox">
				<button type="button" class="btn btn-md team_regist_btn_color"
					id="btn_remove_faq" onclick="remove_faq(this)">삭제하기</button>
			</div>
		</div>
	</div>
	<div id="addFaq"></div>
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
					class="form-control team_regist_form_inputbox">
				<button type="button" class="btn btn-md team_regist_btn_color"
					id="btn_remove_interview" onclick="remove_interview(this)">삭제하기</button>
			</div>
		</div>
	</div>
	<div id="addInterview"></div>
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
						data-toggle="modal" data-target="#recruitCategoryModal1">모집 분야 선택</button>
				</div>
			</div>
		</div>
		<!-- 모집 분야 선택 모달 -->
		<div class="recruitCategoryModal modal team_regist_modal_font" id="recruitCategoryModal1">
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
									value="${role.key }">${role.value }
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
					class="form-control team_regist_form_inputbox">
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
								name="skill1" id="${skills.key }" value="${skills.value }">${skills.value }
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
					name="skill1" id="${skills.key }" value="${skills.value }">${skills.value }
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
					name="skill1" id="${skills.key }" value="${skills.value }">${skills.value }
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
					name="skill1" id="${skills.key }" value="${skills.value }">${skills.value }
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
					class="form-control team_regist_form_inputbox">
			</div>
		</div>
		<div class="row team_regist_row">
			<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집
				상세 설명</div>
			<div class="col-xs-6 team_regist_form_col team_regist_form_input">
				<textarea name="recruitExplains"
					class="form-control team_regist_form_inputbox" style="resize: none"></textarea>
				<button type="button" class="btn btn-md team_regist_btn_color"
					id="btn_remove_role" onclick="remove_item(this)">삭제하기</button>
			</div>
		</div>
	</div>
	</div>
	<div id="addRole"></div>
	<div class="row team_regist_row">
		<div class="col-xs-6 team_regist_form_col team_regist_form_text"></div>
		<div class="col-xs-6 team_regist_form_col">
			<button type="button" class="btn"
				style="background-color: white; color: blue;" onclick="add_item()">추가하기</button>
		</div>
	</div>
	<div class="row team_regist_row team_regist_row_btns">
		<button type="button" class="btn btn-md team_regist_btn_cancel">취소하기</button>
		<button id="registBtn" type="button"
			class="btn btn-md team_regist_btn_submit">등록하기</button>
	</div>
	</form>
	</div>
	</div>
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$("#registBtn").click(function(e) {
			$('#registForm').submit();
		});
	});
	var recruitNum = 0;

	function add_item() {
		if ($("#addRole").children().length == 2) {
			alert("생성할 수 없습니다.");
		} else {
			recruitNum = recruitNum + 1;
			var div = document.createElement('div');
			div.setAttribute("name","recruitDIV");
			div.setAttribute("class", "skill"+ $("#addRole").children().length);
			div.innerHTML = '<hr class="team_regist_hr">'
					+'<div class="row team_regist_row">	<div class="col-xs-6 team_regist_form_col team_regist_form_text">모집 분야</div>'
					+'<div class="col-xs-6 team_regist_form_col"> <button type="button" class="btn btn-md team_regist_btn_color" data-toggle="modal" data-target="#recruitCategoryModal'
					+($("#addRole").children().length + 2)
					+'">모집 분야 선택</button></div></div>'
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
			if($("#addRole").children().length == 1){
				$('#addRole > div > div[name=selectSkill] input[type=checkbox]').attr("name","skill2");
				$('#addRole > div > div[name=recruitCategoryModal] input[type=radio]').attr("name","role2");
			}
			else if($("#addRole").children().length == 2){
				$('#addRole > div:nth-child(2) >div[name=selectSkill] input[type=checkbox]').attr("name","skill3");
				$('#addRole > div:nth-child(2) >div[name=recruitCategoryModal] input[type=radio]').attr("name","role3");
			}
		}
	}

	function remove_item(obj) {
		if (obj.parentNode.parentNode.parentNode.parentNode.id == 'role') {
			alert("삭제할 수 없습니다.");
		} else {
			console.log($('#addRole > div > div[name=selectSkill] input[type=checkbox]'));
			$('#addRole > div > div[name=selectSkill] input[type=checkbox]').attr("name","skill2");
			$('#addRole > div > div[name=recruitCategoryModal] input[type=radio]').attr("name","role2");
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