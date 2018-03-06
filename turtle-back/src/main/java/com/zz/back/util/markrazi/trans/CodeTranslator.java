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
        if (src.equals(codeMark)) {
            if (!context.isCodeOpen()) {
                answer = "<div class='code'>";
            } else {
                answer = "</div>";
            }
            context.setCodeOpen(!context.isCodeOpen());
            return answer;
        }

        return null;
    }

}
