# Shopify 2021 Backend Challenge

## ImageNest

### Table Of Contents

- [Problem Statement](#problem-statement)
- [ImageNest Context](#ImageNest-Context)
- [ImageNest Show Case](#ImageNest-Show-case)
- [Getting Started](#Getting-Started)
- [Improvements](#Improvements)

### Problem Statement

I am a consumer looking for a place to save my images. I want to be able to have the ability to
upload and delete images. Extra functionality that will help me utilize my saved images is welcomed!

### ImageNest Context

ImageNest is an image repository that lets you have control over your images. ImageNest currently
allows you to:

- Upload images

        Uploading images is supported by the "uploadImage" API endpoint.


- Delete images

        Deleting images is supported by the "deleteImage" API endpoint.

**Technologies used**

- Java(Spring Boot)

        The main reason I used java is to show my structural and design skills that
        I can easily demostrate in Java.

- Thymeleaf

        I am familiar with front-end frameworks such as React. However, I wanted to pick up something new that I did not use before.
        Thus, i decided to use Thymeleaf which is a server-side java template engine. Thymeleaf is not a framework! I have used HTML,
        CSS, JS with the help of bootstrap aswell.

- SQL

        I have experience with NoSQL(Neo4j) and SQL(mySQL, PostgreSQL) technologies. Since I did not
        have any focus on scalability or speed for this small application I decided to use mySQL
        to demonstrate my relational database skills and to demonstrate my skills of using an ORM
        technology such as hibernate

### ImageNest Show Case

<p align="center"><img src="https://github.com/mohhef/ShopifyBackendChallenge/blob/main/src/main/resources/static/ImageNest.gif" width="80%"></p>

### Getting Started

I have utilized Docker to ease the getting started with the application.

Make sure you have installed:

- Maven (https://maven.apache.org/install.html)
- Docker-compose (https://docs.docker.com/compose/install/)

1. Run 'mvn package' in the root directory of the application, this will create a jar file in a '
   target' folder
2. Run 'docker-compose up' in the root directory of the application, that will create a jdk 11 image
   of the application and it will create a mysql image.
3. Navigate to 'localhost:8080/imagenest', have fun!!

### Improvements
- Investigate other ways to store images
- Add a many-to-many tags relationship to allow users to add tags and search images by specific tags
- Add unit tests, integration tests and possibly system tests
- Refine backend and frontend structure by better handling unexpected exceptions
