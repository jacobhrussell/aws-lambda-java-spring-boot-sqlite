package com.example.aws_lambda_java_spring_boot_sqlite.repositories;

import com.example.aws_lambda_java_spring_boot_sqlite.models.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, Long>, CrudRepository<BookEntity, Long> {
}
