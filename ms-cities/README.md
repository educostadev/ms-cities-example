# ap-ms-cities

This is a _"toy"_ application to play with microservices.

Its load a CSV File with information of cities of the word and record into a database, providing a endpoint to retrieve information of the cities. 

## End points provided

`GET` http://localhost:8087/v1/cities?country=BR 
`GET` http://localhost:8087/v1/city/1076532519

## Technologies

- JDK 11
- Spring boot 2.2.6.RELEASE
- Lombok
- TestContainer
- Junit5
- Swagger2
- JPA
- CSV File Reading with Apache commons-csv and Apache commons-io

## Database connection

For create the database use the Dockerfile.postgres.

- DB_URL=jdbc:postgresql://localhost:5100/mscitiesdb?currentSchema=mscities
- DB_USERNAME=dbuser
- DB_PASSWORD=dbpass



