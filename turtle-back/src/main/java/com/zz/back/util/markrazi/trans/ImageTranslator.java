package com.zz.back.util.markrazi.trans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageTranslator implements RecallTranslator {

    private final Pattern pLink = Pattern.compile("!\\[[^]]+]\\[([\\d]+)]");
    private final Pattern pSrc = Pattern.compile("\\[([\\d]+)]: ([^\n]+(.png|.jpg))");

    public void collect(String src, TranslatorContext context) {
        src = src.trim();
        Matcher matcher = pSrc.matcher(src);
        if(matcher.matches()) {
            String imageId = matcher.group(1);
            String imageHref = matcher.group(2);
            context.putImage(imageId, imageHref);
        }

    }

    //called when loop the second time
    public String translate(String src, TranslatorContext context) {
        src = src.trim();
        Matcher matcher = pLink.matcher(src);
        if(matcher.matches()) {
            String imageId = matcher.group(1);
            String target = toHTML(context.getImage(imageId));

            return target;
        }

        return null;
    }


    private String toHTML(String src) {
        String target = "<img src='" + src + "'>";
        return target;
    }

}
