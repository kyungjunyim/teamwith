<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">

<link href="/resources/polog/css/profileEdit.css" rel="stylesheet">

</head>
<style>
.skill_modal {
	width: 460px;
}

.skill_modal .modal-header {
	padding-top: 30px;
	padding-left: 0;
}

.skill_modal .modal-body {
	padding: 0;
}

.skill_modal .modal-body .row {
	width: 480px;
}

.modal-header {
	padding-left: 0;
}

.modal-body {
	padding: 0;
	padding-left: 10px;
	width: 200px;
}

.modal-body .row {
	width: 480px;
}

.modal-dialog {
	max-width: 480px;
	margin: 0;
}

.modal-content {
	border: none;
}

.modal_td {
	padding-top: 0;
	margin: 0
}

#profile_form button[type=submit]:hover {
	background: white;
	color: #000025;
}
</style>

<body>

	<form action="/profile/edit" method="post" id="profile_form"
		enctype="multipart/form-data">
		<input type='hidden' name="memberId"
			value="${sessionScope.memberSimpleVO.memberId }">
		<div class="profile" id="profile">

			<!-- 기본 정보 -->
			<div id="information_box" class="profile_box">

				<table>
					<tbody>
						<tr>

							<th><i class="material-icons">info</i>
								&nbsp;&nbsp;Information</th>
						</tr>
						<tr>
							<td>이름</td>
							<td id="member_name">${memberVO.memberName }
								${sessionScope.memberSimpleVO.memberId } ${memberVO.memberId }</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td id="member_email">${memberVO.memberEmail }</td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="text" id="member_phone" name="memberPhone"
								class="profile_input" style="text-align: right;"
								value="${memberVO.memberPhone }"></td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td id="memberBirth">${memberVO.memberBirth }</td>
						</tr>
						<tr>
							<td>프로필 사진</td>
							<td><input id="file" type="file" name="file"
								class="form-control"> <!-- <button type="button" onclick="$('#file').trigger('click')">파일</button> -->
							</td>
						</tr>
						<tr>
							<td>프로필 공개 여부</td>
							<td><button id="public_btn" type="button"
									class="btn btn-md profile_add_btn">공개</button> <input
								type="hidden" name="memberPublic" id="member_public"
								value="${memberVO.memberPublic }"></td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header"
											style="color: #ff4111; text-align: center">활동 지역 선택</div>
										<!-- Modal body -->
										<div class="modal-body">
											<c:forEach items="${applicationScope.regionList }"
												var="region" varStatus="i">
												<c:if test="${(i.index mod 3) eq 0}">
													<div class="row">
												</c:if>
												<div class="col">
													<input name="regionId" type="checkbox"
														class="form-check-input" id="${region.key }"
														value="${region.key }">${region.value }
												</div>
												<c:if test="${(i.index mod 3) eq 2}">
										</div>
										</c:if>
										</c:forEach>
										<c:if test="${(i.index mod 3) eq 1 }">
											<div class="col"></div>
											<div class="col"></div>
									</div>
									</c:if>
									<c:if test="${(i.index mod 3) eq 0 }">
										<div class="col"></div>
								</div> </c:if>
								</div>
								</div>
								</div>
							</td>
						</tr>
				</table>
			</div>



			<!-- 자기소개 -->
			<div id="intro_box" class="profile_box">
				<table>
					<tr>
						<th><i class="material-icons">face</i>
							&nbsp;&nbsp;Introduction</th>
					</tr>
					<tr>
						<td><textarea id="member_intro" class="profile_input"
								name="memberIntro">${memberVO.memberIntro}</textarea></td>
					</tr>
				</table>
			</div>
			<!-- 관심 분야, 역할 -->
			<div id="interest_box" class="profile_box">
				<table>
					<tr>
						<th><i class="material-icons">favorite</i>
							&nbsp;&nbsp;Interest</th>
					</tr>

					<tr>
						<td colspan="2"><div class="modal-dialog"
								style="max-width: none;">
								<div class="modal-content">
									<div class="modal-header"
										style="color: #ff4111; text-align: center">관심분야 선택</div>
									<!-- Modal body -->
									<div class="modal-body">
										<c:forEach items="${applicationScope.projectList }" var="pr"
											varStatus="i">
											<c:if test="${(i.index mod 3) eq 0}">
												<div class="row">
											</c:if>
											<div class="col">
												<input name="categoryId" type="checkbox"
													class="form-check-input" id="${pr.key }" value="${pr.key }">${pr.value }
											</div>
											<c:if test="${(i.index mod 3) eq 2}">
									</div>
									</c:if>
									</c:forEach>
									<c:if test="${(i.index mod 3) eq 1 }">
										<div class="col"></div>
										<div class="col"></div>
								</div>
								</c:if>
								<c:if test="${(i.index mod 3) eq 0 }">
									<div class="col"></div>
							</div> </c:if>

							</div>
							</div>
							</div></td>
					</tr>
					<tr>
						<td>역할</td>
						<td><select id="member_role" class="profile_input"
							name="roleId">
								<option value="role-1">개발자</option>
								<option value="role-2">디자이너</option>
								<option value="role-3">기획자</option>
								<option value="role-4">기타</option>
						</select></td>
					</tr>
				</table>
			</div>


			<!-- 기술 역량 -->
			<div id="skill_box" class="profile_box">
				<table>
					<tr>
						<th><i class="material-icons">build</i> &nbsp;&nbsp;Abilities</th>

					</tr>



					<tr>
						<td class="modal_td">
							<div class="modal-dialog" style="width: 675px;">
								<div class="modal-content skill_modal">
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
												<input type="checkbox"
													class="form-check-input modal_check_box" name="skill"
													id="${skills.key }" value="${skills.key }">
												<div>${skills.value }</div>
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
							</div> </c:if>
							</div>
							<div class="modal-header">
								<h5 class="modal-title text_orange" id="exampleModalLongTitle">디자인
									역량</h5>
							</div>
							<div class="modal-body modal_text">
								<c:forEach items="${applicationScope.designerSkillList }"
									var="skills" varStatus="status">
									<c:if test="${status.index % 3 == 0 }">
										<div class="row">
									</c:if>
									<div class="col" style="margin-left: 20px;">
										<input type="checkbox"
											class="form-check-input modal_check_box" name="skill"
											id="${skills.key }" value="${skills.key }">${skills.value }
									</div>
									<c:if test="${status.index % 3 == 2 }">
							</div> </c:if> <c:set var="index" value="${status.index }" /> </c:forEach> <c:if
								test="${index % 3 == 1 }">
								<div class="col" style="margin-left: 20px;"></div>
								</div>
							</c:if> <c:if test="${index % 3 == 0 }">
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
								<c:forEach items="${applicationScope.plannerSkillList }"
									var="skills" varStatus="status">
									<c:if test="${status.index % 3 == 0 }">
										<div class="row">
									</c:if>
									<div class="col" style="margin-left: 20px;">
										<input type="checkbox"
											class="form-check-input modal_check_box" name="skill"
											id="${skills.key }" value="${skills.key }">${skills.value }
									</div>
									<c:if test="${status.index % 3 == 2 }">
							</div> </c:if> <c:set var="index" value="${status.index }" /> </c:forEach> <c:if
								test="${index % 3 == 1 }">
								<div class="col" style="margin-left: 20px;"></div>
								</div>
							</c:if> <c:if test="${index % 3 == 0 }">
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
								<c:forEach items="${applicationScope.etcSkillList }"
									var="skills" varStatus="status">
									<c:if test="${status.index % 3 == 0 }">
										<div class="row">
									</c:if>
									<div class="col" style="margin-left: 20px;">
										<input type="checkbox"
											class="form-check-input modal_check_box" name="skill"
											id="${skills.key }" value="${skills.key }">${skills.value }
									</div>
									<c:if test="${status.index % 3 == 2 }">
							</div> </c:if> <c:set var="index" value="${status.index }" /> </c:forEach> <c:if
								test="${index % 3 == 1 }">
								<div class="col" style="margin-left: 20px;"></div>
								</div>
							</c:if> <c:if test="${index % 3 == 0 }">
								<div class="col" style="margin-left: 20px;"></div>
								<div class="col" style="margin-left: 20px;"></div>
								</div>
							</c:if>
							</div>
							</div>
							</div>

						</td>
					</tr>
				</table>
			</div>
			<div class="modal" id="skillModal" style="font-size: 25px;">
				<div class="modal-dialog" style="width: 675px; max-width: none;">
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
										name="skill" id="${skills.key }" value="${skills.key }">${skills.value }
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
				<c:forEach items="${applicationScope.designerSkillList }"
					var="skills" varStatus="status">
					<c:if test="${status.index % 3 == 0 }">
						<div class="row">
					</c:if>
					<div class="col" style="margin-left: 20px;">
						<input type="checkbox" class="form-check-input modal_check_box"
							name="skill" id="${skills.key }" value="${skills.key }">${skills.value }
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
						name="skill" id="${skills.key }" value="${skills.key }">${skills.value }
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
						name="skill" id="${skills.key }" value="${skills.key }">${skills.value }
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
		<div class="row">
			<button type="button" class="btn btn-mid profile_add_btn"
				data-dismiss="modal"
				style="margin-left: 150px; margin-bottom: 20px; margin-top: 30px;">확인</button>
		</div>
		</div>
		</div>
		</div>

		<!-- 성향 정보 -->
		<div class="profile_box" id="tendency_box" style="width: 540px">
			<table>
				<tr>
					<th colspan="2"><i class="material-icons">mood</i>
						&nbsp;&nbsp;Tendencies</th>
				</tr>
				<c:forEach items="${tendencyVO.tendency}" var="td" varStatus="cnt">
					<c:set var="tNames"
						value="${fn:split(applicationScope.tendencyList[td.key],'**')}"></c:set>
					<tr>

						<td id="tendency_name"><c:out value="${tNames[0] }"></c:out></td>
						<td><input type="range" min="1" max="10" value="${td.value }"
							class="slider slider1" id="${td.key}"
							name="tendency${cnt.count }" oninput="oninput${cnt.count}()"></td>
						<td id="tendency_name">${tNames[1] }</td>

					</tr>
				</c:forEach>

			</table>

		</div>

		<div>
			<button type="submit" style="margin: 50px 500px;">수정하기</button>
		</div>
	</form>

