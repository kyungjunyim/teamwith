<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 조회 경우 -->
<c:choose>
<c:when test="${!empty content }">
<c:forEach begin="0" end="1" step="1" varStatus="ii">
<c:if test="${ii.index==1&&content.contentOrder==portfolioContent[i.index+1].contentOrder}">
	<c:set var="content" value="${portfolioContent[i.index+1] }"/>
</c:if>
<div class="center_content" id="centercon" >
	<div id="l1picbox" class="pic_box" style="width:80%;height:100%">
	<c:choose>
		<c:when test="${content.portfolioName=='image' }">
			<img src="${content.portfolioValue }" width="100%" height="100%"/>
		</c:when>
		<c:when test="${content.portfolioName=='media' }">
			<iframe width="100%" height="100%" src="${content.portfolioValue }" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
		</c:when>
		<c:when test="${content.portfolioName=='ppt' }">
			<iframe width="100%" height="100%" src="${content.portfolioValue }#page=1&zoom=50"></iframe>
		</c:when>
	</c:choose>
	</div>
</div>
<div class="bottom_content" style="margin-top:2%">
	<c:if test="${content.portfolioName=='text' }">
		${content.portfolioValue }
	</c:if>
</div>
</c:forEach>
</c:when>
<c:otherwise>
<!-- 등록일경우 -->
<div class="center_content" >
		
</div>
<div class="bottom_content">
		<textarea class="form-control registerPortfolioInput" style="margin:0 auto;margin-top:2.5%;height:73%;width:80%;resize: none"
		name="contentIntro"  placeholder="소개글을 입력하세요"></textarea>
</div> 
</c:otherwise>
</c:choose>
