<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/polog/css/pofile.css" rel="stylesheet">
<script src="/resources/polog/js/contact.js"></script>
</head>
<body>
	<form action="/polog/edit" method="post" id="polog_form"
		enctype="multipart/form-data">
		<input type='hidden' name="memberId"
			value="${sessionScope.memberSimpleVO.memberId }">

		<!-- 기본 정보 -->
		<div id="polog_box" class="polog_box">

			<table>
				<tbody>
					<tr>

						<th><i class="material-icons">info</i>
							&nbsp;&nbsp;Information</th>
					</tr>
					<tr>
						<td>폴로그 제목</td>
						<td id="member_name">${memberVO.memberName }</td>
					</tr>
					<tr>
						<td>폴로그 배경색</td>
						<td id="member_email">${memberVO.memberEmail }</td>
					</tr>
					<tr>
						<td>폴로그 소개</td>
						<td><input type="text" id="member_phone" name="memberPhone"
							class="profile_input" style="text-align: right;"
							value="${memberVO.memberPhone }"></td>
					</tr>
					<tr>
						<td>폴로그 배경 사진</td>
						<td><input id="file" type="file" name="file"
							class="form-control"> <!-- <button type="button" onclick="$('#file').trigger('click')">파일</button> -->
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>

</body>
</html>