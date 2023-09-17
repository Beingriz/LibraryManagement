package com.example.librabymanagementsystem.service;

import com.example.librabymanagementsystem.Model.Author;
import com.example.librabymanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public Author addAuthor(Author author) {
       return authorRepository.save(author);

    }
}
