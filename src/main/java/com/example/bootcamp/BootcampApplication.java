package com.example.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class IsbnRestController {
    @GetMapping("/books/{isbn}")
    public String lookupBookByIsbn(@PathVariable("isbn") String isbn) {
        return "Book not found for the " + isbn;
    }
}

@SpringBootApplication
public class BootcampApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcampApplication.class, args);
    }
}



