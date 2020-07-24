package io.github.driblinho.validators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ETHCryptocurrencyValidatorTest {


    private static LinkedList<String> validAddress;
    private static LinkedList<String> inValidAddress;


    @BeforeAll
    static void setUpTest() {
        validAddress = new LinkedList<>();
        inValidAddress = new LinkedList<>();

        validAddress.add("0xc1912fee45d61c87cc5ea59dae31190fffff232d");
        validAddress.add("0x77929AF6d1E863e4460a3565921607Cd2107E68a");
        validAddress.add("0xCD2a3d9F938E13CD947Ec05AbC7FE734Df8DD826");
        validAddress.add("0xAeA9DE3e9D1C6AdE7355Ee57f44127cC213711B7");
        validAddress.add("0x1c9E505a77dce934D8E1F72612559c310d122144");
        validAddress.add("0xd110522166d04C8b61b3B61D444C9FedE1ffD137");

        inValidAddress.add("xv");
        inValidAddress.add("");
        inValidAddress.add("11111");
        inValidAddress.add("1A Na15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i");
        inValidAddress.add("bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq");
        inValidAddress.add("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
        inValidAddress.add("1KmH1Sw8r82kM6jnUNrARDc6o7iAFshPzn");

    }


    @Test
    void shouldDetectAddress() {

        for (String address : validAddress) {
            assertTrue(new ETHCryptocurrencyValidator(address).isValid());
        }

    }

    @Test
    void shouldntDetectAddress() {
        for (String address : inValidAddress) {
            assertFalse(new ETHCryptocurrencyValidator(address).isValid());
        }
    }

}
