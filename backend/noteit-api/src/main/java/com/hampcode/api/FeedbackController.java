package com.hampcode.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.Mapper;
import com.hampcode.api.viewmodel.FeedbackViewModel;
import com.hampcode.model.Feedback;
import com.hampcode.service.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

	
	@Autowired
	private FeedbackService feedBackService;

	@Autowired
	private Mapper mapper;
	
	
	@GetMapping
	public List<FeedbackViewModel> all() {
		List<Feedback> feedbacks = this.feedBackService.getAll();

		// map from entity to view model
		List<FeedbackViewModel> feedbacksViewModel = feedbacks.stream().map(feedback -> this.mapper.convertToFeedbackViewModel(feedback))
				.collect(Collectors.toList());

		return feedbacksViewModel;
	}

	@PostMapping
	public Feedback save(@RequestBody FeedbackViewModel feedbackViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Feedback feedback = this.mapper.convertToFeedbackEntity(feedbackViewModel);

		// save feedbackEntity instance to db
		this.feedBackService.insertOrUpdate(feedback);

		return feedback;
	}

}
