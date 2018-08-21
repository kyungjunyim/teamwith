<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div class="row main_title">
		<div class="col">
			<span class="text_orange">최근</span> <span class="text_blue">회원</span>
		</div>
	</div>
	<c:if test="${empty recentMemberList }">
	<div class="row main_row_whole">
		<label class="label_no_exist"> 등록된 회원이 없습니다. </label>
	</div>
	</c:if>
	<c:if test="${not empty recentMemberList }">
	<div class="row best_member_row_whole">
	<c:forEach items="${recentMemberList }" var="recentMember">
			<div class="col-xs-6 main_content_col" onclick="location='/polog/${recentMember.memberId}'">
					<div class="row member_image_row">
						<img src="${recentMember.memberPic }" class="member_image">
					</div>
				<div class="row member_content_text">
					<div class="row member_text">
						<label class="member_text">${recentMember.memberName }님</label>
					</div>
					<div class="row member_text">
						<label class="member_text member_praise_text">${applicationScope.roleList[recentMember.roleId] }</label>
					</div>
				</div>
			</div>
	</c:forEach>
	</div>
	</c:if>
	
	<!-- 페이징 처리 -->
	<div class="row best_member_row_whole">
		<ul class="pagination member_search_pagination">
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