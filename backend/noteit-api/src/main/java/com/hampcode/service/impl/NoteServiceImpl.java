package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.Note;
import com.hampcode.model.Notebook;
import com.hampcode.repository.NoteRepository;
import com.hampcode.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	private NoteRepository noteRepository;

	@Transactional
	@Override
	public Note insertOrUpdate(Note entity) {
		return noteRepository.save(entity);
	}

	@Override
	public Optional<Note> getOne(Long id) {
		return noteRepository.findById(id);
	}

	@Override
	public List<Note> getAll() {
		return noteRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		noteRepository.deleteById(id);
	}

	@Override
	public List<Note> getByNotebook(Notebook notebook) {
		return noteRepository.findAllByNotebook(notebook);
	}
	
	

}
