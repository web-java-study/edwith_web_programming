package factory_method;

// 여기에서 정해진 조건에 맞는 객체를 생성

public class CompFactory {
    public Component getComp (Console.Usage usage){
        if (usage == Console.Usage.PRESS){
            return new Button();
        }
        else if (usage == Console.Usage.TOGGLE){
            return new Switch();
        }
        else {
            return new Dropdown();
        }
    }
}
