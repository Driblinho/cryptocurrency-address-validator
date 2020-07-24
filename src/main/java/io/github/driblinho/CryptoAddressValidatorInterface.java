package io.github.driblinho;

import java.util.List;
import java.util.Optional;

public interface CryptoAddressValidatorInterface {
    Optional<String> detectCryptocurrency();
    List<String> detectCryptocurrencyAll();
    boolean isValid();
    boolean isValid(String symbol);
}
