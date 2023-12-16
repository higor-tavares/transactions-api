# TransactionsAPI

Restfull API to provide transaction from to users for a bank system.
The purpose from this project is study some concepts like clean code, clean architecture and programing in general

## Requirements
 * Java 17
 * Docker
## Setup

run the command `mvn package` to build the jar file then
run the command `docker build . -t transaction-api` to build the docker image
## Run the project
run `docker run -it -p 8080:8080 transaction-api` to run the project exposing the port 8080

## Usage

to create a new transaction run the flowing snippet

```bash
curl --location 'localhost:8080/transactions' \
--header 'Content-Type: application/json' \
--data '{
    "payer":"Gabriel",
    "payee": "Higor",
    "amount": 10000
}'
```
