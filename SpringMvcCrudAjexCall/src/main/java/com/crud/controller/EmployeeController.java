package com.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.model.Employee;
import com.crud.model.ServiceResponse;
import com.crud.service.ServiceI;


@Controller
@RequestMapping
public class EmployeeController {
	
	@Autowired
	private ServiceI si;
	
	
	
	@GetMapping("employee")
	public String  addEmp()
	{
		
		return "employee";
		
	}
	//save employee form
		@PostMapping("/insertEmployee")
		public String insertEmployee(@ModelAttribute("insertEmployee") Employee emp)
		{
		
			si.postdata(emp);
			return "employee";
		}
		
	
	@GetMapping(value = "/getAllEmployee")
	 @ResponseBody
	public List<Employee>  lodeEmployee(Model model)
	{
		System.out.println("Hello");
		List<Employee> list = si.getalldata();
	for (Employee employee : list) {
		System.out.println("Hello"+employee.toString());
	}
		
		return list;
	}
	//lode edit form
	 
		@GetMapping("/editEmloyee/{id}")
		public ResponseEntity<Object> lodeEditForm(@PathVariable("id") int id, Model m)
		{
			
			Employee emp=si.editdata(id);
			
		
			ServiceResponse<Employee>response=new ServiceResponse<Employee>("success",emp);
			return new ResponseEntity<Object>(emp,HttpStatus.OK);
			
		}
		@PostMapping("/updateEmployee")
		public ResponseEntity<Object> updateEmp(@ModelAttribute("updateEmployee") Employee emp)
		{
			si.update(emp);
			List<Employee> list = si.getalldata();
			
			ServiceResponse<List<Employee>> response=new ServiceResponse<>("success",list);
			
			return new ResponseEntity<Object>(response,HttpStatus.OK);
			
		}
		@PostMapping("/deleteEmployee/{id}")
		public ResponseEntity<Object>  deleteEmployee(@PathVariable int id)
		{
		
			si.delete(id);
			List<Employee> list = si.getalldata();
			
			ServiceResponse<List<Employee>> response=new ServiceResponse<>("success",list);
			
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		
		}
		
	

}
