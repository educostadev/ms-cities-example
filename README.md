# How to create the database

This project uses the postgresSQL database. For create the database you can use file `Dockerfile.postgres`. 

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




# ms-cities-example
A group of Microservice Example using Spring Boot and other technologies.
