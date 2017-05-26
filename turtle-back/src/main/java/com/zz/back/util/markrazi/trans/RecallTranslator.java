package com.zz.back.util.markrazi.trans;

public interface RecallTranslator extends Translator {

    //collect info
    void collect(String src, TranslatorContext context);

    //translate
    String translate(String src, TranslatorContext context);

}
