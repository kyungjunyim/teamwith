<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/polog/js/contact.js"></script>
<link href="/resources/polog/css/profileEdit.css" rel="stylesheet" />
<link href="/resources/polog/css/contact.css" rel="stylesheet" />

<style>
@font-face {
	font-family: 'Material Icons';
	font-style: normal;
	font-weight: 400;
	src:
		url(https://fonts.gstatic.com/s/materialicons/v39/flUhRq6tzZclQEJ-Vdg-IuiaDsNc.woff2)
		format('woff2');
}

.material-icons {
	font-family: 'Material Icons';
	font-weight: normal;
	font-style: normal;
	font-size: 24px;
	line-height: 1;
	letter-spacing: normal;
	text-transform: none;
	display: inline-block;
	white-space: nowrap;
	word-wrap: normal;
	direction: ltr;
	-webkit-font-feature-settings: 'liga';
	-webkit-font-smoothing: antialiased;
}
</style>
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
						<td><input type="text" id="member_phone" name="memberPhone"
							class="profile_input" style="text-align: right;"
							value="${memberVO.memberPhone }"></td>
					</tr>
					<tr>
						<td>폴로그 배경색</td>
						<td><input type="text" id="member_phone" name="memberPhone"
							class="profile_input" style="text-align: right;"
							value="${memberVO.memberPhone }"></td>
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