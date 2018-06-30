package com.zz.back.dao;

import com.zz.back.model.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * 文章的数据库操作类
 */
public interface ArticleDao extends PagingAndSortingRepository<ArticleEntity, Long> {

    /**
     * 根据文章标题获取文章
     * @param title 文章标题
     * @return 文章列表
     */
    List<ArticleEntity> findByTitle(String title);

    /**
     * 根据时间逆序获取所有文章
     * @return 文章列表
     */
    List<ArticleEntity> findByTitleNotNullOrderByIdDesc();

    /**
     * 分页查询
     * @param pageable 分页
     * @return 内容
     */
    @Override
    Page<ArticleEntity> findAll(Pageable pageable);

}
