<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<body>
	<c:if test="${not empty faqInfo }">
		<div class="team_detail_row team_detail_content_interval">
			<div class="team_detail_row_title team_detail_title_content_font">FAQ</div>
			<c:forEach items="${faqInfo}" var="faq">
				<div class="team_detail_row_text team_detail_content_interval">Q: ${faq.faqQuestion }</div>
				<div class="team_detail_row_text team_detail_content_interval team_detail_indent">
					<label class="team_detail_indent text_orange">팀장 답변 :</label><label class="team_detail_indent" style="margin-left: 0;">&nbsp;${faq.faqAnswer } </label>
				</div>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>