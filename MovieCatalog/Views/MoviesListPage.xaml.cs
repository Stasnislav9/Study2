namespace MovieCatalog.Views;

public partial class MoviesListPage : ContentPage
{
    public MoviesListPage()
    {
        InitializeComponent();
        BindingContext = App.MainViewModel;
    }

    private async void OnSelectionChanged(object sender, SelectionChangedEventArgs e)
    {
        if (e.CurrentSelection.Count == 0)
            return;

        await Navigation.PushAsync(new MovieDetailPage());

        if (sender is CollectionView cv)
            cv.SelectedItem = null;
    }

    private void OnDeleteButtonClicked(object sender, EventArgs e)
    {
        var button = sender as Button;
        var movie = button?.BindingContext as MovieCatalog.ViewModels.MovieViewModel;

        if (movie != null)
        {
            App.MainViewModel.DeleteMovieCommand.Execute(movie);
        }
    }
}