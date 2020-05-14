# API For Retrieve Cities

## Database connection

For create the database use the Dockerfile.postgres.

- DB_URL=jdbc:postgresql://localhost:5100/mscitiesdb?currentSchema=mscities
- DB_USERNAME=dbuser
- DB_PASSWORD=dbpass

## End points

`GET` http://localhost:8087/v1/cities?country=BR 
`GET` http://localhost:8087/v1/city/1076532519

## Technologies

- Spring boot
- Lombok
- TestContainer
- Junit5
- Swagger2
- JPA





