package definitions;

import io.cucumber.java.en.Given;

import static support.TestContext.getDriver;

public class CommonStepDefs {

    @Given("I go to {string} page")
        public void iOpenPage(String page) {
        if ("usps".equals(page)) {
            getDriver().get("https://www.usps.com/");
        }else if ("quote".equals(page)){
            getDriver().get("https://skryabin.com/market/quote.html");
        }else if ("google".equals(page)){
            getDriver().get("https://google.com");
        } else {
            throw new Error("Unsupported page " + page);
        }

    }

}