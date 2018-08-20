<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/polog/css/contact.css" />
<link rel="stylesheet" href="/resources/polog/css/profile.css" />

<script src="/resources/polog/js/contact.js"></script>
</head>
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

.profile_input {
	background-color: #fff2ec !important;
	border-radius: 10px !important;
	font-family: nanumSquareRound;
	border-bottom: none !important;
}

.profile_input:focus {
	background-color: white !important;
	box-shadow: 0 0 0 2px #fff2ec !important;
	border-bottom: none !important;
}

textarea {
	resize: none;
	height: 200px;
}

.polog_box {
	width: 1000px;
	margin: auto;
}

#polog_form {
	width: 1800px;
}

#polog_form:before, #polog_form:after {
	display: block;
	content: '';
	clear: both;
}

.polog_box:hover {
	margin: inherit;
}

button[type=submit]:hover {
	background: white;
	color: #000025;
}
</style>
<body>

	<form action="/polog/edit/${sessionScope.memberSimpleVO.memberId }" method="post" id="profile_form"
		enctype="multipart/form-data">
		<input type='hidden' name="memberId"
			value="${sessionScope.memberSimpleVO.memberId }">
		<div class="profile" id="profile">

			<!-- 기본 정보 -->
			<div id="information_box" class="profile_box polog_box">

				<table>
					<tbody>
						<tr>

							<th><i class="material-icons">Settings</i></th>
						</tr>
						<tr>
							<td>폴로그 제목</td>
							<td><input type="text" id="polog_title" name="pologTitle"
								class="profile_input" style="text-align: right;"
								value="${pologVO.pologTitle }"></td>
						</tr>
						<tr>
							<td>폴로그 배경색</td>
							<td><input type="color" id="polog_bgcolor"
								name="pologBgColor" class="profile_input"
								style="text-align: right; height: 50px; width: 100px;"
								value="${pologVO.pologBgColor }"></td>
						</tr>
						<tr>
							<td>폴로그 소개</td>
							<td><textarea id="polog_intro" class="profile_input"
									name="pologIntro">${pologVO.pologIntro}</textarea></td>
						</tr>
						<tr>
							<td>폴로그 배경 사진</td>
							<td><input id="file" type="file" name="pologBgPicFile"
								class="form-control"> <!-- <button type="button" onclick="$('#file').trigger('click')">파일</button> -->
							</td>
						</tr>
				</table>
			</div>
		</div>
		<div>

			<button type="submit" style="margin: 50px 42%;">수정하기</button>

		</div>
	</form>

</body>
</html>