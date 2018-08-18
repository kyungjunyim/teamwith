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
		$('#portfolioSearch').change(function(e) {
			categoryCnt = $('input:checkbox[name="projectCategoryId"]:checked').length;
			$('#categoryBtn').text('카테고리   ' + categoryCnt);
		});
		$('#search_btn').click(function(e) {
		//검색 버튼을 클릭하면 form 데이터를 post방식으로 서버에 전송한다.
		});
	});
</script>
</head>
<body>
	<form action="/searchPortfolio.do" method="post" id="portfolioSearch">
	<input type="hidden" name="page" value="1">
	<input type="hidden" name="perPageNum" value="4">
		<div class="row portfolio_search_layout ">
			<div class="row portfolio_search_bar_position">
				<div class="col">
					<button id="categoryBtn" type="button"
						class="btn btn-md search_portfolio_btn_color" data-toggle="modal"
						data-target="#categoryModal" style="color: red;">카테고리&nbsp;&nbsp;0</button>
					<div class="modal portfolio_search_modal_font" id="categoryModal">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header portfolio_search_modal_title">카테고리
									선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<c:forEach items="${applicationScope.projectList }"
										var="project" varStatus="i">
										<c:if test="${(i.index mod 3) eq 0}">
											<div class="row portfolio_search_big_modal_interval">
										</c:if>
										<div class="col portfolio_search_modal_element">
											<input name="projectCategoryId" type="checkbox"
												class="form-check-input" value="${project.key }">${project.value }
										</div>
										<c:if test="${(i.index mod 3) eq 2}">
								</div>
								</c:if>
								</c:forEach>
									<div class="row">
										<button type="button"
											class="btn search_portfolio_btn btn-mid search_portfolio_btn_submit portfolio_search_big_modal_btn_position"
											data-dismiss="modal">확인</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<input type="text" name="title" class="search_portfolio_input">
				<button type="submit" id="search_btn">검색</button>


			</div>
		</div>
	</form>
</body>
</html>