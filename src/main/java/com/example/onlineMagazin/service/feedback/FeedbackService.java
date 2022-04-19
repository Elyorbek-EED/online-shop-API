package com.example.onlineMagazin.service.feedback;

import com.example.onlineMagazin.dto.feedback.FeedbackCreateDto;
import com.example.onlineMagazin.dto.language.LanguageCreateDto;
import com.example.onlineMagazin.entity.feedback.Feedback;
import com.example.onlineMagazin.entity.language.Language;
import com.example.onlineMagazin.mappers.feedback.FeedbackMapper;
import com.example.onlineMagazin.repository.feedback.FeedbackRepository;
import com.example.onlineMagazin.response.Response;
import com.example.onlineMagazin.service.AbstractService;
import com.example.onlineMagazin.validator.feedback.FeedbackValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService extends AbstractService<FeedbackRepository, FeedbackMapper, FeedbackValidator> {

    protected FeedbackService(FeedbackRepository repository, FeedbackMapper mapper, FeedbackValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<List<Feedback>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Feedback> getById(Long id) {
        return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
    }

    public ResponseEntity<Response> delete(Long id) {
        repository.delete(repository.getById(id));
        return new ResponseEntity<>(new Response("Successfully deleted feedback", HttpStatus.OK.value()), HttpStatus.OK);
    }

    public ResponseEntity<Response> create(FeedbackCreateDto feedbackCreateDto) {
        Feedback feedback = mapper.fromCreateDto(feedbackCreateDto);
        repository.save(feedback);
        return new ResponseEntity<>(new Response("Successfully created feedback", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
