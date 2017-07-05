package com.zz.back.util.markrazi.trans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderListTranslator extends AbstractTranslator {

    private final Pattern pattern = Pattern.compile("^([\\d]+.)([^\n]*)");

    public String translate(String src, TranslatorContext context) {

        src = src.trim();
        Matcher matcher = pattern.matcher(src);

        if(matcher.matches()) {
            String number = matcher.group(1);
            String content = matcher.group(2);

            return toHTML(number, content);
        }
        return null;
    }


    private String toHTML(String number, String content) {

        StringBuilder ans = new StringBuilder();
        ans.append("<div class='order-row'><span>").append(number).append("</span>").append(content).append("</div>");

        return ans.toString();
    }


}
