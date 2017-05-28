package com.zz.back.util.markrazi.trans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagsTranslator extends AbstractTranslator {

    private Pattern pattern = Pattern.compile("标签（空格分隔）：([^\n]+)");

    public String translate(String src, TranslatorContext context) {
        src = src.trim();
        Matcher matcher = pattern.matcher(src);

        if(matcher.find()) {
            String tagString = matcher.group(1).trim();
            return toHTML(tagString);
        }

        return null;
    }

    private String toHTML(String src) {

        String[] tags = src.split(" ");
        if(tags.length == 0) {
            return "";
        }

        StringBuilder target = new StringBuilder();
        for(String tag : tags) {
            String tagHTML = "<label class='blog-tag'>" + tag + "</label>";
            target.append(tagHTML);
        }

        return target.toString();
    }
}
