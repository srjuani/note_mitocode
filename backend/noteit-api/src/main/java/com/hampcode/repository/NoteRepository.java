package com.hampcode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.Note;
import com.hampcode.model.Notebook;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

	List<Note> findAllByNotebook(Notebook notebook);
}
