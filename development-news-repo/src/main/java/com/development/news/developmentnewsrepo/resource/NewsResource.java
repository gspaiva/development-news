package com.development.news.developmentnewsrepo.resource;


import com.development.news.developmentnewsrepo.domain.News;
import com.development.news.developmentnewsrepo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/v1")
public class NewsResource {

    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<News>> list(){
        List<News> news = newsService.list();
        return ResponseEntity.ok().body(news);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<News> insert(@RequestBody News news){
        news = newsService.insert(news);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(news.getId()).toUri();
        return ResponseEntity.created(uri).body(news);
    }



}
