package com.example.aws_lambda_java_spring_boot_sqlite.models.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private String title;

}
