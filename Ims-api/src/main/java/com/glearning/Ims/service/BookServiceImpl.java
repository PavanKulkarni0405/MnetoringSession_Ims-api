package com.glearning.Ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.glearning.Ims.model.Book;
import com.glearning.Ims.repository.BookJpaRepository;

public class BookServiceImpl implements BookService {
	
	@Autowired
	private final BookJpaRepository bookRepository;
	
	public BookServiceImpl(BookJpaRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book save(Book book) {
		
		return this.bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = this.bookRepository.findAll();
		
		return books;
	}

	@Override
	public Book findBookById(int id) {
		
		Optional<Book> optionalBook = this.bookRepository.findById(id);
		
		if(optionalBook.isPresent()) {
			
			return optionalBook.get();
			
		}
		
		throw new IllegalArgumentException("Invalid Book Id is passed")
		
		;
	}

	

	@Override
	public void deleteBookById(int id) {
		this.bookRepository.deleteById(id);
	
		
	}

}
