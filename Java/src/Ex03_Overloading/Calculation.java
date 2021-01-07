package Ex03_Overloading;

// 오버로딩: 클래스에 같은 이름의 메서드가 여러개 존재
class Calc{
    int add(int a, int b){
        return a+b;
    }
    int add(int a){
        return a+1;
    }
    double add(double a, double b){
        return a+b;
    }
}

public class Calculation {

    public static void main(String[] args) {
        Calc calc = new Calc();

        int nReturn1 = calc.add(1);
        int nReturn2 = calc.add(1,2);
        double nReturn3 = calc.add(1.0,2.0);

        System.out.println(nReturn1);
        System.out.println(nReturn2);
        System.out.println(nReturn3);
    }
}
