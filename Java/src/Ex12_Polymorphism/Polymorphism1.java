package Ex12_Polymorphism;

abstract class Calc {
    int a = 5;
    int b = 6;

    abstract void plus();
}
class MyCalc extends Calc {
    void plus() {
        System.out.println(a+b);
    }
    void minus() {
        System.out.println(a-b);
    }
}
public class Polymorphism1 {

    public static void main(String[] args) {
        MyCalc myCalc = new MyCalc();
        myCalc.plus();
        myCalc.minus();

        // 하위클래스 객체를 상위클래스 객체에 대입
        Calc mycalc2 = new MyCalc();
        mycalc2.plus();
            // 다음 메서드는 클래스에 없기때문에 에러 발생
//        mycalc2.minus();

    }
}
