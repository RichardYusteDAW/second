package fpmislata.bookstore._1common.http_errors;

import lombok.Getter;

@Getter
public class ErrorMessage {

    private final String error;
    private final String message;

    public ErrorMessage(Exception exception) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
    }
}