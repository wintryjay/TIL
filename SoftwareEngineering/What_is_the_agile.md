 > 취업준비를 하면서, 가보고 싶은 곳의 공고를 확인해보다가 애자일개발론을 추구한다는 말에 애자일이 뭐지? 하고 찾아봤는데, </br>
 정리해두면 좋을 것 같아서 공부도 할겸 여러 정보를 찾아보고 정리해보고자 한다. </br>
	 <details>
		<summary> 참고자료 </summary>
		<div markdown="1">
		* [KOCW](http://www.kocw.net/home) 한세대학교 김유석 교수님의 [애자일개발론](http://www.kocw.net/home/cview.do?mty=p&kemId=1314883) 참고 </br>
		* [KOCW](http://www.kocw.net/home) 얀양대학교 장진욱 교수님의 [소프트웨어 개발 프로세스](http://www.kocw.net/home/search/kemView.do?kemId=1330838&ar=relateCourse) 참고 </br>
		* [KOCW](http://www.kocw.net/home) 동국대학교 최은만 교수님의 [소프트웨어공학 개론](http://www.kocw.net/home/search/kemView.do?kemId=1300178&ar=relateCourse) 참고 </br>
		* ikso2000님의 포스팅 [소프트웨어 개발론](https://ikso2000.tistory.com/53) 참고 </br>
		* ZDNetKorea 전규현님의 [소프트웨어 개발방법론의 함정](https://zdnet.co.kr/view/?no=20091129180815) 참고
		</div>
	</details>
	
# What is the meaning of agile?
 * Agile is usually defined as moving quickly and lightly.
 	* 통상적으로 빠르고 가볍게 움직이는 것을 의미한다.
	
## Agile 하면 생각나는 것들
	* pair coding(짝 코딩) : 하나의 모니터로 함께 코딩하는 것
	* Kanban Board : 할 일/ 하고있는 일/ 끝난 일 등을 분류하는 것
	[Agile과 관련된 용어](https://ehawaii.github.io/AccessHawaiiCommittee/AnnualReport2014/attachments/18884776/27099267.jpg)
		* 용어는 그냥 용어일 뿐, 너무 깊게 알지 않아도 괜찮다.
	
## "Agile" 이란?
	* 프로젝트의 생명주기(life cycle)동안, 반복적인 개발을 촉진한다.
		* 애자일 방법론은 소프트웨어 개발 방법에 있어서 아무런 계획이 없는 개발 방법과, 계획이 지나치게 많은 개발 방법들 사이에서
		  타협점을 찾고하 하는 방법론이다.

## Agile과 관련된 용어
	* "SCRUM" : 순차적인것이 아닌 동시에 시작하는 것
	* "BACKLOG" : 우선 순위가 정해진 목록이나 프로덕트를 만들기 위해 생성된 모든 기록을 의미한다. 
		* "Product Backlog"는 제품을 만들 때 나온 모든 것을 의미한다. ex) 코드, 주석, 녹음파일, 기록물 등
	* "SPRINT" : 달려가는 것
	* "Lean" : 중요한 개념은 JIT(Just In Time)으로 필요한 시점에 필요한 만큼만 생산하는 것을 의미
	* "Kanban" : 일종의 작업지시서로서 한 번에 진행되는 일의 수를 제한함으로써 지속적인 배포에 초점을 맞추고, 더 효율적으로 만들어 준다.
		* 할 일(To-Do)
		* 하고있는 일(WIP, Work in Process): WIP은 갯수 제한이 필요. 개발자들이 소화할 수 있는 양을 맞춰야 최대효율을 낼 수 있기 때문이다.
		* 끝난 일(Compelete)
	* "Code Review" : 코드리뷰는 남을 까는 것이 목적이 아니다. 내가 도와줌으로써 더 나은 결과물을 낼 수 있도록 하는 것이다.
	* "CI(Continuous Integration)" : 팀이 작업한 소스코드, DB Script, 코드 검사, 자동화 테스트 등을 가능하면 자주 통합하는 소프트웨어 개발 실천법
		* 자주 통합하고 검증함으로써 최신 코드가 항상 건강한 상태인지 확인할 수 있으며, 통합 주기를 짧게 가져감으로써 오류 발생 시 원인 파악을 신속하게 할 수 있다.
		* 최소 하루 한 번 이상 통합을 진행하는 것을 권장한다.
		* 자동화된 빌드를 통해 가능한 빨리 통합 에러가 없는지 검증하는 작업이다.
		* 코드 저장소 : SVN(C-VCS), GIT(D-VCS)
		* CI 통합 서버: Hudson, Jenkins(주로 사용)
		* 빌드 도구 : Ant, Maven, Gradle
		
## Aigle 에 대한 오해와 당부
	* agile은 방법론 그 이상의 것이다.
	* 애자일을 도입하면 빠르게 만들 수 있다? 
		* 짧은 기간에 동작하는 제품(Prototype)을 만들기 때문에 빠르게 만드는 것처럼 보일 수 있다. 애자일은 좋게 만드는 것을 목표로 한다.
	* 프로젝트 성공률을 높여준다?
		* 애자일로 개발한다고 성공률을 높여주지 않는다. 작은 프로젝트가 성공률이 높다. 큰 프로젝트를 작게 나누어서 하는 것이 성공률이 높다.
		* 아이디어와 프로토타입을 통한 데이터 산출, 그리고 다시 이를 활용한 아이디어 개발이 프로젝트의 성공에 큰 영향을 준다.
	* XP(eXtreme Programing) : 불확실성을 어떻게 해결할 것인가?에 대한 애자일에서의 용어로, 팀원들이 함께 팀의 가치와 원칙, 실천방안을 만들고 실천하는 것이 중요하다.
		* Values: 어떠한 가치를 둘 것인가?
		* Principles : 가치를 지키기 위한 원칙을 만들어야 한다.
		* Practices: 이 원칙을 지키기 위한 실행을 하고, 습관을 길러야 한다.
	* 종합하면, Agile = Continuous Improvement(지속적인 발전)라고 볼 수 있다.
