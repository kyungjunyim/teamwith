<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>
	<div class="row main_title">
		<div class="col">
			<span class="text_orange">검색</span> <span class="text_blue">결과</span>
		</div>
	</div>
	<c:if test="${empty resultMemberList }">
	<div class="row main_row_whole">
		<label class="label_no_exist"> 등록된 회원이 없습니다. </label>
	</div>
	</c:if>
	<c:if test="${not empty resultMemberList }">
	<div class="row best_member_row_whole">
	<c:forEach items="${resultMemberList }" var="resultMember">
			<div class="col-xs-6 main_content_col" onclick="location='/polog/${resultMember.memberId}'">
					<div class="row member_image_row">
						<img src="${resultMember.memberPic }" class="member_image">
					</div>
				<div class="row member_content_text">
					<div class="row member_text">
						<label class="member_text">${resultMember.memberName }님</label>
					</div>
					<div class="row member_text">
						<label class="member_text member_praise_text">${applicationScope.roleList[resultMember.roleId] }</label>
					</div>
				</div>
			</div>
	</c:forEach>
	</div>
	</c:if>
	
	<c:if test="${not empty resultMemberList }">
		<div class="row best_member_row_whole">
			<ul class="pagination member_search_pagination">
				<c:choose>
					<c:when test="${fn:length(resultMemberList) < 8 }">
						<li><a href="#">1</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:if>
</body>