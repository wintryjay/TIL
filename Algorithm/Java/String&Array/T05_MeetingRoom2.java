package Algorithm.Java.StringAndArray;

/*
# Question06. MeetingRoom02 (Priority Queue, MinHeap, a.end-b.end)
    Eng: Given an array of meeting time intervals consisting of start and ened times[[s1, e1], [s2,e2],...](si < ei), find the minimum number of conference rooms required.
    Kor: 시작 시간과 종료 시간[[[s1, e1], [s2,e2],...(si <ei)로 구성된 일련의 미팅 시간 간격이 주어진 경우, 최소한으로 필요한 회의실의 갯수를 구하시오.

    Input: [[0, 30], [5, 10], [15, 20]]
    Output: 2

    Input: [[7, 10], [2, 4]]
    Output: 1

# Flow
    1. Sorting (Start Time)
    2. hold.end > cur.start
*/

import java.lang.reflect.Array;
import java.util.*;

class Interval05 {
    int start;
    int end;

    Interval05() {
        start=0;
        end=0;
    }
    Interval05(int s, int e) {
        start = s;
        end = e;
    }


}

public class T05_MeetingRoom2 {

    public static void main(String[] args) {
        Interval05 in1 = new Interval05(5,10);
        Interval05 in2 = new Interval05(15, 20);
        Interval05 in3 = new Interval05(0, 30);

        Interval05[] interval05s = {in1, in2, in3};
        T05_MeetingRoom2 a = new T05_MeetingRoom2();
        System.out.println(a.solve2(interval05s));
    }

    // 시간범위에 있는 minHeap으로 poll()
    public int solve2(Interval05[] interval05s) {
        if(interval05s == null || interval05s.length==0 ) return 0;
        // 1. data 그릇
        Arrays.sort(interval05s, (a, b) -> (a.start - b.start));

        Queue<Interval05> minHeap = new PriorityQueue<>(interval05s.length, (a, b)->(a.end-b.end));
        int max = 0;

        // 2. for
        for(int i=0; i<interval05s.length; i++) {
            while(!minHeap.isEmpty() && minHeap.peek().end <= interval05s[i].start) {
                minHeap.poll();
            }
            minHeap.offer(interval05s[i]); // [0, 30] 들어간다.
            System.out.println(minHeap.size());
            System.out.println(max);
            System.out.println("====");
            max = Math.max(max, minHeap.size());
            System.out.println(max);
            System.out.println("########");
        }
        return max;

    }
}
