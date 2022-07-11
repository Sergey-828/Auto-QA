package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @Given("I go to {string} page")
    public void iOpenPage(String page) {
        getDriver().get("https://skryabin.com/market/quote.html");

    }

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
    }



