<!-- Badges -->
[capgemini-badge]: https://img.shields.io/static/v1?label=Capgemini&message=Capgemini&color=blue
[java-badge]: https://img.shields.io/static/v1?label=Java&message=11&color=blue
[kotlin-badge]: https://img.shields.io/static/v1?label=Kotlin&message=1.5&color=blue
[spring-boot-badge]:  https://img.shields.io/static/v1?label=Spring%20Boot&message=2.5&color=blue

<!-- Images -->

<!-- Links -->
[capgemini-url]: https://www.capgemini.com/br-pt/
[java-url]: https://www.oracle.com/java/
[kotlin-url]: https://kotlinlang.org/
[spring-url]: https://spring.io/


<!-- Content -->
# Capgemini | Restaurant Order System

[![Capgemini][capgemini-badge]][capgemini-url]
[![Java][java-badge]][java-url]
[![Kotlin][kotlin-badge]][kotlin-url]
[![Spring][spring-boot-badge]][spring-url]


# Topics

- [Topics](#topics)
- [Objective](#objective)
- [Running the application](#running-the-application)

# Objective

The objective is to publish events to a queueing system in order to register all the new customers' orders.
For achieving this objective the following technologies will be used:

- Java
- Spring Boot
- Microservices
- Unit tests
- Rest APIs
- Among others

[Go to topics](#topics)

# Running the application

For running the application, it's necessary to type in in the terminal the following command:

```shell
docker-compose up
```

After that, type in another terminal the following command:

```shell
mvn spring-boot:run
```

The application will run on port 8080.

To run the observability, type in:

```shell
docker-compose -f ./observability/docker-compose.yml up
```

This observability will run in ports 9090 and 3000.

