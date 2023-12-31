package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.entities.Departamento;
import com.projeto.repository.DepartamentoRepository;

@Service
public class DepartamentosServices {

	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentosServices(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	public List<Departamento> getAllDepartamento() {
		return departamentoRepository.findAll();
	}

	public Departamento getDepartamentoById(Long id) {
		Optional<Departamento> departamento = departamentoRepository.findById(id);
		return departamento.orElse(null);
	}

	public Departamento salvarDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public Departamento updateDepartamento(Long id, Departamento updatedDepartamento) {
		Optional<Departamento> existingDepartamento = departamentoRepository.findById(id);
		if (existingDepartamento.isPresent()) {
			return departamentoRepository.save(updatedDepartamento);
		}
		return null;
	}
	public boolean deleteDepartamento(Long id) {
		Optional<Departamento> existingDepartamento = departamentoRepository.findById(id);
		if (existingDepartamento.isPresent()) {
			departamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Departamento> getAlldepartamento() {
		// TODO Auto-generated method stub
		return null;
	}
}

