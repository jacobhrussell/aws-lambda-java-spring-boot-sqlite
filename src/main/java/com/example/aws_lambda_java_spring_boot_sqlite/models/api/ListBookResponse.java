package com.example.aws_lambda_java_spring_boot_sqlite.models.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListBookResponse {

    private List<Book> books;

}
