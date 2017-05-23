package com.zz;

import com.zz.back.util.markrazi.Markrazi;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkraziTest {

    @Test
    public void test() {
        String mdSrc = ZFileReader.read("C:\\Ideaprojects\\TurtleSite\\turtle-back\\src\\test\\com\\raw\\test.md");
        //System.out.println(mdSrc);

        Markrazi markrazi = new Markrazi();
        String target = markrazi.doMarkrazi(mdSrc);

        System.out.println(target);
    }


    @Test
    public void regexTest() {
        String src = "# yoyocheck it out";
        Pattern p = Pattern.compile("^# [^\n]*");
        Matcher m = p.matcher(src);

        if(m.matches()) {
            System.out.println(m.group(0));
        } else {
            System.out.println("NOTHING");
        }
    }
}
