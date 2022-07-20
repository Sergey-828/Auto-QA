package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class QuoteStepDefs {


    @And("I print page details")
    public void iPrintPageDetails() {
        getDriver().getCurrentUrl();
        getDriver().getTitle();
        getDriver().getWindowHandles();
        getDriver().getPageSource();
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getWindowHandles());
        System.out.println(getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String res) throws InterruptedException {
        if (res.equals("phone")) {
            getDriver().manage().window().setSize(new Dimension(400, 768));
            Thread.sleep(3000);
        } else if  (res.equals("desktop")) {
            getDriver().manage().window().setSize(new Dimension(1024, 768));
            Thread.sleep(3000);
        }else {
            System.err.println("Incorrect resolution");

        }
    }

        @Given("I fill out required fields")
        public void iFillOutRequiredFields () throws InterruptedException {
            getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
            getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("password");
            getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password");
            getDriver().findElement(By.xpath("//input[@type='number']")).sendKeys("1234567890");
            getDriver().findElement(By.xpath("//input[@name='username']")).clear();
            getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe2");
            getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
            Thread.sleep(3000);

        }

    @And("I {string} third part agreement")
    public void iThirdPartAgreement(String action) {
        getDriver().findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
        switch (action) {
            case "accept" -> getDriver().switchTo().alert().accept();
            case  "decline" -> getDriver().switchTo().alert().dismiss();
            default -> throw new Error("Incorrect action: " + action);
        }
    }

    @And("I fill out contact name {string} and phone {string}")
    public void iFillOutContactNameAndPhone(String name, String phone) {

        getDriver().switchTo().frame("additionalInfo");

//        getDriver().switchTo().frame("anotherFrame");

        getDriver().findElement(By.xpath("//*[@id='contactPersonName']")).sendKeys(name);
        getDriver().findElement(By.xpath("//*[@id='contactPersonPhone']")).sendKeys(phone);

//        getDriver().switchTo().parentFrame();

        getDriver().switchTo().defaultContent();

    }

    @Then("I verify {string} in related documents")
    public void iVerifyInRelatedDocuments(String doc) {

        String originalWindow = getDriver().getWindowHandle();

        getDriver().findElement(By.xpath("//button[contains(@onclick, 'new')]")).click();
        //switch to new window old way
//        for (String handle : getDriver().getWindowHandles()) {
//           getDriver().switchTo().window(handle);
//        }
        //new way
        getDriver().getWindowHandles().forEach(h -> getDriver().switchTo().window(h));
        String docsText = getDriver().findElement(By.xpath("//body")).getText();
        assertThat(docsText).contains(doc);
        //switch back to original window
        getDriver().switchTo().window(originalWindow);
    }
}




