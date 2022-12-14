package com.crud.doa;

import java.util.List;

import com.crud.model.Employee;

public interface Dao {

public	List<Employee> getalldata();

public void postdata(Employee e);

public Employee editdata(int id);

public int update(Employee e);

public int delete(int i);

}
