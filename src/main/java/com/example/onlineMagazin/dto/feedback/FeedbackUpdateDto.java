package com.example.onlineMagazin.dto.feedback;

import com.example.onlineMagazin.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackUpdateDto extends GenericDto {
    private Long userId;
    private String message;
}
