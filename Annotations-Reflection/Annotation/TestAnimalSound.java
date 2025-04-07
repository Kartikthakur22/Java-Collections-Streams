package Annotation;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

public class TestAnimalSound {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();  
    }
}
