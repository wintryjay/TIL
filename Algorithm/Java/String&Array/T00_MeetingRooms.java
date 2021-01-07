package Algorithm.Java.StringAndArray;

/*
# Question01. MeetingRoom01 (String)
    Eng: Given an array of meeting time intervals consisting of start and ened times[[s1, e1], [s2,e2],...](si < ei), determine if a person could attend all meetings.
    Kor: 시작 시간과 종료 시간[[[s1, e1], [s2,e2],...(si <ei)로 구성된 일련의 미팅 시간 간격이 주어진 경우, 사용자가 모든 미팅에 참석할 수 있는지 확인합니다.

    Input: [[0, 30], [5, 10], [15, 20]]
    Output: false
    - 미팅룸의 사용 시간이 겹치면 False

    Input: [[7, 10], [2, 4]]
    Output: true
    - 미팅룸의 사용 시간이 겹치지 않으면 True

# Flow
    1. Sorting (Start Time)
    2. Hold.end > Cur.start
*/

import java.util.Arrays;
import java.util.Comparator;

class Interval{ // 01. 먼저 아래처럼 시작시간과 종료시간을 담아주는 클래스를 만들어준다.

    int start;
    int end;

    Interval(){ // 02. 초기화
        this.start = 0;
        this.end = 0;
    }

    Interval(int s, int e){ // 03. 인자값을 넣어줄 수 있다.
        this.start = s;
        this.end = e;
    }
}

public class T00_MeetingRooms{
    public static void main(String[] args) {
        T00_MeetingRooms a = new T00_MeetingRooms();

        // 04. 문제에서 제시한 3가지 시작, 종료 시간 세트를 생성
        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(0,30);

        // 05. 배열에 넣어주고
        Interval[] intervals = {in1, in2,in3};

        // 06. 미팅룸 전체를 받아왔기때문에, 그 안에 만든 solve 메소드(아래)를 사용해준다.
        System.out.println(a.solve(intervals));

        // 참고 : 이런식으로 Se는 String과 같이 하나의 객체가 되었기 때문에 이렇게 사용할 수 있다.
        String string1 = "string1";
        String string2 = "string2";
        String[] s = {string1, string2};
    }

        // 07. solve 메소드를 생성해준다. solve 메소드는 interval배열을 인자값으로 받는다.
    public boolean solve(Interval[] intervals) {

        // 08. 인자값이 비어있으면 false 반환.
        if(intervals == null) {
            return false;
        }
        print(intervals);

        // 09. 배열을 Compartor 클래스로 전달하여 정렬기준을 바꿔준다(오름차순으로)
        // sort(input1, input2) :: sort()메소드는 input1의 값을 input2 방식으로 정렬해준다.
        Arrays.sort(intervals, Comp);
        System.out.println("===after sort====");
        print(intervals); // [[0, 30], [5, 10], [15, 20]]

        // 10. 오름차순이 되었으므로, 앞의 종료시간이 뒤의 시작시간과 겹치는지 확인해줘야 한다.
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i-1].end >intervals[i].start)
                return false;
        }
        return true;


    }

    // 11. 콘솔창에서 테스트를 통해 확인해보자.
    public void print(Interval[] intervals) {
        for(int i=0; i<intervals.length; i++) {
            Interval in = intervals[i];
            System.out.println(in.start+" "+in.end);

        }
    }

    // 12. sort() 해주기 위해서(=객체의 비교 기준을 정하기 위해서 ) Comparable 인터페이스가 필요하다.
    Comparator<Interval> Comp = new Comparator<Interval>() {

        @Override
        public int compare(Interval a, Interval b) {
            // TODO Auto-generated method stub
            return a.start - b.start; // 시작 시간이 정렬기준이므로, 결과값 >0 이면, 오름차순, 낮으면 내림차순이 된다.
        }

    };
}
