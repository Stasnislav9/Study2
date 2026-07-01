using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using TodoList.Models;

namespace TodoList.Services;

public class RestService
{
    private readonly HttpClient _client;
    private readonly JsonSerializerOptions _serializerOptions;

    public List<TodoItem> Items { get; private set; }

    public RestService()
    {
        _client = new HttpClient();
        _serializerOptions = new JsonSerializerOptions
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
            WriteIndented = true
        };
    }

    // GET — получение всех задач
    public async Task<List<TodoItem>> RefreshDataAsync()
    {
        Items = new List<TodoItem>();

        try
        {
            HttpResponseMessage response = await _client.GetAsync(Constants.RestUrl);
            if (response.IsSuccessStatusCode)
            {
                string content = await response.Content.ReadAsStringAsync();
                Items = JsonSerializer.Deserialize<List<TodoItem>>(content, _serializerOptions);
            }
        }
        catch (Exception ex)
        {
            Debug.WriteLine($"ERROR: {ex.Message}");
        }

        return Items;
    }

    // POST — создание новой задачи
    public async Task SaveTodoItemAsync(TodoItem item, bool isNewItem = false)
    {
        try
        {
            string json = JsonSerializer.Serialize(item, _serializerOptions);
            StringContent content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage response;
            if (isNewItem)
                response = await _client.PostAsync(Constants.RestUrl, content);
            else
                response = await _client.PutAsync($"{Constants.RestUrl}{item.Id}", content);

            if (response.IsSuccessStatusCode)
                Debug.WriteLine("TodoItem successfully saved.");
        }
        catch (Exception ex)
        {
            Debug.WriteLine($"ERROR: {ex.Message}");
        }
    }

    // DELETE — удаление задачи
    public async Task DeleteTodoItemAsync(string id)
    {
        try
        {
            HttpResponseMessage response = await _client.DeleteAsync($"{Constants.RestUrl}{id}");
            if (response.IsSuccessStatusCode)
                Debug.WriteLine("TodoItem successfully deleted.");
        }
        catch (Exception ex)
        {
            Debug.WriteLine($"ERROR: {ex.Message}");
        }
    }
}