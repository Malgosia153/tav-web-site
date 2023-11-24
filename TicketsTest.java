package by.itacademy.rybalko;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TicketsTest {
    @Test
    public void testTickets() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pass.rw.by/ru/");
        Tickets tickets = new Tickets();
        WebElement buttonEnter = driver.findElement(By.xpath(tickets.buttonEnter));
        buttonEnter.click();
        Thread.sleep(3000);
        WebElement fieldAvtorize = driver.findElement(By.xpath(tickets.fieldAvtorize));
        String actualfieldAvtorize = fieldAvtorize.getText();
        Assertions.assertEquals("Авторизация", actualfieldAvtorize);
    }

    @Test
    public void testFieldEmpty() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pass.rw.by/ru/");
        Tickets tickets = new Tickets();
        WebElement buttonEnter = driver.findElement(By.xpath(tickets.buttonEnter));
        buttonEnter.click();
        Thread.sleep(3000);
        WebElement buttonTwoEnter = driver.findElement(By.xpath(tickets.buttonTwoEnter));
        buttonTwoEnter.click();
        Thread.sleep(3000);
        WebElement textErrorLogin = driver.findElement(By.xpath(tickets.textErrorLogin));
        String actualTextErrorLogin = textErrorLogin.getText();
        Assertions.assertEquals("Заполните поле", actualTextErrorLogin);
        Thread.sleep(3000);
        WebElement textErrorPassword = driver.findElement(By.xpath(tickets.textErrorPassword));
        String actualTextErrorPassword = textErrorPassword.getText();
        Assertions.assertEquals("Заполните поле", actualTextErrorPassword);
    }

    @Test
    public void testFieldPasswordEmpty() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pass.rw.by/ru/");
        Tickets tickets = new Tickets();
        WebElement buttonEnter = driver.findElement(By.xpath(tickets.buttonEnter));
        buttonEnter.click();
        Thread.sleep(3000);
        WebElement inputTextLogin = driver.findElement(By.xpath(tickets.inputTextLogin));
        inputTextLogin.sendKeys("mail");
        Thread.sleep(3000);
        WebElement buttonTwoEnter = driver.findElement(By.xpath(tickets.buttonTwoEnter));
        buttonTwoEnter.click();
        Thread.sleep(3000);
        WebElement textErrorPassword = driver.findElement(By.xpath(tickets.textErrorPassword));
        String actualTextErrorPassword = textErrorPassword.getText();
        Assertions.assertEquals("Заполните поле", actualTextErrorPassword);
    }

    @Test
    public void testNotUser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pass.rw.by/ru/");
        Tickets tickets = new Tickets();
        WebElement clickQuestion = driver.findElement(By.xpath(tickets.clickQuestion));
        clickQuestion.click();
        Thread.sleep(3000);
        WebElement buttonEnter = driver.findElement(By.xpath(tickets.buttonEnter));
        buttonEnter.click();
        Thread.sleep(3000);
        WebElement inputTextLogin = driver.findElement(By.xpath(tickets.inputTextLogin));
        inputTextLogin.sendKeys("mail");
        Thread.sleep(3000);
        WebElement inputTextPassword = driver.findElement(By.xpath(tickets.inputTextPassword));
        inputTextPassword.sendKeys("456");
        Thread.sleep(3000);
        WebElement buttonTwoEnter = driver.findElement(By.xpath(tickets.buttonTwoEnter));
        buttonTwoEnter.click();
        Thread.sleep(3000);
        WebElement textError = driver.findElement(By.xpath(tickets.textError));
        String actualTextError = textError.getText();
        Assertions.assertEquals("Пользователь не найден", actualTextError);
    }
}
