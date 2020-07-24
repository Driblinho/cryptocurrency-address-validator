package io.github.driblinho.validators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DASHCryptocurrencyValidatorTest {

    private static LinkedList<String> validAddress;
    private static LinkedList<String> inValidAddress;

    @BeforeAll
    static void setUpTest() {
        validAddress = new LinkedList<>();
        inValidAddress = new LinkedList<>();

        validAddress.add("XbBRbkmg1sRc2ZKW7V4yTF8Cqj7SvunZHj");
        validAddress.add("Xb8cmjtK67y9T2haqrcDicoAMByDesLcAe");
        validAddress.add("XcohcqaaZW1KL7FQFJZLbejJ5YrvvS6cgL");
        validAddress.add("XdQL4m6FNdKdYMJVqbiqCWR2dJvVtrNSa2");
        validAddress.add("XhFGx1pNCNnS4cLHCA5ZKkfJh4RqhRX5gT");
        validAddress.add("Xjcm3GyztkLd2GEqekvovYbfW8iq8EV7pE");

        inValidAddress.add("xv");
        inValidAddress.add("");
        inValidAddress.add("11111");
        inValidAddress.add("1A Na15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i");
        inValidAddress.add("bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq");
        inValidAddress.add("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
        inValidAddress.add("1KmH1Sw8r82kM6jnUNrARDc6o7iAFshPzn");
        inValidAddress.add("0xd110522166d04C8b61b3B61D444C9FedE1ffD137");

    }

    @Test
    void shouldDetectAddress() {

        for (String address : validAddress) {
            assertTrue(new DASHCryptocurrencyValidator(address).isValid());
        }

    }

    @Test
    void shouldntDetectAddress() {
        for (String address : inValidAddress) {
            assertFalse(new DASHCryptocurrencyValidator(address).isValid());
        }
    }

}
