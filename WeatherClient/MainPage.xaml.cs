using WeatherClient.Services;

namespace WeatherClient;

public partial class MainPage : ContentPage
{
    public MainPage()
    {
        InitializeComponent();
    }

    private async void OnRefreshClicked(object sender, EventArgs e)
    {
        // Блокируем кнопку и показываем индикатор загрузки
        RefreshButton.IsEnabled = false;
        BusyIndicator.IsRunning = true;
        BusyIndicator.IsVisible = true;

        // Получаем данные о погоде
        var postalCode = PostalCodeEntry.Text ?? string.Empty;
        var weatherData = await WeatherServer.GetWeather(postalCode);

        // Устанавливаем контекст привязки — данные автоматически обновят UI
        BindingContext = weatherData;

        // Разблокируем
        RefreshButton.IsEnabled = true;
        BusyIndicator.IsRunning = false;
        BusyIndicator.IsVisible = false;
    }
}