$(document).ready(function(){
	$('input[name="journey"]').click(function(){
		let selected_journey = $('input[name="journey"]:checked').val();
		// set the ammount text box
		$("#amount").val(parseFloat(selected_journey));
		// set the journey variable using AJAX and accessing the session variable 
		$.ajax({
			url : 'set-user-journey',
			data : {
				selected_journey : selected_journey
			},
			method: 'get',
			success : function() {
				console.log('journey selected');
			}
		});
	});
	
	$("#payment-form").submit(function(e){
		e.preventDefault();
		//alert('submitted');
		payWithPayStack()
	});
	
	function payWithPayStack(){
		//payment variable 
		let amount = parseFloat(document.getElementById("amount").value);
		let url = document.getElementById("callback_url").value;
		let email = document.getElementById("user_email").value;
		
		let handler = PaystackPop.setup({
			key: 'pk_test_e9a8ce8b46c57ae85605d88131e4af45a71d59c2',
			email: email,
			amount: amount * 100,
			currency: 'NGN',
			ref: '' + Math.floor((Math.random() * 1000000) + 1),
			onClose: function(){
				alert("Transaction was not successfully completed, window closed.");
			},
			callback: function(response){
				let message = 'Payment completed successfully. Reference: ' + response.reference;
				alert(message);
				window.location.href = url
			}
		});
		
		// call the handler 
		handler.openIframe();
	}
});