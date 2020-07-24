package io.github.driblinho;

import java.util.List;
import java.util.Optional;

public interface CryptoAddressValidatorInterface {
    Optional<String> detectCryptocurrency();
    Optional<List<String>> detectCryptocurrencyAll();
    void validate();
    boolean isValid();
    boolean isValid(String symbol);
}
