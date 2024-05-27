package com.canada.h1bvisa;

import org.springframework.stereotype.Service;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Service
public class AppointmentParser {

    public Boolean parseCanada() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Rooney\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        // Create an instance of ChromeDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to the sign-in page
        driver.get("https://ais.usvisa-info.com/en-ca/niv/users/sign_in");
        driver.manage().window().maximize();

        // Find the username and password input fields and the submit button
        WebElement usernameInput = driver.findElement(By.id("user_email"));
        WebElement passwordInput = driver.findElement(By.id("user_password"));
        WebElement submitButton = driver.findElement(By.name("commit"));

        WebElement element=driver.findElement(By.id("policy_confirmed"));
        Actions act= new Actions(driver);
        act.moveToElement(element).click().build().perform();



        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("policy_confirmed")));
        driver.findElement(By.id("policy_confirmed")).click();*/

        // Enter credentials
        usernameInput.sendKeys("kmsharmausa14@gmail.com");
        passwordInput.sendKeys("Wolverine1$");



        // Click the submit button
        submitButton.click();
        Thread.sleep(10000);
        driver.get("https://ais.usvisa-info.com/en-ca/niv/schedule/36637068/payment");

        Boolean availability = driver.getPageSource().contains("February, 2024") || driver.getPageSource().contains("March, 2024");
        Thread.sleep(10000);

        // Close the browser
        driver.quit();

        return availability;
    }
}
