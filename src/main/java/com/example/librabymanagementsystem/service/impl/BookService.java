package com.example.librabymanagementsystem.service.impl;

import com.example.librabymanagementsystem.Enum.Genre;
import com.example.librabymanagementsystem.Model.Book;
import com.example.librabymanagementsystem.dto.responseDTO.BookResponseDTO;

import java.util.List;

public interface BookService {
    public String addBook(Book book);
    public boolean deleteBook(int id);
    public List<String> booksByGenre(Genre genre);
    public List<String> booksByPages(int from, int to);
    public List<String> authorByGenre(Genre genre);
    public List<BookResponseDTO> booksByGenreAndCost(String genre, double cost);

}
