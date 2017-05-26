package com.zz.back.util.markrazi.trans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslatorContext {

    private int CurrentListLevel;

    private Map<String, String> imageMap;

    public TranslatorContext() {
        setCurrentListLevel(0);
        imageMap = new HashMap<>();
    }

    public int getCurrentListLevel() {
        return CurrentListLevel;
    }

    public void setCurrentListLevel(int currentListLevel) {
        CurrentListLevel = currentListLevel;
    }

    public void putImage(String id, String href) {
        imageMap.put(id, href);
    }

    public String getImage(String id) {
        return imageMap.get(id);
    }
}
