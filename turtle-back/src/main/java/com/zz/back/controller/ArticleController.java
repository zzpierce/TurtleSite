package com.zz.back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zz.back.model.Article;
import com.zz.back.service.ArticleService;
import com.zz.back.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getById")
    @ResponseBody
    public Article getById(Long id) {

        logger.info("加载ID = " + id);
        Article article;
        try {
            article = articleService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        logger.info("加载结束: " + article);
        return article;

    }

    @RequestMapping("findByTitle")
    @ResponseBody
    public List<Article> findByTitle(String title) {

        try {
            return articleService.findByTitle("傲骨贤妻");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("findByTags")
    @ResponseBody
    public List<Article> findByTags(String tags) {

        logger.info("按标签查找: tags = " + tags);
        List<Article> articles;
        try {
            articles = articleService.findByTags(tags);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        logger.info("找到博客的数量 = " + articles.size());
        return articles;

    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Article> getAll() {

        logger.info("开始加载BLOG列表");
        List<Article> articles;
        try {
            articles = articleService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        logger.info("加载BLOG数量：" + articles.size());
        return articles;

    }

    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody String body) {

        logger.info("新建博客: " + body);
        try {
            JSONObject bodyJson = JSON.parseObject(body);
            articleService.save(bodyJson);
            logger.info("新建博客成功");
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.FAIL + " " + e.getMessage();
        }

    }

    @RequestMapping("/delete")
    public boolean delete(@RequestParam(value = "id") Long id) {
        try {
            articleService.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
