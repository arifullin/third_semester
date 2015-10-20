package ru.kpfu.execptions;

public class AlredyExistEx extends Exception {
    public AlredyExistEx() {
    }

    public AlredyExistEx(String message) {
        super(message);
    }

    public AlredyExistEx(String message, Throwable cause) {
        super(message, cause);
    }

    public AlredyExistEx(Throwable cause) {
        super(cause);
    }

    public AlredyExistEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
