package com.example.aws_lambda_java_spring_boot_sqlite.models.api;

import com.example.aws_lambda_java_spring_boot_sqlite.models.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    private String title;

    public static Book of(BookEntity bookEntity) {
        return Book.builder()
                .title(bookEntity.getTitle())
                .id(bookEntity.getId())
                .build();
    }

}
