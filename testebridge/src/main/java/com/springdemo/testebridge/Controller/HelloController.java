package com.springdemo.testebridge.Controller;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HelloController {
  @RequestMapping(value = "")
  @ResponseBody
  public String index(HttpServletRequest request) {
    String name = request.getParameter("name");
    if (name == null) {
      name = "World";
    }
    return "Hello " + name;
  }

  @RequestMapping(value = "desafio")
  @ResponseBody
  public String helloForm() {
    String html = "<form method='post'>" +
        "<input type ='text' name = 'name' />" +
        "<input type= 'submit' value='Submit'" +
        "</form>";
    return html;
  }


}
