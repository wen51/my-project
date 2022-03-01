package com.jw.elasticsearchdemo.Entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author lijw
 * @date 2021/12/28 11:06
 */
@Data
@Document(indexName = "movies", type = "_doc")
public class Movies {

    private String id;
    private String title;
    private String[] genre;
    private long year;

}
