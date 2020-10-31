package factory_method;

class Console {

    private CompFactory compFactory = new CompFactory();

    Component comp1;
    Component comp2;
    Component comp3;


    // 단순하게 객체를 선언
    void withoutFactory(){
        comp1 = new Button();
        comp2 = new Switch();
        comp3 = new Dropdown();
    }

    // 팩토리 패턴 정의
    void withFactory(){
        comp1 = compFactory.getComp(Usage.PRESS);
        comp2 = compFactory.getComp(Usage.TOGGLE);
        comp3 = compFactory.getComp(Usage.EXPAND);
    }

    enum Usage{
        PRESS, TOGGLE, EXPAND
    }

    public class withoutFactory {
    }
}
