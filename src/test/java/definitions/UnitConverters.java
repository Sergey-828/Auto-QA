package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.String.*;
import static support.TestContext.getDriver;

public class UnitConverters {

    @When("I would click to {string} button")
    public void iWouldClickToButton(String conv) {
        getDriver().findElement(By.xpath("//a[contains(@href,'" + conv + "')]")).click();
    }


    @And("I would convert {int} {string} to {string}")
    public void iWouldConvertTo(int num, String unitFrom, String unitTo) throws InterruptedException {
        getDriver().findElement(By.xpath("//select[@id='calFrom']/option[text()='" + unitFrom + "']")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']/option[text()='" + unitTo + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='fromVal']")).sendKeys(valueOf(num));

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='calResults']"), valueOf(num)));
    }
}



