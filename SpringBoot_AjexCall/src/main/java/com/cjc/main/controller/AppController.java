package com.cjc.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Book;
import com.cjc.main.model.Employee;
import com.cjc.main.model.ServiceResponse;
import com.cjc.main.service.HomeService;

@RestController
public class AppController {

	@Autowired
	private HomeService hs;
	
	
	
	

		List<Book> bookStore = new ArrayList<>();

		@PostMapping("/saveBook")
		public ResponseEntity<Object> addBook(@RequestBody Book book) {
		
			Book book2=hs.save(book);
			System.out.println(book.toString());
			ServiceResponse<Book> response = new ServiceResponse<Book>("success", book2);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}

		@GetMapping("/getBooks")
		public ResponseEntity<Object> getAllBooks() {
			List<Book> find = hs.find();
			ServiceResponse<List<Book>> response = new ServiceResponse<>("success", find);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}
		@GetMapping("/getOneBook/{bookId}")
		public ResponseEntity<Object> getBooksById(@PathVariable("bookId")int id) {
			Book find = hs.findBookById(id);
		
			ServiceResponse<Book> response = new ServiceResponse<>("success", find);
			System.out.println("Hello Java"+response.getData());
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}
		@PostMapping("/updateStudent")
		public ResponseEntity<Object> updateBook(@RequestBody Book book) {
		
			Book book2=hs.updateBook(book);
			System.out.println(book.toString());
			ServiceResponse<Book> response = new ServiceResponse<Book>("success", book2);
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}
		@PostMapping("/deleteBook/{bookId}")
		public ResponseEntity<Object> deleteData(@PathVariable("bookId")int id) {
			hs.delete(id);
		System.out.println("id0i"+id);
			
			
			return new ResponseEntity<Object>("Delete Data SuccessFully", HttpStatus.NO_CONTENT);
		}
		
	}
	
	
	
	

