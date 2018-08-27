<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 조회 경우 -->
<style>
#l1picbox{
	width:100%;
	height:100%;
	border:2px solid white;
	
}
</style>
<c:choose>
<c:when test="${!empty requestScope.contentTemp or !empty requestScope.oldContent}">
<%-- <c:forEach begin="0" end="1" step="1" varStatus="ii">
<c:if test="${ii.index==1&&contentTemp.portfolioContentOrder==portfolioContent[i.index+1].portfolioContentOrder}">
	<c:set var="content" value="${portfolioContent[i.index+1] }"/>
</c:if> --%>
<div class="center_content" id="centercon" >
	<div id="l1picbox" class="pic_box" style="width:100%;height:100%;border:2px solid white;">
	<c:if test="${!empty requestScope.contentTemp }">
	<c:choose>
		<c:when test="${contentTemp.portfolioContentName=='image' }">
			<img src="${contentTemp.portfolioContentValue }" width="100%" height="100%"/>
		</c:when>
		<c:when test="${contentTemp.portfolioContentName=='media' }">
			<iframe width="100%" height="100%" src="${contentTemp.portfolioContentValue }" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
		</c:when>
		<c:when test="${contentTemp.portfolioContentName=='ppt' }">
			<iframe width="100%" height="100%" src="${contentTemp.portfolioContentValue }#page=1&zoom=50"></iframe>
		</c:when>
		
	</c:choose>
	</c:if>
	<c:if test="${!empty requestScope.oldContent }">
	<input type="hidden" name="portfolioContentId" value="${oldContent.portfolioContentId }">
	<c:choose>
		<c:when test="${oldContent.portfolioContentName=='image' }">
			<div style="width:100%;height:100%;background-image: url(${oldContent.portfolioContentValue });background-size:100% 100%">
				<input type="file" class="btn" style="margin-top: 25%;margin-left:15%" accept=".png,.jpg,.jpeg,.bmp,.gif" name="portfolioFile"/>
				<input type="hidden" name="portfolioContentName" value="image"/>
				<input type="hidden" name="contentOrder" value="${oldContent.portfolioContentOrder }"/>
				<input type="hidden" name="oldContentImage" value="${oldContent.portfolioContentValue }">
			</div>
		</c:when>
		<c:when test="${oldContent.portfolioContentName=='media' }">
				<input type="text" class="form-control registerPortfolioInput"  value="${oldContent.portfolioContentValue }" name="portfolioURL" style="display:inline;margin-top:30%;font-size:100%" placeholder="Youtube URL을 입력해 주세요"/>
				<input type="hidden" name="portfolioContentName" value="media"/><br>
				<동영상 등록하는 방법><br>1.Youtube 동영상 화면 우클릭<br>2.소스코드 복사 클릭<br>
				3. src="https://www.youtube.com/embed/nelSiMnilRw?ecver=1<br>"..." 안에 내용을 복사하여 입력해 주세요
				<input type="hidden" name="contentOrder" value="${oldContent.portfolioContentOrder }"/>
		</c:when>
		<c:when test="${oldContent.portfolioContentName=='ppt' }">
				<input type="file" class="btn" style="margin-left:15%" accept=".ppt,.pptx" name="portfolioFile"/>
				<input type="hidden" name="portfolioContentName" value="ppt"/>
				<input type="hidden" name="contentOrder" value="${oldContent.portfolioContentOrder }"/>
				<input type="hidden" name="oldContentPpt" value="${oldContent.portfolioContentValue }">
			<iframe width="100%" height="88%" src="${oldContent.portfolioContentValue }#page=1&zoom=50"></iframe>
			
		</c:when>
		
	</c:choose>
	</c:if>
	</div>
</div>

<div class="bottom_content" style="margin-top:2%">
	
	<c:if test="${!empty requestScope.oldContent }">
	<textarea class="form-control registerPortfolioInput" style="margin:0 auto;margin-top:2.5%;height:73%;width:80%;resize: none"
		name="contentIntro" placeholder="소개글을 입력하세요">${oldContent.portfolioContentIntro }</textarea>
	</c:if>
	<c:if test="${empty requestScope.oldContent or requestScope.oldContent eq null}">
		${contentTemp.portfolioContentIntro }
	</c:if>
		
	
</div>
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
