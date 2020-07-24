package io.github.driblinho;

import java.util.List;
import java.util.Optional;

public class CryptoAddressValidator implements CryptoAddressValidatorInterface {

    ///https://github.com/ognus/wallet-address-validator
    //https://github.com/SamouraiDev/bech32

    @Override
    public Optional<String> detectCryptocurrency() {
        return Optional.empty();
    }

    @Override
    public List<String> detectCryptocurrencyAll() {
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean isValid(String symbol) {
        return false;
    }

}
