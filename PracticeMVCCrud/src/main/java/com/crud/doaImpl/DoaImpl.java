package com.crud.doaImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.crud.doa.Dao;
import com.crud.model.Employee;

@Component
public class DoaImpl implements Dao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Employee> getalldata() {
		Session session=sf.openSession();
	Transaction tx = session.beginTransaction();
	Query query = session.createQuery("from Employee");
	List<Employee> result = (List<Employee>) query.list();
	tx.commit();
	session.close();
	return result;
		
	}

	@Override
	public void postdata(Employee e) {
		Session session=sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.close();
		
	}

	@Override
	public Employee editdata(int id) {
		Session session=sf.openSession();
		Transaction tx = session.beginTransaction();
		Employee es = session.get(Employee.class,id);
		tx.commit();
		session.close();
		return es;
	}

	@Override
	public int update(Employee e) {
		Session session=sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update Employee set name='"+e.getName()+"',address='"+e.getAddress()+"',department='"+e.getDepartment()+"',designation='"+e.getDesignation()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"'");
		int i = query.executeUpdate();
		return 1;
	}

	@Override
	public int delete(int i) {
		Session session=sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Employee where id='" + i + "'");
		int id = query.executeUpdate();
		tx.commit();
		session.close();
		return id;
	}

}
