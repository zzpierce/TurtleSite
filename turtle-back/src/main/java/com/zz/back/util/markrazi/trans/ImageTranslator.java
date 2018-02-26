package com.zz.back.util.markrazi.trans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageTranslator implements RecallTranslator {

    private final Pattern pLink = Pattern.compile("!\\[[^]]+]\\[([\\d]+)]");
    private final Pattern pSrc = Pattern.compile("\\[([\\d]+)]: ([^\n]+(.png|.jpg|.gif))");

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
            return toHTML(context.getImage(imageId));
        }

        //clean the src info
        Matcher matcher1 = pSrc.matcher(src);
        if(matcher1.matches()) {
            return "";
        }

        return null;
    }


    private String toHTML(String src) {
        return "<img src='" + src + "'>";
    }

}
