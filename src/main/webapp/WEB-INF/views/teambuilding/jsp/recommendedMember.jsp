<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e){
		$('#img').click(function(e){
			$('#recommendForm').submit();
		});
		
	});
</script>
</head>
<body>
	<div class="team_detail_row team_detail_content_interval">
		<div class="team_detail_row_title team_detail_title_content_font">추천 팀원</div>
		<div class="row coworker_row">
			<form action="polog.do" method="post" id="hwang">
				<input type="hidden" name="memberId" value="hwang">
				<div id="teamMember" class="coworker_col" onclick="$('#${member.memberId}').submit()">
					<div><img src="/resources/image/member/hwang.jpg" class="team_detail_img_sm"></div>
					<div><label class="coworker_text">황규진님</label></div>
					<div><label class="coworker_text text_orange">일치율 89%</label></div>
					<div><label class="coworker_text" style="font-size: 14px;">개발자</label></div>
				</div>
			</form>
			<form action="polog.do" method="post" id="hwang">
				<input type="hidden" name="memberId" value="hwang">
				<div id="teamMember" class="coworker_col" onclick="$('#${member.memberId}').submit()">
					<div><img src="/resources/image/member/hwang.jpg" class="team_detail_img_sm"></div>
					<div><label class="coworker_text">황규진님</label></div>
					<div><label class="coworker_text text_orange">일치율 89%</label></div>
					<div><label class="coworker_text" style="font-size: 14px;">개발자</label></div>
				</div>
			</form>
			<form action="polog.do" method="post" id="hwang">
				<input type="hidden" name="memberId" value="hwang">
				<div id="teamMember" class="coworker_col" onclick="$('#${member.memberId}').submit()">
					<div><img src="/resources/image/member/hwang.jpg" class="team_detail_img_sm"></div>
					<div><label class="coworker_text">황규진님</label></div>
					<div><label class="coworker_text text_orange">일치율 89%</label></div>
					<div><label class="coworker_text" style="font-size: 14px;">개발자</label></div>
				</div>
			</form>
			<form action="polog.do" method="post" id="hwang">
				<input type="hidden" name="memberId" value="hwang">
				<div id="teamMember" class="coworker_col" onclick="$('#${member.memberId}').submit()">
					<div><img src="/resources/image/member/hwang.jpg" class="team_detail_img_sm"></div>
					<div><label class="coworker_text">황규진님</label></div>
					<div><label class="coworker_text text_orange">일치율 89%</label></div>
					<div><label class="coworker_text" style="font-size: 14px;">개발자</label></div>
				</div>
			</form>									
		</div>
	</div>
</body>
</html>