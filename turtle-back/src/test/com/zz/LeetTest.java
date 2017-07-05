package com.zz;

import org.junit.Test;

public class LeetTest {

    @Test
    public void test() {

        int[] row = new int[12];

        for(int i = 0; i < row.length; i ++) {
            row[i] = 10 - i;
        }
        row[10] = 1;
        row[11] = 0;

        int mStep = new Solution().jump(row);

        System.out.println(mStep);
    }
}
