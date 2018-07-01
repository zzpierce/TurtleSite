package com.zz.back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zz.back.model.request.ArticleSaveRequest;
import com.zz.back.model.vo.ArticleListVo;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;
import com.zz.back.service.impl.ArticleServiceImpl;
import com.zz.back.util.TurtleConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章相关接口类
 */
@CrossOrigin
@Controller
@RequestMapping("/api/article")
public class ArticleController {

    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    private ArticleServiceImpl articleService;

    /**
     * 获取所有文章
     * @return 文章列表
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
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

    /**
     * 按页获取文章列表
     * @param page 页数
     * @param count 一页的数量
     * @return 文章列表
     */
    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
    @ResponseBody
    public ArticleListVo getPage(int page, int count) {
        logger.info("开始加载BLOG列表");
        ArticleListVo articleListVo = new ArticleListVo();
        try {
            articleListVo = articleService.getPage(page, count);
        } catch (Exception e) {
            logger.error("获取文章列表失败", e);
            articleListVo.setCode(TurtleConstants.RESULT_FAIL);
            articleListVo.setMessage("获取文章列表失败");
            return articleListVo;
        }
        logger.info("加载BLOG数量：" + articleListVo.getArticles().size());
        return articleListVo;
    }

    /**
     * 通过 id 查找文章
     * @param id 文章 id
     * @param format 文章格式，包括 html 和 md 两种
     * @return 文章
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
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

    /**
     * 通过 tag 查找文章
     * @param tag 标签
     * @return 文章列表
     */
    @RequestMapping(value = "findByTag", method = RequestMethod.GET)
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

    /**
     * 保存文章
     * @param article 文章内容
     * @return 是否成功
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public BaseVo save(@RequestBody ArticleSaveRequest article) {

        logger.info("新建博客: " + JSON.toJSONString(article));
        BaseVo vo = new BaseVo();
        try {
            vo = articleService.save(article);
            logger.info(vo.getMessage());

        } catch (Exception e) {
            logger.error("新建文章失败", e);
            vo.setCode(TurtleConstants.RESULT_FAIL);
            vo.setMessage("新建文章失败");
            return vo;
        }
        return vo;
    }

    /**
     * 删除文章
     * @param id 文章 id
     * @return 是否成功
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
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



