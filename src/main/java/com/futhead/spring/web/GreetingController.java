package com.futhead.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/hello")
    public String hello() throws Exception {
        return "hello";
    }

    @GetMapping("/exception")
    public String createException() throws Exception {
        throw new Exception("发生错误");
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
