<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">


<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#img').click(function(e) {
			$('#leaderForm').submit();
		});
	});
</script>
<body>
	<c:if test="${not empty faqInfo }">
		<div class="team_detail_row team_detail_content_interval">
			<div class="row team_detail_row_title team_detail_title_content_font">FAQ</div>
			<c:forEach items="${faqInfo}" var="faq">
				<div class="row team_detail_row_text team_detail_content_interval">Q:
					${faq.faqQuestion }</div>
				<div
					class="row team_detail_row_text team_detail_content_interval team_detail_indent">
					<label class="team_detail_indent">팀장 답변 : ${faq.faqAnswer } </label>
				</div>
				<form id="leaderForm" action="./polog.do" method="post">
					<input type="hidden" value="${teamInfo.memberId} ">
				</form>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>