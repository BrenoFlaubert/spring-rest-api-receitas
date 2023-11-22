package com.br.receitasapi.receitasapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.receitasapi.receitasapi.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
  
}
