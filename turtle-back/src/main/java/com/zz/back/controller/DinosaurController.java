package com.zz.back.controller;

import com.zz.back.model.DinosaurEntity;
import com.zz.back.model.vo.BaseVo;
import com.zz.back.service.IDinosaurService;
import com.zz.back.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author pierce
 */
@Slf4j
@Controller
@RequestMapping(value = "/api/dinosaur")
public class DinosaurController {

    @Resource
    private IDinosaurService dinosaurService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public BaseVo<DinosaurEntity> create(String name) {
        try {
            DinosaurEntity entity = dinosaurService.create(name);
            return BeanUtil.success(entity);
        } catch (Exception e) {
            String failMessage = "创建小恐龙失败";
            log.error(failMessage, e);
            return BeanUtil.fail(failMessage);
        }
    }

}
