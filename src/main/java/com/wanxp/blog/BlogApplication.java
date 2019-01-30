package com.wanxp.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("welcome", "HelloWorld! This is a Blog.");
        return "index";
    }
    @RequestMapping("/footer")
    public String footer(Model model) {
        model.addAttribute("welcome", "HelloWorld! This is a Blog.");
        return "/layout/footer";
    }

}

