package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("--- 🏛 Loading Spring Core Framework Context Engine ---");

        // Bootstrapping the Spring Framework IoC Context by loading the XML definition rules
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("--- 📦 Fetching Managed Beans from Container ---");
        // Retrieve the fully wired bean component from the context
        BookService service = (BookService) context.getBean("bookService");

        System.out.println("--- ⚙ Executing Wire-Injected Methods ---");
        // Invoke the business logic processing sequence
        service.processLibraryCatalog();
    }
}