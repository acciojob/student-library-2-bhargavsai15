package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Card;
import com.driver.models.CardStatus;
import com.driver.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    @Autowired
    AuthorRepository authorRepository1;

    public void create(Author author){
        authorRepository1.save(author);
    }

    public Author  getAuthor(int id){
        Author author=authorRepository1.findById(id).get();
        return author;
    }
}
