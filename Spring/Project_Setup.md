# Spring_intro
 * 인프런 - [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://inf.run/MysH)
 > 목차
 1. [사전 준비](#사전-준비)
 2. [IntelliJ](#IntelliJ)
 3. [라이브러리 살펴보기](#라이브러리-살펴보기)
 4. [View 환경설정](#View-환경설정)
 5. [빌드하고 실행하기](#빌드하고-실행하기)
 
## 사전 준비
  * Java 11
  * IDE: IntelliJ 또는 Eclipse
  * [스프링부트 스타터 사이트](https://start.spring.io)로 이동해서 스프링 프로젝트 생성 
    <details markdown="1">
      <summary>접기/ 열기</summary>
         <div>
          </br>
          ㅁ 스프링 부트 기반으로 스프링 관련 프로젝트를 만들어주는 사이트</br>
          </br>
          &nbsp;ㅇ Project(필요한 라이브러리를 가져오고, 빌드하는 라이프사이클을 관리해주는 툴)</br>
            &nbsp;&nbsp;&nbsp;- Maven Project : 과거에 사용</br>
            &nbsp;&nbsp;&nbsp;- Gradle Project : 최근에는 넘어오는 추세</br>
          </br>
          &nbsp;ㅇ Language - Java</br>
          </br>
          &nbsp;ㅇ Spring Boot</br>
            &nbsp;&nbsp;&nbsp;- 2.3.x</br>
          </br>
          &nbsp;ㅇ Project Metadata</br>
            &nbsp;&nbsp;&nbsp;- Group : com.example : com.spring</br>
            &nbsp;&nbsp;&nbsp;- Artifact : 빌드되었을 때 어떤 결과물 = 프로젝트 명과 비슷 : hello-spring</br>
            &nbsp;&nbsp;&nbsp;- Name, Description, Packagename </br>
          </br>
          &nbsp;ㅇ Dependencies(어떤 라이브러리를 땡겨 쓸 것인가?)</br>
            &nbsp;&nbsp;&nbsp;- Spring Web : 웹 프로젝트를 만들것이기에 사용</br> 
            &nbsp;&nbsp;&nbsp;- Thymeleaf : HTML을 만들어주는 탬플릿 엔진</br>
          </br>
          GENERATE : 다운로드
        </div>
    </details>
    
## IntelliJ
  * 구조
    - .idea : IntelliJ 설정 파일
    - gradle : gradle 폴더
    - src : 
      - main : 프로젝트 파일
        - java
        - resources : Java파일을 제외한 모든 파일
      - test : Test Code 가 중요 함
    - .gitignore : 소스코드 관리하는 파일
    - build.gradle : 프로젝트 설정 파일
    - gradlew : 배포 관련
    - gradlew.bat : 배포 관련
  * 현재 상태에서 Application을 실행시키고 포트주소로 들어갔을 때 에러가 나타나면 정상작동한 것이다.
  * cf) 빌드가 Gradle을 통해서 실행될 경우, </br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Preferences > gradle > build and run using, Run tests using 을 IntelliJ IDEA로 바꿔준다.
    * Gradle을 통하지않고, IntelliJ에서 자바를 바로 띄워서 돌려주기에 훨씬 빠르게 작동된다.

## 라이브러리 살펴보기
  * build.gradle을 보면, 초기에는 라이브러리 설정한 것이 몇 개 없다.
    * thymeleaf, web, test 3가지가 있다.
  * External Libraries 는 외부에서 라이브러리를 가져온 것인데 상당히 많다.
    * 요새 Gradle이나 Maven은 의존관계가 있는 라이브러리를 함께 다운로드(관리)해준다.
    * **스프링 부트 라이브러리**
      * Dependencies 는 라이브러리와 의존관계를 알려줌(우리는 spring-boot-starter와 thymeleaf 2가지만 가져왔지만, 엄청 많다.)            
      * spring-boot-starter-web 라이브러리 하나를 땡겨오면, spring-boot-starter에 필요한 라이브러리를 다 가져와 core까지 가져와서</br>
        스프링부트와 관련된 것이 다 세팅이 되서 돌아간다.
        * spring-boot-starter-tomcat: 톰캣(웹 서버)
          * 과거에는 WAS(ex. TOMCAT)를 직접 설치해서 자바 코드를 밀어넣어 웹서버와 개발 라이브러리를 완전히 분리했었음
          * 요즘에는 소스 라이브러리에서 웹서버를 들고 있다(=임베디드.. 내장형) => 톰캣설치하고 더 이상 그러지 않아도 된다.        
      * spring-webmvc: 스프링 웹 MVC
      * spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(View)
      * spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
        * spring-boot-starter-logging 은 현업에서는 system.out.ln으로 출력하면 안되고, log로 출력해야 한다.
          * 로그로 남겨야 심각한 에러를 모아볼 수 있고, 로그파일을 관리할 수 있기 때문이다.
          * spring-boot-starter 쓰면 자동으로 따라옴
          * 최근에는 2가지 조합으로 많이 이용(표준에 가깝다)
            * slf4j : 쉽게 말해 인터페이스
            * logback : 실제 로그를 어떤 구현체로 출력할지는 logback으로 선택 : 성능도 빠르고 지원 기능이 좋기 때문에
    * **테스트 라이브러리**
      * testCompileClasspath : 테스트와 관련된 라이브러리
        * JUnit : 테스트 프레임워크
          * 자바에서는 JUnit 을 많이 사용하기때문에 spring에서도 사용함(JUnit4에서 JUnit5로 넘어가는 추세)
        * mockito : 목 라이브러리
        * assertj : 테스트를 편하게 하기 위해 도와주는 것
        * 핵심은 JUnit Library 이다.
        * spring-test : 는 스프링과 통합해서 테스트할 수 있도록 해주는 라이브러리다.
        
## View 환경설정
  1. Welcome Page 만들기 </br>
    - `resources/static/index.html`에 html 파일을 넣어두면, Welcome Page를 만들어 준다.
  ```html
  <!DOCTYPE HTML>
  <html>
    <head>
      <title>Hello</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <body>
      Hello
      <a href="/hello">hello</a>
    </body>
  </html>
  ```
  2. 스프링 부트가 제공하는 Welcome Page 기능</br>
    - `static/index.html`을 올려두면 Welcome Page 기능을 제공한다.</br>
    - static 폴더에서 index.html을 먼저 찾고, 못찾으면 index 템플릿을 찾은 후, 자동적으로 웰컴페이지를 만들어준다.</br>
    - [메뉴얼 이동](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-welcome-page)
    
  3. thymeleaf 템플릿 엔진</br>
    - 템플릿 엔진을 사용하면, html 구조를 바꿀 수 있다.</br>
    - [thymeleaf 공식 사이트](https://www.thymeleaf.org/)</br>
    - [스프링 공식 튜토리얼](https://spring.io/guides/gs/serving-web-content)</br>
    - [스프링부트 메뉴얼](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-template-engines)

  4. 동작하고 프로그래밍 되는 간단한 화면을 만들어 보자.</br>
  4.1 Contoller 생성</br>
    - Controller :Web Application 의 첫 번째 진입점
  `main/java/hello.hellospring/controller/HelloController`
  ```java
  @Controller
  public class HelloController{
  
    @GetMapping("hello")
    public String hello(Model model){
      model.addAttribute("data", "hello!");
      return "hello";
    }
  }
  ```
  
&nbsp;&nbsp;&nbsp;&nbsp;  4.2 View 생성</br> 
&nbsp;&nbsp;&nbsp;&nbsp;  `resources/templates/helllo.html`
  ```html
  <!DOCTYPE HTML>
  <html xmlns:th="http://www.thymeleaf.org">
  <!-- th: thymeleaf 를 의미하며, 선언하면 Template Engine으로 사용할 수 있다.-->
  <html xmlns:th="http://www.thymeleaf.org">
  <head>
      <title>Hello</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  </head>
  <body>
    <p th:text="'안녕하세요.' + ${data}"> 안녕하세요. 손님</p>
    <!-- 위쪽의 키값인 data에 들어있는 Value값(hello!)이 치환되어 들어간다. -->
  </body>
  </html>
  ```
  * 컨트롤러에서 리턴 값으로 문자를 반환하면 `ViewResolver`가 화면을 찾아서 처리
    * 스프링 부트 템플릿엔진 기본 viewName 매핑이 된다.
    * `resources:templates/`+{ViewName}+`.html`
    
  > 참고: `spring-boot-devtools`라이브러리를 추가하면, `html`파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경 가능</br>
    IntelliJ 컴파일 방법: 메뉴 Build > Recompile
    
 ## 빌드하고 실행하기
  * 빌드를 해서 실제 실행할 수 있는 파일 만들기
    * 서버 배포할 때는 이 파일만 복사해서 서버에 넣어주고, `java -jar`로 실행하면 서버에서 실행된다.
    * 과거에는 서버에 톰캣을 설치하고, 특정 폴더에 WAR 같은 파일을 넣어야 했지만, 지금은 JAR 파일 하나만 넣고 실행시키면 끝이다.
  * 콘솔(파일이 있는 폴더 위치)로 이동</br>
    0. 서버 닫은 후(
    1. `./gradlew build`
      * 잘 안되는 경우: `./gradlew clean build` : 'clean'을 사용하면 build 폴더를 지우고 새롭게 생성한다.
    2. `cd build/libs`
    3. `java -jar hello-spring-0.0.1-SNAPSHOT.jar`
    4. 실행확인
    5. `ls -arlth` 서버 닫기

