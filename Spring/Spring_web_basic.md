# Spring_intro
 * 인프런 - [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://inf.run/MysH)
 > 목차
 1. [정적 컨텐츠](#정적-컨텐츠)
 2. [MVC와 템플릿 엔진](#MVC와-템플릿-엔진)
 3. [API](#API)
 4. [View 환경설정](#View-환경설정)
 5. [빌드하고 실행하기](#빌드하고-실행하기)
 
 
## 스프링 웹 개발 기초
  * 웹을 개발한다는 것은 크게 3가지 방법이 있다.
    * 정적 컨텐츠 : 서버에서 하는 것 없이 파일을 그대로 웹 브라우저에 내려주는 것
    * MVC와 템플릿 엔진 : JSP, PHP 처럼 템플릿엔진(서버에서 프로그래밍해서 HTML을 동적으로 바꿔서 내려주는 것)사용해서 개발
      * 파일을 그대로 전달 vs 서버에서 변형해서 HTML을 바꿔서 내려주는 것
    * API : JSON 포맷을 이용해서 내려주는 것 
      * Vue.js, React 를 사용할 때도 사용
      * 서버끼리 통신할 경우에도 사용
  
### 정적 컨텐츠(Static Content)
  * 스프링 부트는 정적 컨텐츠 기능을 자동으로 제공
  * [이동](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-static-content)</br>
  `src/main/resources/static/hello-static.html` -> http://localhost:8080/hello-static.html
  ```html
  <!DOCTYPE HTML>
  <html>
  <head>
    <title>static content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  </head>
  <body>
  정적 컨텐츠 입니다.
  </body>
  </html>
  ```
  * 정적 컨텐츠 이미지(수정예정)
  <img src = "https://user-images.githubusercontent.com/76747747/103715544-3c7f5080-5004-11eb-8288-f6212045eb0a.png" width="600px"></br>
  
### MVC와 템플릿 엔진(모델2)
  * MVC: Model, View, Controller
  * Controller
    * 비즈니스 로직 또는 내부적인것을 처리하는데 집중해야한다.
  ```java
  @Controller
  public class HelloController{
   
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // 입력값을 넣어준다
      model.addAttribute("name", name); // 모델에 담아준다.
      return "hello-template"; // 템플릿으로 넘어간다.
  }
  ```
  * View</br>
    * View 단은 화면을 그리는데에만 집중해야한다.
    * thymeleaf의 장점: 서버없이 구현물을 확인할 수 있다.
  `resources/template/hello-template.html`
  ```html
  <html xmlns:th="http://www.thymeleaf.org">
  <body>
  <p th:text="'hello '+${name}">hello! empty</p>
  </body>
  </html>
  ```
  * 실행
    * [이동](http://localhost:8080/hello-mvc?name=spring)</br>
  * MVC, 템플릿 엔진 이미지
    <img src = "https://user-images.githubusercontent.com/76747747/103723765-211d4100-5016-11eb-9eb8-c813019c720e.png" width="600px"></br>
