package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class JavaStepDefs {
    @When("I hello world")
    public void iHelloWorld() {
     System.out.println("Hello world");

    }

    @And("I say {string}")
    public void iSay(String word) {
        System.out.println(word);
    }
}
