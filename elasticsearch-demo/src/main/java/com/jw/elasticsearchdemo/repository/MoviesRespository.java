package com.jw.elasticsearchdemo.repository;

import com.jw.elasticsearchdemo.Entity.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author lijw
 * @date 2021/12/28 11:11
 */
public interface MoviesRespository extends ElasticsearchRepository<Movies, String> {

    Page<Movies> findByTitle(String title, Pageable pageable);
}
