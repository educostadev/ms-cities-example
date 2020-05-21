# ap-ms-cities

This is a _"toy"_ application to play with microservices.

Its load a CSV File with information of cities of the word and record into a database, providing a endpoint to retrieve information of the cities. 

## End points provided

`GET` http://localhost:8087/v1/cities?country=BR 

`GET` http://localhost:8087/v1/city/1076532519

## Technologies

- JDK 11 
- Spring boot 2.2.6.RELEASE 
- PMD for source code analyser
- Lombok 
- TestContainer
- JUnit5
- Swagger2
- JPA
- Apache commons-csv and Apache commons-io for CSV File Reading 


## How to create the database


To create the database you can use file `Dockerfile.postgres`. 

First run the following command, and the docker will download the postgres image.

``
docker build -t mscitiesdb/postgres -f Dockerfile.postgres .
``

Start the container from the image. Run the command bellow. To see the logs during the database initialization you can remove the `-d` parameter.

``
docker run -d -p 5100:5432 --name mscitiesdb-postgres mscitiesdb/postgres
``

A database will be started with the following configuration:

- DB_URL=jdbc:postgresql://localhost:5100/mscitiesdb?currentSchema=<NAME_OF_THE_MICROSERVICE>
- DB_USERNAME=dbuser
- DB_PASSWORD=dbpass

You can stop the database with the following command:

``
docker stop mscitiesdb-postgres
``

You can delete the container and image with the following commands:

``
docker container rm mscitiesdb-postgres
docker image rm mscitiesdb/postgres:latest
``

### Database connection

For create the database use the Dockerfile.postgres.

- DB_URL=jdbc:postgresql://localhost:5100/mscitiesdb?currentSchema=mscities
- DB_USERNAME=dbuser
- DB_PASSWORD=dbpass



