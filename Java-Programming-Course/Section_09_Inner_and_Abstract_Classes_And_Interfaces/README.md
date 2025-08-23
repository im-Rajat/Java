# Section 9: Inner and Abstract Classes & Interfaces


## Interfaces

An **interface** in Java is a reference type, similar to a class, that acts as a contract. It specifies a set of abstract methods that a class must implement.

### Creating an Interface

You create an interface in its own `.java` file. It defines method signatures without providing any implementation.

> **Convention**: Interface names typically start with a capital `I`, for example, `IName` or `ITelephone`.

```java
// IName.java
public interface IName {
    // Method declarations only, like a C++ header file (.h)
    void methodOne();
}
```

### Implementing an Interface

A class uses the `implements` keyword to use an interface. The class must then provide a concrete implementation for all methods defined in that interface.

```java
// Names.java
public class Names implements IName {
    // This class must override all methods mentioned in the IName interface.
    @Override
    public void methodOne() {
        // Your code here
        System.out.println("Executing methodOne.");
    }
}
```

### Built-in Java Interfaces

Java has many powerful built-in interfaces. The `List` interface is a great example, with several classes like `ArrayList` and `LinkedList` providing different implementations of the `List` contract.

```java
// All these classes implement the List interface
List<String> list1 = new ArrayList<>();
List<String> list2 = new LinkedList<>();
List<String> list3 = new Vector<>();
```

> **Multiple Inheritance**: A class can only `extend` one other class, but it can `implements` multiple interfaces. This is how Java supports a form of multiple inheritance.

-----

## Inner Classes

In Java, you can define a class within another class. These are known as **nested classes**.

There are four types of nested classes:

1.  **Static nested classes**: A `static` class defined within another class.
2.  **Non-static nested classes**: Also known as **inner classes**.
3.  **Local classes**: An inner class defined inside a method or scope block.
4.  **Anonymous classes**: An inner class without a name, typically used for one-time implementations.

### Inner Class Syntax and Instantiation

Here is the basic syntax for a non-static inner class.

```java
public class MainClass {
    // ... outer class members ...

    private class SubClass {
        // ... inner class members ...
    }
}
```

To create an instance of an inner class, you first need an instance of the outer class.

```java
// In your main method or another class:
MainClass mc1 = new MainClass();
MainClass.SubClass sc1 = mc1.new SubClass();
```

-----

## Abstraction

**Abstraction** is the concept of hiding complex implementation details and showing only the essential features of an object. It focuses on **what** an object does rather than **how** it does it. Both abstract classes and interfaces are used to achieve abstraction in Java.

### Abstract Classes

An **abstract class** is a class that cannot be instantiated on its own and must be subclassed. It can contain both abstract methods (without a body) and concrete methods (with implementation).

```java
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // Abstract methods must be implemented by subclasses
    public abstract void eat();
    public abstract void breathe();

    // Concrete method is inherited directly
    public String getName() {
        return name;
    }
}
```

### Extending an Abstract Class

A concrete class that extends an abstract class must implement all of its abstract methods.

```java
public class Dog extends Animal {
    public Dog(String name) {
        super(name); // Calls the constructor of the parent class (Animal)
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println("Dog is breathing");
    }
}
```

-----

## Class Relationships and Design

When designing classes, it's helpful to think about their relationships:

  * **Is-A**: Represents inheritance. If Class B **is an** Class A, then `class B extends A`.
      * *Example: A `Dog` **is an** `Animal`.*
  * **Can-Do**: Represents a capability or behavior. If Class B **can do** something, it should implement an interface.
      * *Example: A `Bird` **can** `Fly` (by implementing a `CanFly` interface).*

This allows for flexible and logical designs.

```java
// A Bird is an Animal that can Fly.
public abstract class Bird extends Animal implements CanFly {
    // ... class implementation ...
}
```

### Abstract Class vs. Interface: Key Differences

  * **Purpose**: Use an **abstract class** for objects that are closely related and share common code. Use an **interface** to specify a capability that various unrelated classes can implement.
  * **Methods**: An `abstract class` can have both abstract and concrete (fully implemented) methods. An `interface` (before Java 8) could only have abstract method declarations.
  * **Constructors**: An `abstract class` can have constructors. An `interface` cannot.
  * **Keywords**: You use `extends` for an abstract class and `implements` for an interface.
