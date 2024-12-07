# AWS Lambda Function + Spring Boot + SQLite

## Description

This repository is a reference implementation for a Spring Boot AWS Lambda Function using SQLite.

## Running

### SQLite

Create a local SQLite database:

```shell
data/db.sqlite
```

Run/debug locally with IntelliJ or your IDE of choice.

### Postgres

Create a local Postgres database:

```shell
docker-compose up -d
```

Run/debug locally with IntelliJ or your IDE of choice.

## Deploying

Create a Docker image to create the executable with:

```shell
docker build --platform linux/amd64 -t al2023-graalvm21:native-web . --no-cache
```

Create the executable:

```shell
docker run --platform linux/amd64 -it -v `pwd`:`pwd` -w `pwd` -v ~/.m2:/root/.m2 al2023-graalvm21:native-web ./mvnw clean -Pnative package -DskipTests
```

Set your AWS credentials via the AWS CLI:

```shell
aws configure --profile your-profile
```

Deploy via SAM CLI:

```shell
sam deploy --guided --profile your-profile --parameter-overrides VpcId=vpc-abc123 SubnetIds="subnet-abc123,subnet-def456,subnet-ghi789" SecurityGroupId=sg-abc123
```

Subsequent deploys can be done with just: `sam deploy`.

## Destroying

You can destroy the infrastructure with:

```shell
sam delete
```

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

- https://github.com/aws/serverless-java-container/blob/main/samples/springboot3/pet-store-native/README.md
- https://github.com/aws-samples/serverless-java-frameworks-samples
- https://github.com/aws-samples/serverless-graalvm-demo
- https://github.com/aws-samples/aws-lambda-efs-samples/blob/master/README.md

## FAQ

### 1) What

Skill issue.