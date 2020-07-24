package io.github.driblinho.validators;

import org.web3j.crypto.Keys;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ETHCryptocurrencyValidator extends CryptocurrencyValidator {

    public ETHCryptocurrencyValidator(String address) {
        super(address);
    }

    public ETHCryptocurrencyValidator() {
    }

    @Override
    public boolean isValid() {
        Pattern pattern = Pattern.compile("^0x[a-fA-F0-9]{40}$");

        Matcher matcher = pattern.matcher(address);

        if(!matcher.matches()) return false;

        //if its all low or all upper
        else if(Pattern.compile("(^0x)[0-9a-f]{40}$").matcher(address).matches() || Pattern.compile("(^0x)[0-9A-F]{40}$").matcher(address).matches()) {
            return true;
        }

        return Keys.toChecksumAddress(address).equals(address);
    }

}
