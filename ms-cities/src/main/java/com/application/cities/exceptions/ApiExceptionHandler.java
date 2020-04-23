package com.application.cities.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionAnswerFormat> treatEmptyResultDataAccessException(NotFoundException e) {
    ExceptionAnswerFormat exceptionAnswer = ExceptionAnswerFormat.builder()
        .timestamp(LocalDateTime.now())
        .details(convertStackTraceToString(e))
        .message(e.getMessage()).build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionAnswer);
  }

  @ExceptionHandler(FileSizeLimitExceededException.class)
  public ResponseEntity<ExceptionAnswerFormat> handleException(FileSizeLimitExceededException e) {
    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(createExceptionAnswer(e));
  }

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity<ExceptionAnswerFormat> handleException(MaxUploadSizeExceededException e) {
    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(createExceptionAnswer(e));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionAnswerFormat> handleException(Exception e) {
    ExceptionAnswerFormat exceptionAnswer = createExceptionAnswer(e);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionAnswer);
  }

  private ExceptionAnswerFormat createExceptionAnswer(Exception e) {
    return ExceptionAnswerFormat.builder()
        .timestamp(LocalDateTime.now())
        .details(convertStackTraceToString(e))
        .message(e.getMessage()).build();
  }

  private String convertStackTraceToString(Exception e) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    e.printStackTrace(pw);
    return sw.toString();
  }
}
