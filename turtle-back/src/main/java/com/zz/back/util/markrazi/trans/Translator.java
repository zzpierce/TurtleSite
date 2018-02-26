package com.zz.back.util.markrazi.trans;

/**
 * 翻译器接口类，负责将markdown语法翻译为HTML
 */
public interface Translator {

    /**
     * Translate a string from markdown format to html format
     * @param src src
     * @return null if not matches, html if matches
     */
    String translate(String src, TranslatorContext context);

}
