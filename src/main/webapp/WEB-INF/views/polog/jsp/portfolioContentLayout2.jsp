<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 조회 경우 -->
<c:choose>
<c:when test="${!empty requestScope.contentTemp }">
<c:forEach begin="0" end="1" step="1" varStatus="ii">
<c:if test="${ii.index==1&&contentTemp.portfolioContentOrder==portfolioContent[i.index+1].portfolioContentOrder}">
	<c:set var="content" value="${portfolioContent[i.index+1] }"/>
</c:if>
<div class="left_box" style="margin-left:11%;">
	<div class="pic_box" id="l2picbox">
	<c:choose>
		<c:when test="${contentTemp.portfolioContentName=='image' }">
			<img src="${contentTemp.portfolioContentValue }" width="100%" height="100%"/>
		</c:when>
		<c:when test="${contentTemp.portfolioContentName=='media' }">
			<iframe width="100%" height="100%" src="${contentTemp.portfolioContentValue }" ></iframe>
		</c:when>
		<c:when test="${contentTemp.portfolioContentName=='ppt' }">
			<iframe width="100%" height="95vh" src="${contentTemp.portfolioContentValue }#page=1&zoom=50"></iframe>
		</c:when>
	</c:choose>
	</div>
</div>
<div class="content_box" style="margin-top:5%;height:73vh;font-size:150%;margin-left:2%;width:35%" >
			${contentTemp.portfolioContentIntro }
</div>
</c:forEach>
</c:when>
<c:otherwise>
<!-- 등록일경우 -->
<div class="left_box" style="margin-left:11%;">
	<div class="pic_box" id="l2picbox">
		
	</div>
</div>
<div class="content_box" style="margin-top:5%;height:73vh;font-size:200%;margin-left:2%;width:35%" >
	 <textarea class="form-control registerPortfolioInput" style="margin-top:0;height:90.5%;width:80%;resize: none"
		name="contentIntro"  placeholder="소개글을 입력하세요"></textarea>
</div>
</c:otherwise>
</c:choose>
