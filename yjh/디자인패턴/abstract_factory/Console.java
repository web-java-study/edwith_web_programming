package abstract_factory;

class Console {

    private CompFactory lightCompFactory = new LightCompFactory();
    private CompFactory darkCompFactory = new DarkCompFactory();

    Component comp1;
    Component comp2;
    Component comp3;

    void LightFactory(){
        comp1 = lightCompFactory.getComp(Usage.PRESS);
        comp2 = lightCompFactory.getComp(Usage.TOGGLE);
        comp3 = lightCompFactory.getComp(Usage.EXPAND);
    }

    void DarkFactory(){
        comp1 = darkCompFactory.getComp(Usage.PRESS);
        comp2 = darkCompFactory.getComp(Usage.TOGGLE);
        comp3 = darkCompFactory.getComp(Usage.EXPAND);
    }

    enum Usage{
        PRESS, TOGGLE, EXPAND
    }

}
