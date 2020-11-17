# Spring Framework
이미 필요한 부분이 다 갖춰져있는 프레임워크 그중에서 스프링 프레임워크를 사용한다.  
모듈화가 잘되어있어서 필요한 부분만 가져다가 사용이 가능하다.

# Spring VS Spring Boot

Spring 에서는 원하는 도구를 사용하려면 dependency 가 어마어마하게 길어진다. 왜냐하면 버전까지 정확하게 지정해 주어야 하기 때문이다.
Spring Boot 는 이미 자주 사용되는 세팅에 대해서 starter 가 존재하고 코드의 길이도 짧아지고 버전관리도 권장버전으로 자동설정된다.

## Spring Boot 를 사용하면
- 간편한 설정
- 편리한 의존성 관리 & 자동 권장 버전 관리
- 내장 서버로 인한 간단한 배포 서버 구축
- 스프링 Security, Data JPA 등의 다른 스프링 프레임워크 요소를 쉽게 사용 



# Spring IOC/DI 컨테이너
## 컨테이너란?
- 컨테이너는 인스턴스의 생명주기를 관리한다.
- 생성된 인스턴스들에게 추가적인 기능을 제공한다.

## IOC 란?
Inversion of Control 의 약자로 제어의 역전이라고도한다.
- 개발자는 프로그램의 흐름을 제어하는 코드를 작성
- 이 흐름의 제어를 개발자가 하는것이 아니라 다른 프로그램이 그 흐름을 제어하는것
- 아직 무슨소린지 잘 모르겠음....

## IoC 용어 정리
### bean
스프링에서 제어권을 가지고 직접 만들어 관계를 부여하는 오브젝트

### bean factory
스프링의 IoC를 담당하는 핵심 컨테이너  
Bean 을 등록 / 생성 / 조회 / 반환 / 관리 한다. 보통 bean factory를 바로 사용하지않고 이를 확장한 application context를 이용한다.

### application context
bean factory를 확장한 IcO 컨테이너  
Bean의 등록  / 생성 / 조회 / 반환 / 관리 기능은 bean factoryㅈ와 같지만 추가적으로 spring의 각종 부가 서비스를 제공한다.  
ApplicationContext 는 application context 가 구현해야하는 interface이며, BeanFactory를 상속한다.

### configuration metadata
application context 혹은bean factory가 IoC를 적용하기 위해 사용하는 메타정보  
스프링의 설정정보는 컨테이너에 어떤 기능을 세팅하거나 조정하는 경우에도 사용하지만 주로 bean을 생성/구성하는 용도로 사용한다.

## DI
Dependency Injection 의존성 주입 이란 뜻을 갖고 있으며 클래스사이의 의존관계를 빈 설정 정보를 바탕으로 컨테이너가 자동으로 연결해주는것을 말함.


# DTO
- DTO란 Data Transfer Object의 약자이다.
- 계층간 데이터 교환을 위한 자바빈즈이다.
- 여기서의 계층이란 컨트롤러뷰, 비지니스 계층, 퍼시스턴스 계층을 의미한다.
- 일반적으로 DTO는 로직을 가지고 있지 않고 순수한 데이터 객체이다.

# DAO
- DAO 란 Data Access Object의 약자로 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 객체이다.
- 보통 데이터베이스를 조작하는 기능을 전담하는 목적으로 만들어진다.

# ConnectionPool
- DB 연결은 비용이 많이든다.
- 커넥션풀은 미이 커넥션을 여러개 맺어둔다.
- 커넥션이 필요하면 커넥션 풀에게 빌려서 사용한 후 반납한다.
- 커넥션을 반납하지 않으면 어떻게 될까?


---

