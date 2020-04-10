# MovTub - A Microservices Application

MovTub's mission is to give every movie a voice and show them to world. 

## Motivation and Goal
Millions of movies have been filmed in this world, but it is hard for us to find one we love. IMDb provides movie rating for us, but it is not customized for each user. Everyone has different preferences. And its web page is boring, most of its pages are words. It fails to attract users' attention.

Meanwhile, YouTube is a great video provider. It has a great recommendation system that can increase user engagement wildly. Most of its pages are pictures and videos which can let user quickly browser them. I used to waste myself lots of time watching YouTube. :sob:

My goal is to build an online movie recommendation system, just like YouTube except our content is movie. Video content will be trailers, and we can have a URL on our page to navigate user to an authorized website to watch movies. Our web page will pay attention to pictures and videos, instead of showing description in words. And there will be a recommendation system to help user find movies they love.

Hopefully, this project can bring old but good movies to light and save people's time on flipping ratings and reviews.

## Development Environment
- IntelliJ IDEA
- VS Code

This application has been built using these technologies:
- Spring Boot
- Spring Cloud
- Eureka
- Spring Data JPA
- MySQL
- Vue.js

This application will use:
- Docker, to create, deploy and run

## Application Architecture
This application is build based on the microservices architecture. There are three microservices now. 

- **Movie Catalog Service** - Request user's movie list and ratings from Ratings Data Service, request movie description from Movie Info Service, receive and reply Clients' requests. 
- **Ratings Data Service** - Stores user ratings and watched movie list. 
- **Movie Info Service** - Request movie description from external API. 

<img src="https://raw.githubusercontent.com/HanMufu/Movie-Ratings-Microservices/master/microservices.png" width="60%" height="60%">

## TODO
- Connect Douban(a famous Chinese movie community) by OAuth2.0, get users' ratings
- Implement frontend with Vue.js, implement video player
- Build a movie recommendation system

