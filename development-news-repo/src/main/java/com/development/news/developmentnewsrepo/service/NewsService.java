package com.development.news.developmentnewsrepo.service;

import com.development.news.developmentnewsrepo.domain.News;
import com.development.news.developmentnewsrepo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> list(){
        return newsRepository.findAll();
    }

    @Transactional
    public List<News> insert(List<News> news){
        news = newsRepository.saveAll(news);
        return news;
    }

}
