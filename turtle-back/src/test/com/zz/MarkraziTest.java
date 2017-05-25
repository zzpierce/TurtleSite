package com.zz;

import com.zz.back.util.markrazi.Markrazi;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkraziTest {

    @Test
    public void test() {
        String mdSrc = ZFileReader.read("C:\\Ideaprojects\\TurtleSite\\turtle-back\\src\\test\\com\\raw\\test2.md");
        //System.out.println(mdSrc);

        Markrazi markrazi = new Markrazi();
        String target = markrazi.doMarkrazi(mdSrc);

        System.out.println(target);
    }


    @Test
    public void regexTest() {
        String src = ZFileReader.read("C:\\Ideaprojects\\TurtleSite\\turtle-back\\src\\test\\com\\raw\\test2.md");
        Pattern p = Pattern.compile("!\\[[^\\]]+\\]\\[[\\d]+\\]");
        Matcher m = p.matcher(src);

        while(m.find()) {
            String d = m.group(0);
            System.out.println(d);
        }
    }
}
