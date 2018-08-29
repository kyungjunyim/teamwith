<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="profile_box" class="profile">
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
						<td id="member_name">${memberVO.memberName }</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td id="member_email">${memberVO.memberEmail }</td>
					</tr>
					<c:if test="${teamMember=='true' }">
						<tr>
							<td>전화번호</td>
							<td id="member_phone">${memberVO.memberPhone }</td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td id="member_birth">${memberVO.memberBirth }</td>
						</tr>
					</c:if>


					<tr>
						<td>활동 지역</td>
						<td id="member_region">${applicationScope.regionList[memberVO.regionId1] }
							<c:if
								test="${ memberVO.regionId1!=null && memberVO.regionId2!=null}">
							,
							</c:if> ${applicationScope.regionList[memberVO.regionId2] }
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
					<td id="member_intro">${memberVO.memberIntro}</td>
				</tr>
			</table>
		</div>
		<!-- 관심 분야, 역할 -->
		<div id="interest_box" class="profile_box">
			<table>
				<tr>
					<th><i class="material-icons">favorite</i>&nbsp;&nbsp;Interest</th>
				</tr>

				<tr>
					<td>관심 분야</td>
					<td id="project_category"><c:forEach
							items="${memberProjectCategoryList }" var="pc">
						${applicationScope.projectList[pc] }<br>

						</c:forEach></td>
				</tr>
				<tr>
					<td>역할</td>
					<td id="member_role">

						${applicationScope.roleList[memberVO.roleId]}</td>
				</tr>
			</table>
		</div>


		<!-- 기술 역량 -->
		<div id="skill_box" class="profile_box">
			<table>
				<tr>
					<th><i class="material-icons">build</i> &nbsp;&nbsp;Abilities</th>
				</tr>

				<c:set var="memberSkills" value="${skillVO.skill }"></c:set>

				<tr>
					<td id="role_name">개발역량</td>
				</tr>
				<c:forEach items="${memberSkills }" var="sk">
					<c:if test="${applicationScope.skillList[sk][1]=='role-1'}">
						<tr>
							<td class="profile_box_skill">${applicationScope.skillList[sk][0] }</td>
						</tr>
					</c:if>
				</c:forEach>

				<tr>
					<td id="role_name">디자인역량</td>
				</tr>
				<c:forEach items="${memberSkills }" var="sk">
					<c:if test="${applicationScope.skillList[sk][1]=='role-2'}">
						<tr>
							<td class="profile_box_skill">${applicationScope.skillList[sk][0] }</td>
						</tr>
					</c:if>
				</c:forEach>
				<tr>
					<td id="role_name">기획역량</td>
				</tr>
				<c:forEach items="${memberSkills }" var="sk">
					<c:if test="${applicationScope.skillList[sk][1]=='role-3'}">
						<tr>
							<td class="profile_box_skill">${applicationScope.skillList[sk][0] }</td>
						</tr>
					</c:if>
				</c:forEach>
				<tr>
					<td id="role_name">기타역량</td>
				</tr>
				<c:forEach items="${memberSkills }" var="sk">
					<c:if test="${applicationScope.skillList[sk][1]=='role-4'}">
						<tr>
							<td class="profile_box_skill">${applicationScope.skillList[sk][0] }</td>
						</tr>
					</c:if>
				</c:forEach>

			</table>
		</div>


		<!-- 칭찬 내역 -->
		<div id="praise_box" class="profile_box">
			<table>
				<tr>
					<th><i class="material-icons">mood</i> &nbsp;&nbsp;Praise</th>
				</tr>
				<c:forEach items="${praiseCntList}" var="pc" varStatus="i">
					<tr>
						<td id="member_praise${i.count }">${applicationScope.praiseList[pc.praiseId]}</td>
						<td><span id="praise${i.count }_cnt">${pc.praiseCnt }</span>회</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td><button class="btn btn-md btn_color"
							onclick="toPraise('${sessionScope.memberSimpleVO.memberId}','${memberVO.memberId}')">칭찬하기</button>
						<input type="hidden" data-toggle="modal"
						data-target="#praiseModal" id="p_btn"></td>
				</tr>
			</table>
		</div>
		<div class="modal" id="praiseModal"
			style="font-size: 18px; width: 260px; height: 354px;">

			<div class="modal-header">칭찬하기</div>
			<!-- Modal body -->
			<div class="modal-body">
				<div class="row" style="margin: 10px auto;">

					<form id="praise_form" action="/praise/update" method="post">
						<input type='hidden' name="target" value="${memberVO.memberId }">
						<input type='hidden' name="actor"
							value="${sessionScope.memberSimpleVO.memberId }">
						<c:forEach items="${applicationScope.praiseList }" var="pr">
							<div class="col" style="text-align: left; color: black;">
								<input type="checkbox" class="form-check-input" name="praise"
									id="${ pr.key}" value="${ pr.key}">${ pr.value}
							</div>
						</c:forEach>
					</form>
				</div>
				<div class="row">
					<button type="button"
						class="btn btn-mid team_regist_btn_color team_regist_big_modal_btn_position"
						data-dismiss="modal" style="margin: 0 auto;" id="praise_btn">확인</button>
				</div>
			</div>
		</div>


		<!-- 성향 정보 -->
		<div class="profile_box" id="tendency_box">
			<table>
				<tr>
					<th colspan="2"><i class="material-icons">mood</i>
						&nbsp;&nbsp;Tendencies</th>
				</tr>

				<c:forEach items="${tendencyVO.tendency}" var="td">
					<c:set var="tNames"
						value="${fn:split(applicationScope.tendencyList[td.key],'**')}"></c:set>
					<tr>

						<td id="tendency_name"><c:out value="${tNames[0] }"></c:out></td>
						<td><input type="range" min="1" max="10" value="${td.value }"
							class="slider" id="${td.key}" disabled>
							<div id="tendency_value">${td.value }</div></td>
						<td id="tendency_name">${tNames[1] }</td>

					</tr>
				</c:forEach>

			</table>
		</div>

	</div>
