package com.development.news.developmentnewsrepo.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/v1")
public class NewsResource {

    @GetMapping(value = "/{id}")
    public String welcome(@PathVariable Integer id){
        return "Hello mr" + id;
    }

}
