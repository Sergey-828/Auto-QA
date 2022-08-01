package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static support.TestContext.getDriver;

public class calculaTor {
    @When("I navigate to {string}")
    public void iNavigateTo(String calcType) {
        getDriver().findElement(By.xpath("//a[contains(@href,'auto-loan-calculator')][text()='" + calcType + "']")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.id("cloanamount")).clear();
        getDriver().findElement(By.id("cloanterm")).clear();
        getDriver().findElement(By.id("cinterestrate")).clear();
        getDriver().findElement(By.id("cdownpayment")).clear();
        getDriver().findElement(By.id("ctradeinvalue")).clear();
        getDriver().findElement(By.id("csaletax")).clear();
        getDriver().findElement(By.id("ctitlereg")).clear();
    }
    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();

    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        WebElement text = getDriver().findElement(By.xpath("//font[text()='" + error + "']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(text, error));
        String actualText = getDriver().findElement(By.xpath("//font[text()='" + error + "']")).getText();
        Assertions.assertThat(actualText).isEqualTo(error);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String aPrice, String timeMont, String intRate, String dPaym, String tradeIn, String stat, String sTax, String othFees) {
        getDriver().findElement(By.id("cloanamount")).sendKeys(aPrice);
        getDriver().findElement(By.id("cloanterm")).sendKeys(timeMont);
        getDriver().findElement(By.id("cinterestrate")).sendKeys(intRate);
        getDriver().findElement(By.id("cdownpayment")).sendKeys(dPaym);
        getDriver().findElement(By.id("ctradeinvalue")).sendKeys(tradeIn);
        getDriver().findElement(By.xpath("//select[@name='cstate']")).sendKeys(stat);
        getDriver().findElement(By.id("csaletax")).sendKeys(sTax);
        getDriver().findElement(By.id("ctitlereg")).sendKeys(othFees);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String total) {
        WebElement text = getDriver().findElement(By.cssSelector("h2.h2result"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(text, "Monthly Pay:"));
        String actualText = getDriver().findElement(By.xpath("//*[contains(text(),'Monthly Pay:')]")).getText();
        Assertions.assertThat(actualText).contains(total);
    }
}
