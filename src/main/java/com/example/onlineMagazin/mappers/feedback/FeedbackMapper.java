package com.example.onlineMagazin.mappers.feedback;

import com.example.onlineMagazin.dto.feedback.FeedbackCreateDto;
import com.example.onlineMagazin.dto.feedback.FeedbackDto;
import com.example.onlineMagazin.dto.feedback.FeedbackUpdateDto;
import com.example.onlineMagazin.entity.feedback.Feedback;
import com.example.onlineMagazin.mappers.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface FeedbackMapper extends BaseMapper<Feedback, FeedbackDto, FeedbackCreateDto, FeedbackUpdateDto> {

    @Override
    FeedbackDto toDto(Feedback feedback);

    @Override
    List<FeedbackDto> toDto(List<Feedback> e);

    @Override
    Feedback fromCreateDto(FeedbackCreateDto feedbackCreateDto);

    @Override
    Feedback fromUpdateDto(FeedbackUpdateDto d);
}
