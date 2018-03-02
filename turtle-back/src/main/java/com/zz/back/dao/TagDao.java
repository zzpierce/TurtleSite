package com.zz.back.dao;

import com.zz.back.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 标签数据类
 * @author zhanzong
 */
public interface TagDao extends JpaRepository<Tag, Long> {

}
