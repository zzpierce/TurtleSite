package com.zz.back.controller;

import com.zz.back.util.RandomCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {
    /**
     * 获取网站首页
     * @return 首页内容
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        log.info("index");
        return "forward://index.html";
    }

}
