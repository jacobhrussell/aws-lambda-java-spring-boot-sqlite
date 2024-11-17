package com.example.aws_lambda_java_spring_boot_sqlite.controllers;

import com.example.aws_lambda_java_spring_boot_sqlite.models.api.Book;
import com.example.aws_lambda_java_spring_boot_sqlite.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<Page<Book>> listBooks(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(defaultValue = "id") String sortBy) {
        Page<Book> books = bookService.listBooks(page, size, sortBy);
        return ResponseEntity.ok(books);
    }

}
