package com.example.securemove;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;


public class CryptageManager {
    public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char encryptedChar = (char) (((ch - 'a' + shift) % 26) + 'a');
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Décryptage de César
    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift); // Décryptage en utilisant le décalage inverse
    }

    // Chiffrement affine
    public static String affineEncrypt(String text, int a, int b) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) (((a * (ch - base) + b) % 26) + base);
                result.append(encryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }


    // Décryptage affine
    public static String affineDecrypt(String text, int a, int b) {
        int aInverse = modInverse(a, 26);

        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int base = Character.isUpperCase(ch) ? 'A' : 'a';
                char decryptedChar = (char) (((aInverse * (ch - base - b) + 26) % 26) + base);
                result.append(decryptedChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }


    // Calcul de l'inverse modulaire
    private static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }





// Vigenere encryption
public static String vigenereEncrypt(String text, String key) {
    StringBuilder result = new StringBuilder();
    int keyIndex = 0;

    for (char ch : text.toCharArray()) {
        if (Character.isLetter(ch)) {
            char encryptedChar = (char) ((ch + key.charAt(keyIndex) - 2 * 'a') % 26 + 'a');
            result.append(encryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
        } else {
            result.append(ch);
        }
    }

    return result.toString();
}

    // Vigenere decryption
    public static String vigenereDecrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char decryptedChar = (char) ((ch - key.charAt(keyIndex) + 26) % 26 + 'a');
                result.append(decryptedChar);
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }



}