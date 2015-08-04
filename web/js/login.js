$(document).ready(function(){
	
$('#login_admin').submit(function(e){
		e.preventDefault();

		var username = $('#username').val();
		var pswd = $('#pswd').val();
		var data = 'login_form=yes&username='+username+'&password='+ pswd;
		//alert(data);
		
		$.post(base_url + "login/loginUser",data,function(data2){
			alert(data2);
			
			/*
			$('#login_admin').each(function(){
    			this.reset();
			});
			
			var data3 = JSON.parse(data2);
			
			if(data3.success == "1"){
              	location.replace("index.php");
			}
			else if(data3.success == "0"){
				$('#not').html('<div class="error2">'+data3.message+'</div>');
			}
			*/
			
		});
	});
	
});
