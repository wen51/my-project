package com.jw.elasticsearchdemo.repository;

import com.jw.elasticsearchdemo.Entity.JiaWen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author lijw
 * @date 2021/12/28 14:42
 */
public interface JiaWenRepository extends ElasticsearchRepository<JiaWen, String> {

//    @Query("{\"query\":{\"bool\":{\"must\":[{\"query_string\":{\"query\":\"*?*\", \"fields\":[\"enname\"]}}]}}}")
    Page<JiaWen> findByEnname(String enname, Pageable pageable);

    List<JiaWen> findByName(String name);

    List<JiaWen> findByAgeIn(List<Long> ages);

    List<JiaWen> findByNameIn(List<String> nameList);

    @Query("{\n" +

            "    \"bool\": {\n" +
            "      \"must\": [\n" +
            "        {\n" +
            "          \"match\": {\n" +
            "            \"name\": \"?0\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"range\": {\n" +
            "            \"age\": {\n" +
            "              \"gte\": ?1,\n" +
            "              \"lte\": ?2\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +

            "}")
    List<JiaWen> queryJiawen(String name, Long minAge, Long maxAge);

}
