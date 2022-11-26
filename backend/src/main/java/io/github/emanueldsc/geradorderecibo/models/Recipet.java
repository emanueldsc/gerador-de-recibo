package io.github.emanueldsc.geradorderecibo.models;

public class Recipet {

    private Integer number; // numero
    private Double value; // valor
    private String creditor; // credor
    private String debtor; // devedor
    private String referent; // referente
    private String place; // local
    private String rgCpf;
    private String key; // chave

    public Recipet() {
    }

    public Recipet(Integer number, Double value, String creditor, String debtor, String referent, String place,
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
