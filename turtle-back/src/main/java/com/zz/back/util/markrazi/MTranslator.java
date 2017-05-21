package com.zz.back.util.markrazi;

import com.zz.back.util.markrazi.trans.ListTranslator;
import com.zz.back.util.markrazi.trans.TitleTranslator;
import com.zz.back.util.markrazi.trans.Translator;
import com.zz.back.util.markrazi.trans.TranslatorContext;
import com.zz.back.util.markrazi.util.HTMLTools;

import java.util.ArrayList;
import java.util.List;

public class MTranslator {

    private static List<Translator> translators;

    static {
        translators = new ArrayList<>();
        translators.add(new TitleTranslator());
        translators.add(new ListTranslator());
    }

    public String doTransfer(String src) {

        TranslatorContext context = new TranslatorContext();

        for(Translator translator : translators) {
            String target = translator.translate(src, context);
            if(target != null) {
                return target;
            }
        }

        return HTMLTools.appendBr(src);
    }

}
