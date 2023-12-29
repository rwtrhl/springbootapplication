package dev.rahul.productservice.exceptions;


import dev.rahul.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(
                new ExceptionDto(
                        HttpStatus.NOT_FOUND, e.getMessage()
                ),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(ArrayIndexOutOfBoundsException e){
        return new ResponseEntity<>(
                new ExceptionDto(
                        HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()
                ),
                HttpStatus.NOT_FOUND
        );
    }
}
