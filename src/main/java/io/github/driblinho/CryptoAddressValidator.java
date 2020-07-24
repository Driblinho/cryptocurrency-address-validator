package io.github.driblinho;

import io.github.driblinho.validators.CryptocurrencyValidator;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CryptoAddressValidator implements CryptoAddressValidatorInterface {

    ///https://github.com/ognus/wallet-address-validator
    //https://github.com/SamouraiDev/bech32
    private String address;

    private List<CryptocurrencyValidator> validators;
    private List<String> cryptocurrencySymbols;

    public CryptoAddressValidator() {
        this.initializeValidators();
    }

    private void initializeValidators() {
        validators = new ArrayList<>();
        Reflections reflections = new Reflections("io.github.driblinho.validators");
        Set<Class<? extends CryptocurrencyValidator>> subTypes = reflections.getSubTypesOf(CryptocurrencyValidator.class);

        subTypes.forEach(aClass -> {
            try {
                CryptocurrencyValidator obj;
                if(this.address!=null)
                    obj = aClass.getDeclaredConstructor(String.class).newInstance(this.address);
                else
                    obj = aClass.getDeclaredConstructor().newInstance();
                this.validators.add(obj);

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new AssertionError(e);
            }


        });
    }


    public CryptoAddressValidator(String address) {
        this();
        this.address = address;
        initializeValidators();
    }

    public void setAddress(String address) {
        validators.forEach(cryptocurrencyValidator -> {
            cryptocurrencyValidator.setAddress(address);
        });
        this.address = address;
    }

    @Override
    public Optional<String> detectCryptocurrency() {
        if (this.cryptocurrencySymbols != null && !this.cryptocurrencySymbols.isEmpty()) {
            return Optional.of(this.cryptocurrencySymbols.get(0));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<String>> detectCryptocurrencyAll() {
        if (this.detectCryptocurrency().isPresent()) return Optional.of(this.cryptocurrencySymbols);
        return Optional.empty();
    }

    @Override
    public void validate() {
        this.cryptocurrencySymbols = new ArrayList<>();
        for (CryptocurrencyValidator validator : validators) {
            if (validator.isValid()) {
                this.cryptocurrencySymbols.add(validator.getClass().getSimpleName().replace("CryptocurrencyValidator", ""));
            }
        }
    }

    @Override
    public boolean isValid() {
        return this.cryptocurrencySymbols!=null && !this.cryptocurrencySymbols.isEmpty();
    }

    @Override
    public boolean isValid(String symbol) {
        return false;
    }

}
