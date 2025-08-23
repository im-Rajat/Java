# Section 7: OOP Part 2 - Composition, Encapsulation, and Polymorphism


## Composition vs. Inheritance

A key design choice in OOP is deciding whether to use inheritance or composition. A simple way to think about it is through relationships:

* **Inheritance ("is-a" relationship)**: A `Car` **is a** `Vehicle`. This is used when a class is a more specific type of another class.
* **Composition ("has-a" relationship)**: A `Computer` **has a** `Motherboard`. This is used when an object is made up of other objects.

**Composition** is the practice of creating objects within other objects.

---

## Encapsulation 🛡️

**Encapsulation** is the concept of hiding the data members (fields) of a class by making them `private`. This prevents them from being accessed directly from outside the class.

These hidden members can only be accessed and modified through `public` methods, such as **getters**, **setters**, or **constructors**. This protects the object's integrity and controls how its data is used.

---

## Polymorphism 🎭

**Polymorphism** (from Greek, meaning "many forms") is the mechanism that allows an action or method to behave differently based on the actual object it is being performed on. For example, a `draw()` method could produce a circle for a `Circle` object and a square for a `Square` object.

A core part of how this works in Java is through method resolution:

* If a method is called on an object of a child class and that method isn't defined in the child class, Java will automatically look for and execute the method from its **base/parent class**.
