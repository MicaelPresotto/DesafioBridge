package com.springdemo.testebridge.Controller;

import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;

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
  public HashMap<String, Object> bridge(HttpServletRequest request) {
    long tempoInicial = System.currentTimeMillis();
    //int numero = Integer.parseInt(request.getParameter("entrada"));
    int numero = 100;
    int cont = 0;
    ArrayList<Integer> primeiraLista = new ArrayList<Integer>();
    for (int i = numero - 1; i >= 1 ; i--) {
      ArrayList<Integer> segundaLista = calculadivisores(i);
      if (primeiraLista.size() == segundaLista.size()){
        cont++;
      }
      primeiraLista = segundaLista;
    }
    HashMap<String, Object> hash = new HashMap<String, Object>();
    hash.put("Resultado",cont);
    hash.put("TempoDeExecucao",System.currentTimeMillis() - tempoInicial);
    return hash;
    
  }
  private ArrayList<Integer> calculadivisores(int k){
    ArrayList<Integer> lista = new ArrayList<Integer>();
    for(int count=1; count <= k; count++){
      if(k % count == 0){
        lista.add(count);
      }
  }
  return lista;
  }
}
