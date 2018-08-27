<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<c:if test="${not empty searchPortfolioList }">
	<c:forEach items="${searchPortfolioList }" var="portfolio" varStatus="i">
	<c:if test="${(i.index mod 2) eq 0  }">
	<div class="row portfolio_search_row_whole">
	</c:if>
		<form action="#" method="post" id="">
			<input type="hidden" name="portfolioId" value="${portfolio.portfolioId }">
			<div class="col-xs-6 portfolio_search_content_row">
				<div class="row portfolio_search_content">
					<div class="col-xs-6 portfolio_search_image_col">
						<img src="/resources/image/portfolio/${portfolio.portfolioId }.jpg" class="portfolio_search_image">
					</div>
					<div class="col-xs-6 portfolio_search_content_text">
						<div class="row portfolio_search_text">
							<label class="text-truncate portfolio_search_text text_orange">${portfolio.portfolioTitle }</label>
						</div>
						<div class="row portfolio_search_text">
							<label class="text-truncate portfolio_search_text">${portfolio.memberName }</label>
						</div>
						<div class="row portfolio_search_text">
							<label class="text-truncate portfolio_search_text">${applicationScope.projectList[portfolio.projectCategoryId] }</label>
						</div>
					</div>
				</div>
				<div class="row portfolio_search_content text_truncate">
					<label class="portfolio_search_intro text_truncate">${portfolio.portfolioIntro }</label>
				</div>
			</div>
		</form>
	<c:if test="${(i.index mod 2) eq 1  }">
	</div>
	</c:if>
	<c:set value="${i.index }" var="lastIndex" />
	</c:forEach>
	<c:if test="${lastIndex % 2 == 0 }">
	</div>
	</c:if>
	</c:if>
	
		<!-- 페이징 처리 -->
	<c:if test="${not empty searchPortfolioList }">
		<div class="row best_member_row_whole">
			<ul class="pagination justify-content-center" style="margin: 0 auto;">
				<c:choose>
					<c:when test="${fn:length(searchPortfolioList) < 4 }">
						<li class="active page-item my_page_item"><a href="#" class="page-link my_page_link">1</a></li>
					</c:when>
					<c:otherwise>
						<li class="active page-item my_page_item"><a href="#" class="page-link my_page_link">1</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">2</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">3</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">4</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">5</a></li>
						<li class="page-item my_page_item"><a href="#" class="page-link my_page_link">&gt;&gt;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:if>

</body>