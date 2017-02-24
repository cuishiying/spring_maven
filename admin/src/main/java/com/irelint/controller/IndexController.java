package com.irelint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cuishiying on 2017/2/24.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public Object index(){
        return "ok";
    }
}
