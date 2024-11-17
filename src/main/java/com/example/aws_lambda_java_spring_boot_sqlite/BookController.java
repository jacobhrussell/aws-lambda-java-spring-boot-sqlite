package com.example.aws_lambda_java_spring_boot_sqlite;

import com.example.aws_lambda_java_spring_boot_sqlite.models.api.Book;
import com.example.aws_lambda_java_spring_boot_sqlite.models.api.ListBookResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public ResponseEntity<ListBookResponse> listBooks() {
        List<Book> books = new ArrayList<>();
        Book book = Book.builder().title("Title").build();
        books.add(book);

        ListBookResponse response = ListBookResponse.builder().books(books).build();

        return ResponseEntity.ok(response);
    }

}
