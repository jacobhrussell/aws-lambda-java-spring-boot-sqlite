package com.example.aws_lambda_java_spring_boot_sqlite.models.api;

import com.example.aws_lambda_java_spring_boot_sqlite.models.entity.BookEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private String title;

    public static Book of(BookEntity bookEntity) {
        return Book.builder().title(bookEntity.getTitle()).build();
    }

}
