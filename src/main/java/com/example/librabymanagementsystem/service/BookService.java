package com.example.librabymanagementsystem.service;

import com.example.librabymanagementsystem.Enum.Genre;
import com.example.librabymanagementsystem.Model.Author;
import com.example.librabymanagementsystem.Model.Book;
import com.example.librabymanagementsystem.dto.responseDTO.BookResponseDTO;
import com.example.librabymanagementsystem.exception.AuthorNotFoundException;
import com.example.librabymanagementsystem.repository.AuthorRepository;
import com.example.librabymanagementsystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepo bookRepo;

    public String addBook(Book book) {

        // Check the given Author Id is Valid or Not.
        Optional<Author> getauthor =  authorRepository.findById(book.getAuthor().getId());
        if(getauthor.isEmpty()){
            throw new AuthorNotFoundException("Invalid Author Id");
        }
        Author author = getauthor.get(); //
        book.setAuthor(author); // Found Author with the given id is setting to Book Object.
        author.getBooks().add(book); // Adding the same book to the corresponding author book list.
        authorRepository.save(author); // This will save both author and book, as the author is parent book save function will be done be cascade.all
        return "Book added Successfully!";
    }

    public boolean deleteBook(int id) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isPresent()) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<String> booksByGenre(Genre genre) {
        List<String> names = new ArrayList<>();
        List<Book> books = bookRepo.findByGenre(genre);
        for (Book b : books){
            names.add(b.getTitle());
        }
        return names;
    }

    public List<String> booksByPages(int from, int to) {
        List<String> names = new ArrayList<>();
        List<Book> books= bookRepo.findAll();
        for(Book b : books){
            if(b.getNoOfPages() >= from && b.getNoOfPages() <= to)
                names.add(b.getTitle());
        }
        return names;
    }

    public List<String> authorByGenre(Genre genre) {
        List<String> names = new ArrayList<>();
        List<Book> books= bookRepo.findByGenre(genre);
        for(Book b : books){
                names.add(b.getAuthor().getName());
        }
        return names;
    }

    public List<BookResponseDTO> booksByGenreAndCost(String genre, double cost) {
        List<Book>  books  =  bookRepo.booksByGenreAndCost(genre, cost);
        List<BookResponseDTO> bookResponseDTO =  new ArrayList<>();
        for (Book b : books){
            BookResponseDTO response = new BookResponseDTO();
            response.setGenre(b.getGenre());
            response.setCost(b.getCost());
            response.setTitle(b.getTitle());
            response.setNoOfPages(b.getNoOfPages());
            response.setAuthor(b.getAuthor().getName());
            bookResponseDTO.add(response);
        }
        return bookResponseDTO;
    }
}
