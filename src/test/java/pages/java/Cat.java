package pages.java;


public class Cat extends  Animal {
    public Cat() {

    }

    @Override
    public void speak() {
        System.out.println(getClass() + " " + name + " is meowing!");
    }

    public Cat (String name) {
        setName(name);
        this.age = 0;
    }
}
