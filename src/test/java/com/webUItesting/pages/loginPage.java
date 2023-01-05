package com.webUItesting.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
    WebDriver driver;
    public WebDriverWait wait;
    
By usrnameBy=By.xpath("//*[@id=\"user-name\"]");
By psswdBy=By.xpath("//*[@id=\"password\"]");
By loginButtonBy=By.xpath("//*[@id=\"login-button\"]");
By productListBy = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

public loginPage(WebDriver driver) {
this.driver=driver;
wait = new WebDriverWait(driver, Duration.ofSeconds(60));
}

public loginPage UsernameAndPassword(String username,String password) {

    //entering username
    wait.until(ExpectedConditions.visibilityOfElementLocated(usrnameBy));
    driver.findElement(usrnameBy).clear();
    driver.findElement(usrnameBy).sendKeys(username);

    //entering password
    wait.until(ExpectedConditions.visibilityOfElementLocated(psswdBy));
    driver.findElement(psswdBy).clear();
    driver.findElement(psswdBy).sendKeys(password);

    //clicking login button
    wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy));
    driver.findElement(loginButtonBy).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(productListBy));
    
    return this;
}

}
