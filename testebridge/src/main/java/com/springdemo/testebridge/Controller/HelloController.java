package com.springdemo.testebridge.Controller;

import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Date;

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
  public int bridge(HttpServletRequest request) {
    long start = System.currentTimeMillis();
    int numero = Integer.parseInt(request.getParameter("entrada"));
    ArrayList<Integer> listanumero = new ArrayList<Integer>();
    for(int count=1; count <= numero; count++){
      if(numero % count == 0){
        listanumero.add(count);
      }
    }
    int cont = 0;
    ArrayList<Integer> lista2 = new ArrayList<Integer>();
    for (int i = numero - 1; i >= 1 ; i--) {
      ArrayList<Integer> lista1 = new ArrayList<Integer>();
      for (int j = 1; j <= i; j++) {
        if (i % j == 0){
          lista1.add(j);
        }
      }
      if (lista1.size() == lista2.size()){
        cont++;
      }
      lista2 = lista1;
    }
    return cont;
  }
}
