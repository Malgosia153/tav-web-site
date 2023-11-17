package by.itacademy.rybalko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OzPagesTest {

    @Test
    public void testNonUser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://oz.by/");
        OzPages ozPages = new OzPages();
        WebElement buttonEnter = driver.findElement(By.xpath(ozPages.buttonEnter));
        buttonEnter.click();
        WebElement emailForm = driver.findElement(By.xpath(ozPages.emailForm));
        emailForm.click();
        Thread.sleep(3000);
        WebElement inputTextMail = driver.findElement(By.xpath(ozPages.inputTextMail));
        inputTextMail.sendKeys("mail");
        Thread.sleep(3000);
        WebElement inputTextPassword = driver.findElement(By.xpath(ozPages.inputTextPassword));
        inputTextPassword.sendKeys("693");
        Thread.sleep(3000);
        WebElement buttonButtonTwoEnter = driver.findElement(By.xpath(ozPages.buttonTwoEnter));
        buttonButtonTwoEnter.click();
        Thread.sleep(3000);
        WebElement textErrorMail = driver.findElement(By.xpath(ozPages.textErrorMail));
        String actualTextErrorMail = textErrorMail.getText();
        Assertions.assertEquals("Введите корректный адрес электронной почты", actualTextErrorMail);
    }

    @Test
    public void testEnter() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://oz.by/");
        OzPages ozPages = new OzPages();
        WebElement buttonEnter = driver.findElement(By.xpath(ozPages.buttonEnter));
        buttonEnter.click();
        WebElement fieldEnter = driver.findElement(By.xpath(ozPages.fieldEnter));
        String actualfieldEnter = fieldEnter.getText();
        Assertions.assertEquals("Вход", actualfieldEnter);
    }
}

