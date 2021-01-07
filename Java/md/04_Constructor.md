# 생성자
 * 생성자란 오브젝트 생성과 함께 자동적으로 호출되는 특수한 메서드
 * 개발자가 생성자를 쓰지 않는 경우, 인수가 없는 생성자가 자동으로 만들어진다. 이를 디폴트 생성자라고 한다.
 ```java
class Book(){
    Book(){ // 개발자가 입력하지 않으면 자동으로 만들어진다.

    }
}
 ```
 * 디폴트 생성자의 특징</br>
 1. 메서드와 같은 모양이지만 반환형이 없다.
 2. 클래스의 이름과 동일한 이름을 갖고 매개변수가 없다.
</br>
</br>
# 생성자 오버로딩
 * 생성자는 가장 흔한 오버로딩의 대상이다.
 ```java
class Book {
    String title;
    int price;

    Book() { // 매개변수가 없는 디폴트 생성자
        title="자바 클래스 기초";
        price = 10000;
    }

    Book(String title, int price) { // 매개변수가 두 개인 생성자
        this.title = title;
        this.price = price;
    }
}
 ```
 * 개발자가 매개 변수가 있는 생성자를 만든 경우, 디폴트 생성자를 호출하면 에러가 발생한다.
    * 이 경우, 매개 변수가 없는 디폴트 생성자를 호출하기 위해서는 디폴트 생성자도 같이 구현해줘야 한다.
```java
class Book {
    String title;
    int price;

    Book(String title, int price) {
        this.title = title;
        this.price = price;
    }
}

public class MyBook {

    public static void main(String[] args) {
        
        Book book = new Book(); // 이렇게 생성하면 에러가 발생

        // 위에서 인자를 넣어줬기때문에 이렇게 넣어줘야 함
        Book book = new Book("자바 디자인 패턴", 20000); 
    }
}
```
</br>

# 복제 생성자
 * 동일한 클래스의 오브젝트를 인수로 받아서, 대응하는 필드에 값을 대입하는 생성자를 복제 생성자라고 한다.
 * 객체의 내용을 복사할 때 주로 사용

