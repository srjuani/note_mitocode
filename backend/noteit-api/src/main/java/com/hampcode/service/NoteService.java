package com.hampcode.service;

import java.util.List;

import com.hampcode.model.Note;
import com.hampcode.model.Notebook;

public interface NoteService extends CrudService<Note>{

	List<Note> getByNotebook(Notebook notebook);
	
}
