package com.zz;

import com.zz.back.dao.ArticleDao;
import com.zz.back.dao.TagArticleDao;
import com.zz.back.dao.TagDao;
import com.zz.back.model.ArticleEntity;
import com.zz.back.model.TagArticleEntity;
import com.zz.back.model.TagEntity;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.util.List;

/**
 * @author pierce
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class TagTest {

    @Resource
    private ArticleDao articleDao;

    @Resource
    private TagDao tagDao;

    @Resource
    private TagArticleDao tagArticleDao;

    @Test
    public void test1() {

//        Iterable<ArticleEntity> articleEntity = articleDao.findAll();
//        for (ArticleEntity entity : articleEntity) {
//            String tags = entity.getTags();
//            if (StringUtils.isNotBlank(tags)) {
//                String[] tagArray = tags.split(",");
//                for (String tag: tagArray) {
//                    List<TagEntity> tagEntityList = tagDao.findByName(tag);
//                    Long tagId = 0L;
//                    if (tagEntityList.size() == 0) {
//                        TagEntity saveTagEntity = new TagEntity();
//                        saveTagEntity.setName(tag);
//                        saveTagEntity = tagDao.save(saveTagEntity);
//                        tagId = saveTagEntity.getId();
//                    } else {
//                        tagId = tagEntityList.get(0).getId();
//                    }
//                    TagArticleEntity saveTagArticleEntity = new TagArticleEntity();
//                    saveTagArticleEntity.setArticle(entity);
//                    saveTagArticleEntity.setTagId(tagId);
//                    tagArticleDao.save(saveTagArticleEntity);
//                }
//            }
//        }
    }


}
