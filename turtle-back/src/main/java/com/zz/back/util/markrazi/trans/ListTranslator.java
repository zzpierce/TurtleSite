package com.zz.back.util.markrazi.trans;

import com.zz.back.util.markrazi.MarkConstant;

import java.util.regex.Pattern;

public class ListTranslator extends AbstractTranslator {

    private final Pattern ulPattern = Pattern.compile(MarkConstant.UNORDERED_LIST);

    private int listLevel;
    private int parentListLevel;

    public String translate(String src, TranslatorContext context) {
        analyze(src, context);

        src = src.trim();
        if(ulPattern.matcher(src).matches()) {
            return toHTML(src);
        }

        return null;
    }

    private void analyze(String src, TranslatorContext context) {
        listLevel = getIndent(src);
        parentListLevel = context.getCurrentListLevel();
        context.setCurrentListLevel(listLevel);
    }

    private String toHTML(String src) {

        String className = "razi-ul-" + String.valueOf(listLevel);

        StringBuilder target = new StringBuilder();
        if(parentListLevel < listLevel) {
            target.append("<ul class='").append(className).append("'>");
        }
        target.append("<li>").append(src).append("</li></ul>");

        if(parentListLevel > listLevel) {
            for(int i = parentListLevel - listLevel; i > 0; i --) {
                target.append("</ul>");
            }
        }

        return target.toString();
    }
}
