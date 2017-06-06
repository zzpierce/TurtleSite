package com.zz.back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zz.back.model.Article;
import com.zz.back.service.ArticleService;
import com.zz.back.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        try {
            return articleService.findByTags(tags);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
    @ResponseBody
    public String save(@RequestBody String body) {
        try {
            JSONObject bodyJson = JSON.parseObject(body);
            articleService.save(bodyJson.getString("content"), bodyJson.getString("verifyCode"));
            return Constants.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.FAIL;
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
