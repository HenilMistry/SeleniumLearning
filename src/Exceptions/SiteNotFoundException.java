package Exceptions;

public class SiteNotFoundException extends Exception {
    public SiteNotFoundException() {
        super("The Site that you're looking for doesn't exists.");
    }

    public SiteNotFoundException(String message) {
        super(message);
    }
}
