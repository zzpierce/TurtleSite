package com.zz.back.controller;

import com.zz.back.model.Article;
import com.zz.back.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getById")
    @ResponseBody
    public Article getById(Long id) {

        Article article;
        try {
            article = articleService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return article;

    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Article> getAll() {
        List<Article> articles;
        try {
            articles = articleService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return articles;
    }

    @RequestMapping("/save")
    public boolean save(@RequestParam(value="article") Article article) {
        try {
            articleService.save(article);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestParam(value="id") Long id) {
        try {
            articleService.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
