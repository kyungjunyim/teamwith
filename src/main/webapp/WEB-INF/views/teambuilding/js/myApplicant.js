$(".btn_apply_join").on("click", function(e) {
	var applicationIdStr = $(this).val();
	$.ajax({
		type: 'post',
		url: 'myApplicant.do',
		data: {job: "joinTeam", applicationId: applicationIdStr},
		dataType: 'JSON',	
		success: function(data, status) {
			if(data == true) {
				$("#applicationStatus" + applicationIdStr)[0].innerText = "합류";
				$("#call_join_modal" + applicationIdStr).prop("disabled", true);
				$("#call_join_modal" + applicationIdStr).removeClass("btn_submit_small");
				$("#call_join_modal" + applicationIdStr).addClass("btn_disable");
				$("#call_drop_modal" + applicationIdStr).prop("disabled", true);
				$("#call_drop_modal" + applicationIdStr).removeClass("btn_submit_small");
				$("#call_drop_modal" + applicationIdStr).addClass("btn_disable");
			}
		}
	});
});

$(".btn_apply_drop").on("click", function(e) {
	var applicationIdStr = $(this).val();
	$.ajax({
		type: 'post',
		url: 'myApplicant.do',
		data: {job: "dropTeam", applicationId: applicationIdStr},
		dataType: 'JSON',	
		success: function(data, status) {
			if(data == true) {
				$("#applicationStatus" + applicationIdStr)[0].innerText = "탈락";
				$("#call_join_modal" + applicationIdStr).prop("disabled", true);
				$("#call_join_modal" + applicationIdStr).removeClass("btn_submit_small");
				$("#call_join_modal" + applicationIdStr).addClass("btn_disable");
				$("#call_drop_modal" + applicationIdStr).prop("disabled", true);
				$("#call_drop_modal" + applicationIdStr).removeClass("btn_submit_small");
				$("#call_drop_modal" + applicationIdStr).addClass("btn_disable");
			}
		}
	});
});

function clickTrEvent(trObj) {
	$("#form" + trObj.id).submit();
}