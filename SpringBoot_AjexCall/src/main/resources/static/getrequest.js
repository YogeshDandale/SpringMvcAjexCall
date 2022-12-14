 $(document).ready(
		function() {

			// GET REQUEST
			$("#getALlBooks").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				output="";
				$.ajax({
					type : "GET",
					url : "getBooks",
					success : function(result) {
						if (result.status == "success") {
							x=result.data
							/*$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data,
									function(i, book) {
										var user = "Book Name  "
												+ book.bookName
												+ ", Author  = " + book.author
												+ "<br>";
										$('#getResultDiv .list-group').append(
												user)
									});*/
							for(i=0;i<x.length;i++){
								output+="<tr><td>"+x[i].bookId+"</td><td>"+x[i].bookName+"</td><td>"+x[i].author
								+'</td> <td><input type="button" class="btn btn-warning" onclick="editStudent('
													+ x[i].bookId
													+ ')"  value="Edit"></input></td> <td> <input type="button" class="btn btn-danger" onclick="deleteStudent('
													+ x[i].bookId
													+ ');" value="Delete"></input></td> </tr>';
							}		
							$("#tbody").html(output);
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
					
				});
			
                 
			};
			
			
		
   
		});
			function editStudent(id) {
		$.ajax({
			type : "GET",
			url : "getOneBook/" + id,
			dataType : 'json',
			success : function(response) {

				console.log("student--"+response.data.bookId);
				$("#bookId").val(response.data.bookId), $("#bookName").val(response.data.bookName), $(
						"#author").val(response.data.author)

				$('#saveStudent').hide();
				$('#updateStudent').show();
				$('#idfield').show();
			},
			error : function(err) {
				alert("error is" + err)
			}
		});
	}
	function updateStudentbtn() {

		$.ajax({
			type : "POST",
			url : "updateStudent",
			data : {
				bookId : $("#bookId").val(),
				bookName : $("#bookName").val(),
				author : $("#author").val(),
				course : $("#course").val()
			},
			success : function(result) {
				getAllrecord();

				$('#saveStudent').show();
				$('#updateStudent').hide();
				$('#idfield').hide();
				$('#studentForm')[0].reset()
			},
			error : function(err) {
				alert("error is" + err)
			}
		});
		

	}
	function deleteStudent(id) {
		alert("dg"+id)
		$.ajax({
			type : "POST",
			url : "deleteBook/" + id,
			success : function(response) {
				alert(response)
				getAllrecord();
				
			},
			error : function(err) {
				alert("error is" + err)
			}
		});
	}
	

		
		
		
		
		
		
		