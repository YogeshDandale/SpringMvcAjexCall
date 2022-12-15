
$(document).ready(function() {
		

$('#saveEmployee').click(function() {
			$.ajax({
				type : "POST",
				url : "insertEmployee",
				data : {
					name : $("#name").val(),
					age : $("#age").val(),
					course : $("#course").val()
				},
				success : function(result) {
					getAllrecord();
					$('#studentForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});

		});
		});
