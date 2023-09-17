package com.example.librabymanagementsystem.repository;

import com.example.librabymanagementsystem.Enum.Genre;
import com.example.librabymanagementsystem.Model.Book;
import com.example.librabymanagementsystem.dto.responseDTO.BookResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findByGenre(Genre genre);

    @Query(value = "select * from book where genre = :genre and cost = :cost", nativeQuery = true)
   List<Book> booksByGenreAndCost(String genre, double cost);
}
