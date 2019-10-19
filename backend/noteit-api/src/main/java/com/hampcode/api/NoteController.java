package com.hampcode.api;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.Mapper;
import com.hampcode.api.viewmodel.NoteViewModel;
import com.hampcode.model.Note;
import com.hampcode.model.Notebook;
import com.hampcode.service.NoteService;
import com.hampcode.service.NotebookService;


@RestController
@RequestMapping("/api/notes")
public class NoteController {

	
	@Autowired
	private NoteService noteService;
	
	
	@Autowired
	private NotebookService noteBookService;
	
	
	@Autowired
	private Mapper mapper;

	@GetMapping
	public List<NoteViewModel> all() {
		List<Note> notes = this.noteService.getAll();

		// map from entity to view model
		List<NoteViewModel> notesViewModel = notes.stream().map(note -> this.mapper.convertToNoteViewModel(note))
				.collect(Collectors.toList());

		return notesViewModel;
	}

	@GetMapping("/{id}")
	public NoteViewModel byId(@PathVariable Long id) {
		Optional<Note> note = this.noteService.getOne(id);

		if (!note.isPresent()) {
			throw new EntityNotFoundException();
		}

		NoteViewModel noteViewModel = this.mapper.convertToNoteViewModel(note.get());

		return noteViewModel;
	}

	@GetMapping("/byNotebook/{notebookId}")
	public List<NoteViewModel> byNotebook(@PathVariable Long notebookId) {
		List<Note> notes = new ArrayList<>();

		Optional<Notebook> notebook = this.noteBookService.getOne(notebookId);
		if (notebook.isPresent()) {
			notes = this.noteService.getByNotebook(notebook.get());
		}

		// map to note view model
		List<NoteViewModel> notesViewModel = notes.stream().map(note -> this.mapper.convertToNoteViewModel(note))
				.collect(Collectors.toList());

		return notesViewModel;
	}

	@PostMapping
	public Note save(@RequestBody NoteViewModel noteCreateViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Note noteEntity = this.mapper.convertToNoteEntity(noteCreateViewModel);

		// save note instance to db
		this.noteService.insertOrUpdate(noteEntity);

		return noteEntity;
	}

	@PutMapping
	public Note update(@RequestBody NoteViewModel noteCreateViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Note noteEntity = this.mapper.convertToNoteEntity(noteCreateViewModel);

		// save note instance to db
		this.noteService.insertOrUpdate(noteEntity);

		return noteEntity;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.noteService.delete(id);
	}

}
