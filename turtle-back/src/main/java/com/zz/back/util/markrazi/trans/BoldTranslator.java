package com.zz.back.util.markrazi.trans;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoldTranslator extends AbstractInlineTranslator {

    private final Pattern pattern = Pattern.compile("\\*\\*([^\\*]+)\\*\\*");

    public String translate(String src, TranslatorContext context) {

        Matcher matcher = pattern.matcher(src);
        while(matcher.find()) {

            int start = matcher.start();
            int end = matcher.end();

            src = src.substring(0, start) + "<b>" + matcher.group(1) + "</b>" + src.substring(end, src.length());

        }

        return src;
    }
}
