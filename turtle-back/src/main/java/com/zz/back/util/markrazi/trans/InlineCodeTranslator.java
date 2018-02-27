package com.zz.back.util.markrazi.trans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhanzong
 */
public class InlineCodeTranslator extends AbstractInlineTranslator {

    private final Pattern pattern = Pattern.compile("``");

    public String translate(String src, TranslatorContext context) {

        boolean codeInlineOpen = false;
        Matcher matcher = pattern.matcher(src);

        while(matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            String replace;
            if (!codeInlineOpen) {
                replace = "<span class='code-inline'>";
            } else {
                replace = "</span>";
            }
            codeInlineOpen = !codeInlineOpen;
            src = src.substring(0, start) + replace + src.substring(end, src.length());
            //由于src本身被修改，需要重新进行match
            matcher = pattern.matcher(src);
        }

        if (codeInlineOpen) {
            src = src + "</span>";
        }

        return src;
    }
}
