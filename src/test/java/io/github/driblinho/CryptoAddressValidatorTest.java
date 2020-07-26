package io.github.driblinho;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CryptoAddressValidatorTest {

    private static List<String> validAddresses;
    private static List<String> inValidAddresses;

    @BeforeAll
    static void setUpTest() {

        validAddresses = new ArrayList<>();
        inValidAddresses = new ArrayList<>();

        validAddresses.add("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
        validAddresses.add("1KmH1Sw8r82kM6jnUNrARDc6o7iAFshPzn");
        validAddresses.add("XbBRbkmg1sRc2ZKW7V4yTF8Cqj7SvunZHj");
        validAddresses.add("Xb8cmjtK67y9T2haqrcDicoAMByDesLcAe");
        validAddresses.add("XcohcqaaZW1KL7FQFJZLbejJ5YrvvS6cgL");
        validAddresses.add("0xc1912fee45d61c87cc5ea59dae31190fffff232d");
        validAddresses.add("0x77929AF6d1E863e4460a3565921607Cd2107E68a");
        validAddresses.add("0xCD2a3d9F938E13CD947Ec05AbC7FE734Df8DD826");
        validAddresses.add("TTsc8th97GLgFz5sRi2KiqhYbhqWCkQntV");
        validAddresses.add("TNDzfERDpxLDS2w1q6yaFC7pzqaSQ3Bg3r");

        inValidAddresses.add("xv");
        inValidAddresses.add("");
        inValidAddresses.add("11111");
        inValidAddresses.add("1A Na15ZQXAZUgFiqJ2i7Z2DPU2J6hW62i");

    }

    @Test
    void shouldValidAllAddress() {
        CryptoAddressValidator validator = new CryptoAddressValidator();
        for (String address : validAddresses) {
            validator.setAddress(address);
            validator.validate();
            assertTrue(validator.isValid());
        }
    }

    @Test
    void shouldntValidAllAddress() {
        CryptoAddressValidator validator = new CryptoAddressValidator();
        for (String address : inValidAddresses) {
            validator.setAddress(address);
            validator.validate();
            assertFalse(validator.isValid());
        }
    }

    @Test
    void shouldDetectCryptoSymbol() {
        //BTC
        CryptoAddressValidator validator = new CryptoAddressValidator("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
        validator.validate();
        assertTrue(validator.detectCryptocurrency().isPresent());
        assertEquals("BTC", validator.detectCryptocurrency().get());
        //ETH
        validator.setAddress("0xd110522166d04C8b61b3B61D444C9FedE1ffD137");
        validator.validate();
        assertTrue(validator.detectCryptocurrency().isPresent());
        assertEquals("ETH", validator.detectCryptocurrency().get());
        //DASH
        validator.setAddress("XbBRbkmg1sRc2ZKW7V4yTF8Cqj7SvunZHj");
        validator.validate();
        assertTrue(validator.detectCryptocurrency().isPresent());
        assertEquals("DASH", validator.detectCryptocurrency().get());
        //TRX
        validator.setAddress("TGGUxAm8GHR8cpNNXbXds1wQL7YRKCSUh6");
        validator.validate();
        assertTrue(validator.detectCryptocurrency().isPresent());
        assertEquals("TRX", validator.detectCryptocurrency().get());
    }

    @Test
    void shouldDetectCryptoSymbols() {
        CryptoAddressValidator validator = new CryptoAddressValidator("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
        validator.validate();
        var response = validator.detectCryptocurrencyAll();
        assertAll(
                () -> assertTrue(response.isPresent()),
                () -> assertTrue(response.get().size()>=1)
        );
    }

    @Test
    void shouldValidateBySymbol() {
        CryptoAddressValidator validator = new CryptoAddressValidator("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
        validator.validate();
        validator.isValid("BTC");
    }


}
