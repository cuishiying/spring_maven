package com.irelint.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuishiying on 2017/2/24.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @RequestMapping(path = "/pager",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("name","test");
        return model;
    }
}
