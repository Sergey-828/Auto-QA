package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import support.TestContext;

import java.util.Map;

import static support.TestContext.getDriver;

public class UpsStDefs {
    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() throws InterruptedException {
        getDriver().findElement(By.cssSelector("button.close_btn_thick")).click();
        getDriver().findElement(By.cssSelector("button.ups-alerts_close")).click();
        getDriver().findElement(By.xpath("//span[@class='job-text'][text()='Ship']")).click();
       Thread.sleep(3000);
    }

    @When("I fill out origin shipment fields {string}")
    public void iFillOutOriginShipmentFields(String role) {
        Map<String, String> user = TestContext.getDataByFileName(role);
        getDriver().findElement(By.id("origin-cac_companyOrName")).sendKeys((user.get("username")));
        getDriver().findElement(By.id("origin-cac_singleLineAddress")).sendKeys((user.get("address")));
        getDriver().findElement(By.id("origin-cac_phone")).sendKeys((user.get("phone")));
   }
}

