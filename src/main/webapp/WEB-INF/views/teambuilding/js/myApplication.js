$(".btn_apply_cancel").on("click", function(e) {
	var applicationIdStr = $(this).val();
	$.ajax({
		type: 'post',
		url: 'myApplication.do',
		data: {job: "cancelApply", applicationId: applicationIdStr},
		dataType: 'JSON',	
		success: function(data, status) {
			if(data == true) {
				$("#applicationStatus" + applicationIdStr)[0].innerText = "취소";
				$("#call_cancel_modal" + applicationIdStr).prop("disabled", true);
				$("#call_cancel_modal" + applicationIdStr).removeClass("btn_submit_small");
				$("#call_cancel_modal" + applicationIdStr).addClass("btn_disable");
				$("#call_cancel_modal" + applicationIdStr).text("취소");
			}
		}
	});
});

function clickTrEvent(trObj) {
	$("#form" + trObj.id).submit();
}