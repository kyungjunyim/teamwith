<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="row profile_row_pic">
		<img src="${sessionScope.memberSimpleVO.memberPic }"
			class="profile_pic">
	</div>
	<div class="row profile_info">
		<div class="profile_text_name">${sessionScope.memberSimpleVO.memberName }</div>
	</div>
	<div class="row profile_info">
		<button type="submit" class="btn_logout" onclick="location='/logout'" style="margin-right: 10px;">로그아웃</button>
		<button type="button" class="btn_logout" data-toggle="modal" data-target="#changePwdModal" id="btn_change_password" style="margin-left: 10px;">비밀번호 수정</button>
	</div>
	<div class="row profile_row">
		<div class="col-xs-4 profile_col">
			<label class="profile_label">알림</label>
		</div>

		<div class="col-xs-4 profile_col">
			<label class="profile_label">나의 지원</label>
		</div>

		<div class="col-xs-4 profile_col">
			<label class="profile_label">나의 팀</label>
		</div>
	</div>
	<div class="row profile_row">
		<div class="col-xs-4 profile_col">
			<button type="button" class="btn btn-md btn_profile">0</button>
		</div>
		<div class="col-xs-4 profile_col">
			<button type="submit" id="my_application"
				class="btn btn-md btn_profile"
				onclick="location = '/application/myApplication'">${myApplicationCnt }</button>
		</div>
		<div class="col-xs-4 profile_col">
			<form action="/team/myTeam" method="get">
				<input type="hidden" name="job" value="myTeam"> <input
					type="hidden" name="memberId"
					value="${sessionScope.memberSimpleVO.memberId }">
				<button type="submit" class="btn btn-md btn_profile">
					<c:if test="${fn:length(myTeamList) > 10 }">
						10+
					</c:if>
					<c:if test="${fn:length(myTeamList) <= 10 }">
						${fn:length(myTeamList) }
					</c:if>
				</button>
			</form>
		</div>
	</div>
	<div class="row profile_row profile_row_btn">
		<button type="submit" class="btn btn-md btn_submit"
			onclick="location = '/polog/${sessionScope.memberSimpleVO.memberId }'">나의
			폴로그</button>
	</div>
</body>
</html>