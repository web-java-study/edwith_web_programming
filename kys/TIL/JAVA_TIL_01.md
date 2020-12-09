## 자바 기초
자바라는 언어를 사용하기위해서는 `JDK(Java Development Kit)` 이라는 도구를 다운받아 설치해야만 한다. JDK 를 설치했다면 설치된 디렉토리의 bin 이라는 하위 디렉토리에 javac 와 java 실행 파일이 있을것이다.
  
javac 는 `java compiler` 의 약자로 바로 자바를 컴파일 할때 사용하는 파일이기도 하다. JDK 를 받는 이유도 바로 이 컴파일을 사용하기 위해서 이다. 자바파일은 `.java`라는 확장자명 파일로 실행할 코드를 작성할 파일 이기도 하다.  
  
자바로 작성한 파일이 실행되기 위해서는 두번의 단계를 거쳐야 한다. .java 가 실행되면 우선 .class 파일로 컴파일 하는 과정이 필요하고 두번째는 이 .class 파일을 실행 해야 한다.
  
javac 실행파일은 컴파일을 실행하고 java 실행파일은 `Java Virtual Machine` 으로 컴파일된 바이너리파일을 읽고 실행하게된다.

### 왜 class 파일인가?
c 나 c++ 언어같은경우 컴파일한결과가 운영체제에서 실행가능한 파일로 생성된다. 다만 각 운영체제에 맞게 컴파일 되기때문에 window 에서 생성한 실행파일을 리눅스 운영체제에서 실행하는것을 불가능하다. 
  
java 같은경우는 가상머신에서 파일을 실행하기위해 .class 파일로 컴파일 하는 과정을 거치게되고 이로인해 모든 운영체제에서 동일한 파일로 실행이 가능하다. 단점은 c 나 c++ 보다 실행속도가 느리다
  
> JAVA  
> 속도는 C 나 C++ 보다 속도는 느리지만 모든 운영체제에서 실행이 가능하다.
  
> C , C++  
> JAVA 보다는 속도는 빠르지만 각 운영체제별 실행파일을 별도로 컴파일해주어야한다.


### 실행해보기
프로그래밍을 시작했다면 `Hello World` 를 찍으면서 시작해야한다(?). 코드작성도구는 인텔리제이를 사용하려고 하며 JAVA 프로젝트를 새로 생성하면 자동으로 Main class 파일이 생성되는데 그 내부에 아래의 코드를 작성하면 된다.
```java
package com.company;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("Hello World"); // 작성한 코드
    }
}
```
실행을 해보면 IDE 하단 실행결과에 Hello World 가 찍히게 된다.
  
- **public**: 메소드의 접근제어자로 누구나 접근 가능
- **static**: static이 지정되어있는경우 이 메소드는 인스턴스 생성없이 실행 가능
- **void**: 리턴값이 없다는걸 나타내는 타입

## 변수
변수는 자료형(type)과 함께 선언하여 사용한다.
```java
int a = 1
String b = 'Hello Java'
```
- int
- long
- double
- boolean
- char
- String
- StringBuffer
- List
- Map

### String 클래스
변수중에 자주 사용하게되는 String 타입이 있는데 이 String 타입은 기본적으로 있는 자바의 변수 타입이 아닌 클래스로 내장된 사용자 정의 자료형이라고 볼 수있다. 때문에 String 은 클래스라고 볼 수 있고 특이하게 다른 클래스와 다르게 인스턴스를 생성하지않고도 사용이 가능하다.
```java
public class StringClassTest {
    String string = 'abc';
}
```

클래스이기때문에 인스턴스 생성하듯이 사용도 가능하다.

```java
public class StringClassTest {
    String string = new String("abc");
}
```

위 코드는 동일하게 abc 를 출력하지만 동작하는 방식은 조금 다르다.

```java
public class StringTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        String str3 = new String("abc");
        String str4 = new String("abc");
        
        System.out.println(str1 == str2); // true
        System.out.println(str3 == str4); // false
    }
}
```
new 생성자를 사용하게되면 str3 과 str4 는 완전히 다른 메모리에 각각 값을 저장하게되기때문에 두 변수를 비교하게되면 틀리다고 나오지만 new 없이 사용하게되면 메모리에서 같은값이 있는지 검색하고 있으면 같은 메모리를 참조하고 새로운 인스턴스를 생성하지않는다. 따라서 str1 과 str2 는 같은 메모리를 바라보고있기때문에 같은값이 될 수 있다.


### 사용자 정의 자료형
JAVA 에서 기본적으로 정의되고 제공하는 자료형말고 사용자가 직접 자료형을 정의하고 사용할 수 있다.

```java
class Student {}

Student son
// son 이라는 변수는 Student 자료형 변수이고 Student 자료형에 해당하는 값만 담을 수 있다.
```

int 타입으로 정의된 변수는 숫자형태의 정해진 범위내에 있는 값들만 입력받을 수 있는것처럼 사용자 정의 자료형도 해당 자료형에 해당하는 값만 담을 수 있다.

## 자료형
자료형중에 자주사용하는 숫자에 해당하는 타입은

- int: 정수표현
- long: 정수표현
- float: 실수표현
- double: 실수표현

네가지가 있다 
  
주의해야할 부분은 float 타입으로 실수를 표현할때는 F를 붙여서 사용해야한다.
```java
float f = 1.23f;
double d = 1.23;
```

### List
```java
ArrayList list = new ArrayList();
list.add('a');
list.add('b');
System.out.println(list); // [a, b]
System.out.println(list.get(0)); // a
System.out.println(list.size()); // 2
```

### Generics(제네릭스)
제네릭스를 사용하면 위의 List 사용법을 아래와같이 사용할 수 있다.
```java
ArrayList<String> list = new ArrayList<String>();
```
그렇다면 이 제네릭스를 사용하여 얻는 이점은 무엇일까 바로 타입을 좀더 명확하게 지정해서 사용할 수 있다. 위의 코드를 해석하자면 ArrayList 타입을 가진 list 변수에 포함되는 배열은 스트링만 포함 할 수 있다 라고 해석될 수 있다.
  
이 제네릭스 타입으로 사용할 수 있는 타입에는 String외에도 Integer 그리고 사용자 지정 타입까지 사용가능하다.

### map
map 은 key 와 value 를 사용하여 데이터를 다룬다.
```java
HashMap<String, String> map = new HashMap<String, String>();
map.put("animal", "cat");
map.get("animal"); // cat
map.containsKey("animal") // true
```
map 에는 HashMap 외에도 
- LinkedHashMap
- TreeMap

이있는데 LinkedHashMap 은 입력된 순서대로 데이터가 출력되고  
TreeMap 은 입력된 key의 정렬순으로 데이터가 출력되는 특징이 있다.


