# AWS Lambda Function + Spring Boot + DSQL

## Description

This repository is a reference implementation for a Spring Boot AWS Lambda Function using Aurora DSQL.

## Running

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

## Connecting to the DB

Use your preferred RDBMS tool to connect via the cluster endpoint. You can use the AWS Console to create a short-lived
token to use as a password.

Schema visualization does not work, so you will need to query system tables in order to see database information:
- see all schemas: `select * from pg_namespace;`
- see all tables: `select * from pg_tables where schemaname = 'public';`

## References

- https://github.com/aws/serverless-java-container/blob/main/samples/springboot3/pet-store-native/README.md
- https://github.com/aws-samples/serverless-java-frameworks-samples
- https://github.com/aws-samples/serverless-graalvm-demo
- https://github.com/aws-samples/aws-lambda-efs-samples/blob/master/README.md
- https://docs.aws.amazon.com/aurora-dsql/latest/userguide/SECTION_program-with-java-apps.html
- https://docs.aws.amazon.com/aurora-dsql/latest/userguide/accessing-sql-clients.html#accessing-sql-clients-datagrip
- https://docs.aws.amazon.com/aurora-dsql/latest/userguide/working-with-systems-tables.html

## FAQs

Q: Why isn't the Aurora DSQL cluster defined in the `template.yaml`?
A: Aurora DSQL [doesn't support CloudFormation during preview](https://docs.aws.amazon.com/aurora-dsql/latest/userguide/accessing-programmatic.html).