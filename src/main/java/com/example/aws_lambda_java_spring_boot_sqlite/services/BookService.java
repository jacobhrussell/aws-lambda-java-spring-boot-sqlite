package com.example.aws_lambda_java_spring_boot_sqlite.services;

import com.example.aws_lambda_java_spring_boot_sqlite.models.api.Book;
import com.example.aws_lambda_java_spring_boot_sqlite.models.entity.BookEntity;
import com.example.aws_lambda_java_spring_boot_sqlite.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Page<Book> listBooks(int page, int size, String sortBy) {
        Page<BookEntity> bookEntities = bookRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
        return bookEntities.map(Book::of);
    }

}
