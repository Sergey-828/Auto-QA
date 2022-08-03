package pages.java;

public abstract class Animal {
    //fields

    //encapsulation: used inside class only
    protected String name;
    protected int age;

    //constructor
    public Animal() {
        name = "nameless one";
        age = 0;

    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        String noDigitName = name.replaceAll("[0-9]", "");
        if (noDigitName.length() != name.length()) {
            throw new Error("Digits in name are not allowed:  " + name);
        }
        this.name = noDigitName;
    }

    public void walk() {
        System.out.println(getClass()  + " " + name + " is walking!");
    }

    public void sleep() {
        System.out.println(getClass() + " " + name + " is sleeping!");
    }

    public void eat(String what) {
        System.out.println(getClass() + " " + name + " is eating " + what + "!");
    }

    public abstract void speak();


}
