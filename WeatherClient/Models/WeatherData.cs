namespace WeatherClient.Models;

public record WeatherData
{
    public WeatherType Condition { get; init; }
    public double Temperature { get; init; }
    public int Humidity { get; init; }
    public double Precipitation { get; init; }
    public double Wind { get; init; }
}