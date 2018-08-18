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
		<div class="row team_detail_row_title team_detail_title_content_font">추천 팀원</div>
		<form action="polog.do" method="post" id="teamMember1">
			<input type="hidden" name="memberId" value="hwang">				
		<div id="teamMember" class="row team_detail_row_detail team_detail_row_text team_detail_hover_opacity team_detail_content_interval team_detail_leader_effect" onclick="$('#teamMember1').submit()">
			<img src="/resources/image/member/hwang.jpg" class="rounded-circle team_detail_img_small"><label class="team_detail_img_small_text">조란 기획자 </label><label class="text_orange team_detail_img_small_text">일치율: 89%</label>
		</div>
		</form>
		<form action="/teamwith/polog/jsp/polog.do" method="post" id="teamMember2">
			<input type="hidden" name="memberId" value="kim">
		<div class="row team_detail_row_detail team_detail_row_text team_detail_hover_opacity team_detail_content_interval team_detail_leader_effect" onclick="$('#teamMember2').submit()">
			<img src="/resources/image/member/kim.jpg" class="rounded-circle team_detail_img_small"><label class="team_detail_img_small_text">임경준 디자이너 </label><label class="text_orange team_detail_img_small_text">일치율: 13%</label>
		</div>
		</form>
	</div>
</body>
</html>