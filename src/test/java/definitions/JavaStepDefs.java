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

    @Given("I write java")
    public void iWriteJava() {
        String message = "Hello";
        message = message.toUpperCase();

        System.out.println(message);

        System.out.println("Hey there, " + message.toLowerCase());
    }


    @Given("I divide one by second")
    public void iDivideOneBySecond() {
        int num1 = 30;
        int num2 = 20;
        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 / num2);
        System.out.println(num1 * num2);
        var sum = num1 + num2;
        var difference = num1 - num2;
        var quotient = num1 / num2;
        var product = num1 * num2;
        System.out.println(sum);
        System.out.println(difference);
        System.out.println(quotient);
        System.out.println(product);
    }

    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String page) {
        System.out.println("page is: " + page);
        if (page.equals("google")) {
            System.out.println("https://google.com");
        } else if (page.equals("quote")) {
            System.out.println("https://skryabin.com/market/quote.html");
        } else {
            System.err.println("Unsupported page: " + page);
        }
    }

    @Given("I compare {string} and {string}")
    public void iCompareAnd(String first, String second) {
        if (first.equals(second)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }


    @Given("I print {string} th day of week")
    public void iPrintThDayOfWeek(String enter) {
        int day = Integer.parseInt(enter);
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.err.println("Incorrect week number");
        }
    }

    @Given("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String num) {
        int n = Integer.parseInt(num);
        if (n == 35) {
            System.out.println("Number is positive");
        } else if (n < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Error");
        }
    }

    @Given("Favorite color {string} and Not favorite color {string}")
    public void favoriteColorAndNotFavoriteColor(String color1, String color2) {
        if (color1.equals(color2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }


    @Given("I print {string} day of the week from array")
    public void iPrintDayOfTheWeekFromArray(String daysOfWeek) {
        int day = Integer.parseInt(daysOfWeek);
        String[] numbs = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        switch (day) {
            case 1 -> System.out.println(numbs[0]);
            case 2 -> System.out.println(numbs[1]);
            case 3 -> System.out.println(numbs[2]);
            case 4 -> System.out.println(numbs[3]);
            case 5 -> System.out.println(numbs[4]);
            case 6 -> System.out.println(numbs[5]);
            case 7 -> System.out.println(numbs[6]);
            default -> System.err.println("Incorrect week number");
        }
    }
}



















