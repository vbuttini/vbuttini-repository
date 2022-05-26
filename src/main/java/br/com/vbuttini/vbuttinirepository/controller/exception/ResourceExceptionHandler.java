package br.com.vbuttini.vbuttinirepository.controller.exception;

import br.com.vbuttini.vbuttinirepository.service.exception.DataBaseException;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author Vinícius Buttini
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-3")
    private final LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request){
        String error = "DataBaseError";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(now,status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}