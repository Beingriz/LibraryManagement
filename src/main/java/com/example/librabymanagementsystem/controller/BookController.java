package com.example.librabymanagementsystem.controller;

import com.example.librabymanagementsystem.Enum.Genre;
import com.example.librabymanagementsystem.Model.Book;
import com.example.librabymanagementsystem.exception.AuthorNotFoundException;
import com.example.librabymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody  Book book){
        try {
            return bookService.addBook(book);
        }catch (AuthorNotFoundException e){
           return e.getMessage();
        }
    }
    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam("id") int id){
       if(bookService.deleteBook(id)){
           return "Book Deleted!!";
       }
       return "Invalid Book Id";
    }

    @GetMapping("/list-books")
    public List<String> booksByGenre(@RequestParam("genre") Genre genre){
        return bookService.booksByGenre(genre);
    }

    @GetMapping("books")
    public List<String> booksByGenreAndPrice(@RequestParam("genre") Genre genre, @RequestParam("cost") int cost){
        return bookService.booksByGenreAndPrice(genre,cost);
    }
    @GetMapping("books-bw-pages")
    public List<String> booksByPages(@RequestParam("from") int from, @RequestParam("to") int to){
        return bookService.booksByPages(from,to);
    }
    @GetMapping("auth-by-genre")
    public List<String> authorByGenre(@RequestParam("genre") Genre genre){
        return bookService.authorByGenre(genre);
    }

}
