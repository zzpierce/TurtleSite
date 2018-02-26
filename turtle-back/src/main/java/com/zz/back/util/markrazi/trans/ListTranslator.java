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
            String ans = toHTML(src);
            context.setCurrentListLevel(listLevel);
            return ans;
        }
        return null;
    }

    private void analyze(String src, TranslatorContext context) {
        int spaceSize = getIndent(src);

        listLevel = (spaceSize + 7) / 4;
        parentListLevel = context.getCurrentListLevel();

    }

    private String toHTML(String src) {

        String className = "razi-ul-" + String.valueOf(listLevel);

        StringBuilder target = new StringBuilder();
        if(parentListLevel > listLevel) {
            for(int i = parentListLevel - listLevel; i > 0; i --) {
                target.append("</ul>\n");
            }
        }

        if(parentListLevel < listLevel) {
            target.append("<ul class='").append(className).append("'>\n");
        }

        target.append("<li>").append(src.substring(2)).append("</li>");

        return target.toString();
    }

    public void clear() {

    }

    public static String clearContext(TranslatorContext context) {

        StringBuilder paddingBuffer = new StringBuilder();
        int listLevel = context.getCurrentListLevel();

        while(listLevel -- > 0) {
            paddingBuffer.append("</ul>");
        }

        context.setCurrentListLevel(0);

        return paddingBuffer.toString();
    }



}
