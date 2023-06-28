package com.glearning.Ims.service;

import java.util.List;

import com.glearning.Ims.model.Book;

public interface BookService {
	
    Book save(Book book);
	
	List<Book> findAll();
	
	Book findBookById(int id);
	
	void deleteBookById(int id);
	

}
