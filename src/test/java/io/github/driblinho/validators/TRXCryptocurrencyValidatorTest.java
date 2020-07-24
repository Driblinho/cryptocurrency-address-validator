package io.github.driblinho.validators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TRXCryptocurrencyValidatorTest {

    private static LinkedList<String> validAddress;
    private static LinkedList<String> inValidAddress;

    @BeforeAll
    static void setUpTest() {
        validAddress = new LinkedList<>();
        inValidAddress = new LinkedList<>();

        validAddress.add("TTsc8th97GLgFz5sRi2KiqhYbhqWCkQntV");
        validAddress.add("TNDzfERDpxLDS2w1q6yaFC7pzqaSQ3Bg3r");
        //Testnet??
        //validAddress.add("27bLJCYjbH6MT8DBF9xcrK6yZnm43vx7MNQ");
        validAddress.add("TGGUxAm8GHR8cpNNXbXds1wQL7YRKCSUh6");
        validAddress.add("THtbMw6byXuiFhsRv1o1BQRtzvube9X1jx");
        validAddress.add("TMUinVF223FRtCK17VNRigGsBsSSLQAKz4");
        validAddress.add("TJxQRpG7c7zp6LvP8HkRLi2B3YKmfoz84q");

        inValidAddress.add("xv");
        inValidAddress.add("");
        inValidAddress.add("11111");
        inValidAddress.add("1A Na15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i");
        inValidAddress.add("1fzWLkAahHooV3kzTgyx6qsswXJ6sCXkSr");
        inValidAddress.add("bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq");
        inValidAddress.add("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
        inValidAddress.add("1KmH1Sw8r82kM6jnUNrARDc6o7iAFshPzn");
        inValidAddress.add("0xd110522166d04C8b61b3B61D444C9FedE1ffD137");

    }

    @Test
    void shouldDetectAddress() {

        for (String address : validAddress) {
            assertTrue(new TRXCryptocurrencyValidator(address).isValid());
        }

    }

    @Test
    void shouldntDetectAddress() {
        for (String address : inValidAddress) {
            assertFalse(new TRXCryptocurrencyValidator(address).isValid());
        }
    }


}
