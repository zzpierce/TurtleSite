package com.zz.back.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author pierce
 */
@Slf4j
@Repository
public class VerifyUtil {

    @Value("${blog.verifycode}")
    private String verifyCode;

    public boolean check(String code) {
        String encode = sha(code);
        return verifyCode.equals(encode);
    }

    private String sha(String code) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(code.getBytes());
            return Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            log.error("algorithm not found", e);
        }
        return null;
    }

}
