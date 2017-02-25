package com.irelint.demo.controller;

import com.irelint.demo.base.AjaxResponse;
import com.irelint.demo.dto.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuishiying on 2017/2/24.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    /**
     * 返回数据到模板页面
     *
     * @return
     */
    @RequestMapping(path = "/pager", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("name", "test");
        return model;
    }

    /**
     * 接口形式，返回json
     *
     * @return
     */
    @RequestMapping(path = "/json", method = RequestMethod.GET)
    public Object testJson() {
        User user = new User();
        user.setName("test");
        user.setSex("man");
        return user;
    }

    /**
     * 从客户端提交参数
     */
    @RequestMapping(value = "uploadParams", method = RequestMethod.GET)
    public Object uploadParams(String name,String sex) {
        User userInfo = new User();
        userInfo.setName(name);
        userInfo.setSex(sex);
        return AjaxResponse.success();
    }
    /**
     * 从客户端提交参数,rest风格
     */
    @RequestMapping(value = "uploadParams/{name}", method = RequestMethod.GET)
    public Object restParams(@PathVariable String name) {
        User userInfo = new User();
        userInfo.setName(name);
        userInfo.setSex("femail");
        return AjaxResponse.success();
    }

    /**
     * 从客户端提交json
     */
    @RequestMapping(value = "uploadJson",method = RequestMethod.POST)
    public Object uploadJson(@RequestBody User userInfo){
        System.out.print(userInfo.toString());
        return AjaxResponse.success();
    }
    /**
     * 从客户端提交序列化对象
     */
    @RequestMapping(value = "uploadObj",method = RequestMethod.POST)
    public Object uploadObj(User user){
        System.out.print(user.getName());
        return AjaxResponse.success();
    }
}
