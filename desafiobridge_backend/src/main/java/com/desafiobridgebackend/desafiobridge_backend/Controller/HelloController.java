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
    return "Hello " + name; // apenas um helloworld kkkkkk, a nao ser que voce digite seu nome no ?name=seuNome
  }

  @CrossOrigin
  @RequestMapping(value = "desafio") // aqui seria um endpoint
  @ResponseBody
  public HashMap<String, Object> bridge(HttpServletRequest request, HttpServletResponse response) { // é um hashmap pois preciso retornar 2 valores
    String entrada = request.getParameter("entrada"); //da um request e pega o numero digitado pelo usuario e coloca em uma string
    int numero = 0;
    try{
      numero = Integer.parseInt(entrada); // transforma a string em um inteiro
      if(numero <= 1){
        throw new Exception("Tende ser um numero maior que 1"); // se acaso nao for um numero maior que 1
      }
    }
    catch(Exception e){
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // se acaso o usuario nao digitou um numero e sim uma string ou etc
      return null;
    }
    long tempoInicial = System.currentTimeMillis(); //aqui pega o tempo inicial da execução
    int cont = 0; //contador
    ArrayList<Integer> primeiraLista = new ArrayList<Integer>(); 
    for (int i = numero - 1; i >= 1 ; i--) { //aqui ele pega todo o numero menor que a entrada de forma decrescente
      ArrayList<Integer> segundaLista = calculadivisores(i); //calcula todos os divisores do numero atual e coloca na variavel segundaLista
      if (primeiraLista.size() == segundaLista.size()){ // se a lista da quantidade de divisores do numero atual tiver a mesma quantidade da lista do numero anterior, entao conta 1
        cont++;
      }
      primeiraLista = segundaLista; // essa igualdade vai ser para armazenar a lista de divisores do numero atual
    }
    HashMap<String, Object> hash = new HashMap<String, Object>();
    hash.put("resultado",cont);
    hash.put("tempodeexecucao",System.currentTimeMillis() - tempoInicial);
    return hash; //aqui vai retornar o resultado e o tempo de execução em forma de um dicionario
    
  }
  private ArrayList<Integer> calculadivisores(int k){ //função que calcula os divisores 
    ArrayList<Integer> lista = new ArrayList<Integer>(); //cria uma lista vazia
    for(int count=1; count <= k; count++){ //faz o for entre 1 e o número que ele recebeu como parametro na função
      if(k % count == 0){
        lista.add(count); //se acaso for divisor, ele adiciona na lista
      }
  }
  return lista;
  }
}
