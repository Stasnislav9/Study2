using Microsoft.Maui.Controls;

namespace Astronomy.Pages;

[QueryProperty(nameof(AstroName), "astroName")]
public partial class AstronomicalBodyPage : ContentPage
{
    private string? astroName;

    public string AstroName
    {
        get => astroName;
        set
        {
            astroName = value;
            UpdateAstroBodyUI(astroName);
        }
    }

    public AstronomicalBodyPage()
    {
        InitializeComponent();
    }

    private void UpdateAstroBodyUI(string bodyName)
    {
        switch (bodyName?.ToLower())
        {
            case "sun":
                lblTitle.Text = "☀️ Sun";
                imgBody.Source = "sun.png";
                lblDescription.Text = "The Sun is the star at the center of our Solar System. It is a nearly perfect sphere of hot plasma, heated to incandescence by nuclear fusion reactions in its core.";
                break;

            case "moon":
                lblTitle.Text = "🌙 Moon";
                imgBody.Source = "moon.png";
                lblDescription.Text = "The Moon is Earth's only natural satellite. It orbits the Earth every 27.3 days and is the fifth-largest satellite in the Solar System.";
                break;

            case "earth":
                lblTitle.Text = "🌍 Earth";
                imgBody.Source = "earth.png";
                lblDescription.Text = "Earth is the third planet from the Sun and the only astronomical object known to harbor life. It is the densest planet in the Solar System.";
                break;

            case "comet":
                lblTitle.Text = "☄️ Halley's Comet";
                imgBody.Source = "comet.png";
                lblDescription.Text = "Halley's Comet is a short-period comet visible from Earth every 75–79 years. It is the only known short-period comet that is regularly visible to the naked eye from Earth.";
                break;

            default:
                lblTitle.Text = "Unknown Body";
                imgBody.Source = "question.png";
                lblDescription.Text = "No information available for this celestial body.";
                break;
        }
    }
}