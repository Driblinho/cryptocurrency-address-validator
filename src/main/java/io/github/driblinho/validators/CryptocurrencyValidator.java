package io.github.driblinho.validators;

public abstract class CryptocurrencyValidator {
    protected String address;

    public CryptocurrencyValidator(String address) {
        this.address = address;
    }

    public CryptocurrencyValidator() {

    }


    public void setAddress(String address) {
        this.address = address;
    }

    public abstract boolean isValid();
}
