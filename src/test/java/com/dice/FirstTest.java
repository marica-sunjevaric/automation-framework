package com.dice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void firstTestMethod() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver94\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open dice
        driver.get("https://www.dice.com/");

        System.out.println("Dice opened.");

        driver.quit();
    }

    @Test
    public void secondTestMethod() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver94\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open dice
        driver.get("https://www.linkedin.com/");

        System.out.println("Linkedin opened.");

        driver.quit();
    }
}
