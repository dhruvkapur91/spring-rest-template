package com.example.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class IsbnRestController {

    private final RestTemplate restTemplate;

    public IsbnRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
    Example request - curl localhost:8080/books/9780099590088
     */
    @GetMapping("/books/{isbn}")
    public String lookupBookByIsbn(@PathVariable("isbn") String isbn) {
        ResponseEntity<String> exchange = restTemplate.exchange("https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn, HttpMethod.GET, null, String.class);
        return exchange.getBody();
    }
}

@SpringBootApplication
public class BootcampApplication {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(BootcampApplication.class, args);
    }
}
