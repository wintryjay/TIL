/*
 # Question01. MeetingRoom01
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

Package String&Array;


class Interval{ // 01. 먼저 아래처럼 시작시간과 종료시간을 담아주는 클래스를 만들어주는 것이 시작.
    int start;
    int end;

    Interval(){ // 02. Se s = New Se();로 초기화하면 시작과 종료시간은 둘다 0이다. 
        start=0;
        end=0;
    }

    Interval(int start, int End){ // 03. Se e = new Se(0,10); 하지만 클래스에 start, end 인수를 넣어주면 시작과 종료 시간이 정해진다.
        this.start=start;
        this.end=end;
    }
}

public class MeetingRooms {
    public static void main(String[] args){
        // 04. 문제에서 제시한 3가지 시작, 종료 시간 세트를 생성해준다.
        Interval se1 = new Interval(15, 20);
        Interval se2 = new Interval(5, 10);
        Interval se3 = new Interval(0, 30);

        // 05. 그리고 세트를 Se 배열에 담아준다.
        Interval[] Intervals = {se1, se2, se3};

        // 참고 : 이런식으로 Se는 String과 같이 하나의 객체가 되었기 때문에 이렇게 사용할 수 있다.
        String string1 = "string1";
        String string2 = "string2";
        String[] s = {string1, string2};

        // 06. 위에 미팅룸 전체를 받아왔기 때문에 미팅룸 안에 만든 solve 메소드를 사용할 수 있다.
        MeetingRoom m = new MeetingRoom();
        System.out.println(m.solve(Interval));
    }

    public boolean solve(Interval[] Intervals){ // 07. solve 메소드는 Se 배열을 받아와서

        // 08. Se 배열이 비어있다면 false를 반환하고
        if (Interval == null){ 
            return false;
        }
        
        // 09. 그게 아니라면 Se[] 배열을 오름차순으로 정렬한다.
        Arrays.sort(Intervals, Comp); 
        // sort() 메서드의 2번째 인자에서 Comparator를 익명클래스로 전달하여 정렬기준을 재정의하는 것
        // 이렇게 하면 ses 가 start 기준으로 오름차순이 된다. [[0, 30], [5, 10], [15, 20]]

        // 10. 오름차순이 되었으므로, 앞의 종료시간이 뒤의 시작 시간과 겹치는지를 확인해줘야 한다.
        for(int  i=1; i<Interval.length; i++){
            if(Interval[i-1].end > Interval[i].start){
                return false;
            }
        }
        return true;
    }
    
    Comparator<Interval> Comp = new Comparator<Interval>(){ 
        // Comparable과 Comparator 는 정렬과 관련된 인터페이스로 sort() 메소드 관련
        // 객체의 비교기준을 정해서 정렬 시켜주기 위해. Comparable 인터페이스 필요
        @Override
        public int compare(Interval se1, Interval se2){
            return se1.start - se2.start; // 시작 시간이 정렬 기준
        }
    };

    public void print(Interval[] Intervals){ // 각각 콘솔창에서 확인하는 용도
        for(int i=0; i<Intervals.length;i++){
            Interval a =Intervals[i];
            System.out.println(a.start+ " " + a.end);
        }
    }

}
