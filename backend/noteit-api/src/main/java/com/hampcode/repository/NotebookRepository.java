package com.hampcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.Notebook;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long> {
	
}

