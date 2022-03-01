package com.jw.elasticsearchdemo.controller;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijw
 * @date 2021/12/29 19:25
 */
@RestController
@RequestMapping("js")
public class JiaWenSuggestController {

    private ElasticsearchTemplate elasticsearchTemplate;

    public JiaWenSuggestController(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @GetMapping("/suggest")
    public List<String> suggest(@RequestParam String mark) {
        List<String> marks = new ArrayList<>();

        CompletionSuggestionBuilder builder = new CompletionSuggestionBuilder("mark");
        builder.prefix(mark).skipDuplicates(true).size(10);

        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion("mark_suggestion", builder);

        SearchRequestBuilder searchRequestBuilder = elasticsearchTemplate.getClient()
                .prepareSearch("jiawen")
                .suggest(suggestBuilder)
                .setFetchSource(false);
        SearchResponse searchResponse = searchRequestBuilder.get();
        Suggest suggest = searchResponse.getSuggest();
        Suggest.Suggestion<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> markSuggestion = suggest.getSuggestion("mark_suggestion");
        List<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> entries = markSuggestion.getEntries();
        entries.forEach(entry -> {
            List<? extends Suggest.Suggestion.Entry.Option> options = entry.getOptions();
            options.forEach(option -> {
                marks.add(option.getText().string());
            });
        });
        return marks;

    }
}
