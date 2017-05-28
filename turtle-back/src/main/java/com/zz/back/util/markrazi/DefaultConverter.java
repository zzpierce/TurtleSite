package com.zz.back.util.markrazi;

import com.zz.back.util.markrazi.trans.*;
import com.zz.back.util.markrazi.util.HTMLTools;
import javafx.collections.transformation.TransformationList;

import java.util.ArrayList;
import java.util.List;

public class DefaultConverter implements Converter {

    private MReader reader;

    private List<Translator> translators;
    private TranslatorContext context;

    public DefaultConverter() {

        context = new TranslatorContext();
        reader = new MReader();

        translators = new ArrayList<>();
        translators.add(new TitleTranslator());
        translators.add(new ListTranslator());
        translators.add(new ImageTranslator());
        translators.add(new SplitTranslator());

        translators.add(new EmptyLineTranslator());

    }

    public String convert(String src) {

        StringBuilder builder = new StringBuilder("");
        reader.setBuffer(src);
        String curLine;

        while(null != (curLine = reader.readLine())) {
            collect(curLine);
        }

        reader.reset();

        while(null != (curLine = reader.readLine())) {
            String markStr = doConvert(curLine);
            builder.append(markStr).append('\n');
        }

        return builder.toString();
    }


    private String doConvert(String line) {

        for(Translator translator : translators) {
            String target = translator.translate(line, context);
            if(target != null) {
                return target;
            }
        }

        return HTMLTools.appendBr(line);
    }

    private void collect(String line) {
        for(Translator translator : translators) {
            if(translator instanceof RecallTranslator) {
                ((RecallTranslator) translator).collect(line, context);
            }
        }
    }
}
