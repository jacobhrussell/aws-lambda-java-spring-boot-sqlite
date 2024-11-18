package com.example.aws_lambda_java_spring_boot_sqlite.services;

import com.example.aws_lambda_java_spring_boot_sqlite.models.api.Book;
import com.example.aws_lambda_java_spring_boot_sqlite.models.entity.BookEntity;
import com.example.aws_lambda_java_spring_boot_sqlite.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Page<Book> listBooks(int page, int size, String sortBy) {
        Page<BookEntity> bookEntities = bookRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
        return bookEntities.map(Book::of);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id).map(Book::of);
    }

    public Book createBook(Book book) {
        BookEntity bookToSave = BookEntity.of(book);
        BookEntity savedBook = bookRepository.save(bookToSave);
        return Book.of(savedBook);
    }

    public Optional<Book> updateBook(Long id, Book book) {
        return bookRepository.findById(id).map(existing -> {
            existing.setTitle(book.getTitle());
            return Book.of(bookRepository.save(existing));
        });
    }

    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
