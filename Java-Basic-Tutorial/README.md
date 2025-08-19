# Java Basic Tutorial

## Printing Data

```java
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
```

> **Note:** Java is case-sensitive: "MyClass" and "myclass" have different meanings.

## Primitive Data Types

A primitive data type specifies the size and type of variable values, and it has no additional methods.


## Non-Primitive Data Types

Non-primitive data types are called **reference types** because they refer to objects.

### Widening Casting (automatically)

This involves converting a smaller type to a larger type size. It's done automatically when passing a smaller size type to a larger size type:
`byte` -\> `short` -\> `char` -\> `int` -\> `long` -\> `float` -\> `double`

### Narrowing Casting (manually)

This involves converting a larger type to a smaller size type. It must be done manually by placing the type in parentheses in front of the value:
`double` -\> `float` -\> `long` -\> `int` -\> `char` -\> `short` -\> `byte`


## Java Operators

Java divides operators into the following groups:

  * Arithmetic operators
  * Assignment operators
  * Comparison operators
  * Logical operators
  * Bitwise operators

## Java Strings

  - Use the `length()` method to find the length of a string.
    ```java
    String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    System.out.println(txt.length());
    ```
  - Use `toUpperCase()` to convert a string to uppercase.
    ```java
    System.out.println(txt.toUpperCase());
    ```
  - The `indexOf()` method returns the index (the position) of the first occurrence of a specified text in a string.
  - Use the `concat()` method to concatenate two strings.

## Java Math

  - `Math.max(x,y)`
  - `Math.min(x,y)`
  - `Math.sqrt(x)`
  - `Math.abs(x)`
  - `Math.random()`

## Short Hand If...Else (Ternary Operator)

```java
variable = (condition) ? expressionTrue : expressionFalse;

// Example
String result = (time < 18) ? "Good day." : "Good evening.";
```

## Java Switch

The `switch` statement selects one of many code blocks to be executed.

```java
switch(expression) {
  case x:
    // code block
    break;
  case y:
    // code block
    break;
  default:
    // code block
}

// Example
int day = 4;
switch (day) {
  case 6:
    System.out.println("Today is Saturday");
    break;
  case 7:
    System.out.println("Today is Sunday");
    break;
  default:
    System.out.println("Looking forward to the Weekend");
}
// Outputs "Looking forward to the Weekend"
```

## Loops

### The Do/While Loop

This loop will execute the code block once, before checking if the condition is true, then it will repeat the loop as long as the condition is true.

```java
do {
  // code block to be executed
}
while (condition);

// Example
int i = 0;
do {
  System.out.println(i);
  i++;
}
while (i < 5);
```

### For-Each Loop

This is used exclusively to loop through elements in an array (or other collections).

```java
for (type variableName : arrayName) {
  // code block to be executed
}

// Example
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
for (String i : cars) {
  System.out.println(i);
}
```

## Java Arrays

Arrays are used to store multiple values in a single variable.

```java
// Declaration and instantiation
int a[] = new int[5];

// Declaration with initialization
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

// Access an element
System.out.println(cars[0]);

// Change an element
cars[0] = "Opel";

// Array length
System.out.println(cars.length);

// Loop through an array
for (int i = 0; i < cars.length; i++) {
  System.out.println(cars[i]);
}
```

### Multidimensional Arrays

A multidimensional array is an array of arrays.

```java
int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
int x = myNumbers[1][2];
System.out.println(x); // Outputs 7

// Loop through a multidimensional array
for (int i = 0; i < myNumbers.length; ++i) {
  for(int j = 0; j < myNumbers[i].length; ++j) {
    System.out.println(myNumbers[i][j]);
  }
}
```

## Java Methods

A method is a block of code which only runs when it is called.

```java
public class Main {
  static void myMethod() {
    System.out.println("I just got executed!");
  }

  public static void main(String[] args) {
    myMethod();
  }
}
// Outputs "I just got executed!"
```

### Example Explained

  * `myMethod()`: The name of the method.
  * `static`: The method belongs to the `Main` class and not an object of the `Main` class.
  * `void`: This method does not have a return value.

### Java Method Overloading

