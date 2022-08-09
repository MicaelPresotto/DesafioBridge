package com.desafiobridgebackend.desafiobridge_backend.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.NumericNode;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

  @CrossOrigin
  @RequestMapping(value = "desafio")
  @ResponseBody
  public HashMap<String, Object> bridge(HttpServletRequest request, HttpServletResponse response) {
    String entrada = request.getParameter("entrada");
    int numero = 0;
    try{
      numero = Integer.parseInt(entrada);
      if(numero <= 1){
        throw new Exception("Tende ser um numero maior que 1");
      }

    }
    catch(Exception e){
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return null;
    }
    

    long tempoInicial = System.currentTimeMillis();
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
    hash.put("resultado",cont);
    hash.put("tempodeexecucao",System.currentTimeMillis() - tempoInicial);
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
