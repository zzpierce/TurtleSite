package com.zz.back.util.markrazi.trans;

public abstract class AbstractTranslator implements Translator {

    public abstract String translate(String src, TranslatorContext context);

    /**
     * caculate the indent of list by number of spaces
     * @param src src
     * @return (0,1) (1-4, 2) (5-8, 3)...
     */
    protected int getIndent(String src) {

        if(src == null || src.trim().equals("")) {
            return 0;
        }

        int spaceSize = 0;
        int p = 0, len = src.length();

        while(p < len && (src.charAt(p) == ' ' || src.charAt(p) == '\t')) {
            if(src.charAt(p) == ' ') spaceSize += 1;
            else if(src.charAt(p) == '\t') spaceSize += 4;
            p ++;
        }

        return spaceSize;
    }

    protected void clearContext() {}

}