With method overloading, multiple methods can have the same name but with different parameters.

```java
int myMethod(int x)
float myMethod(float x)
double myMethod(double x, double y)
```

## Java OOP (Object-Oriented Programming)

**Classes** and **objects** are the two main aspects of OOP.

  * **Class**: A template for objects (e.g., Fruit).
  * **Object**: An instance of a class (e.g., Apple, Banana, Mango).

### Java Classes and Objects

```java
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj.x);
  }
}
```

If you don't want the ability to override existing values, declare the attribute as `final`.

### Java Constructors

A constructor is a special method used to initialize objects. It's called when an object of a class is created.

```java
public class Main {
  int x;  // Create a class attribute

  // Create a class constructor
  public Main() {
    x = 5;  // Set the initial value
  }

  public static void main(String[] args) {
    Main myObj = new Main(); // This will call the constructor
    System.out.println(myObj.x); // Outputs 5
  }
}
```

#### Constructor Parameters

Constructors can also take parameters to initialize attributes.

```java
public class Main {
  int modelYear;
  String modelName;

  public Main(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    Main myCar = new Main(1969, "Mustang");
    System.out.println(myCar.modelYear + " " + myCar.modelName); // Outputs 1969 Mustang
  }
}
```

## Java Modifiers

For more details, visit [W3Schools](https://www.w3schools.com/java/java_modifiers.asp).

Modifiers are divided into two groups:

  * **Access Modifiers**: Controls the access level.
  * **Non-Access Modifiers**: Provides other functionality.

### Access Modifiers

  * **For classes**: `public` or `default`.
  * **For attributes, methods, and constructors**: `public`, `private`, `default`, `protected`.

### Non-Access Modifiers

  * **For classes**: `final` or `abstract`.
  * **For attributes and methods**: `final`, `static`, `abstract`, `transient`, `synchronized`, `volatile`.

## Encapsulation

Encapsulation means hiding "sensitive" data from users.

  * Declare class variables/attributes as `private`.
  * Provide public `get` and `set` methods to access and update the value of a `private` variable.

### Get and Set

```java
public class Person {
  private String name; // private = restricted access

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
  }
}
```

### Why Encapsulation?

  * Better control of class attributes and methods.
  * Attributes can be made read-only or write-only.
  * Increased flexibility and security of data.

## Java Packages & API

A package is used to group related classes.

  * **Built-in Packages**: Packages from the Java API.
  * **User-defined Packages**: Packages you create yourself.

### Built-in Packages

```java
import package.name.Class;   // Import a single class
import package.name.*;     // Import the whole package

// Example
import java.util.Scanner;

class MyClass {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter username");

    String userName = myObj.nextLine();
    System.out.println("Username is: " + userName);
  }
}
```

## Java Inheritance (Subclass and Superclass)

Inheritance allows one class to inherit attributes and methods from another.

  * **subclass** (child): The class that inherits.
  * **superclass** (parent): The class being inherited from.

Use the `extends` keyword to inherit from a class.

```java
class Vehicle {
  protected String brand = "Ford";
  public void honk() {
    System.out.println("Tuut, tuut!");
  }
}

class Car extends Vehicle {
  private String modelName = "Mustang";
  public static void main(String[] args) {
    Car myCar = new Car();
    myCar.honk();
    System.out.println(myCar.brand + " " + myCar.modelName);
  }
}
```

## Java Polymorphism

Polymorphism means "many forms" and occurs when many classes are related by inheritance. It allows us to perform a single action in different ways.

```java
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}
```

## Java Abstraction

Data abstraction is the process of hiding certain details and showing only essential information.

  * **Abstract class**: A restricted class that cannot be used to create objects. It must be inherited.
  * **Abstract method**: Can only be used in an abstract class and does not have a body. The body is provided by the subclass.

<!-- end list -->

```java
// Abstract class
abstract class Animal {
  // Abstract method (does not have a body)
  public abstract void animalSound();
  // Regular method
  public void sleep() {
    System.out.println("Zzz");
  }
}

// Subclass (inherit from Animal)
class Pig extends Animal {
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The pig says: wee wee");
  }
}

class Main {
  public static void main(String[] args) {
    Pig myPig = new Pig(); // Create a Pig object
    myPig.animalSound();
    myPig.sleep();
  }
}
```

## Interfaces

An interface is a completely "abstract class" that is used to group related methods with empty bodies. A class uses the `implements` keyword to use an interface.

```java
// Interface
interface Animal {
  public void animalSound(); // interface method
  public void sleep(); // interface method
}

// Pig "implements" the Animal interface
class Pig implements Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
  public void sleep() {
    System.out.println("Zzz");
  }
}
```

## Enums

An `enum` is a special "class" that represents a group of constants.

```java
enum Level {
  LOW,
  MEDIUM,
  HIGH
}

Level myVar = Level.MEDIUM;

// Loop through an enum
for (Level myVar : Level.values()) {
  System.out.println(myVar);
}
```

## Collections

### Java ArrayList

The `ArrayList` class is a resizable array.

```java
import java.util.ArrayList;
import java.util.Collections;

ArrayList<String> cars = new ArrayList<>();
cars.add("Mazda");
cars.get(0);
cars.set(0, "Opel");
cars.remove(0);
cars.clear();
cars.size();
Collections.sort(cars); // Sorts the list
```

### Java LinkedList

The `LinkedList` is almost identical to the `ArrayList` but is more efficient for manipulating data (adding/removing elements from the beginning or end).

  - `addFirst()`
  - `addLast()`
  - `removeFirst()`
  - `removeLast()`
  - `getFirst()`
  - `getLast()`

> **When to Use**: Use `ArrayList` for storing and accessing data. Use `LinkedList` to manipulate data.

### Java HashMap

A `HashMap` stores items in "key/value" pairs.

```java
import java.util.HashMap;

HashMap<String, String> capitalCities = new HashMap<String, String>();
capitalCities.put("England", "London");
capitalCities.get("England");
capitalCities.remove("England");

// Print keys
for (String i : capitalCities.keySet()) {
  System.out.println(i);
}
```

### Java HashSet

A `HashSet` is a collection of unique items.

```java
import java.util.HashSet;

HashSet<String> cars = new HashSet<String>();
cars.add("Volvo");
cars.contains("Mazda");
```

## Java Iterator

An `Iterator` is an object used to loop through collections.

```java
// Get the iterator
Iterator<String> it = cars.iterator();

// Print the first item
System.out.println(it.next());

// Loop through a collection
while(it.hasNext()) {
  System.out.println(it.next());
}

// Removing items
Iterator<Integer> it = numbers.iterator();
while(it.hasNext()) {
  Integer i = it.next();
  if(i < 10) {
    it.remove();
  }
}
```

> **Note**: It's safer to use an `Iterator` to remove items from a collection while looping to avoid issues.

## Java Wrapper Classes

Wrapper classes provide a way to use primitive data types (e.g., `int`, `boolean`) as objects.

| Primitive Data Type | Wrapper Class |
| :------------------ | :------------ |
| `byte`              | `Byte`        |
| `short`             | `Short`       |
| `int`               | `Integer`     |
| `long`              | `Long`        |
| `float`             | `Float`       |
| `double`            | `Double`      |
| `boolean`           | `Boolean`     |
| `char`              | `Character`   |

## Java Exceptions - Try...Catch

An exception is an error that occurs during the execution of a program.

### Java try and catch

The `try` statement defines a block of code to be tested for errors. The `catch` statement defines a block of code to be executed if an error occurs.

```java
try {
  //  Block of code to try
}
catch(Exception e) {
  //  Block of code to handle errors
}
```

### Finally

The `finally` statement executes code after `try...catch`, regardless of the result.

```java
try {
  int[] myNumbers = {1, 2, 3};
  System.out.println(myNumbers[10]);
} catch (Exception e) {
  System.out.println("Something went wrong.");
} finally {
  System.out.println("The 'try catch' is finished.");
}
```

### The throw keyword

The `throw` statement allows you to create a custom error.

```java
static void checkAge(int age) {
  if (age < 18) {
    throw new ArithmeticException("Access denied - You must be at least 18 years old.");
  }
  else {
    System.out.println("Access granted - You are old enough!");
  }
}
```