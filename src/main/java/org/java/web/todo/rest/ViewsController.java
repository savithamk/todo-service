package org.java.web.todo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewsController {

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String login(){
        return "login.html";
    }

    @RequestMapping(value = {"/home"},method = RequestMethod.GET)
    public String home(){
        return "index.html";
    }
}
