<a name="readme-top"></a>

# BookStore
### ximple challenge
## Table of Contents
<details open>
   <ol>
      <li><a href="#prerequisites">Prerequisites</a></li>
      <li><a href="#getting-started">Getting Started</a></li>
      <li><a href="#built-with">Built With</a></li>
      <li><a href="#running-the-tests-and-coverage">Running the Tests and Coverage</a></li>
   </ol>
</details>

## Prerequisites

* Install Java 21
* Install Docker Compose

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

1. Clone the repo
   ```sh
   git clone git@github.com:drupalio/BookStoreChallenge.git
   ```
2. Import the project in your IDE
3. Sync Gradle dependencies
4. Setup dev environment
    ```sh
    docker-compose -f docker-compose.yml up
    ```
5. Teardown dev environment
    ```sh
    docker-compose -f docker-compose.yml down
    ```

## Outbox pattern implementation
* Access to main page dashboard and send a petition to the API to list user loans.
* List all loans and review which are without returning and give the option to return.
* Offer the possibility to send a review if you've already returned a book.
* Print a button to list a specific book or all books and take it as a loan.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Built With

* [Java 21][java-url] - Runtime and programming language.
* [Maven 3.9.6 ][maven-url] - Main build tool management.
* [Docker][docker-url] - Containerize applications for consistency.
* [H2DB][h2db-url] - In memory database dbms writed on java
* [Redis ][redis-url] - Cache Manager tool
* [Spring Boot][spring-boot-url] - Production-grade Spring based Applications that you can "just run".

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Running the Tests and Coverage

* [JUnit 5][junit5-url]


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[java-url]: https://openjdk.org/projects/jdk/17/
[maven-url]: https://maven.apache.org/
[docker-url]: https://www.docker.com/
[h2db-url]: https://www.h2database.com/
[redis-url]: https://redis.io/
[spring-boot-url]: https://spring.io/projects/spring-boot
[junit5-url]: https://junit.org/junit5/
[jacoco-url]: https://www.jacoco.org/jacoco/
