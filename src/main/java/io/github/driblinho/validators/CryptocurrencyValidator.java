package io.github.driblinho.validators;

public abstract class CryptocurrencyValidator {
    protected final String address;

    public CryptocurrencyValidator(String address) {
        this.address = address;
    }

    abstract boolean isValid();
}
