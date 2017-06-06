package com.zz.back.controller;


import com.zz.back.util.RandomCodeGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        System.out.println("into index method");
        return "forward://index.html";
    }

    @RequestMapping("/generateNewValidateCode")
    @ResponseBody
    public String generateCode() {
        return RandomCodeGenerator.generate(20, "VVV");
    }

}
