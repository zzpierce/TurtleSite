package com.zz.back.util.markrazi.trans;

import com.zz.back.util.markrazi.MarkConstant;
import java.util.regex.Pattern;

public class TitleTranslator extends AbstractTranslator{

    private final Pattern p1 = Pattern.compile(MarkConstant.TITLE_V1);
    private final Pattern p2 = Pattern.compile(MarkConstant.TITLE_V2);
    private final Pattern p3 = Pattern.compile(MarkConstant.TITLE_V3);
    private final Pattern p4 = Pattern.compile(MarkConstant.TITLE_V4);

    public String translate(String src, TranslatorContext context) {

        if(null == src || src.trim().equals("")) return null;
        if(getIndent(src) != 0) return null;

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

        if(src.length() < level + 1) {
            return "";
        }

        src = src.substring(level + 1);
        String levelStr = "h" + String.valueOf(level);
        String target = "<" + levelStr + ">"
                + src
                + "</" + levelStr + ">";

        return target;
    }
}
