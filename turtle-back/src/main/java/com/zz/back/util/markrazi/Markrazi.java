package com.zz.back.util.markrazi;

public class Markrazi {

    private Converter converter;

    public Markrazi() {
        converter = new DefaultConverter();
    }

    public Markrazi(Converter converter) {
        this.converter = converter;
    }

    public String doMarkrazi(String src) {
        return converter.convert(src);
    }

}