</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						if ($('#member_public').val() == '0') {
							document.getElementById('public_btn').innerText = '공개';
						} else {
							document.getElementById('public_btn').innerText = '비공개';
						}

						switch ('${memberVO.roleId}') {
						case 'role-1':
							$('#member_role')[0].selectedIndex = 0;
							break;
						case 'role-2':
							$('#member_role')[0].selectedIndex = 1;
							break;
						case 'role-3':
							$('#member_role')[0].selectedIndex = 2;
							break;
						case 'role-4':
							$('#member_role')[0].selectedIndex = 3;
							break;

						}

						if ('${memberVO.regionId1}' != null) {
							document.getElementById('${memberVO.regionId1}').checked = true;
						}
						if ('${memberVO.regionId2}' != null) {
							document.getElementById('${memberVO.regionId2}').checked = true;
						}

						<c:forEach var="c" items="${memberProjectCategoryList}">
						$('input:checkbox[id=${c}]')[0].checked = true;
						</c:forEach>

						<c:forEach var="c" items="${skillVO.skill}">
						$('input:checkbox[id=${c}]')[0].checked = true;
						</c:forEach>

						$('#profile_form')
								.change(
										function() {
											if ($('input:checkbox[name="regionId"]:checked').length > 2) {
												alert("활동 지역은 최대 2개까지 선택 가능합니다.");
												$('input:checkbox[name="regionId"]:checked')[0].checked = false;
											} else if ($('input:checkbox[name="categoryId"]:checked').length > 5) {
												alert("관심분야는 최대 5개까지 선택 가능합니다.");
												$('input:checkbox[name="categoryId"]:checked')[0].checked = false;
											} else if ($('input:checkbox[name="skill"]:checked').length > 30) {
												alert("기술은 최대 30개까지 선택 가능합니다.");
												$('input:checkbox[name="skill"]:checked')[0].checked = false;
											}
										});

						$('#public_btn').on("click", function() {
							if (this.innerText == '비공개') {
								this.innerText = '공개';
								$('#member_public').val(0);
							} else {
								this.innerText = '비공개';
								$('#member_public').val(1);
							}
						});

					});

	var oninput1 = function() {
		document.getElementById('tendency_figure1').innerHTML = document
				.getElementById("tendency1").value;
	}
	var oninput2 = function() {
		document.getElementById('tendency_figure2').innerHTML = document
				.getElementById("tendency2").value;
	}
	var oninput3 = function() {
		document.getElementById('tendency_figure3').innerHTML = document
				.getElementById("tendency3").value;
	}
	var oninput4 = function() {
		document.getElementById('tendency_figure4').innerHTML = document
				.getElementById("tendency4").value;
	}
	var oninput5 = function() {
		document.getElementById('tendency_figure5').innerHTML = document
				.getElementById("tendency5").value;
	}
</script>
</html>