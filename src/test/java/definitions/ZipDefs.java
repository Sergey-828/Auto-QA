package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ZipDefs {

    @Given("I go to usps page")
    public void iGoToUspsPage() {
        getDriver().get("https://www.usps.com/");
    }
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress()  {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//*[contains(@href,'input.action')]")).click();
        getDriver().findElement(By.xpath("//*[@class='btn-primary zip-code-home'][contains(text(),'Address')]")).click();
    }
    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String sity, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(sity);
        getDriver().findElement(By.xpath("//select[@id='tState']")).sendKeys(state);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        Thread.sleep(3000);
    }
    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        String actualText = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText();
        assertThat(actualText).containsIgnoringCase(zip);
    }
}
