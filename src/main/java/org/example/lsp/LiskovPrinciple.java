package org.example.lsp;

import java.util.ArrayList;
import java.util.List;

public class LiskovPrinciple {

    public static void main(String[] args) {
        abstract class Animal {
            abstract void makeSound();
        }

        class Dog extends Animal {

            @Override
            void makeSound() {
                System.out.println("Gow");
            }
        }

        class Cat extends Animal {

            @Override
            void makeSound() {
                System.out.println("Miaw");
            }
        }

        Cat cat = new Cat();

        Dog dog = new Dog();

        List<Animal> animals = new ArrayList<>();

        animals.add(cat);
        animals.add(dog);

        animals.forEach( animal -> animal.makeSound());
    }
}
