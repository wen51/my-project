package com.jw.elasticsearchdemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author lijw
 * @date 2021/12/28 11:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "jiawen", type = "_doc")
public class JiaWen {
    private String id;
    private String name;

    private Long age;
    private String enname;

}
