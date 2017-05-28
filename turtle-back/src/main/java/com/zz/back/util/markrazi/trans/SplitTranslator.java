package com.zz.back.util.markrazi.trans;

import java.util.regex.Pattern;

public class SplitTranslator extends AbstractTranslator {

    private Pattern pattern = Pattern.compile("---");

    public String translate(String src, TranslatorContext context) {

        src = src.trim();
        if(pattern.matcher(src).matches()) {
            return "<hr>";
        }

        return null;
    }

}
