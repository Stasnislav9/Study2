using Microsoft.Maui.ApplicationModel.Communication;
using Microsoft.Maui.Devices.Sensors;

namespace GroceryLoyalApp;

public partial class MainPage : ContentPage
{
    public MainPage()
    {
        InitializeComponent();
    }

    private async void OnCallClicked(object sender, EventArgs e)
    {
        try
        {
            if (PhoneDialer.Default.IsSupported)
            {
                PhoneDialer.Default.Open("+74951234567");
                StatusLabel.Text = "📞 Звоним в магазин...";
            }
            else
            {
                await DisplayAlert("Ошибка", "Звонки не поддерживаются", "OK");
            }
        }
        catch (Exception ex)
        {
            await DisplayAlert("Ошибка", ex.Message, "OK");
        }
    }

    private async void OnLocationClicked(object sender, EventArgs e)
    {
        try
        {
            var status = await Permissions.RequestAsync<Permissions.LocationWhenInUse>();

            if (status != PermissionStatus.Granted)
            {
                await DisplayAlert("Нет доступа", "Разрешите доступ к геолокации", "OK");
                return;
            }

            var location = await Geolocation.Default.GetLocationAsync();

            if (location != null)
            {
                StatusLabel.Text = $"📍 Координаты: {location.Latitude:F2}, {location.Longitude:F2}";

                // Открываем карту с меткой магазина
                var storeLocation = new Location(55.7558, 37.6176);
                var options = new MapLaunchOptions
                {
                    Name = "Ближайший магазин"
                };
                await Map.Default.OpenAsync(storeLocation, options);
            }
        }
        catch (Exception ex)
        {
            await DisplayAlert("Ошибка", ex.Message, "OK");
        }
    }

    private async void OnOfferClicked(object sender, EventArgs e)
    {
        StatusLabel.Text = "🎁 Скидка 15% на фрукты сегодня!";
        await DisplayAlert("Спецпредложение", "Скидка 15% на фрукты сегодня!", "OK");
    }
}