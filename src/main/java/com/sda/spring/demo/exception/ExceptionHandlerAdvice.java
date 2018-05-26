package com.sda.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(BookNotFoundException.class) //podajemy jaki błąd ma obslużyć ta metoda
    public ResponseEntity handleException(BookNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new AppError(HttpStatus.NOT_FOUND,
                        "Nie znaleziono rekordu",
                        Arrays.asList("brak ksiązki w bazie"))
                );
    }
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity authorNotFound(AuthorNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new AppError(HttpStatus.NOT_FOUND,
                        "Nie znaleziono rekordu",
                        Arrays.asList("brak autora w bazie"))
                );
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity categoryNotFound(CategoryNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new AppError(HttpStatus.NOT_FOUND,
                        "Nie znaleziono rekordu",
                        Arrays.asList("brak kategorii w bazie"))
                );
    }
    @ExceptionHandler(PublisherNotFoundException.class)
    public ResponseEntity publisherNotFound(PublisherNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new AppError(HttpStatus.NOT_FOUND,
                        "Nie znaleziono rekordu",
                        Arrays.asList("brak wydawcy w bazie"))
                );
    }
}
