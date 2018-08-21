<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.portfolio_search_content_row:hover {
	background: #fff7f4;
	
}
</style>


<body>
	<div class="row portfolio_search_title">
		<div class="col">
			<span class="text_orange">최근</span> <span class="text_blue">포트폴리오</span>
		</div>
	</div>
	<c:if test="${empty recentPortfolioList }">
		<div class="row portfolio_search_row_whole">
			<label class="label_no_exist"> 공개된 포트폴리오가 존재하지 않습니다. </label>
		</div>
	</c:if>
	<!-- 최근 포폴 목록 보여주기 -->
	<c:forEach items="${recentPortfolioList }" var="portfolio"
		varStatus="i">
		<c:if test="${(i.index mod 2) eq 0  }">
			<div class="row portfolio_search_row_whole">
		</c:if>
		<form action="/portfolio/${fn:split(portfolio.portfolioId,'-')[1]}" method="get"
			id="${portfolio.portfolioId }">
			<div class="col-xs-6 portfolio_search_content_row" id="${portfolio.portfolioId }_box" onclick="$('#${portfolio.portfolioId }').submit()">
				<div class="row portfolio_search_content">
					<div class="col-xs-6 portfolio_search_image_col">
						<img
							src="/resources/image/portfolio/${portfolio.portfolioId }.jpg"
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


</body>