# Spring_intro
 * 인프런 - [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](https://inf.run/MysH)
 > 목차
 1. [사전 준비](#사전-준비)
 2. [IntelliJ](#IntelliJ)
 
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
