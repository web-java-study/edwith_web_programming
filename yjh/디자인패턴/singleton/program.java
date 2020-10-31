package singleton;

// 싱글턴패턴
// 어떤 클래스의 객체가 해당 프로세스에서 하나만 정의 되어야하는 경우
// ex 다크모드
// 어떤 페이지에 있던 세팅값은 하나만

// 싱글턴을 더 안전하게 사용하는 방법이 존재

public class program {
    public static void main(String[] args){

        new FirstPage().setAndPrintSettings();
        new SecondPage().printSettings();

    }
}

