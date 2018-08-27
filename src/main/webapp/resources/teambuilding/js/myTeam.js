$(".btn_team_delete").on("click", function(e) {
	var teamIdStr = $(this).val();
	$("#form" + teamIdStr).submit();
});

function clickTrEvent(trObj) {
	location = "/teamSearch/" + trObj.id;
}