using System.Text.Json;
using MovieCatalog.Models;

namespace MovieCatalog.Services;

public static class MovieDataService
{
    private static readonly string _moviesJson = @"
    [
        { ""Id"": 1, ""Title"": ""Inception"", ""Genre"": ""Sci-Fi"", ""Year"": 2010, ""Director"": ""Christopher Nolan"", ""Description"": ""A thief who steals corporate secrets through dream-sharing technology."", ""PosterUrl"": ""inception.png"" },
        { ""Id"": 2, ""Title"": ""The Matrix"", ""Genre"": ""Sci-Fi"", ""Year"": 1999, ""Director"": ""Lana Wachowski, Lilly Wachowski"", ""Description"": ""A computer hacker learns about the true nature of reality."", ""PosterUrl"": ""matrix.png"" },
        { ""Id"": 3, ""Title"": ""Interstellar"", ""Genre"": ""Sci-Fi"", ""Year"": 2014, ""Director"": ""Christopher Nolan"", ""Description"": ""A team of explorers travel through a wormhole in space."", ""PosterUrl"": ""interstellar.png"" },
        { ""Id"": 4, ""Title"": ""The Godfather"", ""Genre"": ""Drama"", ""Year"": 1972, ""Director"": ""Francis Ford Coppola"", ""Description"": ""The aging patriarch of an organized crime dynasty transfers control to his reluctant son."", ""PosterUrl"": ""godfather.png"" },
        { ""Id"": 5, ""Title"": ""Pulp Fiction"", ""Genre"": ""Crime"", ""Year"": 1994, ""Director"": ""Quentin Tarantino"", ""Description"": ""The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine."", ""PosterUrl"": ""pulpfiction.png"" }
    ]";

    public static List<Movie> GetMovies()
    {
        return JsonSerializer.Deserialize<List<Movie>>(_moviesJson) ?? new List<Movie>();
    }
}