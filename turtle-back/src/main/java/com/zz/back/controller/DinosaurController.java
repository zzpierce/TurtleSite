package com.zz.back.controller;

import com.zz.back.service.IDinosaurService;
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

    @RequestMapping(value = "/getDinosaur", method = RequestMethod.GET)
    @ResponseBody
    public boolean getDinosaur() {
        try {
            dinosaurService.getPic();
        } catch (IOException e) {
            log.error("error", e);
        }
        return true;
    }

}
