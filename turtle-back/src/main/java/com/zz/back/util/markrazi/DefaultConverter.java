package com.zz.back.util.markrazi;

import com.zz.back.util.markrazi.trans.*;
import com.zz.back.util.markrazi.util.HTMLTools;

import java.util.ArrayList;
import java.util.List;

public class DefaultConverter implements Converter {

    private List<Translator> translators;
    private TranslatorContext context;

    public DefaultConverter() {

        context = new TranslatorContext();

        translators = new ArrayList<>();
        translators.add(new TitleTranslator());
        translators.add(new ListTranslator());
        translators.add(new EmptyLineTranslator());
    }

    public String convert(String src) {

        for(Translator translator : translators) {
            String target = translator.translate(src, context);
            if(target != null) {
                return target;
            }
        }

        return HTMLTools.appendBr(src);
    }

}
