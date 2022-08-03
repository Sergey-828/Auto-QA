package pages.java;

public class Dog extends Animal {

    public Dog(String name) {
            setName(name);
            this.age = 0;
        }

    @Override
    public void speak() {
        System.out.println(getClass() + " " + name + " is barking!");
    }
}
