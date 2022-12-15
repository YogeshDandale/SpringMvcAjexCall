package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public String addEmp() {

		return "employee";

	}

	// save employee form
	@PostMapping("/insertEmployee")
	@ResponseBody
	public String insertEmployee(@ModelAttribute("insertEmployee") Employee emp) {

		si.postdata(emp);
		return "SuccessFully Insert Record";
	}

	@GetMapping(value = "/getAllEmployee")
	@ResponseBody
	public List<Employee> lodeEmployee(Model model) {
		
		List<Employee> list = si.getalldata();
		return list;
	}
	// lode edit form

	@GetMapping("/editEmloyee/{id}")
	@ResponseBody
	public Employee lodeEditForm(@PathVariable("id") int id, Model m) {

		Employee emp = si.editdata(id);
		return emp;

	}

	@PostMapping("/updateEmployee")
	@ResponseBody
	public String updateEmp(@ModelAttribute("updateEmployee") Employee emp) {
		si.update(emp);
		return "successFully Updated Record";

	}

	@PostMapping("/deleteEmployee/{id}")
	@ResponseBody
	public String deleteEmployee(@PathVariable int id) {

		si.delete(id);
		return "SuccessFully Deleted Record";

	}

}
