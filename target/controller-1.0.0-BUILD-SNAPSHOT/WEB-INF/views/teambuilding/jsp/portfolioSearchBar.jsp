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
						$('#portfolioSearch')
								.change(
										function(e) {
											categoryCnt = $('input:checkbox[name="projectCategoryId"]:checked').length;
											$('#categoryBtn').text(
													'카테고리   ' + categoryCnt);
										});
						$('#search_btn').click(function(e) {
							//검색 버튼을 클릭하면 form 데이터를 post방식으로 서버에 전송한다.
						});
					});
</script>
</head>
<body>
	<form action="/portfolios" method="post" id="portfolioSearch">
		<input type="hidden" name="page" value="1">
		<input type="hidden" name="perPageNum" value="4">
		<div class="row portfolio_search_layout ">
			<div class="row portfolio_search_bar_position">
				<div class="col" style="line-height: 50px; margin-right: 292px;">
					<button type="button" class="btn btn-md search_portfolio_btn_color"	data-toggle="modal" data-target="#projectModal" id="categoryBtn" style="color: red;">관심 분야 0</button>
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
											<input type="checkbox" class="form-check-input modal_check_box" name="projectCategoryId" value="${projects.key }">${projects.value }
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
		</div>
		<div class="col" style="line-height: 50px;">
			<input type="text" name="title" class="search_portfolio_input">
			<button type="submit" class="btn btn-md btn_color" id="search_btn">검색</button>
		</div>
		</div>
		</div>
	</form>
</body>
</html>