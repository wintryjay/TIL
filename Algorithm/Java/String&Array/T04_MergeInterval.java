/*
# Question 05. MergeInterval (ArrayList, Sort)
    Eng: Given a collection of intervals, merge all overlapping intervals.
    Kor: 간격들의 집합이 있을 때, 겹치는 구간을 모두 병합시키세요.

    input: [[1,3], [2,6], [8,10], [15,18]]
    output: [[1,6], [8,10], [15,18]]
 */

package Algorithm.Java.StringAndArray;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start =s;
        end = e;
    }
}

public class T04_MergeInterval {

    public static void main(String[] args) {
//        int[][] nums = {{1,3}, {2,6}, {8,10}, {15,18}};
        Interval in2 = new Interval(1,3);
        Interval in1 = new Interval(2,6);
        Interval in3 = new Interval(8,10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);
        T04_MergeInterval a  = new T04_MergeInterval();
        List<Interval> list = a.merge(intervals);

        System.out.println("결과값은...");
        a.print(list);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;
        // 1. 담을 그릇
        List<Interval> result = new ArrayList<>();
        // 2. sorting (오름차순)

        print(intervals);
        Collections.sort(intervals, (a,b)->a.start-b.start);
//        Collections.sort(intervals, comp);
        System.out.println("========");
        print(intervals);

        // 3.
        Interval before = intervals.get(0); // [1,3]
        for(int i=1; i<intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(before.end >= current.start) {
                before.end = Math.max(before.end, current.end);
            }else {
                result.add(before);
                before = current;
            }
        }

        if(!result.contains(before)) {
            result.add(before);
        }

        return result;
    }

    void print(List<Interval> list) {
        for(int i=0; i<list.size(); i++) {
            Interval in = list.get(i);
            System.out.println(in.start+" "+in.end);
        }
    }

    Comparator comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };
}
