<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/polog/css/bestPortfolio.css">
<section id="one" class="tiles">
	
		<c:forEach items="${portfolioSimpleList }" var="portfolioSimpleVO" begin="0" end="3">
			 <article style="background-image: url(&quot;${portfolioSimpleVO.portfolioPic}&quot;);">
                <span class="image" style="display: none;">
                        <img src="${portfolioSimpleVO.portfolioPic}" alt="">
                </span>
                <header class="major">
                        <h3><a href="제목" class="link">${portfolioSimpleVO.portfolioTitle }</a></h3>
                        <p>${portfolioSimpleVO.portfolioIntro }</p>
                </header>
        <a href="/portfolio/${portfolioSimpleVO.portfolioId }" class="link primary"></a></article>
		</c:forEach>
        
</section>
