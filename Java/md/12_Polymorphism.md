# 다형성 (폴리모피즘)
 * 판타지 소설에서 드레곤이 폴리모프한다. 라는 것의 그 폴리모피즘을 의미
 * 상속한 클래스의 오브젝트는 슈퍼 클래스로도 서브 클래스로도 다룰 수 있다. 이렇게 하나의 오브젝트와 메서드가 많은 형태를 가지고 있는 것(오버로딩같은것을 통해 많은 메서드가 있음)을 다형성이라고 한다.

</br>

 * 슈퍼 클래스의 오브젝트 생성 : 서브 클래스의 오브젝트는 슈퍼 클래스의 오브젝트에 대입할 수 있다.
 ```java
X a = new Y();
// X: 슈퍼 클래스 명
// Y: 서브 클래스 명
 ```
 * 하위클래스 객체를 상위클래스 객체에 대입하여 사용할 수 있다.
 ```java
 // 추상클래스
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
 ```
 ```java
// MS사 : 윈도우 10에서 사용될 프린터는 다음의 규격을 준수해야 합니다. Printable을 구현해 주세요.
// 아래아한글, MS Word, : 인쇄는 Printable의 Print만 호출하면 되는 군요. 알겠습니다.
// 삼성, 엡손 : 프린터는 Printable 인터페이스 규격에 맞춰 만들겠습니다.

// 인터페이스
interface Printable {
    void print(String doc);
}

class PrnDrvSamsung implements Printable {
    public void print(String doc) {
        System.out.println(doc + "\nFrom Samsung : Black-White Ver");
    }
}

class PrnDrvEpson implements Printable {
    public void print(String doc) {
        System.out.println(doc + "\nFrom Epson : Black-White Ver");
    }
}

public class Polymorphism2 {

    // 제 3의 워드프로세스로 가정
    public static void main(String[] args) {
        String doc = "프린터로 출력을 합니다.";

        Printable prn1 = new PrnDrvSamsung();
        prn1.print(doc);

        Printable prn2 = new PrnDrvEpson();
        prn2.print(doc);

    }
}
 ```

 * 상위클래스의 객체를 하위클래스의 객체로 대입할 수는 없다.

</br>

### 클래스간에 전체적인 계층구조가 필요해서 누구한테 상속받았고 누구에게 상속해줬는지 이런 계층구조가 필요할 때는 추상클래스, 단지 기능만 제공하고 싶을 때에는 인터페이스 사용
 * 이러한 개념적인 구분외에 기능은 100% 호환이 된다. 
 * 디자인 패턴적인 의미에서 추상클래스를 상속받는 것보다는 인터페이스를 사용하여 기능을 제공하는 것을 더 권장
 