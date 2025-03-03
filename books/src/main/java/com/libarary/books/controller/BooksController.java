package com.libarary.books.controller;

import com.libarary.books.models.Books;
import com.libarary.books.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api")
public class BooksController {

    @Value("${app.author.name}")
    private String authorName;

    @Autowired
    private BookService service;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return service.getAllBooks();
    }

    @PostMapping("/books")
    public ResponseEntity<Books> createBook(@RequestBody @Valid Books books){
        Books createdBook = service.createBook(books);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/books/{Id}")
    public Books getBookById(@PathVariable Long Id){
        return service.getBookById(Id);
    }



    @DeleteMapping("/books/{Id}")
    public void deleteBookById (@PathVariable Long Id){
        service.deleteBookById(Id);
    }

    @PutMapping("/books/{Id}")
    public ResponseEntity<Books> updateBookById(@PathVariable Long Id ,@RequestBody Books bookDetails ){
        Books updated =  service.updateBookById(Id ,bookDetails);
        return ResponseEntity.ok(updated);
    }
    @GetMapping("/books/search")
    public List<Books> searchBy(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre)
    {
        return service.searchBy(title,author,genre);
    }
    @GetMapping("books/sort")
    public Page<Books> sortBy(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "title") String sortBy
    ){
        return service.sortBy(page,size,sortBy);
    }
    @GetMapping("/about/author")
    public ResponseEntity<?> aboutAuthor(){
        return ResponseEntity.ok(Map.of("name",authorName));
    }
}