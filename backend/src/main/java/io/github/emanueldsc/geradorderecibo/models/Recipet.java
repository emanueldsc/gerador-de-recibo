package io.github.emanueldsc.geradorderecibo.models;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class Recipet {

    @NumberFormat
    @NotNull(message = "Número do Documento inválido")
    private Integer number; // numero
    
    @NumberFormat
    @NotNull(message = "Valor do Documento inválido")
    private Double value; // valor

    @NotBlank(message = "Credor do Documento inválido")
    private String creditor; // credor
    
    @NotBlank(message = "Devedor do Documento inválido")
    private String debtor; // devedor
    
    @NotBlank(message = "Local do Documento inválido")
    private String referent; // referente
    
    @NotBlank(message = "Local do Documento inválido")
    private String place; // local
    
    @NotBlank(message = "RG/CPF do Documento inválido")
    private String rgCpf;
    
    @Null
    private String key; // chave

    public Recipet() {
    }

    public Recipet(
            Integer number,
            Double value,
            String creditor,
            String debtor,
            String referent,
            String place,
            String rgCpf) {
        this.number = number;
        this.value = value;
        this.creditor = creditor;
        this.debtor = debtor;
        this.referent = referent;
        this.place = place;
        this.rgCpf = rgCpf;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCreditor() {
        return this.creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getDebtor() {
        return this.debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getReferent() {
        return this.referent;
    }

    public void setReferent(String referent) {
        this.referent = referent;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRgCpf() {
        return this.rgCpf;
    }

    public void setRgCpf(String rgCpf) {
        this.rgCpf = rgCpf;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
