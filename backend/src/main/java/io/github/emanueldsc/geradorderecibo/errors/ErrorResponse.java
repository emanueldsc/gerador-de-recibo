package io.github.emanueldsc.geradorderecibo.errors;

import java.util.List;

public class ErrorResponse {

    private Integer code;
    private String message;
    private String InternalCode;
    private List<FieldErrorResponse> erros;

    public ErrorResponse(Integer code, String message, String InternalCode, List<FieldErrorResponse> erros) {
        this.code = code;
        this.message = message;
        this.InternalCode = InternalCode;
        this.erros = erros;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInternalCode() {
        return this.InternalCode;
    }

    public void setInternalCode(String InternalCode) {
        this.InternalCode = InternalCode;
    }

    public List<FieldErrorResponse> getErros() {
        return this.erros;
    }

    public void setErros(List<FieldErrorResponse> erros) {
        this.erros = erros;
    }

}
