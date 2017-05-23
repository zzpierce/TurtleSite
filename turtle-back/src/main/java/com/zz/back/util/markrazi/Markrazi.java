package com.zz.back.util.markrazi;

public class Markrazi {

    private MReader reader;
    private MTranslator translator;

    public Markrazi() {
        reader = new MReader();
        translator = new MTranslator();
    }

    public String doMarkrazi(String src) {

        StringBuilder builder = new StringBuilder("");
        reader.setBuffer(src);
        String curLine;

        while(null != (curLine = reader.readLine())) {
            String markStr = translator.doTransfer(curLine);
            builder.append(markStr).append('\n');
        }

        return builder.toString();
    }

}
