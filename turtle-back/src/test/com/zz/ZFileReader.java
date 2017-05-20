package com.zz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ZFileReader {

    public static String read(String path) {
        StringBuilder builder = new StringBuilder("");

        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String bTemp;
            while( null != (bTemp = bufferedReader.readLine())) {
                builder.append(bTemp).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

}
