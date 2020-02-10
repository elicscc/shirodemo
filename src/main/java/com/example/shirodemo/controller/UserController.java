package com.example.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("/hello")
    public String hello() {
        return "ok";
    }

    @RequestMapping("/testThy")
    public String test(Model model) {
        model.addAttribute("name", "hei");
        return "test";

    }

    @RequestMapping("/add")
    public String add() {

        return "user/add";

    }

    @RequestMapping("/update")
    public String update() {

        return "user/update";

    }

    @RequestMapping("/toLogin")
    public String toLogin() {

        return "/login";

    }

    @RequestMapping("/noAuth")
    public String noAuth() {

        return "/noAuth";

    }
    /**
     * 登录控制处理
     *
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);

            return "redirect:/testThy";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户不存在");
            return "login";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","安全退出！");
        return "login";
    }
}
