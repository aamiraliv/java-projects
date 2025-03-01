package com.libarary.books.service;

import com.libarary.books.models.Books;
import com.libarary.books.repository.BooksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class BookService {
    @Autowired
    private BooksRepository repository;
    
    public List<Books> getAllBooks() {
        return repository.findAll();
    }

    public Books createBook(Books books) {
        return repository.save(books);
    }

    public Books getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    public Books updateBookById(Long id , Books books) {
        Books book = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Book not found with id : "+ id));
        book.setAuthor(books.getAuthor());
        book.setGenre(books.getGenre());
        book.setTitle(books.getTitle());
        book.setPrice(books.getPrice());
        return repository.save(book);
    }

    public List<Books> searchBy(String title, String author, String genre) {
        if (title != null) return repository.findByTitleContainingIgnoreCase(title);
        if (author != null) return repository.findByAuthorContainingIgnoreCase(author);
        if (genre != null) return repository.findByGenreContainingIgnoreCase(genre);
        return Collections.emptyList();
    }
}
