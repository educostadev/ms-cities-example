# Template for Microservice #

- Spring boot
- Lombok
- TestContainer
- Junit5
- Swagger2


# Local postgres configuration

Create the postgres image from `Dockerfile.postgres`. See the file for database user and password.

``
docker build -t cities/postgres -f Dockerfile.postgres .
``

Create and run the container from the image
``
docker run -d -p 5100:5432 --name cities-postgres cities/postgres
``

Start the container 
``
docker start cities-postgres
``



