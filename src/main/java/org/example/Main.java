package org.example;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;

import java.nio.charset.StandardCharsets;

public class Main {





    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        APIRequest apiRequest = playwright.request();
        APIRequestContext request = apiRequest.newContext();


        APIResponse response = request.post("https://automationexercise.com/api/createAccount", RequestOptions.create()
                .setHeader("Content-Type", "application/x-www-form-urlencoded").setForm(
                FormData.create()
                        .set("name", "JohnDoe")
                        .set("email", "johndoe@example.com")
                        .set("password", "Test@123")
                        .set("title", "Mr")
                        .set("birth_date", "10")
                        .set("birth_month", "07")
                        .set("birth_year", "1995")
                        .set("firstname", "John")
                        .set("lastname", "Doe")
                        .set("company", "ExampleCorp")
                        .set("address1", "123 Street")
                        .set("address2", "Apt 4B")
                        .set("country", "United States")
                        .set("zipcode", "12345")
                        .set("state", "California")
                        .set("city", "Los Angeles")
                        .set("mobile_number", "+1234567890")
        ));

        System.out.print(response.status());
        System.out.print(response.text());
        playwright.close();




    }






}