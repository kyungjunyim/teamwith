<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#memberRegisterModal" id="btn_member_register" style="display: none;"></button>
	<div class="modal fade bd-example-modal-sm" id="memberRegisterModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-md" role="document">
			<div class="modal-content">
				<form action="/account/register" method="post">
					<div class="modal-header">
						<h5 class="modal-title text_orange" id="exampleModalLongTitle">회원	가입</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<label class="register_label">아이디</label>
						<input type="text" placeholder="아이디" class="register_input" name="memberId" required><br>
						<label class="register_label">비밀번호</label> 
						<input type="password" id="pwd" placeholder="비밀번호" class="register_input" name="memberPassword" required><br>
						<label class="register_label">비밀번호 확인</label>
						<input type="password" id="pwd2" placeholder="비밀번호 확인" class="register_input" required><br>
						<label class="register_label">이름</label>
						<input type="text" placeholder="이름" class="register_input" name="memberName" required><br> 
						<label class="register_label">이메일</label>
						<input type="email" placeholder="이메일" class="register_input" name="memberEmail" required><br>
						<label class="register_label">생년월일</label> 
						<input type="date" placeholder="생년월일" class="register_input" name="memberBirth" required><br> 
						<label class="register_label">핸드폰번호</label>
						<input type="number" placeholder="핸드폰번호" class="register_input" name="memberPhone" required><br>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-md btn_submit"	style="margin: auto;">회원 가입</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#findAccountModal" id="btn_find_account" style="display: none;"></button>
	<div class="modal fade bd-example-modal-sm" id="findAccountModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-md" role="document">
			<div class="modal-content">
				<form action="/account/findId" method="post">
					<div class="modal-header">
						<h5 class="modal-title text_orange" id="exampleModalLongTitle">아이디 찾기</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<label class="register_label">이메일</label>
						<input type="email" placeholder="이메일" class="register_input" name="memberEmail" required><br>
						<label class="register_label">생년월일</label> 
						<input type="date" placeholder="생년월일" class="register_input" name="memberBirth" required><br>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-md btn_submit" style="margin: auto;">아이디 찾기</button>
					</div>
				</form>
				<form action="/account/findPwd" method="post">
					<div class="modal-header">
						<h5 class="modal-title text_orange" id="exampleModalLongTitle">비밀번호 찾기</h5>
					</div>
					<div class="modal-body">
						<label class="register_label">아이디</label>
						<input type="text" placeholder="아이디" class="register_input" name="memberId" required><br>
						<label class="register_label">이메일</label>
						<input type="email" placeholder="이메일" class="register_input" name="memberEmail" required><br>
						<label class="register_label">생년월일</label> 
						<input type="date" placeholder="생년월일" class="register_input" name="memberBirth" required><br>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-md btn_submit" style="margin: auto;">비밀번호 찾기</button>
					</div>
				</form>
			</div>
		</div>
	</div>	
	
	<div class="modal fade bd-example-modal-sm" id="changePwdModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-md" role="document">
			<div class="modal-content">
				<form action="/account/changePassword" method="post">
					<div class="modal-header">
						<h5 class="modal-title text_orange" id="exampleModalLongTitle">비밀번호 변경</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<label class="register_label">아이디</label>
						<input type="text" placeholder="아이디" class="register_input" name="memberId" required><br>
						<label class="register_label">비밀번호</label> 
						<input type="password" placeholder="비밀번호" class="register_input" name="memberPassword" required><br>
						<label class="register_label">새 비밀번호</label> 
						<input type="password" placeholder="새 비밀번호" class="register_input" name="newPassword" required><br>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-md btn_submit" style="margin: auto;">비밀번호 변경</button>
					</div>
				</form>
			</div>
		</div>
	</div>	
	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#removeMember" id="btn_remove_member" style="display: none;"></button>
	<div class="modal fade bd-example-modal-sm" id="removeMember" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-md" role="document">
			<div class="modal-content">
				<form action="/account/remove" method="post">
					<div class="modal-header">
						<h5 class="modal-title text_orange" id="exampleModalLongTitle">회원 탈퇴</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<label class="register_label">비밀번호</label>
						<input type="password" placeholder="비밀번호" class="register_input" name="memberPassword" required><br>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-md btn_submit" style="margin: auto;">탈퇴하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>	

</body>
</html>