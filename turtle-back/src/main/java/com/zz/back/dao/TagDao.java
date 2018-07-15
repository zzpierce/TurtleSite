package com.zz.back.dao;

import com.zz.back.model.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 标签数据类
 * @author zhanzong
 */
public interface TagDao extends JpaRepository<TagEntity, Long> {

    List<TagEntity> findByName(String name);

    @Query("select t from TagEntity t where (select count(id) from TagArticleEntity ta where t.id = ta.tag) = 0")
    List<TagEntity> findEmptyTag();
}
