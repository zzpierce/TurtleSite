package com.zz.back.util.cache;

import com.zz.back.dao.TagDao;
import com.zz.back.model.TagEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缓存
 * @author zhanzong
 */
@Repository
public class TurtleCache {

    /***存储tag信息***/
    public static Map<String, Long> tagMap = new HashMap<>();

    @Resource
    private TagDao tagDao;

    public boolean recache() {
        List<TagEntity> tagList = tagDao.findAll();
        if (TurtleCache.tagMap == null) {
            TurtleCache.tagMap = new HashMap<>();
        }
        for (TagEntity tag : tagList) {
            TurtleCache.tagMap.put(tag.getName(), tag.getId());
        }
        return true;
    }
}
