package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    @Autowired
    AuthorRepository authorRepository;

    public void createBook(Book book){

        Author author=book.getAuthor();

        //Here we are getting all the list of books written by author
        List<Book> currentListOfBooks=author.getBooksWritten();

        if(currentListOfBooks==null){
            currentListOfBooks=new ArrayList<>();
        }
        //Adding current book into that list
        currentListOfBooks.add(book);
        //Setting/updating BooksList
        author.setBooksWritten(currentListOfBooks);
        //saving
        authorRepository.save(author);
    }

    public List<Book> getBooks(String genre, boolean available, String author){

        List<Book> books = null; //find the elements of the list by yourself
        books=bookRepository2.findBooksByGenreAuthor(genre,author,available);
        return books;
    }
}
