package com.example.aws_lambda_java_spring_boot_sqlite.models.entity;

import com.example.aws_lambda_java_spring_boot_sqlite.models.api.Book;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue()
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String title;

    public static BookEntity of(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        return bookEntity;
    }

}
