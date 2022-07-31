package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UpsStDefs {
    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() throws InterruptedException {
        getDriver().findElement(By.cssSelector("button.close_btn_thick")).click();
        getDriver().findElement(By.cssSelector("button.ups-alerts_close")).click();
        getDriver().findElement(By.xpath("//span[@class='job-text'][text()='Ship']")).click();
        WebElement resultElement = getDriver().findElement(By.xpath("//label[@for='origin-cac_singleLineAddress']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(resultElement, "Address"));
    }

    @When("I fill out origin shipment fields {string}")
    public void iFillOutOriginShipmentFields(String role) {
        Map<String, String> user = TestContext.getDataByFileName(role);
        getDriver().findElement(By.id("origin-cac_companyOrName")).sendKeys((user.get("username")));
        getDriver().findElement(By.id("origin-singleLineAddressEditButton")).click();
        getDriver().findElement(By.id("origin-cac_addressLine1")).sendKeys((user.get("street")));
        getDriver().findElement(By.id("origin-cac_postalCode")).sendKeys((user.get("zip")));
        getDriver().findElement(By.id("origin-cac_city")).sendKeys((user.get("city")));
        getDriver().findElement(By.id("origin-cac_state")).sendKeys((user.get("state")));
        getDriver().findElement(By.id("origin-cac_email")).sendKeys((user.get("email")));
        getDriver().findElement(By.id("origin-cac_phone")).sendKeys((user.get("phone")));
   }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {
        getDriver().findElement(By.id("nbsBackForwardNavigationContinueButton")).click();
         Thread.sleep(5000);
    }

    @Then("I verify origin shipment fields submitted {string}")
    public void iVerifyOriginShipmentFieldsSubmitted(String role) {
        Map<String, String> user = TestContext.getDataByFileName(role);
        String resultHeading = getDriver().findElement(By.id("origin_showSummaryAddress")).getText();
        assertThat(resultHeading).contains(user.get("username"));
    }
}

