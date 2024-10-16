package com.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {

    @Test
    public void testSearchFunctionality() {
        WebDriver driver = null;
        try {
            // Set up WebDriver
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // run browser in headless mode
            driver = new ChromeDriver(options);
            driver.get("https://www.example.com");

            // Perform search
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium");
            searchBox.submit();

            // Assert that search results are displayed
            WebElement results = driver.findElement(By.id("searchResults"));
            Assert.assertTrue(results.isDisplayed(), "Search results not displayed");

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit(); // Clean-up code to close the browser
            }
        }
    }
}
