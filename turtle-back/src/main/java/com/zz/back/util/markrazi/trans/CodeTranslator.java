package com.zz.back.util.markrazi.trans;

/**
 * 引用语法翻译器
 * 负责翻译 ```ABC``` 为引用的格式
 * @author zhanzong
 */
public class CodeTranslator implements Translator {

    private static String codeMark = "```";

    public String translate(String src, TranslatorContext context) {
        String answer;
        if (src.startsWith(codeMark)) {
            if (!context.isCodeOpen()) {
                //find syntax
                String syntax;
                if (src.length() > 3) {
                    syntax = src.substring(3);
                } else {
                    syntax = "java";
                }
                answer = "<pre><code class='" + syntax + "'>";
            } else {
                answer = "</code></pre>";
            }
            context.setCodeOpen(!context.isCodeOpen());
            return answer;
        }
        return null;
    }
}
