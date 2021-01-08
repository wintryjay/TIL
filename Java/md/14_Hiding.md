# 은닉화
 * 클래스는 객체에 대해서 설계도와 같은 개념으로 받아들이면 된다.
    * 클래스를 이용한다는 것은 어떻게든 객체지향 프로그래밍을 하고 있다는 말과 같다.
    * 이런 객체의 기능을 설계도화 하기위해서는 객체의 기능을 잘 모아야 하는데 이를 캡슐화라고 한다.
    </br>객체와 관련된 데이터, 기능만을 한데 모아 놓는다는 이야기다. 
 * 클래스를 이용한 객체지향 프로그래밍을 할 때, 객체의 변수를 public으로 설정하면, 외부에서 마음대로 이 변수를 사용할 수 있기때문에 문제가 발생할 수 있다.
    * 의도하지 않은 범위의 값을 넣을 수 있다.
    * 원하지 않는 데이터타입을 강제적으로 형변환하여 넣을 수도 있다.

 * 이러한 문제점을 방지하기 위해 변수를 private으로 설정하고, setter를 통해 값을 입력시 검증을 받게 한다.
    * 그리고 private이라 접근이 안되기 때문에 getter를 통해서 값을 가져갈 수 있도록 해준다.
 ```java
public class Student {
    public int age;
    public String name;
    ...
}
Student student = new Student();
student.age = -10; // -10 살이 가능하거나..
student.name = new String("32"); // 이름에 숫자를 넣을 수도 있다...
 ```

</br>

 ## 은닉화와 Getter, Setter

```java
// 키워드 this 사용하기
// 클래스의 은닉화 : 
// - 변수에 직접적인 접근을 막는다.
// - getter, setter를 통해 변수에 접근한다.

class SimpleBox {
    private int num; // 변수를 private으로 은닉화 시켜준다.

    SimpleBox(int num) {
        this.num = num;
    }

    public int getNum() { // Getter 생성
        return num;
    }

    publi void setNum(int Num) { // Setter 생성
        this.num = num + 1;
    }
}
```