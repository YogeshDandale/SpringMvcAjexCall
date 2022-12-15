<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
		
	getAllrecord();
	
	$('#saveEmployee').show();
	$('#updateEmployee').hide();
	$('#idfield').hide();
	
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
					getAllrecord()
					$('#employeeForm')[0].reset()
				},
				error : function(err) {
					alert("error is" + err)
				}
			});

		});
		
		
});
//GET REQUEST
	var data = "";
	function getAllrecord() {
		$
				.ajax({
					type : "GET",
					url : "getAllEmployee",
					success : function(response) {
						 data = response
						 
						 $('.tr').remove();
						for (i = 0; i < data.length; i++) {
							
							$("#employeeTable")
									.append(
											'<tr class="tr"> <td>'
													+ data[i].id
													+ '</td> <td>'
													+ data[i].name
													+ '</td> <td>'
													+ data[i].age
													+ '</td> <td>'
													+ data[i].course
													+ '</td> <td><input type="button" class="btn btn-warning" onclick="editEmployee('
													+ data[i].id
													+ ')"  value="Edit"></input></td> <td> <input type="button" class="btn btn-danger" onclick="deleteEmployee('
													+ data[i].id
													+ ');" value="Delete"></input></td> </tr>');

						}

					},
					error : function(err) {
						alert("error is" + err)
					}
				});
	}



function editEmployee(id) {

	$.ajax({
		
		type : "GET",
	
		url : "editEmloyee/" + id,
		dataType : 'json',
		success : function(response) {
			
			$("#id").val(response.id), $("#name").val(response.name), $(
					"#age").val(response.age), $("#course").val(response.course)

			$('#saveEmployee').hide();
			$('#updateEmployee').show();
			$('#idfield').show();
		},
		error : function(err) {
			alert("error is" + err)
		}
	});
}
function updateEmployeebtn() {

	$.ajax({
		type : "POST",
		url : "updateEmployee",
		data : {
			id : $("#id").val(),
			name : $("#name").val(),
			age : $("#age").val(),
			course : $("#course").val()
		},
		success : function(result) {
			getAllrecord();

			$('#saveEmployee').show();
			$('#updateEmployee').hide();
			$('#idfield').hide();
			$('#employeeForm')[0].reset()
		},
		error : function(err) {
			alert("error is" + err)
		}
	});
	

}
function deleteEmployee(id) {
	$.ajax({
		type : "POST",
		url : "deleteEmployee/" + id,
		success : function(response) {
			alert(response)
			getAllrecord();
			
		},
		error : function(err) {
			alert("error is" + err)
		}
	});
}

</script>
</head>
<body>  
	<div class="container mt-3">
		<form id="employeeForm" name="employeeform">
			<div class="row">
				<div class="col-6">
					<h3>Employee Form</h3>
					<div class="row" id="idfield">
						<div class="col">
							<div class="form-group">
								<label for="id">ID</label> <input type="text" readonly="readonly"
									class="form-control" id="id" name="id">
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="name">Name</label> <input type="text"
									class="form-control" id="name" name="name"
									placeholder="Enter Name">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="age">Age</label> <input type="text"
									class="form-control" id="age" name="age"
									placeholder="Enter Age">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="name">Course</label> <input type="text"
									class="form-control" id="course" name="course"
									placeholder="Enter Course">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<button type="button" id="saveEmployee" class="btn btn-primary">Submit</button>
							<button type="button" id="updateEmployee"
								onclick="updateEmployeebtn()" class="btn btn-primary">Update</button>
								
							
						</div>
					</div>
				</div>
				<div class="col-6">

					<h3>Employee Record</h3>
					
					 <br>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Name</th>
								<th scope="col">Age</th>
								<th scope="col">Course</th>
								<th scope="col">Edit</th>
								<th scope="col">Delete</th>
							</tr>
						</thead>
						<tbody id="employeeTable">
						</tbody>
						
					</table>


				</div>


			</div>
		</form>
	</div>


</body>
</html>