package com.zz.back.util.timer;

import com.zz.back.dao.TagDao;
import com.zz.back.model.TagEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pierce
 */
@Slf4j
@Component
public class BlogTask {

    @Resource
    private TagDao tagDao;

    @Scheduled(cron = "0 30 * * * ?")
    public void delEmptyTag  () {

        log.info("[batch] --- start");
        List<TagEntity> tagEntityList = tagDao.findEmptyTag();
        if (tagEntityList != null) {
            for (TagEntity entity : tagEntityList) {
                log.info("删除空的TAG: " + entity.getName());
                tagDao.delete(entity.getId());
            }
        }
        log.info("[batch] --- end");
    }

}
