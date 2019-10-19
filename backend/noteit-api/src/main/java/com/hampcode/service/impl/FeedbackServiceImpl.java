package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hampcode.model.Feedback;
import com.hampcode.repository.FeedbackRepository;
import com.hampcode.service.FeedbackService;

@Service
public class FeedbackServiceImpl  implements FeedbackService{
	
	@Autowired
	private FeedbackRepository feedBackRepository;

	@Transactional
	@Override
	public Feedback insertOrUpdate(Feedback entity) {
		return feedBackRepository.save(entity);
	}

	
	@Override
	public Optional<Feedback> getOne(Long id) {
		return feedBackRepository.findById(id);
	}

	@Override
	public List<Feedback> getAll() {
		return feedBackRepository.findAll();
	}

	@Transactional
	@Override
	public void delete(Long id) {
		feedBackRepository.deleteById(id);
	}
	
	

}
