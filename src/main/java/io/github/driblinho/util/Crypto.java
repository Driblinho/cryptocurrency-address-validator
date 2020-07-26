package io.github.driblinho.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Crypto {

    //https://github.com/nayuki/Bitcoin-Cryptography-Library/blob/master/java/io/nayuki/bitcoin/crypto/Base58Check.java

    public static final String BTC_ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";  // Everything except 0OIl
    private static final BigInteger BTC_ALPHABET_SIZE = BigInteger.valueOf(BTC_ALPHABET.length());

    public static byte[] base58ToRawBytes(String s) {
        // Parse base-58 string
        BigInteger num = BigInteger.ZERO;
        for (int i = 0; i < s.length(); i++) {
            num = num.multiply(BTC_ALPHABET_SIZE);
            int digit = BTC_ALPHABET.indexOf(s.charAt(i));
            if (digit == -1)
                throw new IllegalArgumentException("Invalid character for Base58Check");
            num = num.add(BigInteger.valueOf(digit));
        }

        // Strip possible leading zero due to mandatory sign bit
        byte[] b = num.toByteArray();
        if (b[0] == 0)
            b = Arrays.copyOfRange(b, 1, b.length);

        try {
            // Convert leading '1' characters to leading 0-value bytes
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            for (int i = 0; i < s.length() && s.charAt(i) == BTC_ALPHABET.charAt(0); i++)
                buf.write(0);
            buf.write(b);
            return buf.toByteArray();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] doubleSha256(byte[] in) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] doubleHash = digest.digest(in);
            doubleHash = digest.digest(doubleHash);
            return doubleHash;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String toHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            int decimal = (int) aByte & 0xff;               // bytes widen to int, need mask, prevent sign extension
            // get last 8 bits
            String hex = Integer.toHexString(decimal);
            if (hex.length() % 2 == 1) {                    // if half hex, pad with zero, e.g \t
                hex = "0" + hex;
            }
            result.append(hex);
        }
        return result.toString();
    }

}
