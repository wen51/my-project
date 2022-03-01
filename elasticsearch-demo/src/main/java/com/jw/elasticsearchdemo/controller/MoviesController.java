package com.jw.elasticsearchdemo.controller;

import com.jw.elasticsearchdemo.Entity.Movies;
import com.jw.elasticsearchdemo.repository.MoviesRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lijw
 * @date 2021/12/28 11:15
 */
@RestController
@RequestMapping("movies")
public class MoviesController {

    private MoviesRespository moviesRespository;

    public MoviesController(MoviesRespository moviesRespository) {
        this.moviesRespository = moviesRespository;
    }

    @GetMapping("/movies")
    public List<Movies> getPageData(@RequestParam String title,
                                    @RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size
                                    ) {
        Pageable pageData = PageRequest.of(page, size);
        Page<Movies> moviesPage = moviesRespository.findByTitle(title, pageData);
        return moviesPage.getContent();
    }
}
