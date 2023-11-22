package com.br.receitasapi.receitasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.receitasapi.receitasapi.model.Receita;
import com.br.receitasapi.receitasapi.respository.ReceitaRepository;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {
  @Autowired
  private ReceitaRepository repository;

  @GetMapping
  public Iterable<Receita> listarReceitas(){
    return repository.findAll();
  }
  @PostMapping
  public Receita criarReceita(@RequestBody Receita receita){
    return repository.save(receita);
  }
  @DeleteMapping
  public Iterable<Receita> deleteReceita(@RequestBody Receita receita){
    repository.delete(receita);
    return repository.findAll();
  }
}
