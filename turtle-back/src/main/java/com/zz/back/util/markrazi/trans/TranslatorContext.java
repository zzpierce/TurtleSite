package com.zz.back.util.markrazi.trans;

public class TranslatorContext {

    private int CurrentListLevel;

    public TranslatorContext() {
        setCurrentListLevel(0);
    }

    public int getCurrentListLevel() {
        return CurrentListLevel;
    }

    public void setCurrentListLevel(int currentListLevel) {
        CurrentListLevel = currentListLevel;
    }
}
