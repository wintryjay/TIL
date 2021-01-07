# 패키지 선언이 필요한 상황
 * "B"회사로부터 원(Circle) 개발 의뢰를 받은 "A"회사가 있다. "A"회사에는 Team1과 Team2가 있고, 빠른 개발을 위해서 각 팀이 의뢰를 나눠서 개발을 진행했다. 
    * Team1에게는 원의 넓이를 구하게 했고, Team2에게는 원의 둘레를 구하게 했다.

 * 위의 경우 2가지 문제가 발생한다.
    </br> 1. 공간에서 충돌 : 동일 이름의 클래스 파일은 같은 위치에 둘 수 없다.
    </br> 2. 접근 방법에서 충돌 : 인스턴스 생성 방법에서 두 클래스에 차이가 없다.
    ```java
    // Team1
    public class Circle{
        final double PI = 3.14;
        double rad;

        public void setRad(double r){
            rad = r;
        }

        // 원의 넓이 반환
        public double getArea(){
            return (rad * rad) * PI;
        }
    }
    ```
    ```java
    // Team2
    public class Circle{
        final double PI = 3.14;
        double rad;

        public void setRad(double r){
            rad = r;
        }

        // 원의 둘레 반환
        public double getPerimeter(){
            return (rad * 2) * PI;
        }
    }
</br>

# 패키지 선언
 ```java
 // 파일명: A.java (public을 붙인 클래스와 같은 이름으로 합니다.)
 package pack1; // 패키지명: 파일 첫 머리에 씁니다.

 public class A { // public: 클래스를 다른 패키지에서 이용할 수 있도록 합니다.

 }
 ```
 * 위와 같은 코드를 생성한 후 디렉토리 구조를 살펴보자.
    * ( 상위디렉토리 ) 패키지를 이용하는 파일이 있는 디렉토리
        * ( pack1 ) 디렉토리 명 = 패키지 명 </br>
            &nbsp; ^ 파일 A.java는 이곳에 저장
</br>

## 공간적, 접근적 충돌 해결을 위한 패키지 선언
 * 클래스 접근 방법의 구분
    * 서로 다른 패키지의 두 클래스는 인스턴스 생성 시 사용하는 이름(클래스 변수명)이 다르다.
    * `team1.Circle c1 = new team1.Circle();` 과 `team2.Circle() c2 = new team2.Circle();` 로 나눠지게 된다.

* 클래서의 공간적인 구분
    * 서로 다른 패키지의 두 클래스 파일은 저장되는 위치가 다르다.
    * `src/team1/Circle.java` 와 `src/team2/Circle.java` 로 공간적 구분이 나눠짐

    ```java
    // Team1
    package team1;

    public class Circle{
        final double PI = 3.14;
        double rad;

        public void setRad(double r){
            rad = r;
        }

        // 원의 넓이 반환
        public double getArea(){
            return (rad * rad) * PI;
        }
    }
    ```
    ```java
    // team2
    package team2;
    
    public class Circle{
        final double PI = 3.14;
        double rad;

        public void setRad(double r){
            rad = r;
        }

        // 원의 둘레 반환
        public double getPerimeter(){
            return (rad * 2) * PI;
        }
    }
    ```
</br>

# 패키지 선언 실제 예
 * 패키지 이름은 모두 **소문자**로 구성
 * 인터넷 도메인 이름의 역순으로 이름을 구성
    * `com.company.team1` 또는 `com.company.team2` 와 같은 방식