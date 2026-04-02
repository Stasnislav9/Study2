using System.Collections.ObjectModel;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using MovieCatalog.Models;
using MovieCatalog.Services;

namespace MovieCatalog.ViewModels;

public partial class MovieListViewModel : ObservableObject
{
    [ObservableProperty]
    private ObservableCollection<MovieViewModel> _movies = new();

    [ObservableProperty]
    private MovieViewModel? _selectedMovie;

    public MovieListViewModel()
    {
        LoadMovies();
        DeleteMovieCommand = new RelayCommand<MovieViewModel>(DeleteMovie);
    }

    public IRelayCommand<MovieViewModel> DeleteMovieCommand { get; }

    private void LoadMovies()
    {
        var moviesFromService = MovieDataService.GetMovies();
        Movies.Clear();
        foreach (var movie in moviesFromService)
        {
            Movies.Add(new MovieViewModel(movie));
        }
    }

    private void DeleteMovie(MovieViewModel? movie)
    {
        if (movie != null && Movies.Contains(movie))
        {
            Movies.Remove(movie);
        }
    }

    [RelayCommand]
    private void RefreshMovies()
    {
        LoadMovies();
    }
}