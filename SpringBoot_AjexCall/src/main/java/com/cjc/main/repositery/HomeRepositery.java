package com.cjc.main.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Book;
import com.cjc.main.model.Employee;
@Repository
public interface HomeRepositery extends JpaRepository<Book, Integer>{

	public Book findByBookId(int id);

	

}
