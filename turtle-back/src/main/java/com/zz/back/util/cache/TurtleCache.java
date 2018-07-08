package com.zz.back.util.cache;

import com.zz.back.model.TagEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缓存
 * @author zhanzong
 */
public class TurtleCache {

    /***存储tag信息***/
    public static Map<String, Long> tagMap = new HashMap<>();

    public static boolean refresh(List<TagEntity> tagList) {
        if (TurtleCache.tagMap == null) {
            TurtleCache.tagMap = new HashMap<>();
        }
        for (TagEntity tag : tagList) {
            TurtleCache.tagMap.put(tag.getName(), tag.getId());
        }
        return true;
    }

    public static void save(String name, Long id) {
        tagMap.put(name, id);
    }
}
