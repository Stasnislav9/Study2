using Microsoft.Maui.Controls;
using People.Models;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace People.Views;

public partial class MainPage : ContentPage
{
    public MainPage()
    {
        InitializeComponent();
    }

    private async void OnAddPerson(object sender, EventArgs e)
    {
        string name = nameEntry.Text;
        if (string.IsNullOrWhiteSpace(name))
        {
            statusLabel.Text = "Please enter a name.";
            return;
        }

        await App.PersonRepo.AddNewPerson(name);
        statusLabel.Text = App.PersonRepo.StatusMessage;
        nameEntry.Text = string.Empty;
    }

    private async void OnGetAllPeople(object sender, EventArgs e)
    {
        List<Person> people = await App.PersonRepo.GetAllPeople();
        peopleCollectionView.ItemsSource = people;
        statusLabel.Text = App.PersonRepo.StatusMessage ?? $"Loaded {people.Count} people.";
    }
}