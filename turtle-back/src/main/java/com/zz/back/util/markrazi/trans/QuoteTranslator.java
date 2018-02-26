package com.zz.back.util.markrazi.trans;

/**
 * 引用语法翻译器
 * 负责翻译 ```ABC``` 为引用的格式
 * @author zhanzong
 */
public class QuoteTranslator implements Translator {

    private static String quoteMark = "```";

    public String translate(String src, TranslatorContext context) {

        String answer;
        if (!context.isQuoteOpen()) {
            answer = "<div class='quote'>";
        } else {
            answer = "</div>";
        }

        return null;
    }

}
