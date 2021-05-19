package com.blog.viagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.viagens.model.Tema;
import com.blog.viagens.repository.TemaRepository;


@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;

	@GetMapping
	public ResponseEntity<List<Tema>> GetAll() {
		return ResponseEntity.ok(temaRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable long id) {
		return temaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/pesquisa/{tema}")
	public ResponseEntity<List<Tema>> GetByTema(@PathVariable String tema) {
		return ResponseEntity.ok(temaRepository.findAllByTemaContainingIgnoreCase(tema));
	}

	@PostMapping
	public ResponseEntity<Tema> postTema(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}

	@PutMapping
	public ResponseEntity<Tema> putTema(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}

	@DeleteMapping("/{id}")
	public void deleteTema(@PathVariable long id) {
		temaRepository.deleteById(id);
	}
}