package com.br.receitasapi.receitasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.receitasapi.receitasapi.model.Receita;
import com.br.receitasapi.receitasapi.respository.ReceitaRepository;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
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
  public Iterable<Receita> criarReceita(@RequestBody Receita receita){
    repository.save(receita);
    return repository.findAll();
  }
  @DeleteMapping
  public ResponseEntity<String> deleteReceita(@RequestBody Receita receita) {
    try {
        Long id = receita.getId();
        if (id == null) {
            return new ResponseEntity<>("O ID da receita é obrigatório para a exclusão.", HttpStatus.BAD_REQUEST);
        }
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>("Receita excluída com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Receita com ID " + id + " não encontrada.", HttpStatus.NOT_FOUND);
        }
    } catch (Exception e) {
        return new ResponseEntity<>("Erro ao excluir a receita: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping
  public ResponseEntity<String> putReceita(@RequestBody Receita receita) {
    Long id = receita.getId();
    if (id == null) {
        return new ResponseEntity<>("O ID da receita é obrigatório para a atualização.", HttpStatus.BAD_REQUEST);
    }
    if (repository.existsById(id)) {
        repository.save(receita);
        return new ResponseEntity<>("Receita atualizada com sucesso.", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Receita com ID " + id + " não encontrada.", HttpStatus.NOT_FOUND);
    }
  }
}
