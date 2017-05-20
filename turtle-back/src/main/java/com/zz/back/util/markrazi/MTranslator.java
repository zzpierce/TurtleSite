package com.zz.back.util.markrazi;

import com.zz.back.util.markrazi.trans.TransTitle;
import com.zz.back.util.markrazi.trans.Translator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MTranslator {

    private static List<Translator> translators;

    static {
        translators = new ArrayList<>();
        translators.add(new TransTitle());
    }


    public String doTransfer(String src) {

        for(Translator translator : translators) {
            String target = translator.translate(src);
            if(target != null) {
                return target;
            }
        }

        return src;
    }
}
