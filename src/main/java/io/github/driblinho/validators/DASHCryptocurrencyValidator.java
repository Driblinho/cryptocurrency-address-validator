package io.github.driblinho.validators;

import java.util.regex.Pattern;

public class DASHCryptocurrencyValidator extends CryptocurrencyValidator {

    public DASHCryptocurrencyValidator() {
    }

    public DASHCryptocurrencyValidator(String address) {
        super(address);
    }

    @Override
    public boolean isValid() {
        return Pattern.compile("^X[1-9A-HJ-NP-Za-km-z]{33}").matcher(address).matches();
    }
}
