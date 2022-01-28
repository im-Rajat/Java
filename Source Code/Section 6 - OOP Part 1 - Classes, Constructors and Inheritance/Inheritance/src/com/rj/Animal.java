package com.rj;

public class Animal {

    private String Name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public Animal(String name, int brain, int body, int size, int weight) {
//        System.out.println("Animal Constructor caller");
        this.Name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    public void eat()
    {
        System.out.println("Animal.eat() called");
    }

    public void move(int speed)
    {
        System.out.println("Animal.move() called. Animal is moving at " + speed);
    }

    public String getName() {
        return Name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
