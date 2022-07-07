package definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


import java.util.*;


import static java.util.Arrays.*;




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


    @Given("I print {int} day of the week from array")
    public void iPrintDayOfTheWeekFromArray(int day) {
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

    @Given("I print {int} day of the week from second array")
    public void iPrintDayOfTheWeekFromSecondArray(int day) {
        if (day < 1 || day > 7) {
            System.out.println("Invalid day of week: " + day);
        } else {
            String[] daysOfWeek = {"Su", "Mn", "Tu", "We", "Th", "Fr", "Sa"};
            System.out.println(daysOfWeek[day - 1]);
        }
    }

    @Given("Print num and fruit array")
    public void printNumAndFruitArray() {
        System.out.println("String array");
        String[] fruits = {"plum", "apple", "kiwi"};
        System.out.println(fruits.length);

        for (String fruit : fruits) {
            System.out.println(fruit);

        }
        System.out.println();
        System.out.println("Numeric array");
        int[] nums = {7, 3, 5, 8, 2, 9, 11, 12};

        for (int num : nums) {
            System.out.print(num);
        }
    }

    @Given("List Java util")
    public void listJavaUtil() {
        System.out.println();
        System.out.println("ArrayList class");
        List<String> fruitsList = List.of("plum", "apple", "kiwi");
        System.out.println(fruitsList);
        for (String fruit : fruitsList) {
            System.out.println(fruit + " ");
        }

    }

    @Given("numsList")
    public void numslist() {
        System.out.println();
        List<Integer> numList = asList(7, 3, 5, 8, 2, 9, 11, 12);
        System.out.println(numList);

        for (int num : numList) {
            System.out.print(num + " ");
        }
        System.out.println();

        numList.sort((i1, i2) -> i2 - i1);
        System.out.println(numList);
    }

    @Given("I solve coding challenges")
    public void isolveCodingChallenges() {
        System.out.println("isolveCodingChallenges metod");
        swapVars();
    }

    private void swapVars() {
        System.out.println("swapVars method");
        int a = 5;
        int b = 3;
        System.out.println("a = " + a + " b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + " b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + " b = " + b);
        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("a = " + a + " b = " + b);
    }


    @Given("Prints all integer array")
    public void printsAllIntegerArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int num : array) {
            System.out.println(num);
        }
    }

    @Given("prints  even numbers from  array")
    public void printsEvenNumbersFromArray() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Even numbers: ");

        for (int num : nums) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }

    @Given("Check if array is empty")
    public void checkIfArrayIsEmpty() {
        String[] ar = {};
        if (ar.length == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array not empty");
        }
    }

    @Given("Print all numbers from zero up to {string}")
    public int printAllNumbersFromZeroUpTo(String num) {
        int n = Integer.parseInt(num);

        System.out.print("Print all numbers from 0: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ", ");
        }
        return n;
    }
}
































