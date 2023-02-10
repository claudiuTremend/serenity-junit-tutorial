package serenityswag.authenticationJUnit;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLoggingOn {

    WebDriver driver = new ChromeDriver();

    @Test
    public void usersCanLogOnViaTheHomePage() {
        driver.get("https://www.saucedemo.com/");
        //WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login as a standard user
        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        // Should see product catalog
        //webDriverWait.until(presenceOfElementLocated(By.cssSelector(".title")));
        assertThat(driver.findElement(By.cssSelector(".title")).getText()).isEqualToIgnoringCase("Products");
    }

}
