package com.algorithms.twopointers;

import java.util.ArrayList;




public class NC_BM89 {

    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param intervals Interval类ArrayList
     * @return Interval类ArrayList
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // write code here
        int i = 0;
        int j = 1;
        if (intervals.size() < 2) {
            return intervals;
        }
        ArrayList<Interval> result = new ArrayList<>();
        while (j <= intervals.size()) {


            j ++;
        }


        return result;
    }
}