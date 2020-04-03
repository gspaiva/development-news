package com.development.news.developmentnewsrepo.resource;


import com.development.news.developmentnewsrepo.domain.News;
import com.development.news.developmentnewsrepo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/v1")
public class NewsResource {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> list(){
        List<News> news = newsService.list();
        return ResponseEntity.ok().body(news);
    }

    @PostMapping
    public ResponseEntity<List<News>> insert(@RequestBody List<News> news){
        news = newsService.insert(news);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(news);
    }

}
