package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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


    @Given("I perform actions with {string}")
    public void iPerformActionsWith(String word) {
        System.out.println(word.length());
        System.out.println(word.getClass());
        System.out.println(word.toLowerCase());
        System.out.println(word.toUpperCase());
        System.out.println(word.trim());
        System.out.println(word.isEmpty());


    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String var1, String var2) {
        System.out.println(var1 + var2);
        System.out.println(var1.toUpperCase() + var2.toUpperCase());
        System.out.println(var1.length() + var2.length());
        System.out.println((var1.equals(var2)));
        System.out.println(var1.equalsIgnoreCase(var2));
        System.out.println(var1.contains(var2));






    }
}
