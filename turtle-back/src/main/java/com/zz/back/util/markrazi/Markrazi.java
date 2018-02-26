package com.zz.back.util.markrazi;

public class Markrazi {

    private IConverter converter;

    public Markrazi() {
        converter = new DefaultConverter();
    }

    public Markrazi(IConverter converter) {
        this.converter = converter;
    }

    public String doMarkrazi(String src) {
        return converter.convert(src);
    }

}
