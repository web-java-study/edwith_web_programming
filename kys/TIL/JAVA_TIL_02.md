## 자바의 객체지향 프로그래밍

- 클래스, 객체, 인스턴스
- 상속
- 인터페이스
- 다형성
- 추상화

### class
```java
public class Student {}

Student son = new Student();
```

위의 코드는 가장 기본적인 클래스 선언과 사용 형태이며 `new Student()` 를 선언함으로써 객체가 만들어진다. son 은 객체라고 부를수있고 son 은 Student 의 인스턴스라고도 부를 수도 있다. 
  
위와같이 빈 클래스를 만들어두면 여러개의 객체를 생성할 수 있다.
```java
Student son = new Student();
Student son1 = new Student();
Student son2 = new Student();
```

### class 확장
```java
public class Student {
    // 객체변수, 인스턴스변수, 멤버 변수 라고도 부른다.
    String name;

    public static void main(String args[]) {
        Student son = new Student();
        System.out.println(son.name); // null
    }
}
```

아직 name 객체변수에 어떤값도 할당해주지 않았기때문에 출력값은 null이 나온다. 

```java
public class Student {
    // 객체변수, 인스턴스변수, 멤버 변수 라고도 부른다.
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]) {
        Student son = new Student();
        son.setName("brown");
        System.out.println(son.name); // null
    }
}
```

위의 코드는 Student 클래스에 리턴값이 없는 setName 메소드를 생성하여 인자값으로 name을 전달받아 객체 변수에 인자로 넘어온값을 할당해준다. 그리고 main 메소드에서 생성한 객체에서 setName을 사용하여 값을 전달할 수 있다.