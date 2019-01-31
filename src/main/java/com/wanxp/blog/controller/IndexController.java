package com.wanxp.blog.controller;

import com.wanxp.blog.service.ContentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController{

    @Autowired
    private ContentServiceI contentService;

    @RequestMapping(value = "/")
    public ModelAndView index(Model model) throws IOException {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "updatetime");
        Page contentPage = contentService.queryInPage(pageRequest);
        model.addAttribute("contentList", contentPage.getContent());
        model.addAttribute("logined", true);
        model.addAttribute("title", "sYsBlog");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
