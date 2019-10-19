package com.hampcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hampcode.api.viewmodel.FeedbackViewModel;
import com.hampcode.api.viewmodel.NoteViewModel;
import com.hampcode.api.viewmodel.NotebookViewModel;
import com.hampcode.api.viewmodel.PrecioVentaViewModel;
import com.hampcode.model.Feedback;
import com.hampcode.model.Note;
import com.hampcode.model.Notebook;
import com.hampcode.model.PrecioVenta;
import com.hampcode.repository.NotebookRepository;

@Component
public class Mapper {

	@Autowired
	private NotebookRepository notebookRepository;

	public NoteViewModel convertToNoteViewModel(Note entity) {
		NoteViewModel viewModel = new NoteViewModel();
		viewModel.setTitle(entity.getTitle());
		viewModel.setId(entity.getId());
		viewModel.setLastModifiedOn(entity.getLastModifiedOn());
		viewModel.setText(entity.getText());
		viewModel.setNotebookId(entity.getNotebook().getId());

		return viewModel;
	}

	public Note convertToNoteEntity(NoteViewModel viewModel) {
		Notebook notebook = this.notebookRepository.findById(viewModel.getNotebookId()).get();
		Note entity = new Note(viewModel.getId(), viewModel.getTitle(), viewModel.getText(), notebook);

		return entity;
	}

	public NotebookViewModel convertToNotebookViewModel(Notebook entity) {
		NotebookViewModel viewModel = new NotebookViewModel();
		viewModel.setId(entity.getId());
		viewModel.setName(entity.getName());
		

		return viewModel;
	}

	public Notebook convertToNotebookEntity(NotebookViewModel viewModel) {
		Notebook entity = new Notebook(viewModel.getId(), viewModel.getName());

		return entity;
	}
	
	
	public FeedbackViewModel convertToFeedbackViewModel(Feedback entity) {
		FeedbackViewModel viewModel = new FeedbackViewModel();
		viewModel.setId(entity.getId());
		viewModel.setName(entity.getName());
		viewModel.setEmail(entity.getEmail());
		viewModel.setFeedback(entity.getFeedback());

		return viewModel;
	}

	public Feedback convertToFeedbackEntity(FeedbackViewModel viewModel) {
		Feedback entity = new Feedback(viewModel.getId(), viewModel.getName(),viewModel.getEmail(),viewModel.getFeedback());

		return entity;
	}
	
	
	public PrecioVentaViewModel convertToPrecioVentaViewModel(PrecioVenta entity) {
		PrecioVentaViewModel viewModel = new PrecioVentaViewModel();
		viewModel.setId(entity.getId());
		viewModel.setClave(entity.getClave());
		viewModel.setName(entity.getName());
		viewModel.setCostoMateriaPrima(entity.getCostoMateriaPrima());
		viewModel.setPrecio(entity.getPrecio());

		return viewModel;
	}

	public PrecioVenta convertToPrecioVentaEntity(PrecioVentaViewModel viewModel) {
		PrecioVenta entity = new PrecioVenta(viewModel.getId(), viewModel.getClave(),viewModel.getName(),viewModel.getCostoMateriaPrima(),viewModel.getPrecio());

		return entity;
	}

}
