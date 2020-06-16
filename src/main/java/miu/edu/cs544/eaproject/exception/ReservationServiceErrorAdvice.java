package miu.edu.cs544.eaproject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ReservationServiceErrorAdvice {
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({NotAcceptableException.class})
    public ResponseEntity<String> handle(NotAcceptableException e) {
        return error(HttpStatus.NOT_ACCEPTABLE, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
//        ResponseBody responseBody = new ResponseBody();

        return ResponseEntity.status(status).body(e.getMessage());
    }
}
