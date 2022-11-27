package io.github.emanueldsc.geradorderecibo.errors;

public class NotFoundException extends Exception {

    private String message;
    private String errorCode;

    public NotFoundException(String message, String errorCode) {

    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
