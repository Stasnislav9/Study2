using CommunityToolkit.Mvvm.ComponentModel;
using MovieCatalog.Models;

namespace MovieCatalog.ViewModels;

public partial class MovieViewModel : ObservableObject
{
    private readonly Movie _movie;

    [ObservableProperty]
    private string _title = string.Empty;

    [ObservableProperty]
    private string _genre = string.Empty;

    [ObservableProperty]
    private int _year;

    [ObservableProperty]
    private string _director = string.Empty;

    [ObservableProperty]
    private string _description = string.Empty;

    [ObservableProperty]
    private string _posterUrl = string.Empty;

    public MovieViewModel(Movie movie)
    {
        _movie = movie;
        UpdateProperties();
    }

    private void UpdateProperties()
    {
        Title = _movie.Title;
        Genre = _movie.Genre;
        Year = _movie.Year;
        Director = _movie.Director;
        Description = _movie.Description;
        PosterUrl = _movie.PosterUrl;
    }

    public void UpdateFromMovie(Movie movie)
    {
        _movie.Title = movie.Title;
        _movie.Genre = movie.Genre;
        _movie.Year = movie.Year;
        _movie.Director = movie.Director;
        _movie.Description = movie.Description;
        _movie.PosterUrl = movie.PosterUrl;
        UpdateProperties();
    }
}