package com.mufu.moviecatalogservice.resources;

import com.mufu.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userID) {

        return Collections.singletonList(
                new CatalogItem("Transformers", "good movie", 4)
        );

    }

}
