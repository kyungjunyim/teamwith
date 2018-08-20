<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(e) {
		$('#teamSearch').change(function(e) {
			var regionCnt = $('input:checkbox[name="region"]:checked').length;
			var roleCnt = $('input:checkbox[name="role"]:checked').length;
			var skillCnt = $('input:checkbox[name="skill"]:checked').length;
			var projectCnt = $('input:checkbox[name="project"]:checked').length;
			$('#regionBtn').text('활동 지역 ' + regionCnt);
			$('#roleBtn').text('역할 ' + roleCnt);
			$('#skillBtn').text('요구 기술 ' + skillCnt);
			$('#projectBtn').text('카테고리 ' + projectCnt);
		});
		$('#search_btn').click(function(e) {
			$("#teamSearch").submit();
		});
	});
</script>
</head>
<body>
	<form action="/teamSearch" method="post" id="teamSearch">
		<div class="row search_bar_row">
			<div class="member_search_btn_padding">
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-md member_search_btn_color member_search_btn_size" data-toggle="modal" data-target="#regionModal" id="regionBtn" style="color: red;">활동 지역 0</button>
				<div class="modal fade bd-example-modal-sm" id="regionModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title text_orange" id="exampleModalLongTitle">활동 지역</h5>
							</div>
							<div class="modal-body modal_text">
								<c:forEach items="${applicationScope.regionList }" var="regions" varStatus="status">
									<c:if test="${status.index % 3 == 0 }">
										<div class="row">
									</c:if>
									<div class="col" style="margin-left: 20px;">
										<input type="checkbox" class="form-check-input modal_check_box" name="region" id="${regions.key }" value="${regions.value }">
										${regions.value }
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
					<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
		</div>
		</div>
		<div class="member_search_btn_padding">
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-md member_search_btn_color member_search_btn_size" data-toggle="modal" data-target="#projectModal" id="projectBtn" style="color: red;">관심 분야 0</button>
			<div class="modal fade bd-example-modal-sm" id="projectModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title text_orange" id="exampleModalLongTitle">관심 분야</h5>
						</div>
						<div class="modal-body modal_text">
							<c:forEach items="${applicationScope.projectList }" var="projects" varStatus="status">
								<c:if test="${status.index % 3 == 0 }">
									<div class="row">
								</c:if>
								<div class="col" style="margin-left: 20px;">
									<input type="checkbox" class="form-check-input modal_check_box" name="project" id="${projects.key }" value="${projects.value }">
									${projects.value }
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
				<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">확인</button>
			</div>
		</div>
		</div>
		</div>
		</div>
		<div class="member_search_btn_padding">
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-md member_search_btn_color member_search_btn_size" data-toggle="modal" data-target="#roleModal" id="roleBtn" style="color: red;">역할 0</button>
			<div class="modal fade bd-example-modal-sm" id="roleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title text_orange" id="exampleModalLongTitle">역할</h5>
						</div>
						<div class="modal-body modal_text">
							<c:forEach items="${applicationScope.roleList }" var="roles" varStatus="status">
								<c:if test="${status.index % 2 == 0 }">
									<div class="row">
								</c:if>
								<div class="col" style="margin-left: 20px;">
									<input type="checkbox" class="form-check-input modal_check_box" name="role" id="${roles.key }" value="${roles.value }">
									${roles.value }
								</div>
								<c:if test="${status.index % 2 != 0 }">
						</div>
						</c:if>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-md btn_color_small"
							data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
		</div>
		
		<div class="member_search_btn_padding">
			<button type="button" class="btn btn-md member_search_btn_color member_search_btn_size" data-toggle="modal" data-target="#skillModal" id="skillBtn" style="color: red;">보유 기술 0</button>
			<div class="modal fade bd-example-modal-sm" id="skillModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title text_orange" id="exampleModalLongTitle">개발 역량</h5>
						</div>
						<div class="modal-body modal_text">
						<c:forEach items="${applicationScope.developerSkillList }" var="skills" varStatus="status">
						<c:if test="${status.index % 3 == 0 }">
							<div class="row">
						</c:if>
								<div class="col" style="margin-left: 20px;">
									<input type="checkbox" class="form-check-input modal_check_box" name="skill" id="${skills.key }" value="${skills.value }">
									${skills.value }
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
							<h5 class="modal-title text_orange" id="exampleModalLongTitle">디자인 역량</h5>
						</div>
						<div class="modal-body modal_text">
						<c:forEach items="${applicationScope.designerSkillList }" var="skills" varStatus="status">
						<c:if test="${status.index % 3 == 0 }">
							<div class="row">
						</c:if>
								<div class="col" style="margin-left: 20px;">
									<input type="checkbox" class="form-check-input modal_check_box" name="skill" id="${skills.key }" value="${skills.value }">
									${skills.value }
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
							<h5 class="modal-title text_orange" id="exampleModalLongTitle">기획 역량</h5>
						</div>
						<div class="modal-body modal_text">
						<c:forEach items="${applicationScope.plannerSkillList }" var="skills" varStatus="status">
						<c:if test="${status.index % 3 == 0 }">
							<div class="row">
						</c:if>
								<div class="col" style="margin-left: 20px;">
									<input type="checkbox" class="form-check-input modal_check_box" name="skill" id="${skills.key }" value="${skills.value }">${skills.value }
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
							<h5 class="modal-title text_orange" id="exampleModalLongTitle">기타 역량</h5>
						</div>
						<div class="modal-body modal_text">
						<c:forEach items="${applicationScope.etcSkillList }" var="skills" varStatus="status">
						<c:if test="${status.index % 3 == 0 }">
							<div class="row">
						</c:if>
								<div class="col" style="margin-left: 20px;">
									<input type="checkbox" class="form-check-input modal_check_box" name="skill" id="${skills.key }" value="${skills.value }">${skills.value }
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
							<button type="button" class="btn btn-md btn_color_small" data-dismiss="modal">확인</button>
						</div>																
					</div>
				</div>
			</div>
		</div>
		<div class="member_search_btn_size_big">
			<select class="member_search_select_box" name="textCondition">
				<option value="tc1">팀 명</option>
				<option value="tc2">프로젝트 명</option>
				<option value="tc3">공모전 명</option>
			</select>
			<input class="member_search_input_box" type="text" name="keyword">
			<button class="btn btn-md btn_color" type="button" id="search_btn">검색</button>
		</div>
	</form>
</div>
</body>
</html>