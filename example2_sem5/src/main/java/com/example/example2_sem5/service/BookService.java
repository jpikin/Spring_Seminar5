package com.example.example2_sem5.service;

import com.example.example2_sem5.model.Book;
import com.example.example2_sem5.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }
    public Book updateBook(Long id, Book bookDetails){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPublicationYear(bookDetails.getPublicationYear());
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found by ID "+ id);
        }
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
