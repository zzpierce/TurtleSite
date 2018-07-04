package com.zz.back.util;

import com.zz.back.model.ArticleEntity;
import com.zz.back.model.vo.ArticleVo;
import com.zz.back.model.vo.BaseVo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;

/**
 * @author pierce
 */
public class BeanUtil {

    public static ArticleVo toArticle(ArticleEntity articleEntity) {
        ArticleVo vo = new ArticleVo();
        BeanUtils.copyProperties(articleEntity, vo);
        return vo;
    }

    public static <T> BaseVo<T> success(T t, String message) {
        BaseVo<T> baseVo = new BaseVo<>();
        baseVo.setCode(TurtleConstants.RESULT_SUCCESS);
        baseVo.setMessage(message);
        baseVo.setData(t);
        return baseVo;
    }

    public static <T> BaseVo<T> fail(T t, String message) {
        BaseVo<T> baseVo = new BaseVo<>();
        baseVo.setCode(TurtleConstants.RESULT_FAIL);
        baseVo.setMessage(message);
        baseVo.setData(t);
        return baseVo;
    }

    public static <T> BaseVo<T> success(String message) {
        return success(null, message);
    }

    public static <T> BaseVo<T> fail(String message) {
        return fail(null, message);
    }

}
