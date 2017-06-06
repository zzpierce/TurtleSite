package com.zz.back.util;

public class RandomCodeGenerator {

    public static String validateCode = null;

    public static String generate(int length, String prefix) {

        String pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#^&-+";
        int poolLen = pool.length();

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i ++) {
            int index = (int)(Math.random() * poolLen);
            builder.append(pool.charAt(index));
        }

        validateCode = prefix + builder.toString();

        return validateCode;
    }


    public static boolean matchValidateCode(String code) {

        boolean result = false;
        if(code == null || code.equals("") || !code.equals(validateCode)) {
            result = false;
        }
        else if(code.equals(validateCode)) {
            result = true;
        }
        //destroy validate code after matching
        validateCode = null;
        return result;

    }
}
