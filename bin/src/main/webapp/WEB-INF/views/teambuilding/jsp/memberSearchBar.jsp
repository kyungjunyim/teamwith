<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document)
			.ready(
					function(e) {
						$('#teamSearch')
								.change(
										function(e) {
											var regionCnt = $('input:checkbox[name="region"]:checked').length;
											var roleCnt = $('input:checkbox[name="role"]:checked').length;
											var skillCnt = $('input:checkbox[name="skill"]:checked').length;
											var categoryCnt = $('input:checkbox[name="category"]:checked').length;
											$('#regionBtn').text(
													'활동 지역' + regionCnt);
											$('#roleBtn').text('역할' + roleCnt);
											$('#skillBtn').text(
													'요구 기술' + skillCnt);
											$('#categoryBtn').text(
													'카테고리' + categoryCnt);
										});
						$('#search_btn').click(function(e) {
							//검색 버튼을 클릭하면 form 데이터를 post방식으로 서버에 전송한다.
						});
					});
</script>
</head>
<body>
	<form action="#" method="post" id="teamSearch">
		<div class="row member_search_layout">
			<div class="row member_search_bar_position">
				<div class="member_search_btn_padding">
					<!-- Button trigger modal -->
					<button id=regionBtn type="button"
						class="btn btn-md member_search_btn_color member_search_btn_size"
						data-toggle="modal" data-target="#regionModal" style="color: red;">활동
						지역0</button>
					<div class="modal member_search_modal_font" id="regionModal">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header member_search_modal_title">활동지역 선택</div>
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

				<div class="member_search_btn_padding">
					<button id="roleBtn" type="button"
						class="btn btn-md member_search_btn_color member_search_btn_size"
						data-toggle="modal" data-target="#roleModal" style="color: red;">역할0</button>
					<div class="modal" id="roleModal" style="font-size: 25px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="color: #ff4111; text-align: center">역할 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="role"
												id="role1" value="개발자">개발자
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="role"
												id="role2" value="디자이너">디자이너
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="role"
												id="role3" value="기획자">기획자
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="role"
												id="role4" value="기타">기타
										</div>
									</div>
									<div class="row">
										<button type="button"
											class="btn btn-mid member_search_btn_color"
											data-dismiss="modal"
											style="margin-left: 150px; margin-bottom: 20px; margin-top: 30px;">확인</button>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="member_search_btn_padding">
					<button id="skillBtn" type="button"
						class="btn btn-md member_search_btn_color member_search_btn_size"
						data-toggle="modal" data-target="#skillModal" style="color: red;">요구
						기술0</button>
					<div class="modal" id="skillModal" style="font-size: 25px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="color: #ff4111; text-align: center">기술 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="skill"
												id="skill1" value="C">C
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="skill"
												id="skill2" value="C++">C++
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="skill"
												id="skill3" value="JAVA">JAVA
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="skill"
												id="skill4" value="JAVASCRIPT">JAVASCRIPT
										</div>
									</div>
									<div class="row">
										<button type="button"
											class="btn btn-mid member_search_btn_color"
											data-dismiss="modal"
											style="margin-left: 150px; margin-bottom: 20px; margin-top: 30px;">확인</button>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="member_search_btn_padding">
					<button id="categoryBtn" type="button"
						class="btn btn-md member_search_btn_color member_search_btn_size"
						data-toggle="modal" data-target="#categoryModal"
						style="color: red;">카테고리0</button>
					<div class="modal" id="categoryModal" style="font-size: 25px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="color: #ff4111; text-align: center">카테고리 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input"
												name="category" id="category1" value="빅데이터">빅데이터
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input"
												name="category" id="category2" value="보안">보안
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input"
												name="category" id="category3" value="인공지능">인공지능
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input"
												name="category" id="category4" value="IOT">IOT
										</div>
									</div>
									<div class="row">
										<button type="button"
											class="btn btn-mid member_search_btn_color"
											data-dismiss="modal"
											style="margin-left: 150px; margin-bottom: 20px; margin-top: 30px;">확인</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col member_search_btn_size_big">
					<select class="member_search_select_box ">
						<option>이름</option>
						<option>id</option>
					</select> <input class="member_search_input_box" type="text">
					<button class="member_search_search_btn member_search_font_size"
						type="button" id="search_btn">검색</button>
				</div>

			</div>


		</div>
	</form>
</body>
</html>