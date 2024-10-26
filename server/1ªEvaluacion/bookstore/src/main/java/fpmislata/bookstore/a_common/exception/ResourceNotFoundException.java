package fpmislata.bookstore.a_common.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        //super("\u001B[31m" + "The resource does not exist." + "\u001B[0m");
        super("The resource does not exist.");
    }

    public ResourceNotFoundException(String message) {
        //super("\u001B[31m" + message + "\u001B[0m");
        super(message);
    }
}