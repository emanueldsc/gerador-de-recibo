package io.github.emanueldsc.geradorderecibo.errors;

public class BadRequestException extends Exception {

    private String message;
    private String errorCode;

    public BadRequestException() {
    }

    public BadRequestException(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
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
