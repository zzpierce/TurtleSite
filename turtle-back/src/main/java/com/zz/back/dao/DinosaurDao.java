package com.zz.back.dao;

import com.zz.back.model.DinosaurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pierce
 */
public interface DinosaurDao extends JpaRepository<DinosaurEntity, Long> {

    List<DinosaurEntity> findByName(String name);

}
