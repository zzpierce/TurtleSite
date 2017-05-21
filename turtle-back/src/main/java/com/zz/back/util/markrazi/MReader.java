package com.zz.back.util.markrazi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MReader {

    private List<String> bufferList;
    private int index;
    private final String sp = "(\r\n)|(\n)";

    public MReader() {
        this("");
    }

    public MReader(String buffer) {
        this.bufferList = split(buffer);
        this.index = 0;
    }

    public List<String> getList() {
        return this.bufferList;
    }

    public String readLine() {
        if(index >= bufferList.size()) {
            return null;
        }
        return bufferList.get(index ++);
    }

    public void setBuffer(String buffer) {
        this.bufferList = split(buffer);
    }

    private List<String> split(String src) {
        List<String> lineList = new ArrayList<>();
        if(null == src || "".equals(src)) {
            return lineList;
        }
        String[] lines = src.split(sp);

        Collections.addAll(lineList, lines);
        index = 0;
        return lineList;
    }
    


}
