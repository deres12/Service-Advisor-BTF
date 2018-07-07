package it.btf.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHashing {

    /* converts a byte array to hexadecimal string */
    public static String hex(byte[] text) {
        String result = "";
        for(int i = 0; i < text.length; i++) {
            result += String.format("%02x", text[i]);
        }
        return result;
    }
    
    /* returns an hexadecimal encoded sha1 hash of the input string */
    public static String sha1(String text) {
        MessageDigest algo = null;
        try {
            algo = MessageDigest.getInstance("SHA-1");
        } catch(NoSuchAlgorithmException ex) {
            return "";
        }
        byte[] data = algo.digest(text.getBytes());
        return hex(data);
    }
}
