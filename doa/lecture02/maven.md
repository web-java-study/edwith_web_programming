## Maven (빌드도구)

빌드툴, 빌드할 때 사용할 수 있는 도구, 현재 가장 많이 사용된다고 함.

## 빌드과정 (프로젝트 작업 과정)

프로젝트 생성하고, 라이브러리 설정, 코드작업, 컴파일, 테스트, 패키지 만들기, 배포, 레포팅

→ 이런 반복되는 과정을 효율적으로 도와주는 도구

→ 빌드 과정을 경량화

→ 이클립스나 비주얼 스튜디오는 **IDE** 개발환경, 더 큰 단위의 도구

## CoC

프로그램의 소스파일은 어떤 위치에 있어야 하고, 소스가 컴파일된 파일들은 어떤 위치에 있어야 하는지에 대한 약속

## Maven 자바 프로젝트 생성

C:(Maven 프로젝트 생성할 경로)>mvn archetype:generate -Dgroupld=com.newlecture -Dartifactld=javaprj -DarchetypeArtifactld=maven-archetype-quickstart

- groupld : 프로젝트 충돌 방지, 본인만의 도메인 네임을 사용하는 경우가 많음
- artifactld : 프로젝트명
- maven-archetype-quickstart 라는 프로젝트 구조를 기본으로 한다.

→ 컴파일은 메이븐 상위 디렉터리 경로에서 mvn compile 

java -cp target\javaprj-1.0-SNAPSHOT.jar com.newlecture.App

Hello Maven!

## A Build Lifecycle is Made Up of Phases

수행 단계를 나타낸다.

1. mvn compile
2. mvn test
3. mvn package
