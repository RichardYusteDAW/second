package fpmislata.bookstore.a_common.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public ResourceNotFoundException() {
        super(RED + "The resource does not exist." + RESET);
    }

    public ResourceNotFoundException(String message) {
        super(RED + message + RESET);
    }
}