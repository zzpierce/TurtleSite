package com.zz.back.util.markrazi.trans;

import com.zz.back.util.markrazi.MarkConstant;
import java.util.regex.Pattern;

public class TransTitle implements Translator{

    private static Pattern p1 = Pattern.compile(MarkConstant.TITLE_V1);
    private static Pattern p2 = Pattern.compile(MarkConstant.TITLE_V2);
    private static Pattern p3 = Pattern.compile(MarkConstant.TITLE_V3);
    private static Pattern p4 = Pattern.compile(MarkConstant.TITLE_V4);

    public String translate(String src) {
        if(null == src || src.trim().equals("")) return null;

        src = src.trim();
        if(p1.matcher(src).matches()) {
            return toHTML(src, 1);
        }
        if(p2.matcher(src).matches()) {
            return toHTML(src, 2);
        }
        if(p3.matcher(src).matches()) {
            return toHTML(src, 3);
        }
        if(p4.matcher(src).matches()) {
            return toHTML(src, 4);
        }

        return null;
    }


    private String toHTML(String src, int level) {
        src = src.substring(level + 3);
        String levelStr = "h" + String.valueOf(level);
        String target = "<" + levelStr + ">"
                + src
                + "</" + levelStr + ">";

        return target;
    }
}
