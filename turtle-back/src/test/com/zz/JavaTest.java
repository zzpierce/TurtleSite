package com.zz;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import sun.security.mscapi.RSACipher;

import java.security.MessageDigest;

/**
 * @author pierce
 */
public class JavaTest {

    @Test
    public void test() throws Exception {
        String key = "";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(key.getBytes());
        String code = new String(hash);
        System.out.println(code);

        String code1 = Hex.encodeHexString(hash);
        System.out.println(code1);
    }
}
