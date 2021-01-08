# 클래스와 오브젝트의 응용
 * `instanceof` 는 오브젝트가 지정한 클래스의 오브젝트인지를 조사하기 위한 연산자이다.
 ```java
boolean flag = c instanceof X;
// c : 오브젝트명
// X : 클래스명
// 왼쪽 오브젝트(c)가 오른쪽 클래스(X) 또는 서브 클래스의 오브젝트라면(=관계가 있으면) true
 ```
 * `instanceof` 는 지정한 인터페이스를 오브젝트가 구현하고 있는지를 조사할 수도 있다.
 ```java
boolean flac = c instanceof Y;
// c : 오브젝트명
// Y : 인터페이스명
// 왼쪽 오브젝트(c)가 오른쪽 인터페이스를 구현하고 있으면 true
 ``` 