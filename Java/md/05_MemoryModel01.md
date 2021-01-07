# 자바 가상머신(JVM)은 운영체제 위에서 동작한다.
 * JVM은 운영체제로부터 할당받은 메모리 공간을 기반으로 자바 프로그램을 실행해야 한다.
 * JVM은 운영체제로부터 할당받은 메모리 공간을 이용해서 자기 자신도 실행하고, 자바 프로그램도 실행한다.

</br>

# 자바 가상머신의 메모리 모델
 * 메모리 공간 활용의 효율성을 높이기 위해 메모리 공간을 3개의 영역으로 구분한다.</br>
 1. 메서드 영역(Method Area)
    * 메서드의 바이트 코드, static 변수
 2. 스택 영역(Stack Area)
    * 지역변수, 매개변수
 3. 힙 영역(Heap Area)
    * 인스턴스(객체)

</br>

## 바이트코드(Bytecode)
 * 바이트코드는 고급 언어로 작성된 소스 코드를 가상머신이 이해할 수 있는 중간 코드로 컴파일한 것을 말한다.
 * 가상머신은 이 바이트코드를 각각의 하드웨어 아키텍처에 맞는 기계어로 다시 컴파일한다. 어셈블리에 가까운 형태를 띄고 있다.
    * 자바 바이트 코드: 자바 가상머신에 의해 실행되는 코드
    ```java
    outer:
    for (int i=2; i<1000; i++) {
        for (int j=2; j<i; j++) {
            if (i%j == 0) {
                coutinue outer;
            }
        }
        System.out.println (i);
    }
    ```

    ```java
    iconst_2
    istore_1
    iload_1
    sipush 1000
    if_icmpge
    iconst_2
    ...
    ```

## 메서드 영역
 * 메서드의 자바 바이트코드는 JVM이 구분하는 메모리 공간 중에서 메서드 영역에 저장된다.
 * static으로 선언된 클래스 변수도 메서드 영역에 저장된다.
 * **이 영역에 저장된 내용은 프로그램 시작 전에 로드되고 프로그램 종료 시 소멸된다.**
 ```java
class Boy {
    static int average = 0; // 메서드 영역에 저장된다.
    public void Run() {

    }
}

class MyMain {
    public static void main(String[] args) { // 메서드 영역에 저장된다.
        Boy b = new Boy();
        Boy.average += 5;
        ...
    }
}
 ```

## 스택 영역
 * 매개변수, 지역변수가 할당되는 메모리 공간
 * 프로그램이 실행되는 도중에 임시로 할당되었다가 바로 이어서 소멸되는 특징이 있는 변수가 할당된다.
 * **이 영역에 저장된 변수는 해당 변수가 선언된 메서드 종료 시 소멸된다.**
 ```java
public static void main(String[] args) {
    int num1 = 10; // 
    int num2 = 20; // 
    adder(num1, num2);
    System.out.println("end of program");
}

public static void adder(int n1, int n2) { // 매개변수
    int result = n1 + n2; // 지역변수 result
    return result;
}
 ```
 * 지역변수는 스택에 할당된다.
 * 스택에 할당된 지역변수는 해당 메서드를 빠져 나가면 소멸된다.
 * 할당 및 소멸의 특성상 그 형태가 장작을 쌓는 것과 유사해서 스택이라 이름 지어졌다.
 * 할당 및 소멸의 특성상 메서드 별 스택이 구분된다!
 * LIFO(Last In, First Out)

## 힙 영역
 * 인스턴스(객체)가 생성되는 메모리 공간
 * JVM에 의한 메모리 공간의 정리(Garbage Collection)가 이뤄지는 공간
 * 할당은 프로그래머가, 소멸은 JVM이 처리한다.
 * 참조변수에 의한 참조가 전혀 이뤄지지 않는 인스턴스가 소멸의 대상이 된다.</br>
 따라서 JVM은 인스턴스의 참조관계를 확인하고 소멸할 대상을 선정한다.
 ```java
public static void simpleMethod() {
    String str1 = new String("My String"); // 참조 변수 str1(스택영역) -(참조)-> 인스턴스 "My String" (힙 영역) 
    String str2 = new String("Your String"); // 참조
    ...
    str1 = null; // 참조 관계 소멸
    str2 = null; // 참조 관계 소멸
}
 ```
 * 가비지 컬렉션의 대상이 되는 영역이다.
 * 참조 관계가 끊어진 인스턴스는 접근이 불가하기에 가비지 컬렉션의 대상이 된다.

### Garbage Collection에 대한 추가 설명
 * GC는 한 번도 발생하지 않을 수 있다.
 * GC가 발생하면, 소멸의 대상이 되는 인스턴스는 결정되지만 이것이 실제 소멸로 바로 이어지지는 않는다.
 * 인스턴스의 실제 소멸로 이어지지 않은 상태에서 프로그램이 종료될 수 도 있다. </br>
 종료되면 어차피 인스턴스는 소멸 된다.
 ```java
System.gc(); // Garbage Collection 명령, 수집만 하게 됨
System.runFinalization(); // GC에 의해서 소멸이 결정된 인스턴스를 즉시 소멸시키는 명령어(실제 소멸)
 ```

 * 같은 객체를 참조하고 있는 참조변수의 경우, 값을 잘못 바꾸면 참조하고 있는 모든 변수의 값이 바뀌게 되므로 주의해야 한다.