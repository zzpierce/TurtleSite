package com.zz;


import org.junit.Test;

class Solution {

    public int jump(int[] nums) {


        int length = nums.length;
        int[] minStep = new int[length];
        for(int i = 0; i < length; i ++) {
            minStep[i] = Integer.MAX_VALUE - 1;
        }
        minStep[length - 1] = 0;
        for(int i = length - 2; i >= 0; i --) {
            if(i < length - 2 && nums[i] == nums[i + 1] + 1) {
                minStep[i] = minStep[i + 1];
                continue;
            }
            int step = nums[i];
            int realStep = Integer.min(i + step, length - 1);
            for(int j = realStep; j > i; j --) {
                if(minStep[i] > minStep[j] + 1) {
                    minStep[i] = minStep[j] + 1;
                }
            }
        }

        return minStep[0];
    }

}

