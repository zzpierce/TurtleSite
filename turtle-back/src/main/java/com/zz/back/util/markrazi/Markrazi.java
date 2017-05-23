package com.zz.back.util.markrazi;

public class Markrazi {

    private MReader reader;
    private DefaultConverter converter;

    public Markrazi() {
        reader = new MReader();
        converter = new DefaultConverter();
    }

    public String doMarkrazi(String src) {

        StringBuilder builder = new StringBuilder("");
        reader.setBuffer(src);
        String curLine;

        while(null != (curLine = reader.readLine())) {
            String markStr = converter.convert(curLine);
            builder.append(markStr).append('\n');
        }

        return builder.toString();
    }

}
