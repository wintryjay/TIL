package Ex06_AccessRestriction.team1;

import Ex06_AccessRestriction.team2.AnotherClass2;

public class AccessTest {

    public int num1;
    private int num2;
    protected int num3;
    int num4;

    public void test1() {
        System.out.println("test1");
    }
    private void test2() {
        System.out.println("test2");
    }
    protected void test3() {
        System.out.println("test3");
    }
    void test4() {
        System.out.println("test4");
    }

    public static void main(String[] args) {
        // 같은 클래스 내에 있는 멤버변수에는 접근지시자가 모두 접근 가능하다.
        AccessTest at = new AccessTest();
        at.num1 = 1;
        at.num2 = 2;
        at.num3 = 3;
        at.num4 = 4;

         AnotherClass1 ac1 = new AnotherClass1();
         ac1.num1 = 1;
         // ac1.num2 = 2; // private 접근지시자이기 때문에 지다른 클래스에서는 접근할 수 없다.
         ac1.num3 = 3;
         ac1.num4 = 4;

        AnotherClass2 ac2 = new AnotherClass2();
        ac2.num1 = 1;
        // ac2.num2 = 2; // private 접근지시자이기 때문에 다른 클래스, 패키지에서는 접근할 수 없다.
        // ac2.num3 = 3; // protected 접근지시자이기 때문에 다른 패키에서는 접근할 수 없다.
        // ac2.num4 = 4; // default 접근지시자이기 때문에 다른 패키지에서는 접근할 수 없다.


    }
}