## 스프링 부트 스타터사이트에서 스프링 프로젝트 생성
[스프링부트 스타터 사이트](https://start.spring.io)
![](https://i.ibb.co/C2yyFh5/2020-10-27-9-34-47.png)  

해당 화면과 같이 동일하게 세팅

## API
### @ResponseBody 사용시
HTTP 의 BODY 에 문자 내용을 직접 반환  
기본 객체 처리는 JSON 형태로 자동으로 반환

## 스프링부트 테스트코드 작성 방법
```java
@Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }
```
`@Test` 를 시작으로 테스트코드를 작성하게되고 반환값이 따로 필요없기때문에 void로 작성된다.  
테스트코드는 프로덕션으로 배포되는 코드가 아니므로 한글로 작성되어도 무방하다.  
javascript 에서는 `describe > it > 테스트코드작성` 방식인데 자바는 코드를 짜는것과 동일한 형태로 작성하는것으로 보여진다.
  
given / when / then 형식으로 초반엔 형식을 잡아놓고 작성하는것이 습관만들기에 좋으며 좀더 명확한 테스트코드 작성이 가능하다.


## Spring boot jdbc template
기존에 sql 쿼리를 날리는 코드를 사용하려면 굉장히 긴 코드가 나왔다. 그리고 그 내부에는 꽤 반복적으로 보이는 내용들도 있었다. `spring jdbc template` 는 이러한 반복적이고 긴 코드를 줄이고 쿼리문 작성에만 집중할 수 있도록 만들어준다.
  
close() 을 순서를 신경써가며 만들 필요 없고 try~catch 문같은 복잡한 문법또한 필요없다.

```java
package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {

    //private final을 선언한 변수를 사용하면 재할당하지 못하며, 해당 필드, 메서드 별로 호출할 때마다 새로이 값이 할당(인스턴스화)한다.
    private final JdbcTemplate jdbcTemplate;

    // 생성자가 하나일떄는 오토와이어드 생략 가능
   @Autowired
    public JdbcTemplateMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(key.longValue());
        return member;
    }

    // 테이블을 조회하는 코드는 단 세줄로 구현 가능하다.
    @Override
    public Optional<Member> findById(Long id) {
        List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", memberRowMapper());
    }

    // 여기서 해당하는 파라미터들의 객체를 생성해주는 역할을 한다.
    private RowMapper<Member> memberRowMapper() {
       return (rs, rowNum) -> {
           Member member = new Member();
           member.setId(rs.getLong("id"));
           member.setName(rs.getString("name"));
           return member;
       }
    }
}

```



## edwith 와 인프런 spring 강좌의 프로젝트 구조 차이점
edwith 에서는 DTO와 DAO 를 폴더명으로 만들며 구조를 잡았는데 인프런에서 실무개발자가 해주는 강좌에서는  
controller / domain / repository / service 의 폴더구조로 프로젝트를 진행 하였다.  
  
**controller**  
주로 api 접근에 대한 로직을 작성하는곳으로 `@Controller` 로 명시하고 코드를 작성한다.  
@GetMapping("test") 이러한 형식으로 접근 url을 지정하고 해당 url로 접근시 동작될 코드를 하단에 작성하게된다.  
```java
@GetMapping("hello")
public String hello(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
}
```

**domain**  
해당 프로젝트에서 사용될 값들을 정의하고 모델링하는곳이다. 
```java
public class Member {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

**repository**  
Interface 를 작성하고 작성한 Interface를 토대로 디비와의 연결작업과 쿼리를 컨트롤하는 코드를 작성한다.

  
**service**  
실제 동작하게되는 서비스 로직을 작성하는곳이며 repository에 작성된 쿼리함수들을 실행하고 그 결과값을 리턴하는 로직이 작성된다.


## 정리
정리하자면 Controller 를 통해서 외부 요청을 받고 Service 에서 비즈니스 로직을 작성하고 Repository 에서 데이터를 저장한다.  
이것은 매우 정형화되어있는 하나의 패턴이다.


## Spring 의 Annotation
### @Configuration
pom.xml 대신에 자바코드로 작성되는 설정이며 해당클래스파일은 configuration 이라고 알리고 내부에는 @Bean 을 사용하여 스프링컨테이너에 등록한다.    
- 해당 클래스가 환경 설정과 관련된 파일이라는 것을 알려주는 어노테이션  
- 해당 클래스에 정의된 @Bean이 적용된 메소드는 @Autowired를 통해서 호출

### @Autowired
생성자나 setter메소드 없이 의존성을 주입해서 자동으로 객체를 생성해주는 어노테이션이다.

### @Transactional
해당 클래스 또는 메소드에 트랜잭션을 적용  
DB에 액세스하는 여러 연산들을 하나의 트랜잭션으로 처리하여 오류가 발생하면 자동으로 롤백

### @Service
비즈니스 로직을 담당하는 클래스에 사용

### @Repository
DB 를 다루는 클래스를 다루는곳에서 사용

### @GetMapping, @PostMapping
프론트에서 요청 메소드 형태에 따라 해당 어노테이션을 만나면 메소드를 실행