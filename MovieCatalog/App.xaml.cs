using MovieCatalog.ViewModels;

namespace MovieCatalog;

public partial class App : Application
{
    public static MovieListViewModel MainViewModel { get; } = new();

    public App()
    {
        InitializeComponent();

        MainPage = new NavigationPage(new Views.MoviesListPage());
    }
}