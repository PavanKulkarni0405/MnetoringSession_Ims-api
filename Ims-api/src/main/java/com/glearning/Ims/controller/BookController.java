package com.glearning.Ims.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.Ims.model.Book;
import com.glearning.Ims.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/list")
	public String listBooks(Model model) {
		List<Book> books = this.bookService.findAll();
		model.addAttribute("books", books);
		return "books/list-books";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("books") Book book) {
		this.bookService.save(book);
		return "redirect:books/list";
	}
	
	@DeleteMapping("/delete")
	public String deleteBook(@RequestParam("id") int id) {
		this.bookService.deleteBookById(id);
		return "redirect:books/list";
	}
	
	


}
