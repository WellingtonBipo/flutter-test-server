package com.pessoas.flutter.test.restapi.database;

import com.pessoas.flutter.test.restapi.entity.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioPessoa extends JpaRepository<Pessoa,Long>{
    
}
