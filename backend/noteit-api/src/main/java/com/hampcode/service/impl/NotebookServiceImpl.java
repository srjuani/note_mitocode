package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.Notebook;
import com.hampcode.repository.NotebookRepository;
import com.hampcode.service.NotebookService;

@Service
public class NotebookServiceImpl implements NotebookService{
	
	@Autowired
	private NotebookRepository noteBookRepository;
	
    @Transactional
	@Override
	public Notebook insertOrUpdate(Notebook entity) {
		return noteBookRepository.save(entity);
	}

	@Override
	public Optional<Notebook> getOne(Long id) {
		return noteBookRepository.findById(id);
	}

	@Override
	public List<Notebook> getAll() {
		return noteBookRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		noteBookRepository.deleteById(id);
	}

	
	
}
