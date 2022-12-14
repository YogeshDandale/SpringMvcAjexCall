package com.cjc.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cjc.main.model.Book;
import com.cjc.main.model.Employee;
import com.cjc.main.repositery.HomeRepositery;
import com.cjc.main.service.HomeService;
@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	private HomeRepositery hr;
	
	@Override
	public Book save( Book e) {

		return hr.save(e);
	}

	@Override
	public List<Book> find() {
		return hr.findAll();
	}

	@Override
	public void delete(int id) {

		hr.deleteById(id);
	}

	@Override
	public Book findBookById(int id) {
		
		return hr.findByBookId(id);
	}

	@Override
	public Book updateBook(Book book) {
		
		return hr.save(book);
	}

	
	

}
