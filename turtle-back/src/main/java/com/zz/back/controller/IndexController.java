package com.zz.back.controller;

import com.zz.back.util.RandomCodeGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * 获取网站首页
     * @return 首页内容
     */
    @RequestMapping("/")
    public String index() {
        System.out.println("into index method");
        return "forward://index.html";
    }

    /**
     * 生成一个新的验证码
     * @return 验证码
     */
    @RequestMapping("/generateNewValidateCode")
    @ResponseBody
    public String generateCode() {
        return RandomCodeGenerator.generate(20, "VVV");
    }

}
