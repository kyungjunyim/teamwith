<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="row side_title">
		<div class="col">
			<span class="text_orange">최근</span> <span class="text_blue">포트폴리오</span>
		</div>
	</div>
	<c:if test="${empty recentPortfolioList }">
		<div class="row main_portfolio_row_whole">
			<label class="label_no_exist"> 등록된 포트폴리오가 없습니다! </label>
		</div>
	</c:if>
	<c:if test="${not empty recentPortfolioList }">
		<div class="row main_portfolio_row_whole">
			<c:forEach items="${recentPortfolioList }" var="recentPortfolio"
				begin="0" end="1" varStatus="status">
				<div class="col-xs-6 main_portfolio_col"
					onclick="location = '/portfolio/${fn:substringAfter(recentPortfolio.portfolioId, 'portfolio-') }'">
					<div class="row main_portfolio_row_image">
						<img src="${recentPortfolio.portfolioPic }"
							class="main_portfolio_image">
					</div>
					<div class="row main_portfolio_row_text">
						<div class="row text-truncate main_portfolio_text_name">
							<label class="main_portfolio_label">${recentPortfolio.memberName }</label>
						</div>
						<div class="text-truncate main_portfolio_text_title">
							<label class="main_portfolio_label">${recentPortfolio.portfolioTitle }</label>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<button type="button" class="btn btn-md btn_more" onclick="location = '/portfolios'">더보기</button>
	</c:if>
</body>
</html>