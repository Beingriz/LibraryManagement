package com.example.librabymanagementsystem.controller;

import com.example.librabymanagementsystem.Enum.Genre;
import com.example.librabymanagementsystem.Model.Book;
import com.example.librabymanagementsystem.dto.responseDTO.BookResponseDTO;
import com.example.librabymanagementsystem.exception.AuthorNotFoundException;
import com.example.librabymanagementsystem.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/add")
    public String addBook(@RequestBody  Book book){
        try {
            return bookServiceImpl.addBook(book);
        }catch (AuthorNotFoundException e){
           return e.getMessage();
        }
    }
    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam("id") int id){
       if(bookServiceImpl.deleteBook(id)){
           return "Book Deleted!!";
       }
       return "Invalid Book Id";
    }

    @GetMapping("/list-books")
    public List<String> booksByGenre(@RequestParam("genre") Genre genre){
        return bookServiceImpl.booksByGenre(genre);
    }

    @GetMapping("books-by-genre-and-cost")
    public List<BookResponseDTO> booksByGenreAndCost(@RequestParam("genre") String genre, @RequestParam("cost") double cost){
        return bookServiceImpl.booksByGenreAndCost(genre,cost);
    }
    @GetMapping("books-bw-pages")
    public List<String> booksByPages(@RequestParam("from") int from, @RequestParam("to") int to){
        return bookServiceImpl.booksByPages(from,to);
    }
    @GetMapping("auth-by-genre")
    public List<String> authorByGenre(@RequestParam("genre") Genre genre){
        return bookServiceImpl.authorByGenre(genre);
    }


}
