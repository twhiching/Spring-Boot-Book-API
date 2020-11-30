package tcs.micheleilliano.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcs.micheleilliano.book.Book;
import tcs.micheleilliano.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);;
		return books;
	}

	public Optional<Book> getBook(int id) {
		return bookRepository.findById(id);
	}
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

}
