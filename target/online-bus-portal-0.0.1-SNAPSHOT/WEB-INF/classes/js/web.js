$(document).ready(function(){
	$('input[name="journey"]').click(function(){
		alert('journey clicked');
		let selected_journey = $('input[name="journey"]:checked').val();
		$('input[name="amount"]').val(selected_journey);
		alert(selected_journey);
		// set the journey variable using AJAX and accessing the session variable 
//		$.ajax({
//			url : 'set-user-journey',
//			data : {
//				selected_journey : selected_journey
//			},
//			method: 'get',
//			success : function() {
//				console.log('journey selected');
//			}
//		});
	});
});