using WeatherClient.Models;

namespace WeatherClient.Services;

public static class WeatherServer
{
    private static readonly Random _random = new();

    public static async Task<WeatherData> GetWeather(string postalCode)
    {
        await Task.Delay(1000);

        if (string.IsNullOrWhiteSpace(postalCode) || postalCode.ToLower() == "error")
        {
            return new WeatherData
            {
                Condition = WeatherType.Cloudy,
                Temperature = 32.0,
                Humidity = 80,
                Precipitation = 0.5,
                Wind = 10.0
            };
        }

        var seed = postalCode.GetHashCode();
        var rng = new Random(seed);

        return new WeatherData
        {
            Condition = rng.Next(2) == 0 ? WeatherType.Sunny : WeatherType.Cloudy,
            Temperature = rng.Next(-10, 110),
            Humidity = rng.Next(20, 95),
            Precipitation = Math.Round(rng.NextDouble() * 2, 1),
            Wind = Math.Round(rng.NextDouble() * 30, 1)
        };
    }
}