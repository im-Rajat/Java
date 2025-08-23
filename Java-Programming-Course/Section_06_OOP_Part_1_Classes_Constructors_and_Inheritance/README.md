# Section 6: OOP Part 1 - Classes, Constructors, and Inheritance


## Class vs. Object

  * **Class**: A **class** is a "blueprint" or template for creating objects. It defines the properties (fields) and behaviors (methods) that its objects will have. Every class you create implicitly inherits from Java's base `Object` class.
  * **Object**: An **object** is a specific instance of a class. It represents a physical or logical entity with state and behavior. You create an object (instantiate a class) using the `new` keyword.
    `Class_Name object_Name = new Class_Name();`

-----

## Classes, Encapsulation, and Constructors

**Encapsulation** is the practice of bundling an object's data (fields) and methods together. It restricts direct access to an object's components, which is a fundamental principle of OOP. This is often achieved by making fields `private` and providing `public` methods (getters and setters) to access and modify them.

**Example:** Using `this` to distinguish between a class field and a method parameter.

```java
public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    // A "setter" method to modify the private 'model' field
    public void setModel(String model) {
        this.model = model; // 'this.model' refers to the class field
    }
}
```

You would use this method in your `main` method like so:
`porsche.setModel("Carrera");`

### Constructors

A **constructor** is a special method that is called when a new object is created. It's primarily used to initialize the object's state.

  * A **default (or empty) constructor** is automatically provided if you don't define any constructors yourself.
  * Constructors are the preferred way to initialize an object's fields for the first time.
  * **General Rule**: It's better to call another constructor using `this()` from within a constructor, rather than calling a setter method.

-----

## Inheritance

**Inheritance** is a mechanism where a new class (subclass or child class) inherits properties and methods from an existing class (superclass or parent class).

  * **`super` Keyword**: The `super` keyword is used to refer to the immediate parent class. `super()` calls the parent class's constructor and is essential for initializing the inherited part of the object.

-----

## Key Concepts: Reference, Object, Instance, Class

This analogy helps clarify the terms:

  * **Class**: A blueprint for a house. 🏡
  * **Object/Instance**: A physical house built from that blueprint. Each house you build is an object, also known as an instance.
  * **Reference**: The address of a house. You can have many copies of the address (references), but they all point to the same single house (object).

In Java, you **never access objects directly**; you always work with **references** that point to objects in memory.

-----

## `this` vs. `super`

| Keyword | Purpose | Common Use Case |
| :--- | :--- | :--- |
| **`super`** | Accesses members (fields, methods) of the **parent class**. | Used in method overriding to call the parent's version of a method. |
| **`this`** | Accesses members of the **current class**. | Used in constructors and setters to differentiate between instance variables and parameters. |
| **`super()`** | Calls a constructor from the **parent class**. | Must be the *first statement* in a child class's constructor. |
| **`this()`** | Calls an overloaded constructor from the **current class**. | Must be the *first statement* in a constructor. |

**Note**: A constructor can have a call to `super()` or `this()`, but **never both**.

-----

## Method Overriding vs. Overloading

  * **Method Overloading (Compile-Time Polymorphism)**: Having two or more methods in the **same class** with the same name but **different parameters** (different number, type, or order of parameters).
  * **Method Overriding (Runtime Polymorphism)**: Defining a method in a **child class** that has the **same name and signature** as a method in its parent class. This allows the child class to provide a specific implementation of that method.
      * Use the `@Override` annotation just above the method definition for clarity and compiler checks.
      * You can only override instance methods, not `static` methods.

-----

## Static vs. Instance Members

  * **Static Methods/Variables**:
      * Belong to the **class itself**, not to any specific instance.
      * Declared with the `static` keyword.
      * A **static variable** is shared among all instances of a class. If one instance changes it, the change is visible to all other instances.
      * **Static methods** can be called directly on the class (`ClassName.methodName()`) without creating an instance. They cannot directly access instance variables or methods.
  * **Instance Methods/Variables**:
      * Belong to a specific **instance (object)** of a class.
      * Each object gets its own copy of instance variables.
      * **Instance methods** must be called on an object (`objectName.methodName()`) and can access both instance and static members.
