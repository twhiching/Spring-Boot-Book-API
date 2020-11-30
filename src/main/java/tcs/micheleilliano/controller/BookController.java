package tcs.micheleilliano.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tcs.micheleilliano.book.Book;
import tcs.micheleilliano.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/books")
	public List<Book> getBooks(){
		return bookService.getBooks();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/books/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		return bookService.getBook(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public void addBook(@RequestBody Book book){
		bookService.addBook(book);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
	public void updateBook(@RequestBody Book book, @PathVariable int id){
		bookService.updateBook(book);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
	public void updateBook(@PathVariable int id){
		bookService.deleteBook(id);
	}
	
}
