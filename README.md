# AWS Lambda Function + Spring Boot + SQLite

## Description

This repository is a reference implementation for a Spring Boot AWS Lambda Function using SQLite.

## Setup

Create a new SQLite database: `./data/db.sqlite`

## Endpoints

Create:
```shell
curl -X POST http://localhost:8080/book \
     -H "Content-Type: application/json" \
     -d '{
           "title": "The Great Gatsby"
         }' | jq
```

List all:
```shell
curl http://localhost:8080/book | jq
```

Find by id:
```shell
curl http://localhost:8080/book/1 | jq
```

Update:
```shell
curl -X PUT http://localhost:8080/book/1 \
     -H "Content-Type: application/json" \
     -d '{
           "title": "The Great Gatsby - Updated"
         }' | jq

```

Delete:
```shell
curl -X DELETE http://localhost:8080/book/1 | jq
```

## References

- https://github.com/aws-samples/serverless-java-frameworks-samples
- https://github.com/aws-samples/serverless-graalvm-demo

## FAQ

### 1) What

Skill issue.