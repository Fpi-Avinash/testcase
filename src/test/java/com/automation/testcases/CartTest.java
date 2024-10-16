package com.automation.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddItemToCart() {
        // Navigate to the website
        driver.get("https://www.example.com");

        // Add an item to the cart
        driver.findElement(By.id("add-to-cart-button")).click();

        // Verify the cart is not empty
        String cartText = driver.findElement(By.id("cart-count")).getText();
        Assert.assertEquals(cartText, "1", "Item was not added to the cart correctly.");
    }

    @Test
    public void testRemoveItemFromCart() {
        // Navigate to the website
        driver.get("https://www.example.com");

        // Add an item to the cart
        driver.findElement(By.id("add-to-cart-button")).click();

        // Open the cart
        driver.findElement(By.id("cart-button")).click();

        // Remove the item from the cart
        driver.findElement(By.id("remove-item-button")).click();

        // Verify the cart is empty
        String cartText = driver.findElement(By.id("cart-count")).getText();
        Assert.assertEquals(cartText, "0", "Item was not removed from the cart correctly.");
    }
}
