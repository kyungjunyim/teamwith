<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header h3:hover{
opacity: 0.7;
}
</style>
</head>
<body>
<div class="inner">
				<header class="major">
					<a href="polog.do?memberId=${memberVO.memberId }" style="text-decoration:none;"><h3>${memberVO.memberName }의 폴로그입니다.</h3></a>
				</header>
				<div class="content">

					<img id="member_sm_pic" src='${memberVO.memberPic }'>
					<h5 id="member_name" style="width: 120px">${memberVO.memberName }</h5>
					<div id="polog_intro" style="font-family: bmjua">${memberVO.memberIntro }</div>
				</div>
			</div>
</body>
</html>