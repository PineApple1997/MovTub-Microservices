package com.mufu.moviecatalogservice.resources;

import com.mufu.moviecatalogservice.models.CatalogItem;
import com.mufu.moviecatalogservice.models.Movie;
import com.mufu.moviecatalogservice.models.HomePageVideos;
import com.mufu.moviecatalogservice.models.Rating;
import com.mufu.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            // for each movie ID, call movie info service and get details
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            // put them all together
            return new CatalogItem(movie.getName(), "test movie desc", rating.getRating());
        })
        .collect(Collectors.toList());
    }

    @RequestMapping("/homepage")
    public List<HomePageVideos> getHomePageVideos(@RequestParam Map<String, Object> params) {
        List<String> predictedMovies = restTemplate.getForObject("http://ratings-data-service/ratingsdata/prediction/?userId={userId}&epoch={epoch}", List.class, params);
        Map<String, List> map = new HashMap<>();
        map.put("predictedMovies", predictedMovies);
        List<HomePageVideos> res = restTemplate.getForObject("http://movie-info-service/movies/homepage/?predictedMovies={predictedMovies}", List.class, map);
//        for(String movieId : predictedMovies) {
//            HomePageVideos movie = restTemplate.getForObject("http://movie-info-service/movies/" + movieId, HomePageVideos.class);
//            res.add(movie);
////            System.out.println("yes!!! " + movie.getTitle());
//        }
        return res;
    }

}
