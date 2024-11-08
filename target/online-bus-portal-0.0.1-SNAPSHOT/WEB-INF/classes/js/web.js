$(document).ready(function(){
	$('input[name="journey"]').on('click', function(){
		alert('journey clicked');
		let selected_journey = $('input[name="journey"]:checked').val();
		$('input[name="amount"]').val(selected_journey);
	})
});