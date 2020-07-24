package io.github.driblinho.validators;

import io.github.driblinho.util.Crypto;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BTCCryptocurrencyValidator extends CryptocurrencyValidator implements AddressImplementSegWit {

    public BTCCryptocurrencyValidator(String address) {
        super(address);
    }

    private boolean segWit;

    @Override
    boolean isValid() {

        if(address.startsWith("bc1")) {
            final Pattern pattern = Pattern.compile("\\bbc(0([ac-hj-np-z02-9]{39}|[ac-hj-np-z02-9]{59})|1[ac-hj-np-z02-9]{8,87})\\b", Pattern.MULTILINE);
            final Matcher isMatch = pattern.matcher(address);
            if (isMatch.matches()) {
                this.segWit = true;
                return true;
            }
            return false;
        }
        if (address.length()-1 > 33) return false;

        int endIndex = address.length()-9;
        byte[] input = Crypto.base58ToRawBytes(address);
        byte[] hash = Crypto.doubleSha256(Arrays.copyOfRange(input, 0, endIndex-4));
        return Arrays.equals(Arrays.copyOfRange(hash, 0, 4), Arrays.copyOfRange(input, endIndex-4, endIndex));
    }




    @Override
    public boolean isSegWit() {
        return segWit;
    }
}
