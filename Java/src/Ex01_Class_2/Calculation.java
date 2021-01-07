package Ex01_Class_2;

// 클래스에 메서드만 있는 경우 (데이터는 없고 동작만 하는 클래스)

class Calc{
    int add(int a, int b){
        return a+b;
    }
}

public class Calculation {

    public static void main(String[] args) {
        // 객체 생성
        Calc calc = new Calc();

        // 메서드 호출
        int nReturn = calc.add(3, 9);

        System.out.println("3+9="+nReturn);
    }
}
