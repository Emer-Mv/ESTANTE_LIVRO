package com.emerson_vaz_ru4191452.estantelivro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emerson_vaz_ru4191452.estantelivro.model.Livro;
import com.emerson_vaz_ru4191452.estantelivro.prateleira.prateleiraLivro;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired  
    private prateleiraLivro prateleira;

    @GetMapping
    public List<Livro> listar(){
       return prateleira.findAll();
    }

    @GetMapping(value = "/{id}")
    public Livro findById(@PathVariable long id){
      Livro result = prateleira.findById(id).get();
      return result;
    }
    
    @PostMapping
    public Livro adicionar(@RequestBody Livro livro){
       return prateleira.save(livro);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deletar(@PathVariable long id){
      if(prateleira.existsById(id)){
         prateleira.deleteById(id);
         return ResponseEntity.ok("Livro removido com sucesso!");
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado!");
   }



    }

}