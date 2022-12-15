package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crud.doa.Dao;
import com.crud.model.Employee;

@Service
@Component
public class ServiceI{

	@Autowired
	Dao di;
	
	public List<Employee> getalldata() {
		
		return di.getalldata();
	}

	public void postdata(Employee e) {
		
		 di.postdata(e);
	}
	
	public Employee editdata(int id) {
		
		return di.editdata(id);
	}
	
	public int update(Employee e) {
		
		return di.update(e);
	}

	public int delete(int i) {
		
		return di.delete(i);
	}

}
