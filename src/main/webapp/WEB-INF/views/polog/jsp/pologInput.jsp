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
							&nbsp;&nbsp;Polog Settings</th>
					</tr>
					<tr>
						<td>폴로그 제목</td>
						<td><input type="text" id="polog_title"
							name="pologTitle" class="profile_input"
							style="text-align: right;" value="${pologVO.memberPhone }"></td>
					</tr>
					<tr>
						<td>폴로그 배경색</td>
						<td><input type="color" id="polog_bgcolor"
							name="pologBgColor" class="profile_input"
							style="text-align: right;" value="${pologVO.memberPhone }"></td>
					</tr>
					<tr>
						<td>폴로그 소개</td>
						<td><textarea id="polog_intro" class="profile_input"
								name="pologIntro">${pologVO.memberIntro}</textarea></td>
					</tr>
					<tr>
						<td>폴로그 배경 사진</td>
						<td><input id="file" type="file" name="pologBgPicFile"
							class="form-control"> <!-- <button type="button" onclick="$('#file').trigger('click')">파일</button> -->
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>

</body>
</html>