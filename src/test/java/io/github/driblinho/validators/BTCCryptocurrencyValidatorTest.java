package io.github.driblinho.validators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BTCCryptocurrencyValidatorTest {

    private static LinkedList<String> validAddress;
    private static LinkedList<String> inValidAddress;


    @BeforeAll
    static void setUpTest() {
        validAddress = new LinkedList<>();
        inValidAddress = new LinkedList<>();

        validAddress.add("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
        validAddress.add("1KmH1Sw8r82kM6jnUNrARDc6o7iAFshPzn");
        validAddress.add("1AGNa15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i");
        validAddress.add("1Q1pE5vPGEEMqRcVRMbtBK842Y6Pzo6nK9");
        //P2PKH
        validAddress.add("1BvBMSEYstWetqTFn5Au4m4GFg7xJaNVN2");
        //P2SH
        validAddress.add("3J98t1WpEZ73CNmQviecrnyiWrnqRhWNLy");
        //Bech32
        validAddress.add("bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq");

        inValidAddress.add("xv");
        inValidAddress.add("");
        inValidAddress.add("11111");
        inValidAddress.add("1A Na15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i");
        inValidAddress.add("1fzWLkAahHooV3kzTgyx6qsswXJ6sCXkSr");

    }

    @Test
    void shouldDetectAddress() {

        for (String address : validAddress) {
            assertTrue(new BTCCryptocurrencyValidator(address).isValid());
        }

    }

    @Test
    void shouldntDetectAddress() {
        for (String address : inValidAddress) {
            assertFalse(new BTCCryptocurrencyValidator(address).isValid());
        }
    }
}
