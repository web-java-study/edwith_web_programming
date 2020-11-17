package adapter;

public class SearchButton {
    private MyProgram myProgram;

    public SearchButton (MyProgram _myProgram){
        myProgram = _myProgram;
    }

    private SearchStrategy searchStrategy = new SearchStrategyAll();

    // setter를 활용하여 검색전략을 바꾸면서 관리
    public void setSearchStrategy(SearchStrategy _searchStrategy){
        searchStrategy = _searchStrategy;
    }

    public void onClick(){
        // searchStrategy 객체의 search 기능만 사용
        searchStrategy.search();
    }
}


