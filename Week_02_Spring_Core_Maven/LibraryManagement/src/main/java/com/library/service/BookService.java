package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method used by Spring IoC container for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void processLibraryCatalog() {
        System.out.println("[SERVICE LAYER]: Processing application core library business workflow indices...");
        bookRepository.executeDataQuery();
    }
}