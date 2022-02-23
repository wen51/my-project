package com.jw.elasticsearchdemo.controller;

import com.jw.elasticsearchdemo.Entity.JiaWen;
import com.jw.elasticsearchdemo.repository.JiaWenRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author lijw
 * @date 2021/12/28 11:15
 */
@RestController
@RequestMapping("jiawen")
public class JiaWenController {

    private JiaWenRepository jiaWenRespository;

    public JiaWenController(JiaWenRepository jiaWenRespository) {
        this.jiaWenRespository = jiaWenRespository;
    }

    @GetMapping
    public List<JiaWen> getPageData(@RequestParam String enname,
                                    @RequestParam(defaultValue = "0") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size
                                    ) {
        Pageable pageData = PageRequest.of(page, size);
        Page<JiaWen> moviesPage = jiaWenRespository.findByEnname(enname, pageData);
        return moviesPage.getContent();
    }

    @GetMapping("/list")
    public List<JiaWen> getPageData(@RequestParam String name) {
        List<JiaWen> jiawens = jiaWenRespository.findByName(name);
        return jiawens;
    }

    @GetMapping("/by-id")
    public JiaWen getById(@RequestParam String id) {
        Optional<JiaWen> moviesPage = jiaWenRespository.findById(id);
        return moviesPage.get();
    }

    @GetMapping("/by-ages")
    public List<JiaWen> getByAgeIn(@RequestParam List<Long> ages) {
        return jiaWenRespository.findByAgeIn(ages);
    }

    @GetMapping("/by-names")
    public List<JiaWen> getByNameIn(@RequestParam List<String> names) {
        return jiaWenRespository.findByNameIn(names);
    }

    @GetMapping("/by-query")
    public List<JiaWen> getByNameIn(@RequestParam String name, Long minAge, Long maxAge) {
        return jiaWenRespository.queryJiawen(name, minAge, maxAge);
    }
}
