package factory_method;


// 팩토리 패턴

// 객체 생성자가 변경시 모두 찾아서 변경해주는 것이아닌
// 팩토리 클래스에서 관리

// console 개발자들로 하여금 컴포넌트 들에 대해 알 수 없게?

// 사용할 부분만 알려주면 팩토리가 확인하고 제공
//

public class Main {
    public static void main(String[] args){
        new Console().withoutFactory();
        new Console().withFactory();
    }
}
