package com.zz;

import com.zz.back.dao.ArticleDao;
import com.zz.back.dao.DinosaurDao;
import com.zz.back.dao.TagArticleDao;
import com.zz.back.dao.TagDao;
import com.zz.back.model.ArticleEntity;
import com.zz.back.model.TagArticleEntity;
import com.zz.back.model.TagEntity;
import com.zz.back.service.IDinosaurService;
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
public class SpringTest {

    @Resource
    private ArticleDao articleDao;

    @Resource
    private TagDao tagDao;

    @Resource
    private TagArticleDao tagArticleDao;

    @Resource
    private IDinosaurService dinosaurService;

    @Test
    public void test1() {
        dinosaurService.create("yoyo");
    }


}
