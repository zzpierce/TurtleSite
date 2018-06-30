package com.zz.back.dao;

import com.zz.back.model.ArticleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zhanzong
 */
public interface PageArticleDao extends PagingAndSortingRepository<ArticleEntity, Long> {

}
