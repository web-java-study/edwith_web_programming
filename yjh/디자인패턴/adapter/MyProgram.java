package adapter;

public class MyProgram {
    private SearchButton searchButton = new SearchButton(this);

    // 각 버튼에 대응되는 부분

    public void setModeAll(){
        searchButton.setSearchStrategy(new SearchStrategyAll());
    }
    public void setModeImage(){
        searchButton.setSearchStrategy(new SearchStrategyImage());
    }
    public void setModeNews(){
        searchButton.setSearchStrategy(new SearchStrategyNews());
    }
    public void setModeMap(){
        searchButton.setSearchStrategy(new SearchStrategyMap());
    }
    public void setModeMovie(){
        searchButton.setSearchStrategy(new SearchFindAdapter(new FindMovieAlgorithm()));
    }

    public void testProgram(){
        searchButton.onClick();
        setModeImage();
        searchButton.onClick();
        setModeNews();
        searchButton.onClick();
        setModeMap();
        searchButton.onClick();
        setModeAll();
        searchButton.onClick();
        setModeMovie();
        searchButton.onClick();
    }
}
