# AWS Lambda Function + Spring Boot + SQLite

## Description

This repository is a reference implementation for a Spring Boot AWS Lambda Function using SQLite.

## Endpoints

Create
```shell
curl -X POST http://localhost:8080/book \
     -H "Content-Type: application/json" \
     -d '{
           "title": "The Great Gatsby"
         }' | jq
```
```shell
curl http://localhost:8080/book | jq
```
```shell
curl http://localhost:8080/book/1 | jq
```
```shell
curl -X PUT http://localhost:8080/book/1 \
     -H "Content-Type: application/json" \
     -d '{
           "title": "The Great Gatsby - Updated"
         }' | jq

```
```shell
curl -X DELETE http://localhost:8080/book/1 | jq
```

## References

- https://github.com/aws-samples/serverless-java-frameworks-samples
- https://github.com/aws-samples/serverless-graalvm-demo