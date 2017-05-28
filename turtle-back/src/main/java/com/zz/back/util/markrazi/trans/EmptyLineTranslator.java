package com.zz.back.util.markrazi.trans;

public class EmptyLineTranslator extends AbstractTranslator {

    public String translate(String src, TranslatorContext context) {

        if(src == null) return null;

        if(src.trim().equals("")) {
            return src;
        }

        return src;
    }

    private String clear(TranslatorContext context) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(ListTranslator.clearContext(context));

        return buffer.toString();
    }

}
