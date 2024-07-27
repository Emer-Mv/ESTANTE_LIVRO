package com.emerson_vaz_ru4191452.estantelivro.prateleira;


import org.springframework.data.jpa.repository.JpaRepository;

import com.emerson_vaz_ru4191452.estantelivro.model.Livro;

public interface prateleiraLivro extends JpaRepository<Livro, Long> {

}