package com.zz.back.util.markrazi.trans;

public abstract class AbstractInlineTranslator implements Translator {

    public abstract String translate(String src, TranslatorContext context);

}
