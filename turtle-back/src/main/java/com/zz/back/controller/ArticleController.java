package com.zz.back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zz.back.model.vo.ArticleListVo;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;
import com.zz.back.service.ArticleService;
import com.zz.back.util.TurtleConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    private ArticleService articleService;

    @RequestMapping("/getById")
    @ResponseBody
    public ArticleVo getById(Long id, String format) {

        logger.info("加载ID = " + id);
        ArticleVo article = new ArticleVo();
        try {
            article = articleService.getById(id, format);
        } catch (RuntimeException e) {
            logger.error("请求文章失败 ID=" + id, e);
            article.setCode(TurtleConstants.RESULT_FAIL);
            article.setMessage("请求文章失败");
            return article;
        }
        logger.info("加载结束: " + JSON.toJSONString(article));
        return article;
    }

    @RequestMapping("findByTag")
    @ResponseBody
    public ArticleListVo findByTag(String tag) {

        logger.info("按标签查找: tag = " + tag);
        ArticleListVo articles = new ArticleListVo();
        try {
            articles = articleService.findByTag(tag);
        } catch (Exception e) {
            logger.error("根据标签查找文章失败", e);
            articles.setCode(TurtleConstants.RESULT_FAIL);
            articles.setMessage("查找失败");
            return articles;
        }
        logger.info("找到博客的数量 = " + articles.getArticles().size());
        return articles;

    }

    @RequestMapping("/getAll")
    @ResponseBody
    public ArticleListVo getAll() {
        logger.info("开始加载BLOG列表");
        ArticleListVo articleListVo = new ArticleListVo();
        try {
            articleListVo = articleService.getAll();
        } catch (Exception e) {
            logger.error("获取文章列表失败", e);
            articleListVo.setCode(TurtleConstants.RESULT_FAIL);
            articleListVo.setMessage("获取文章列表失败");
            return articleListVo;
        }
        logger.info("加载BLOG数量：" + articleListVo.getArticles().size());
        return articleListVo;
    }

    @RequestMapping("/save")
    @ResponseBody
    public BaseVo save(@RequestBody String body) {

        logger.info("新建博客: " + body);
        BaseVo vo = new BaseVo();
        try {
            JSONObject bodyJson = JSON.parseObject(body);
            vo = articleService.save(bodyJson);
            logger.info(vo.getMessage());

        } catch (Exception e) {
            logger.error("新建文章失败", e);
            vo.setCode(TurtleConstants.RESULT_FAIL);
            vo.setMessage("新建文章失败");
            return vo;
        }
        return vo;
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestParam(value = "id") Long id) {
        try {
            articleService.delete(id);
            return true;
        } catch (Exception e) {
            logger.error("删除文章失败", e);
            return false;
        }
    }

}
