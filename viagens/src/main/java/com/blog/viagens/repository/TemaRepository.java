package com.blog.viagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.viagens.model.Tema;


public interface TemaRepository extends JpaRepository<Tema, Long> {
			public List<Tema> findAllByDescricaoContainingIgnoreCase (String descricao);


	}



