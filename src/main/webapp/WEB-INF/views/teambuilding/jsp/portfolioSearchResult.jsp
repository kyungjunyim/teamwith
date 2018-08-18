<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<div class="row portfolio_search_title">
		<div class="col">
			<span class="text_orange">검색</span> <span class="text_blue">결과</span>
		</div>
	</div>
	<c:if test="${empty searchPortfolioList }">
	<div class="row portfolio_search_row_whole">
		<label class="label_no_exist"> 검색 결과가 없습니다. </label>
	</div>
	</c:if>
	<!-- 검색된 포트폴리오 결과 보여주기 -->
	<c:forEach items="${searchPortfolioList }" var="portfolio"
		varStatus="i">
		<c:if test="${(i.index mod 2) eq 0  }">
			<div class="row portfolio_search_row_whole">
		</c:if>
		<form action="#" method="post" id="">
			<input type="hidden" name="portfolioId"
				value="${portfolio.portfolioId }">
			<div class="col-xs-6 portfolio_search_content_row">
				<div class="row portfolio_search_content">
					<div class="col-xs-6 portfolio_search_image_col">
						<img src="/teamwith15/image/portfolio/${portfolio.portfolioId }.jpg"
							class="portfolio_search_image">
					</div>
					<div class="col-xs-6 portfolio_search_content_text">
						<div class="row portfolio_search_text">
							<label class="text-truncate portfolio_search_text">${portfolio.portfolioTitle }</label>
						</div>
						<div class="row portfolio_search_text">
							<label class="text-truncate portfolio_search_text">${portfolio.memberName }</label>
						</div>
						<div class="row portfolio_search_text">
							<label class="text-truncate portfolio_search_text">${portfolio.projectCategoryId }</label>
						</div>
					</div>
				</div>
				<div class="row portfolio_search_content">
					<label>${portfolio.portfolioIntro }</label>
				</div>
			</div>
		</form>
		<c:if test="${(i.index mod 2) eq 1  }">
			</div>
		</c:if>
	</c:forEach>
	<!-- 페이징 처리 -->
	<div class="row portfolio_search_row_whole">
		<ul class="pagination portfolio_search_pagenation">	
			<li><a href="#">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>

</body>