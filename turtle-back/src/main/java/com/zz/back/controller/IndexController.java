package com.zz.back.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        System.out.println("into index method");
        return "forward://index.html";
    }
}
