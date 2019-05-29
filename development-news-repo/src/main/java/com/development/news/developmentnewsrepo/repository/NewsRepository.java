package com.development.news.developmentnewsrepo.repository;

import com.development.news.developmentnewsrepo.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
}
