package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.service.DepartamentosServices;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Departamento", description = "API REST DE GERENCIAMENTO DE Departamento")
@RestController
@RequestMapping("/Departamento")	
	public class DepartamentoController {
	
	private final DepartamentosServices departamentoSService;
	
	@Autowired
	public DepartamentoController(DepartamentosServices departamentoService) {
	this.departamentosServices = departamentoSService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<departamento> getProductById(@PathVariable Long id) {
	Departamento departamento = DepartamentosServices.getDepartamentoById(id);
	if (Departamento != null) {
	return ResponseEntity.ok(Departamento);
	
	} else {
	return ResponseEntity.notFound().build();

	}
	}

	@GetMapping("/")
	public ResponseEntity<List<Departamento>> getAllDepartamento() {
	List<Departamento> Departamento = DepartamentoService.getAllDepartamento();
	return ResponseEntity.ok(Departamento);
	}

	@PostMapping("/")
	public ResponseEntity<Departamento> criarDepartamento(@RequestBody @Valid Departamento Departamento) {
		Departamento criarDepartamento = DepartamentoService.salvarDepartamento(Departamento);
	return ResponseEntity.status(HttpStatus.CREATED).body(criarDepartamento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody @Valid Departamento Departamento) {
	Departamento updatedDepartamento = DepartamentoService.updateDepartamento(id, Departamento);
	if (updatedDepartamento != null) {
	return ResponseEntity.ok(updatedDepartamento);
	} else {
	return ResponseEntity.notFound().build();
	}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartamento(@PathVariable Long id) {
	boolean deleted = departamentoService.deleteDepartamento(id);
	if (deleted) {
	return ResponseEntity.ok().body("O Departamento foi excluído com sucesso.");
	} else {
	return ResponseEntity.notFound().build();
	 }
	}
}
