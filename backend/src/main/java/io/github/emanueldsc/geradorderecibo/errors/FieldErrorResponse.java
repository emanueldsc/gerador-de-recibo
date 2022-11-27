package io.github.emanueldsc.geradorderecibo.errors;

public class FieldErrorResponse {
    private String message;
    private String field;

    public FieldErrorResponse() {
    }

    public FieldErrorResponse(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
