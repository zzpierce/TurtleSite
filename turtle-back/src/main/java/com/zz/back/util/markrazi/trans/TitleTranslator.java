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
        int level = 0;
        if(p1.matcher(src).matches()) {
            level = 1;
        }
        else if(p2.matcher(src).matches()) {
            level = 2;
        }
        if(p3.matcher(src).matches()) {
            level = 3;
        }
        if(p4.matcher(src).matches()) {
            level = 4;
        }

        if(level > 0) {
            String prefix = clear(context);
            return prefix + toHTML(src, level);
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

    private String clear(TranslatorContext context) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(ListTranslator.clearContext(context));

        return buffer.toString();
    }
    
}
