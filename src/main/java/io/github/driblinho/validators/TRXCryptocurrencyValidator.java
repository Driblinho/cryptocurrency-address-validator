package io.github.driblinho.validators;

import io.github.driblinho.util.Crypto;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TRXCryptocurrencyValidator extends CryptocurrencyValidator {
    public TRXCryptocurrencyValidator(String address) {
        super(address);
    }

    public TRXCryptocurrencyValidator() {
    }

    @Override
    public boolean isValid() {

        if(!Pattern.compile("^T[1-9A-HJ-NP-Za-km-z]{33}").matcher(address).matches()) return false;

        if (address.length()<4) return false;
        byte[] base = Crypto.base58ToRawBytes(address);
        String checksum = Crypto.toHex(Arrays.copyOfRange(base, base.length - 4, base.length));
        String computedChecksum = Crypto.toHex(Crypto.doubleSha256(Arrays.copyOfRange(base, 0, base.length - 4))).substring(0, 8);

        return checksum.equals(computedChecksum);
    }
}
