# Maven


### maven pom.xml 구조 파악
```xml
<!-- POM 모델의 버전 -->
<modelVersion>4.0.0</modelVersion>

<!-- 프로젝트를 만들때 입력, 제작자와 회사 단체등을 식별하기 위한것 -->
<groupId>kr.or.connect</groupId> 

<!-- 아티팩트 id는 프로젝트에 할당한 고유 id 이다 -->
<artifactId>mavenweb</artifactId> 

<!-- 프로그램 버전으로 개발중일때는 SNAPSHOT 을 붙여서 사용한다 -->
<version>0.0.1-SNAPSHOT</version>

<!-- 
	jar, war, zip 등을 지정 할 수 있다. 
	JAVA 의 jar 툴을 이용하여 생성된 압축(아카이브) 파일이며 어플리케이션을 쉽게 배포하고 동작시킬 수 있도록 관련 파일들을 패키징 해주는 역할을하는 압축형태를 지정
-->
<packaging>war</packaging>
```

### .jar
Class 와 같은 Java 리소스와 속성파일, 라이브러리 및 엑세서리 파일이 포함되어있다.   
자바 프로젝트를 압축한 파일로 JAR 파일은 플랫폼에 귀속되는 점만 제외하면 WIN ZIP 파일과 동일한 구조이다.

### .war
`servlet / jsp` 컨테이너에 배치할 수 있는 웹 어플리케이션 압축파일 포맷이다.  
Servlet Context 관련 파일들로 패키징 되어 있으며 WAR는 웹 응용프로그램을 위한 포맷이기 때문에 웹 관련 자원만 포함하고 있으며 이를 사용하면 웹 어플리케이션을 쉽게 배포할 수 있다.
  
WEB-INF 및 META-INF 디렉토리로 사전 정의된 구조를 사용하며 웹서버 또는 웹 컨테이너가 필요하다.

------------------

```xml
<!-- pom.xml 에서 사용하는 속성값 등을 모아 둔다 -->
  <properties>
    <!-- 소스의 기본 인코딩 -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

    <!-- 컴파일 버전 설정 -->
    <maven.compiler.source>1.7</maven.compiler.source>

    <!-- 컴파일된 클래스가 JVM 1.7과 호환되려면 target 값이 1.7 이어야한다 -->
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>
```

### dependencies & dependency
`<dependencies>` 는 의존 라이브러리를 한곳에 모아 기술하기 위해 사용  
```xml
<dependencies>
    <dependency>
      <!-- 단위 테스트를 위한 기능을 제공하는 라이브러리 -->
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope> <!-- 컴파일시에 필요 배포시 제외 -->
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version> <!--톰캣이 기본으로 제공하지 않기 때문에 컴파일과 배포할때 모두 필요  -->
    </dependency>
  </dependencies>
```