</body>
<script>
	var toPraise = function(actor, target) {

		if (actor == target) {
			alert("본인은 칭찬할 수 없습니다.");
		} else {

			$.ajax({
				method : 'get',
				url : '/praise/check?actor=' + actor + '&target=' + target,
				headers : {
					"Content-type" : "application/json",
				},
				success : function(data) {
					if (data.result == 'true') {
						$('#p_btn').trigger('click');
					} else {
						alert("같은 팀원만 칭찬할 수 있습니다.");
					}
				}

			});
		}
	}
	var setPrCnt = function() {

	}

	$(document)
			.ready(
					function() {

						<c:forEach items="${myPraiseList}" var="p">
						$('input:checkbox[id=${p.praiseId}]')[0].checked = true;
						</c:forEach>

						var elements = document
								.getElementsByClassName("profile_box");
						var i;
						for (i = 0; i < elements.length; i++) {

							elements[i].style.flex = "50%";
						}

						$('#praise_btn')
								.on(
										'click',
										function() {
											var pr = new Array();
											for (var i = 0; i < 5; i++) {
												if (document
														.getElementsByName('praise')[i].checked) {
													console
															.log(document
																	.getElementsByName('praise')[i].value);
													pr
															.push(document
																	.getElementsByName('praise')[i].value);

												}
											}
											console.log(pr);

											$
													.ajax({
														method : 'post',
														url : '/praise/update',
														traditional : true,
														data : {
															'actor' : '${sessionScope.memberSimpleVO.memberId }',
															'target' : '${memberVO.memberId }',
															'praise' : pr
														},

														success : function(data) {
															var i = 1;
															$(data)
																	.each(
																			function() {
																				$('#praise'
																						+ i
																						+ '_cnt')[0].innerHTML = this.praiseCnt;
																				console
																						.log($('#praise'
																								+ i
																								+ '_cnt'));
																				i++;
																			});
														}

													});
										});

					});
</script>
</html>