package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.model.Employee;
import com.crud.service.ServiceI;


@Controller
@RequestMapping
public class EmployeeController {
	
	@Autowired
	private ServiceI si;
	
	
	
	@GetMapping("addEmployee")
	public String  addEmp()
	{
		
		return "AddEmployee";
		
	}
	//save employee form
		@PostMapping("/insertEmployee")
		public String insertEmployee(@ModelAttribute("insertEmployee") Employee emp)
		{
			
			si.postdata(emp);
			return "redirect:/employeeReport";
		}
		
	
	@GetMapping("employeeReport")
	public String lodeEmployee(Model m)
	{
		m.addAttribute("employee", si.getalldata());
		m.addAttribute("title", "Employee Report");

		return "EmployeeReport";
	}
	//lode edit form
	 
		@GetMapping("/editEmployee/{id}")
		public String lodeEditForm(@PathVariable(value="id") int id, Model m)
		{
			Employee emp=si.editdata(id);
			
			System.out.println(emp);
			m.addAttribute("employee", emp);
			m.addAttribute("title", "Edit Employee");
			
			return "EditEmployee";
			
		}
		@PostMapping("/editEmployee/updateEmployee")
		public String updateEmp(@ModelAttribute("updateEmployee") Employee emp)
		{
			si.update(emp);
			
			return "redirect:/employeeReport";
			
		}
		@GetMapping("/deleteEmployee/{id}")
		public String deleteEmployee(@PathVariable int id)
		{
			si.delete(id);
			
			
			return "redirect:/employeeReport";
		}
		
	

}
