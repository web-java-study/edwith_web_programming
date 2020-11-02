package strategy;

// interface는 그자체로 객체를 만들 수 없지만
// 특정 interface를 implements를 한다면
// 기능을 꼭 정의해야함.

// 각 기능의 알고리즘이 변경되거나,
// 새로운 기능이 추가될 경우 여기서 관리

interface SearchStrategy {
    void search();
}

class SearchStrategyAll implements SearchStrategy{
    public void search(){ System.out.println("Search ALL"); }
}

class SearchStrategyImage implements SearchStrategy{
    public void search(){
        System.out.println("Search IMAGE");
    }
}

class SearchStrategyNews implements SearchStrategy{
    public void search(){
        System.out.println("Search NEWS");
    }
}

class SearchStrategyMap implements SearchStrategy{
    public void search(){
        System.out.println("Search MAP");
    }
}


class SearchStrategyVV implements SearchStrategy{
    public void search(){
        System.out.println("Search VV");
    }
}

