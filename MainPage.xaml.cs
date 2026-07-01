using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Maui.Controls;
using TodoList.Models;
using TodoList.Services;

namespace TodoList.Views;

public partial class MainPage : ContentPage
{
    private readonly RestService _restService;
    private List<TodoItem> _allItems;

    public MainPage()
    {
        InitializeComponent();
        _restService = new RestService();
        _allItems = new List<TodoItem>();
    }

    private async void OnLoadButtonClicked(object sender, EventArgs e)
    {
        statusLabel.Text = "Loading...";
        _allItems = await _restService.RefreshDataAsync();

        if (_allItems != null && _allItems.Any())
        {
            todoCollectionView.ItemsSource = _allItems;
            statusLabel.Text = $"Loaded {_allItems.Count} items";
        }
        else
        {
            statusLabel.Text = "No items found or error occurred";
        }
    }

    private async void OnDeleteButtonClicked(object sender, EventArgs e)
    {
        var button = sender as Button;
        var item = button?.BindingContext as TodoItem;

        if (item != null && !string.IsNullOrEmpty(item.Id))
        {
            await _restService.DeleteTodoItemAsync(item.Id);
            _allItems.Remove(item);
            todoCollectionView.ItemsSource = null;
            todoCollectionView.ItemsSource = _allItems;
            statusLabel.Text = $"Deleted: {item.Name}";
        }
        else
        {
            statusLabel.Text = "Delete: This is a demo (API doesn't support DELETE)";
        }
    }
}