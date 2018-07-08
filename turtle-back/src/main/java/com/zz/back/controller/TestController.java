package com.zz.back.controller;

import com.alibaba.fastjson.JSON;
import com.zz.back.dao.TagDao;
import com.zz.back.model.TagEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pierce
 */
@Slf4j
@Controller
@RequestMapping("/api/test")
public class TestController {

    @Resource
    private TagDao tagDao;

    @RequestMapping(value = "getAllTag", method = RequestMethod.GET)
    @ResponseBody
    public List<TagEntity> getAllTag() {
        String name1 = "a";
        List<TagEntity> lista = tagDao.findByName(name1);
        log.info(JSON.toJSONString(lista));

        TagEntity entity = new TagEntity();
        entity.setId(33L);
        entity.setName("yoyoyo");
        tagDao.save(entity);

        String name2 = "b";
        List<TagEntity> listb = tagDao.findByName(name2);
        log.info(JSON.toJSONString(listb));

        return null;
    }
}
