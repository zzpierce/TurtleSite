package com.zz.back.util.cache;

import com.zz.back.dao.TagDao;
import com.zz.back.model.TagEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * spring启动后进行缓存加载
 * @author zhanzong
 */

@Repository
public class CachePostProcessor implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(CachePostProcessor.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * 加载缓存
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        try {
            if (bean instanceof TagDao) {
                List<TagEntity> tagList = ((TagDao) bean).findAll();
                if (TurtleCache.tagMap == null) {
                    TurtleCache.tagMap = new HashMap<>();
                }
                for (TagEntity tag : tagList) {
                    TurtleCache.tagMap.put(tag.getName(), tag.getId());
                }
            }
        } catch (Exception e) {
            logger.error("加载缓存TAG失败", e);
        }

        return bean;
    }

}
