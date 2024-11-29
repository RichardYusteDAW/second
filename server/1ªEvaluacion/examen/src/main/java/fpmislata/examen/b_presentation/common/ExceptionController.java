package fpmislata.examen.b_presentation.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fpmislata.examen.a_common.exception.ResourceNotFoundException;
import lombok.Getter;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception e) {
        return new ErrorMessage(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage internalServerError(Exception e) {
        return new ErrorMessage(e);
    }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(Exception.class)
    // @ResponseBody
    // public ErrorMessage badRequest(Exception e) {
    //     return new ErrorMessage(e);
    // }
}

@Getter
class ErrorMessage {

    private final String error;
    private final String message;

    public ErrorMessage(Exception exception) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
    }
}