package com.cjc.main.service;

import java.util.List;

import com.cjc.main.model.Book;
import com.cjc.main.model.Employee;

public interface HomeService {

	public Book save(Book book);

	public List<Book> find();

	public void delete(int id);

	public Book findBookById(int id);

	public Book updateBook(Book book);



}
