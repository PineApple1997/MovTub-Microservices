package com.mufu.ratingsdataservice.resources;

import com.mufu.ratingsdataservice.models.Rating;
import com.mufu.ratingsdataservice.models.UserRating;
import com.mufu.ratingsdataservice.DAO.PredictionDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }

    @RequestMapping("/prediction")
    public List<String> getPrediction(@RequestParam Map<String, Object> params) {
//        for(Map.Entry<String, Object> entry : params.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
        String userId = params.get("userId").toString();
        int epoch = Integer.parseInt(params.get("epoch").toString());
        // get top 40 predictions from database
        List<String> res = PredictionDao.retrievePredictions(userId, epoch);
        // randomly remove 8 of them
        for(int i = 0; i < 8; i++) {
            int randomNum = (int) Math.random() * res.size();
            res.remove(randomNum);
        }
        Collections.shuffle(res);
        return res;
    }

}
