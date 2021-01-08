# 인터페이스
 * 인터페이스란 상속 관계가 아닌 클래스에 (추상 클래스처럼)기능을 제공하는 구조
    * 상속관계에 연관성이 없는 기능을 넣고자 할 때 사용
 * 클래스와 비슷한 구조이지만, 정의와 추상 메서드만이 멤버가 될 수 있다는 점이 다르다.
 * 클래스에서 인터페이스를 이용하도록 하게 하는 것을 '인터페이스의 구현'이라고 한다.
 * 인터페이스를 구현하기 위해서는 implements를 사용한다.
 ```java
interface A {
    public static final int a = 2;
    public abstract void say();
}

class B implements A {
    public void say() {
        System.out.println("Hello"); 
    }
}
 ```

 </br>

 * 인터페이스는 다음과 같이 수식자를 생략할 수 있다.
 ```java
interface A {
    public static final int a = 2;
    public abstract void say();
}
// 위의 인터페이스를 보통 아래처럼 사용한다.
interface A {
    int a = 2;
    void say();
}
 ```
 * 인터페이스는 몇 개라도 구현할 수 있다.
 ```java
class X implements A, B, C {

}
// 반면, 상속은 단일 상속만 가능하다. 
class X extends A {

}
 ```
 * 인터페이스는 클래스처럼 상속할 수 있다.
 ```java
 interface A {
     void greeting();
 }

 interface B extends A {
     void goodbye();
 }
 ```
 * 여러개의 인터페이스를 상속하여 새로운 인터페이스를 만들 수 있다.
 ```java
 interface X extends A, B, C {
     ...
 }
 // 상속은, 단일 상속만 가능하다.
 class X extends A {
     ...
 }
 ```

</br>

## 인터페이스의 상속
 * `extends` 와 `implements` : 다른 클래스를 상속하고, 또한 인터페이스를 구현하는 경우에는 다음과 같이 정의한다. (`extends`를 먼저 기술한다.)
 ```java
class C extends A implements B {
    ...
}
 ``` 