# 스태틱의 이해
 * static은 필드와 메서드에 붙이는 제한자이다.
    * 프로그램 시작 전, 메모리에 로딩된다.
    * 오브젝트를 생성하지 않고도 필드, 메서드 사용이 가능하다.
    * 이 때, 오브젝트에서 참조하기 위해서는 오브젝트 이름이 아닌 클래스명을 지정한다.

</br>

## 필드의 스태틱
 * 같은 클래스에서 생성된 오브젝트들은 static을 붙인 필드의 값을 공유한다.
 ```java
class A {
    static int a;
}
...
    // a1, a2 는 서로 다른 객체지만, 
    A a1 = new A();
    A a2 = new A();
...
    // a1.a 와 a2.a는 서로 같은 변수를 공유한다.
    a1.a = 50;
    a2.a = 10;
 ```

 </br>

 ## 메서드의 스태틱
  * 어떤 오브젝트에서도 같은 동작을 하는 메서드는 static 키워드를 붙여주는 것이 좋다.
    * 한 번만 생성이 된다.
  * static을 붙인 메서드는 다음과 같은 성질을 가진다.
    * static 메서드는 오버라이딩 할 수 없다. (한 번만 생성이 되기 때문에)
    * static 메서드에서 동일한 오브젝트 내의 멤버를 이용하기 위해서는 멤버(필드, 메서드)에게 static을 붙여야만 한다.

</br>

## 예제 01
```java
class Cat {
    static int a = 5;
    int num = 3;

    void print(int num3) {
        System.out.println("a:"+a);
        num=num3;
        System.out.println("num:"+num);
    }
}

public class StaticEx1 {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 2;
        System.out.println(num1 + ", " + num2);
        System.out.println();

        Cat cat1 = new Cat();
        cat1.num = 1;
        cat1.a = 10;
        cat1.print(20);
        System.out.println(cat1.num);
        System.out.println(cat1.a);
        System.out.println();

        Cat cat2 = new Cat();
        cat2.num = 2;
        cat2.a = 11;
        cat2.print(20);
        System.out.println(cat2.num);
        System.out.println(cat2.a);
        System.out.println(cat1.a);
    }
}
```

## 예제 02
 * 스태틱은 프로그램이 시작하기 전에 먼저 메모리에 올라가고, 스태틱 영역에 있는 것이 동작한다.  
```java
import java.util.Random;

public class StaticEx2 {

    static int num;

    // static 초기화 블록
    static {
        Random rand =new Random();
        // main 실행 전 이미 난수 값이 대입 된다.
        num = rand.nextInt(100);
    }

    public static void main(String[] args) {
        System.out.println(num);
    }
}
```

</br>

## System.out.println()에서 out 과 println의 정체는?
 * `java.lang.System`.out.println(...);
    * System은 java.lang 패키지에 묶여 있는 클래스의 이름</br>
      그러나 컴파일러가 다음 문장을 삽입해 주므로 java.lang을 생략할 수 있다.
      </br>`import java.lang.*;`
 * System.`out`.println(...);
    * out은 클래스 System의 이름을 통해 접근하므로, 이는 System 클래스의 클래스 변수 이름임을 유추할 수 있다.
 * System.out.`println(...);`
    * println 은 out이 참조하는 인스턴스의 메소드이다.

</br>

## main 메서드가 public이고 static인 이유는?
 * public `static` void main(String[] args) { ...}
    * static 인 이유 : 인스턴스 생성과 관계없이 제일 먼저 호출되는 메서드이다.</br>
      중복된 메서드가 있으면 안되기 때문이다. 오버라이딩이 일어나지 않는다 = 메서드가 딱 한 존재한다는 것
 * `public` static void main(String[] args) { ...}
    * public 인 이유 : JVM에게 main 메서드를 보여주고 실행 시킬 수 있도록 하기 위함이다. 
    </br>호출 명령은 외부로부터 시작되는 명령이다. 단순히 일종의 약속으로 이해해도 괜찮다.