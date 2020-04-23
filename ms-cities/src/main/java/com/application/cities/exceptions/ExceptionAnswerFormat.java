package com.application.cities.exceptions;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ExceptionAnswerFormat {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
