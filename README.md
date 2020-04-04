# Movie Ratings - A Sample Microservices Application

## Introduction

Movie Ratings is an example of how to build and implement a microservices based back-end system. 

This application has been built using these technologies:
- Spring Boot
- Spring Cloud
- Eureka
- Gradle
- RESTful API

## Development Environment
- IntelliJ IDEA

## Application Architecture
This application is build based on the microservices architecture. There are three microservices now. 

- **Movie Catalog Service** - Request user's movie list and ratings from Ratings Data Service, request movie description from Movie Info Service, receive and reply Clients' requests. 
- **Ratings Data Service** - Stores user ratings and watched movie list. 
- **Movie Info Service** - Request movie description from external API. 

<img src="https://raw.githubusercontent.com/HanMufu/Movie-Ratings-Microservices/master/microservices.png" width="60%" height="60%">

