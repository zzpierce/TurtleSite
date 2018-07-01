package com.zz.back.util;

public class RandomCodeGenerator {

    public static String verifyCode = null;

    public static String generate(int length, String prefix) {

        String pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#^&-+";
        int poolLen = pool.length();

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i ++) {
            int index = (int)(Math.random() * poolLen);
            builder.append(pool.charAt(index));
        }

        verifyCode = prefix + builder.toString();

        return verifyCode;
    }


    public static boolean matchVeryfyCode(String code) {

        boolean result = false;
        if(code == null || code.equals("") || !code.equals(verifyCode)) {
            result = false;
        }
        else if(code.equals(verifyCode)) {
            result = true;
        }
        //destroy validate code after matching
        verifyCode = null;
        return result;

    }
}
