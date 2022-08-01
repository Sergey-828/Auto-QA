package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class UspsDefs {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    Actions actions = new Actions(getDriver());

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {

        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction')]")).click();

        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sendMenu).perform();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement zipItem = getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href,'zip-code-lookup')]"));
        wait.until(ExpectedConditions.elementToBeClickable(zipItem));
        zipItem.click();
        getDriver().findElement(By.xpath("//a[contains(@class,'btn-primary')][contains(@class,'zip-code-home')][@data-location='byaddress']")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        // getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();

        // no dynamic XPATH
        WebElement stateElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        Select stateSelect = new Select(stateElement);
        stateSelect.selectByValue(state);

        //new Select(getDriver().findElement(By.xpath("//select[@id='tState']"))).deselectByValue(state);
        // No assignment

        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        WebElement resultElement = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        // explicit wait
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(resultElement, zip));

        //  assertThat(result).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sendMenu).perform();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement priceItem = getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[contains(@href,'postcalc.usps.com')]"));
        wait.until(ExpectedConditions.elementToBeClickable(priceItem));
        priceItem.click();

    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String form) {
        WebElement countryElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText(country);

        switch (form) {
            case "Postcard" -> getDriver().findElement(By.xpath("//input[@value='Postcard']")).click();
            case "Flat Rate Envelopes" -> getDriver().findElement(By.xpath("//input[@value='FlatRateEnvelopes']")).click();
            case "Flat Rate Boxes" -> getDriver().findElement(By.xpath("//input[@value='FlatRateBoxes']")).click();
            case "Shape And Size" -> getDriver().findElement(By.xpath("//input[@value='ShapeAndSize']")).click();
            default -> System.err.println("Incorrect shape of Mailing");

        }
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quant) {
        getDriver().findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys(quant);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String price) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        WebElement resultElement = getDriver().findElement(By.xpath("//div[@id='total']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(resultElement, price));

    }

    @Then("I validate {string} zip code exists in each row of the result")
    public void iValidateZipCodeExistsInEachRowOfTheResult(String zip) {
        List<WebElement> resultRows = getDriver().findElements(By.xpath("//div[@id='zipByAddressDiv']//li"));
        for (WebElement row : resultRows) {
            if (row.isDisplayed()) {
                assertThat(row.getText()).contains(zip);
            }
        }
    }

    @When("I perform {string} search")
    public void iPerformSearch(String search) {
        // Mouse over -> enter text from cucumber string -> click enter (push button "ENTER")
        WebElement searchIcon = getDriver().findElement(By.xpath("//li[contains(@class, 'nav-search')]"));
        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        WebElement searchButton = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']/../input[@value='Search']"));
        actions = new Actions(getDriver());
        actions.moveToElement(searchIcon).sendKeys(searchInput, search).click(searchButton).perform();
        //sendKeys(Keys.ENTER).perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + filter + "')]")).click();
        // wait spinner disappear
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String count) {
        int countInt = Integer.parseInt(count);   //convert string to integer
        String resultHeading = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        assertThat(resultHeading).contains(count);
        //second step check actual result (container)
        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(results.size()).isEqualTo(countInt);

    }

    @When("I select {string} in results")
    public void iSelectInResults(String resultText) {
        getDriver().findElement(By.xpath("//ul[@id='records']//span[text()='" + resultText + "']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String buttonText) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + buttonText + "')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        // String originalWindow = getDriver().getWindowHandle();

        //switch to new window
        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle));
        /*
                  old way to switch to new window
                 for(String handle : getDriver().getWindowHandles()) {
                    getDriver().switchTo().window(handle);
                }
        */
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains("Sign In"));
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String menuItem, String menuHeader) {
        WebElement menuH = getDriver().findElement(By.xpath("//li[@class='menuheader']//a[text()='" + menuHeader + "']"));
        WebElement menuI = getDriver().findElement(By.xpath("//li[@class='tool-eddm']//a[text()='" + menuItem + "']"));
        actions.moveToElement(menuH).click(menuI).perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) throws InterruptedException {
        WebElement searchIn = getDriver().findElement(By.xpath("//div[contains(@class,'location-input-group')]"));
        WebElement searchBut = getDriver().findElement(By.xpath("//div[contains(@class,'search-btn-wrapper')]/a[@role='button']"));
        actions.sendKeys(searchIn, address).click(searchBut).perform();
        Thread.sleep(1000); //without TreadSleep does not work
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(7));
        this.wait.until(ExpectedConditions.invisibilityOf(spinner));
        //New way By ID, By CSS,
        //        getDriver().findElement(By.id("cityOrZipCode")).sendKeys(search);
        //        getDriver().findElement(By.cssSelector(".eddm-search-btn")).click();
        //        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        //        wait.until(ExpectedConditions.visibilityOf(spinner));
        //        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewTab) {
        getDriver().findElement(By.xpath("//li[contains(@class,'view-table')]//span[text()='" + viewTab + "']")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().findElement(By.xpath("//input[@id='select-all-checkboxes']")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() throws InterruptedException {
        Thread.sleep(1000); // without does not work
        getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']")).click();
        // New way;
        //   WebElement closeButton = getDriver().findElement(By.xpath("//div[@id='drop-off-location-modal']//a[@class='close']"));
        //   wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        //  closeButton.click();

    }


    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> costElements = getDriver().findElements(By.xpath("//table[contains(@class,'target-audience-table')]//td[9]"));
        // In case of infinite loop
//        int size = 0;
//        do {
//            size = costElements.size();
//            System.out.println("Size: " + size);
//            actions.moveToElement(costElements.get(costElements.size() - 1)).perform();
//            Thread.sleep(500);
//            costElements = getDriver().findElements(By.xpath("//table[contains(@class,'target-audience-table')]//td[9]"));
//        } while (size != costElements.size());
        // ? actions.moveToElement(costElements.get(costElements.size() - 1)).perform(); ?
        double costTotal = 0;
        for (WebElement costElement : costElements) {
            String costText = costElement.getText(); // $95.93
            double costNum = Double.parseDouble(costText.substring(1)); //removing $
            costTotal += costNum; //sum
        }
        String approximateText = getDriver().findElement(By.xpath("//p[@id='approximateCost']")).getText();
        double approximateNum = Double.parseDouble(approximateText.substring(1)); // removing $

        double epsilon = 0.001d;
        assertEquals(approximateNum, costTotal, epsilon);
        System.out.println("Approximate Cost:        $" + approximateNum);
        System.out.println("Sum from all Cost rows:  $" + costTotal);
        //    % Assertion
        //  assertThat(calcCost).isCloseTo(approximateCost, Percentage.withPercentage(0.5));
    }
}

