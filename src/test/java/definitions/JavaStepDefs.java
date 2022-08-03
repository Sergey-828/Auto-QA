package definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.ArrayUtils;
import pages.java.Cat;
import pages.java.Dog;

import java.util.*;

import static java.util.Arrays.asList;


public class JavaStepDefs<publicc, inp> {
    private int[] arr;

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
        int[] numbs = {7, 3, 5, 8, 2, 9, 11, 12};

        for (int num : numbs) {
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
        System.out.println("Array is empty");
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

    @Given("Swaps array data {string}")
    public void swapsArrayData(String array) {
        int[] arr = {5, 2, 9, 7, 3};
        System.out.print("Array before swapping ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        ArrayUtils.swap(arr, 2, 4);
        System.out.print("Array after swapping ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    @Given("I work with maps")
    public void iWorkWithMaps() {
//        List<String> user1 = List.of("jdoe", "123 Main st", "john.doe@example.com", "welcome", "John Doe");
//        List<String> user2 = List.of("rroe", "456 Second st", "richard.roe@example.com", "welcome", "Richard Roe");

        Map<String, String> user1 = new HashMap<>();
        user1.put("username", "jdoe");
        user1.put("address", "123 Main st");
        user1.put("email", "john.doe@example.com");
        user1.put("password", "welcome");
        user1.put("name", "John Doe");
        user1.put("password", user1.get("password") + "+1");

        Map<String, String> user2 = new LinkedHashMap<>();
        user2.put("username", "rroe");
        user2.put("address", "456 Second st");
        user2.put("email", "richard.roe@example.com");
        user2.put("password", "welcome");
        user2.put("name", "Richard Roe");

        System.out.println(user1.get("username"));
        System.out.println(user1.get("email"));
        System.out.println(user1.get("password"));
        System.out.println(user1.get("name"));
        System.out.println(user1.get("address"));

        System.out.println(user1);
        System.out.println(user2);
    }

    @Given("Reverse string")
    public void reverseString() {
        String notRev = "Dommod";
        StringBuilder rev = new StringBuilder();
        System.out.print("Initial String: " + notRev);
        int n = notRev.length();
        char[] c = notRev.toCharArray();
        for (int i = n - 1; i >= 0; i--)
            rev.append(c[i]);
        System.out.print("  Reversed string: " + rev);

    }

    @Given("Largest element in array")
    public void largestElementInArray() {
        int[] array = {4, 15, 11, 74, 38, 55};
        int size = array.length;
        Arrays.sort(array);
        System.out.println("Array " + Arrays.toString(array));
        int max = array[size - 1];
        System.out.println("Largest element is " + max);
    }

    @Given("Reverses words in a sentence")
    public String reversesWordsInASentence() {

        String str = "Hello World July";
        System.out.println("Good sentence: " + str);
        String rev = reverse(str);
        System.out.println("Reversed sentence: " + rev);
        return str;
    }

    public static String reverse(String s) {
        int x = s.indexOf(" ");
        if (x == -1)
            return s;
        return reverse(s.substring(x + 1)) + " " + s.substring(0, x);
    }

    @Given("Print reverse {string}")
    public void printReverse(String str) {
        System.out.println("String: " + str);
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println("Reverse string: " + reverse);
    }

    @Given("Print reverse string {string}")
    public void printReverseString(String str) {
        System.out.println((">>>>>>printReverseString method, param " + str));
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    @Given("Print reverse sting value {string}")
    public void printReverseStingValue(String str) {
        System.out.println(">>>>>>printReverseString method, param " + str);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed += str.charAt(i);
        }
        System.out.println(">>>>>>printReverseString, param " + reversed);

    }

    @Given("Palindrome {string}")
    public void palindrome(String ent) {
        String reverse = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Entered: " + ent);
        for (int i = ent.length() - 1; i >= 0; i--)
            reverse = reverse + ent.charAt(i);
        if (ent.equals(reverse))
            System.out.println("Entered is a palindrome.");
        else
            System.out.println("Entered not a palindrome.");
    }

    @Given("Two max numbers in the Array")
    public void twoMaxNumbersInTheArray() {
        int[] array = {-87, 33, 15, -5, -2, 0, 38};
        int maxOne = Integer.MIN_VALUE;
        int maxSecond = Integer.MIN_VALUE;
        for (int n : array) {
            if (maxOne < n) {
                maxSecond = maxOne;
                maxOne = n;
            } else if (maxSecond < n) {
                maxSecond = n;
            }
        }
        System.out.println("Two max numbers: " + maxOne + "," + maxSecond);

    }

    @Given("FizzBuzz {int}")
    public void fizzbuzz(int target) {
        System.out.print(">>>>>>> fizzBuzz method, param " + target);
        for (int num = 1; num <= target; num++) {
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (num % 3 == 0) {
                System.out.print("Fizz ");
            } else if (num % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    @Given("Mask four characters {string}")
    public String maskFourCharacters(String nums) {
        if (nums.length() < 4) {
            return nums;
        } else {
            StringBuilder mask = new StringBuilder();
            for (int i = 0; i < nums.length(); i++) {
                if (i >= 4) {
                    mask.append("#");
                }
            }
            mask.append(nums.substring(nums.length() - 4));
            System.out.println(mask);
            return mask.toString();
        }
    }

    @Given("Two elements of an array result in sum")
    public void twoElementsOfAnArrayResultInSum() {
        int[] arr = {5, 6, 5, 4, 2, 8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr) {
        System.out.println(">>>>> sort, param " + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    @Given("Convert {string} {string} into initials")
    public void convertIntoInitials(String first, String last) {
        first = first.toUpperCase().substring(0, 1);
        last = last.toUpperCase().substring(0, 1);
        System.out.println(first + "." + last);
    }
    //Second Method:
//    b) Name to initial
//    Write a function to convert a name into initials. Strictly takes two words with one space in between them.
//    The output should be two capital letters with a dot separating them.
//    It should look like this:
//    Sam Harris => S.H
//    patrick feeney => P.F
//String getInitials(String fullName) {
//    System.out.println(">>>>> getInitials, param " + fullName);
//    fullName = fullName.toUpperCase();
//    String initials = fullName.charAt(0) + ".";
//    for (int i = 0; i < fullName.length() - 1; i++) {
//        if (fullName.charAt(i) == ' ') {
//            initials += fullName.charAt(i + 1);
//            break;
//        }
//    }
//    return initials;
//}


    @Given("find Sum Two num")
    //    @Given("Finds if any two elements of an array result in sum")
//    public void findsIfAnyTwoElementsOfAnArrayResultInSum() {
//    Entry params {5, 6, 5, 4, 2, 8}  and 12 => true
//    Entry params {5, 6, 5, 4, 2, 8}  and 4 => false

    public void findSumTwoNum() {
        int[] arr5 = {5, 6, 5, 4, 2, 8};
        System.out.println(findsum(arr5, 5));
    }

    boolean findsum(int[] arr, int sum) {
        System.out.println(">>>>> findSum, param " + Arrays.toString(arr) + " and " + sum);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    @Given("Calculate the average of the numbers in a given list.")
    public int calculateTheAverageOfTheNumbersInAGivenlist() {
        int[] arr = {5, 6, 5, 4, 2, 8};
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Sum: " + sum);
        int aver = sum / arr.length;
        System.out.print("Average: " + aver);
        return sum;

    }

    @Given("If there's any duplicates")
    public boolean ifThereSAnyDuplicates() {
        int[] arr = {5, 6, 9, 4, 2, 8};
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("True");
                    return true;
                }
            }
        }
        System.out.println("False");
        return false;
    }

    @Given("Fibonacci")
    public void fibonacci(int seq) {
        //1 2 3 4 5 6  7  8  9  10
        //1,1,2,3,5,8,13,21,34,55

        int prevFib = 0;
        int nextFib = 1;
        for (int i = 1; i < seq; i++) {
            nextFib = prevFib + nextFib;
        }
    }

    @Given("I work with classes")
    public void iWorkWithClasses() {
        System.out.println("Working with classes");
        Cat cat1 = new Cat();
        cat1.walk();
        Cat cat2 = new Cat();
        cat2.walk();

        Cat cat3 = new Cat ("Tom");
        cat3.walk();

        cat1.setName("Charlie");
        cat1.walk();
        cat1.eat("fish");
        cat1.sleep();
        cat1.speak();

        Dog dog1 = new Dog("Cooper");
        dog1.walk();
        dog1.eat("bone");
        dog1.sleep();
        dog1.speak();
    }
}

















































