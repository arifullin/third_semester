package ru.kpfu.execptions;

public class DataBaseEx extends Exception {

    public DataBaseEx() {
    }

    public DataBaseEx(String message) {
        super(message);
    }

    public DataBaseEx(String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseEx(Throwable cause) {
        super(cause);
    }

    public DataBaseEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
