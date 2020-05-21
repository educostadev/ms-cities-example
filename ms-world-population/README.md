# api-ms-world-population

This is a _"toy"_ application to play with microservices.

Its load a CSV File in memory with information cities and **population** and provide a rest endpoint to read the number of people by city.

## End points provided

`GET` localhost:8089/population/city/1076532519

## Technologies used

- JDK 14
- Spring boot 2.3.0.RC1
- CSV File Reading with Apache commons-csv and Apache commons-io
