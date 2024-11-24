package com.example.aws_lambda_java_spring_boot_sqlite;

import com.example.aws_lambda_java_spring_boot_sqlite.hints.SQLiteRuntimeHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(SQLiteRuntimeHints.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
