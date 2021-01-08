# 클래스 정의 대상의 public 과 default 선언이 갖는 의미
 * public : 어디서든 인스턴스 생성이 가능하다.
 ```java
 public class AAA {
     ...
 }
 ```
 * dafault : 동일 패키지로 묶인 클래스 내에서만 인스턴스 생성을 허용한다.
 ```java
 class ZZZ {
     ...
 }
 ```
</br>

# 인스턴스 멤버 대상의 접근 수준 지시자(접근 제한자) 선언
 * `public`, `protected`, `private`, `(default)` 4가지로 변수와 메서드 앞에 지정할 수 있다.
 ```java
 class AAA {
     public int num1;
     protected int num2;
     private int num3;
     int num4; // default 선언
 
    public void md1() {..}
    protected void md2() {..}
    private void md3() {..}
    void md4() {..} // default 선언
 }
 ```
 
 * 인스턴스 멤버 대상 접근 수준 지시자 정리</br>

 <!-- table -->
 |지시자|클래스 내부|동일 패키지|상속 받은 클래스|이외의 영역|
 |:--:|:--:|:--:|:--:|:--:|
 |**private**|O|X|X|X|
 |**default**|O|O|X|X|
 |**protected**|O|O|O|X|
 |**public**|O|O|O|O|