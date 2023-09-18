package com.example.librabymanagementsystem.service;

import com.example.librabymanagementsystem.Model.Author;
import com.example.librabymanagementsystem.repository.AuthorRepository;
import com.example.librabymanagementsystem.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceimpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public Author addAuthor(Author author) {
       return authorRepository.save(author);

    }
}
