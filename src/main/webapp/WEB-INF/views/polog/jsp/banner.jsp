<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.polog_header h3 {
	line-height: 0;
	font-size: 2em;
	margin: 0 0 1em 0;
}

header h3:hover {
	opacity: 0.7;
}
</style>
</head>
<body>
	<div class="inner">
		<header class="major polog_header">
			<a href="/polog/${memberVO.memberId }" style="text-decoration: none;"><h3>${pologVO.pologTitle }</h3></a>
		</header>
		<div class="content">

			<img id="member_sm_pic" src='${memberVO.memberPic }'>
			<h5 id="member_name" style="width: 120px">${memberVO.memberName }</h5>
			<div id="polog_intro" style="font-family: bmjua">${pologVO.pologIntro}</div>
		</div>
	</div>
</body>
</html>