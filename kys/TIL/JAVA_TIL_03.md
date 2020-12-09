## 자바에 있는 여러가지 기능
- 패키지
- 접근제어자
- 정적 변수와 메소드(static)
- 예외처리
- 쓰레드

## 패키지
패키지는 폴더를 이용하여 연관있는것들끼리 묶어서 정리하는 개념과 비슷하다. 자바에서는 비슷한 성격의 클래스끼리 묶어서 모아놓는 곳이라고 볼 수 있다. 

```java
package java.student;

public class sienceStudent {}
```

```java
package java.student;

public class mathStudent {}
```

**사용법**
```java
import java.student.historyStudent; // historyStudent 클래스만 사용
// or
import java.student.*; // java.student 패키지에 있는 모든 클래스 사용
```

만약 같은 패키지내의 클래스라면 별도의 import 를 사용할 필요없이 바로 사용 가능하다.


## 접근제어자
4가지 접근 제어자
1. private : 해당 클래스 내에서만 접근 가능
2. default : 해당 패키지 내에서만 접근 가능
3. protected : 해당 패키지 내에서 그리고 해당 클래스를 상속받은 외부패키지의 클래스에서 접근 가능
4. public : 어떤 클래스에서라도 접근 가능

위의 숫자 순서대로 아래로 갈수록 접근 범위가 넓어진다.


## static
항상 값이 변하지 않을 변수라면 static 을 사용하여 변수를 만들 수 있다.
```java
public class test {
    static String lastName = 'KANG';
}
```
위와같이 static을 사용하여 얻을 수 있는 이점은 메모리에 딱 한번만 할당되기 때문에 메모리 사용에 있어서 성능상 이점을 얻을 수 있다. 그리고 같은곳의 메모리주소를 항상 바라보고있기 때문에 static 변수의 값을 공유할 수 있다.

```java
public class Counter {
    int count = 0;
    Counter() {
        this.count++;
        System.out.println(this.count);
    }

    public static void main(String[] args) {
        Counter counter = new Counter(); // 1
        Counter counter2 = new Counter(); // 1
    }
}
```
위와같인 staitc을 사용하지 않았을경우는 counter 와 counter2 가 서로 다른 메모리를 가르키고 있기때문에 변수의 공유가 되지않아 각각 1이 출력된다.

```java
public class Counter {
    static int count = 0; // static 추가
    Counter() {
        this.count++;
        System.out.println(this.count);
    }

    public static void main(String[] args) {
        Counter counter = new Counter(); // 1
        Counter counter2 = new Counter(); // 2
    }
}
```
변수에 static 을 추가하게되면 count변수가 하나의 메모리에 지정되어 변수를 공유할 수 있기때문에 count 값의 증가된 결과값이 출력된다.