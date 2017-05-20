package com.zz.back.util.markrazi.trans;

public interface Translator {

    /**
     * Translate src from markdown format to html format
     * @param src src
     * @return null if not matches, html if matches
     */
    String translate(String src);

}
