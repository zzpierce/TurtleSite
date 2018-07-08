package com.zz.back.controller;

import com.alibaba.fastjson.JSON;
import com.zz.back.model.request.ArticleSaveRequest;
import com.zz.back.model.vo.ArticleListVo;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;
import com.zz.back.service.impl.ArticleServiceImpl;
import com.zz.back.util.BeanUtil;
import com.zz.back.util.TurtleConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章相关接口类
 */
@Slf4j
@CrossOrigin
@Controller
@RequestMapping("/api/article")
public class ArticleController {
    
    @Resource
    private ArticleServiceImpl articleService;

    /**
     * 按页获取文章列表
     * @param page 页数
     * @param count 一页的数量
     * @return 文章列表
     */
    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
    @ResponseBody
    public BaseVo<ArticleListVo> getPage(int page, int count) {
        log.info("开始加载BLOG列表");
        try {
            ArticleListVo articleListVo = articleService.getPage(page, count);
            return BeanUtil.success(articleListVo, "按页获取文章列表成功");
        } catch (Exception e) {
            log.error("获取文章列表失败", e);
            return BeanUtil.fail("获取文章列表失败");
        }
    }

    /**
     * 通过 id 查找文章
     * @param id 文章 id
     * @param format 文章格式，包括 html 和 md 两种
     * @return 文章
     */
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ResponseBody
    public BaseVo<ArticleVo> getById(Long id, String format) {

        log.info("加载ARTICLE ID = " + id);
        BaseVo<ArticleVo> baseVo = new BaseVo<>();
        try {
            ArticleVo article = articleService.getById(id, format);
            baseVo.setData(article);
        } catch (RuntimeException e) {
            log.error("请求文章失败 ID=" + id, e);
            baseVo.setCode(TurtleConstants.RESULT_FAIL);
            baseVo.setMessage("请求文章失败");
            return baseVo;
        }
        log.info("加载结束: " + JSON.toJSONString(baseVo));
        return baseVo;
    }

    /**
     * 通过 tag 查找文章
     * @param tag 标签
     * @return 文章列表
     */
    @RequestMapping(value = "findByTag", method = RequestMethod.GET)
    @ResponseBody
    public BaseVo<ArticleListVo> findByTag(String tag) {

        log.info("按标签查找: tag = " + tag);
        BaseVo<ArticleListVo> baseVo = new BaseVo<>();
        try {
            ArticleListVo articles = articleService.findByTag(tag);
            baseVo.setData(articles);
        } catch (Exception e) {
            log.error("根据标签查找文章失败", e);
            baseVo.setCode(TurtleConstants.RESULT_FAIL);
            baseVo.setMessage("查找失败");
            return baseVo;
        }
        return baseVo;

    }

    /**
     * 保存文章
     * @param article 文章内容
     * @return 是否成功
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public BaseVo save(@RequestBody ArticleSaveRequest article) {

        log.info("新建博客: " + JSON.toJSONString(article));
        BaseVo vo;
        try {
            vo = articleService.save(article);
            log.info(vo.getMessage());
        } catch (Exception e) {
            log.error("新建文章失败", e);
            return BeanUtil.fail("新建文章失败");
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
            log.error("删除文章失败", e);
            return false;
        }
    }

}



