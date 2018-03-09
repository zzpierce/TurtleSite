package com.zz.back.dao;

import com.zz.back.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zhanzong
 */
public interface PageArticleDao extends PagingAndSortingRepository<Article, Long> {

}
