package com.example.onlineMagazin.validator.feedback;

import com.example.onlineMagazin.dto.feedback.FeedbackCreateDto;
import com.example.onlineMagazin.dto.feedback.FeedbackUpdateDto;
import com.example.onlineMagazin.validator.AbstractValidator;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class FeedbackValidator extends AbstractValidator<FeedbackCreateDto, FeedbackUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validateOnCreate(FeedbackCreateDto feedbackCreateDto) throws ValidationException {

    }

    @Override
    public void validateOnUpdate(FeedbackUpdateDto feedbackUpdateDto) throws ValidationException {

    }
}
