package com.zz.back.util.markrazi.trans;

public class EmptyLineTranslator extends AbstractTranslator {

    public String translate(String src, TranslatorContext context) {

        if(src == null) return null;

        if(src.trim().equals("")) {
            clear(context);
        }

        return src;
    }

    private void clear(TranslatorContext context) {
        ListTranslator.clearContext(context);
    }

}
