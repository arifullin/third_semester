package ru.kpfu.execptions;

public class NoUserEx extends Exception {
    public NoUserEx() {
        super();
    }

    public NoUserEx(String message) {
        super(message);
    }

    public NoUserEx(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUserEx(Throwable cause) {
        super(cause);
    }
}
