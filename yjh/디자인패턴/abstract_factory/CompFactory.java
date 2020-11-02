package abstract_factory;

// 서로 다른 테마들을 같이 쓰지 않음
// 이런 경우 테마별로 팩토리를 만들어 관리하는게 효율적

// 추상이나, 인터페이스로 팩토리를 만들고
// 이를 상속한 테마마다의 팩토리

interface CompFactory{
    public Component getComp(Console.Usage usage);
}

// 라이트 모드
class LightCompFactory implements CompFactory {
    public Component getComp (Console.Usage usage){
        if (usage == Console.Usage.PRESS){
            return new LightButton();
        }
        else if (usage == Console.Usage.TOGGLE){
            return new LightSwitch();
        }
        else {
            return new LightDropdown();
        }
    }
}

// 다크모드
class DarkCompFactory implements CompFactory {
    public Component getComp (Console.Usage usage){
        if (usage == Console.Usage.PRESS){
            return new DarkButton();
        }
        else if (usage == Console.Usage.TOGGLE){
            return new DarkSwitch();
        }
        else {
            return new DarkDropdown();
        }
    }
}