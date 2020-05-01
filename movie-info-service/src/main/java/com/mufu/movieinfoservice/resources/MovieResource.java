package com.mufu.movieinfoservice.resources;

import com.mufu.movieinfoservice.models.HomePageVideos;
import com.mufu.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mufu.movieinfoservice.DAO.MovieDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/movies")
public class MovieResource {

//    @RequestMapping("/{movieId}")
//    public HomePageVideos getMovieInfo(@PathVariable("movieId") String movieId) {
//        return MovieDao.retrieveMovie(movieId);
//    }

    @RequestMapping("/homepage")
    public List<HomePageVideos> getHomepage(@RequestParam Map<String, Object> params) {
        List<HomePageVideos> res = new ArrayList<>();
        String movies = params.get("predictedMovies").toString();
        movies = movies.substring(1, movies.length() - 1);
        String str[] = movies.split(", ");
        List<String> predictedMovies = Arrays.asList(str);
        return MovieDao.retrieveMovie(predictedMovies);
    }

}
