	$(".navbar-header").click(function(e) {
		$(".to_home").submit();
	});
	
	$(".commingSoon").click(function(e) {
		$("#btn_modal").click();
	});
	
	$("#register").on("click", function(){
		$("#btn_member_register").click();
	});
	
	$("#find_account").on("click", function() {
		$("#btn_find_account").click();
	});
	
	$("#label_remove_member").on("click", function() {
		$("#btn_remove_member").click();
	});