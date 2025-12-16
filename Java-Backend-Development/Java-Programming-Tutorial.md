# [Java Programming Tutorial](https://www.youtube.com/playlist?list=PLsyeobzWxl7pFZoGT1NbZJpywedeyzyaf)


## Section 1:

### 1\. Basic Structure

```java
public class FirstCode {
	
	public static void main(String args[]) {
		System.out.println("Hello World");
	}
}
```

**Execution Flow:**
Source File `->` **Compiler** `->` Output: **Byte Code**
Byte Code `->` Run on **JVM** (Java Virtual Machine) `->` Get Result

-----

### 2\. Naming Conventions

| Type | Part of Speech | Examples | Notes |
| :--- | :--- | :--- | :--- |
| **Interface** | Adjective | `Runnable`, `Readable`, `Remote` | Describes a capability. |
| **Class** | Noun | `Student`, `Person`, `Computer`, `HashMap` | Represents an entity. |
| **Method** | Verb | `actionPerformed`, `run`, `print`, `write` | Represents an action. |
| **Variable** | (Mixed) | `stockPrice`, `bankDetails` | usually camelCase. |
| **Constant** | (Uppercase) | `PI`, `DENSITY`, `MAX_PRICE` | SCREAMING\_SNAKE\_CASE. |

-----

### 3\. Constructor

  * A Constructor is a member method: `ClassName()`
  * The Constructor has the **same name** as the class name.
  * Constructors **never return anything** (they have no return type, not even void).
      * Syntax: `public ClassName()`
  * It is used to **allocate memory**.

-----

### 4\. Static Keyword

**Static Variable:**

  * If we don't want a variable to be object-specific but rather **class-specific**, we can make that variable `static`.
  * That variable is stored in **loader memory** (Method Area).
  * When we have a static variable, we can use the **class name** to access it (preferred) or the object name.

**Initialization:**

  * If we initialize **non-static** variables, we can use the **Constructor**.
  * If we want to define/initialize **static** variables, we can use a **Static Block**.
      * *Note:* The Static block runs **only once**, and it runs **first** (before the constructor) when the class is loaded.

**Example Code:**

```java
class Emp {
    int eid;
    int salary;
    static String ceo;

    static {    // Executed when you load a class
        ceo = "Larry";
        System.out.println("in static");
    }

    public Emp() { // Executed when you create an object
        eid = 1;
        salary = 3000;
        System.out.println("in constructor");
    }
}
```

> **Important Rule:** We cannot access a **non-static** variable inside a **static block** (or static method). We would need to make that variable static to access it inside a static block (even if it's the static `main` block).

-----

### 5\. Inner Classes

An Inner Class is a class inside a class.

**Structure:**
`Outer class -> Inner class`

**How to access a Member Inner Class:**

```java
Outer obj = new Outer();
Outer.Inner obj2 = obj.new Inner();
```

-----

### 6\. Static Inner Class

When there is a requirement where we require a class only for the main class purpose, we can use a static inner class.

**Definition:**

```java
static class InnerStatic {
	
	public void display() {
		System.out.println("In static display()");
	}
}
```

**How to access:**

```java
// Notice you don't need an object of Outer to instantiate InnerStatic
Outer.InnerStatic obj3 = new Outer.InnerStatic();
obj3.display();
```

-----

### 7\. Summary: 3 Types of Inner Classes

1.  **Member class** (Normal inner class, requires an instance of Outer class).
2.  **Static class** (Static inner class, does not require an instance of Outer class).
3.  **Anonymous class** (A class without a name, used for one-time use).



## Section 2:

### 8\. Jagged Array

A **Jagged Array** is an array of arrays such that member arrays can be of different sizes.

**Example:**

```java
int[][] jaggedArray3 = {
    new int[] { 1, 3, 5, 7, 9 },
    new int[] { 0, 2, 4, 6 },
    new int[] { 11, 22 }
};
```

### 9\. Create an Array

  * `int nums[] = new int[4];`
  * `int nums[] = {1, 2, 3, 4, 5};`

**2D Array:**

  * `int two_d_array[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };`

**Jagged Array Iteration Example:**

```java
int d[][] = {
    {1, 2, 3, 4},
    {2, 4, 8},
    {5, 6, 7, 8, 9}
};

for(int i=0; i<d.length; i++) {
    for(int j=0; j<d[i].length; j++) {
        System.out.print(" " + d[i][j]);
    }
    System.out.println();
}
```

-----

### 10\. Enhanced For Loop

Used to iterate through arrays or collections more simply.

```java
int arr[][] = { {1, 2, 3}, {4, 5, 6, 7}, {8, 9} };

for (int i[] : arr) {
    for (int j : i) {
        System.out.print(j + " ");
    }
    System.out.println();
}
```

-----

### 11\. Variable Arguments (Varargs)

  * Used when we don't know how many arguments are going to be passed to a function.
  * The function below will work for any number of arguments.
  * All arguments will be **passed as an array**.
  * Syntax: `add(int ... n)` — The 3 dots (`...`) are required.

<!-- end list -->

```java
class Calculator {
    public int add(int ... n) {
        int sum = 0;
        for (int i : n) {
            sum = sum + i;
        }
        return sum;
    }
}

public class VarargsDemo {
    public static void main(String args[]) {
        Calculator c1 = new Calculator();
        System.out.println(c1.add(1, 2, 3));
        System.out.println(c1.add(5, 2));
        System.out.println(c1.add(1, 2, 3, 4, 5, 8));
    }
}
```

-----

### 12\. Inheritance

  * Used using the `extends` keyword.
  * Java supports **Single** and **Multilevel** inheritance, but **does not support Multiple inheritance** (because of ambiguity).
  * **IS-A relationship:** When a class extends another class.
  * **HAS-A relationship:** When we have a class in which we are creating an object of another class.

-----

### 13\. Super Keyword

  * When we create a sub-class object, the **super-class default constructor** will also be called first automatically, and then the sub-class constructor will be called.
  * Every sub-class has `super()` called by the compiler inside the constructor.
  * If we change `super()` to `super(i)`, then instead of the default constructor, it can call a **parameterized constructor**.

**Code Example:**

```java
class A {
    public A() {
        System.out.println("in A");
    }
    public A(int i) {
        System.out.println("in A int");
    }
}

class B extends A {
    public B() {
        super(); // by default called by compiler
        System.out.println("in B");
    }
    public B(int i) {
        super(i); // super call parameterized constructor will called
        System.out.println("in B int");
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        // A obj1 = new A();
        B obj2 = new B(5);
    }
}
```



## Section 3:

### 14\. Method Overriding

**Code Example:**

```java
class A {
    public void config() {
        System.out.println("in A config");
    }
}

class B extends A {
    @Override
    public void config() {
        System.out.println("in B config");
    }
}

public class MethodOverridingDemo {
    public static void main(String args[]) {
        B obj = new B();
        obj.config(); // Output: in B config
    }
}
```

-----

### 15\. Runtime Polymorphism & Dynamic Method Dispatch

**Code Example:**

```java
class A {
    public void show() {
        System.out.println("in A");
    }
}

class B extends A {
    public void show() {
        System.out.println("in B");
    }
}

class C extends A {
    public void show() {
        System.out.println("in C");
    }
}

public class DemoPolymorphism {
    public static void main(String args[]) {
        // Compile time and run time
        A obj1 = new B(); // Runtime polymorphism
        obj1.show();      // Output: in B
        
        obj1 = new C();
        obj1.show();      // Output: in C (Dynamic Method Dispatch)
    }
}
```

**Key Notes:**

  * **Pre-requisite:** Class A must have the `show` method, otherwise `A obj = new B()` will fail at compile time when calling `obj.show()`.
  * **Method Overriding** is called **Runtime Polymorphism**.
  * **Dynamic Method Dispatch:** When we change the object assigned to the reference variable, it changes which method is called.
  * **Rule:** Runtime polymorphism cannot be achieved by data members (variables). A method is overridden, not the data members.

-----

### 16\. Encapsulation

**Definition:** Binding data with methods.

**Code Example:**

```java
class Student {
    private int rollno;
    private String name;

    // Getters and Setters
    public void setRollno(int r) {
        this.rollno = r;
    }
    
    public int getRollno() {
        return rollno;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

public class EncapsulationDemo {
    public static void main(String args[]) {
        Student s1 = new Student();
        s1.setRollno(2);
        s1.setName("Navin");
        
        System.out.println(s1.getRollno());
    }
}
```

**Why use Encapsulation?**

  * To make data **safe**.
  * We can use methods for **logging** (which cannot be done if we access variables directly like `obj1.rollno = 2`).
  * It is always better to access variables with the help of methods.

-----

### 17\. Wrapper Class | AutoBoxing

**Code Example:**

```java
public class WrapperDemo {
    public static void main(String args[]) {
        
        int i = 5; // Primitive datatype
        
        Integer ii = new Integer(i); // Boxing - Wrapping
        
        int j = ii.intValue(); // Unboxing - Unwrapping
        
        Integer value = i; // AutoBoxing
        
        int k = value; // AutoUnboxing
    }
}
```

**Notes:**

  * **Boxing/Wrapping:** Putting a primitive value inside an object.
  * **Unboxing/Unwrapping:** Fetching a value from a wrapper class object back to a primitive datatype.
  * Primitives work **faster** than wrapper classes.

-----

### 18\. Abstract Keyword

The `abstract` keyword can be used with both **methods** and **classes**.

**1. Abstract Class:**

  * When we don't want anyone to create an object of a class, we can make it abstract.
  * *Note:* We cannot create an instance of an abstract class, but we **can create a reference** (e.g., `Human h1 = new Man();`).
  * The abstract class can be extended by a new class, and we can create an object of that new class.
  * The new class (Concrete class) should define/implement **all** the abstract methods declared in the abstract parent class.

**2. Abstract Method:**

  * If we have an abstract method in a class, the class **must** be declared as an abstract class.
  * If we only declare a method (without definition/body), it has to be an `abstract` method.

**Code Example:**

```java
abstract class Human {
    public abstract void eat();
    
    public void sleep() {
        
    }
}

class Man extends Human { // Concrete class
    public void eat() {
        System.out.println("Man eats");
    }
}
```

**Why use Abstract Classes?**
We use them when we don't want to create multiple similar methods. We can use the abstract class as a general type (Polymorphism).

**Example (Using Number Abstract Class):**

```java
class Printer {
    // Number is an abstract class extended by Integer, Double, Float, etc.
    public void show(Number i) {
        System.out.println(i);
    }
}

public class AbstractDemo {
    public static void main(String args[]) {
        Printer obj = new Printer();
        obj.show(5.5); // Works for Double
        obj.show(4);   // Works for Integer
    }
}
```

-----

### 19\. Final Keyword

The `final` keyword can be used with:

1.  **Variables**
2.  **Methods**
3.  **Classes**

**Code Example:**

```java
final class A {
    final int DAY = 10; // Constant
    
    public final void show() {
        System.out.println("In A show");
    }
}
```

**Rules:**

  * **Variable:** When we make a variable final, it becomes a **constant**. Once defined, its value cannot be changed.
  * **Class:** If we make a class final, no other class can `extend` it (inherit from it).
  * **Method:** If we make a method final, no one can `override` it in a subclass.



## Section 4:

### 20\. Interface

  * **Interface vs Abstract Class:**
      * In an **Abstract Class**, we can have abstract methods as well as normal (concrete) methods.
      * In an **Interface** (prior to Java 8), we can have *only* abstract methods. We cannot define method bodies.
        ```java
        interface Writer {
            void write();
            void show() {} // Error (before Java 8)
        }
        ```
      * By default, all methods in an interface are `public abstract`.
  * **Multiple Inheritance:**
      * We cannot extend 2 classes because Java does not support multiple inheritance (due to ambiguity).
      * However, we can **create an interface and implement it**, and simultaneously **extend another class**. In this way, we can achieve multiple inheritance.
  * **Instantiation:**
      * We can create a **reference** of an interface, but we *cannot* create an **object** of an interface.
  * **Best Practice:**
      * Given a choice, always go with an **Interface** instead of an Abstract Class, because if required in the future, we can achieve multiple inheritance.

**Code Example:**

```java
interface I01 {
    void show();
}

class Implementor implements I01 {
    public void show() {
        System.out.println("In Implementor");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        I01 obj = new Implementor();
        obj.show();
    }
}
```

-----

### 21\. Anonymous Inner Class

  * A class which **doesn't have any name**.
  * Anonymous classes can be created by providing the implementation **just before the semicolon** when creating an object.
  * **Purpose:** To avoid creating a new class when the only purpose is to override a method one time.
  * **Scope:** Limited to the current context.

**Code Example (Overriding a Class):**

```java
class A {
    public void show() {
        System.out.println("in A show");
    }
}

public class AnonymousClass {
    public static void main(String[] args) {
        // Creating an anonymous class extending A
        A obj = new A() {
            public void show() {
                System.out.println("this is anonymous class");
            }
        };
        obj.show();
    }
}
```

-----

### 22\. Anonymous Class with Interface

  * In an interface, we cannot create an object directly because it lacks implementation.
  * However, we can create an object of an interface using an **Anonymous Class**.

**Code Example:**

```java
interface Abc {
    void show();
}

public class InterfaceWithAnonymous {
    public static void main(String[] args) {
        // Implementing interface using anonymous class
        Abc obj = new Abc() {
            public void show() {
                System.out.println("in anonymous class");
            }
        };
        obj.show();
    }
}
```

-----

### 23\. Types of Interface

1.  **Normal Interface:** Has more than one method.
2.  **SAM Interface (Single Abstract Method):** Has *only* one abstract method.
      * In Java 8, this is known as a **Functional Interface**.
      * Allows the use of **Lambda Expressions**.
3.  **Marker Interface:** Has **no** methods (e.g., `Serializable`, `Cloneable`).

**Lambda Expressions:**

  * A feature adopted from Scala in Java 8.
  * A Functional Interface can be identified using the annotation `@FunctionalInterface`.
  * Used to create objects of the interface in **one line of code**.

**Code Example (Lambda):**

```java
@FunctionalInterface
interface Abc {
    void show();
}

public class InterfaceWithLambda {
    public static void main(String[] args) {
        // Using Lambda Expression
        Abc obj = () -> System.out.println("in anonymous class via Lambda");
        obj.show();
    }
}
```

-----

### 24\. Default Method in Interface

  * Starting from **Java 1.8**, methods *can* be defined in interfaces using the keyword `default`.
  * A functional interface can have only one *abstract* method but can have multiple *default* methods.

**Code Example:**

```java
@FunctionalInterface
interface I01 {
    void show();
    default void show2() {   // We can override this method also
        System.out.println("in interface show");
    }
}

class Implementor implements I01 {
    public void show() {
        System.out.println("In Implementor");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        I01 obj = new Implementor();
        obj.show();  // Prints: In Implementor
        obj.show2(); // Prints: in interface show
    }
}
```

**Multiple Inheritance Issue with Interface:**

  * If we implement 2 interfaces and both have a `default` method with the **same name**, it causes an ambiguity issue.
  * **Solution 1:** Define a method with the same name inside the implementing class to override the ambiguity.
  * **Solution 2:** Override the default method and call the specific super interface method using `InterfaceName.super.methodName()`.

-----

### 25\. Static Method in Interface

  * By default, variables in an interface are `public static final` (Constant).
  * With **static methods** in interfaces, there is no need to create an object of the class that implements the interface to call the method.
  * Since we cannot create an object of an interface, static methods provide an alternative way to call utility methods defined in interfaces.

**Code Example:**

```java
@FunctionalInterface
interface Demo {
    void abc();
    static void show() {
        System.out.println("Hi");
    }
}

public class InterfaceStaticDemo {
    public static void main(String[] args) {
        // Called directly using Interface name
        Demo.show();
    }
}
```



## Section 5:

### 26. Packages

* Java has many built-in classes, as well as external libraries, which are organized into **packages**.
* A package is a **folder** that contains classes that are classified based on their functionality and use.
* The use of packages makes it easy to manage classes and locate them quickly.
* **Naming Convention:** Naming a package after a domain name can make it unique and avoid naming conflicts.
    * *Example:* `com.rajat.package`
* **Importing:** The star (`*`) can be used to retrieve all the classes within a package (e.g., `import java.util.*;`), but it **only retrieves classes and not sub-packages**.

---

### 27. Access Modifiers

**Rules for Classes:**
* The only modifiers we can use with a top-level class are `final`, `abstract`, and `public`.
* If we have an **inner class**, we can use the `private` keyword.
* **Default Class:** If we write just `class A` (without `public`), it will be a **default** class.
    * If we don't mention the `public` keyword in a class, we **can't access** that class outside the package.
    * Default classes can only be used inside the **same package**.

**Rules for Members (Variables/Methods):**
* If we want to use a variable outside the package, make sure it is `public`.
* `int a` means **default variable**; this variable cannot be accessed outside the package.

**Summary of Access Levels:**

| Modifier | Access Scope |
| :--- | :--- |
| **Private** | Specific Class (Only within the class) |
| **Default** | Specific Package (Package-Private) |
| **Public** | Any Class or Package (Global) |
| **Protected** | Subclass (Inheriting Class) |



## Section 6:

### 28\. Exception Handling

  * **Types of Exceptions:**
    1.  **Checked Exception** (Compile-time)
    2.  **Unchecked Exception** (Runtime)
  * **Unchecked exceptions** are not specified by the compiler, but the program throws an exception at runtime.
  * To handle exceptions, we use `try-catch`. The `try` block contains the critical statements, and the `catch` block catches the exception object.
  * **Flow:** If an exception is thrown, the program jumps to the catch block. If there is no error, the program continues to execute the statements outside the try-catch block.
  * **Finally Block:** We can use a `finally` block to write statements that we want to execute **whether the exception occurs or not** (e.g., closing resources).
  * *Note:* If instead of `System.out.println`, we write `System.err.println`, the color of the error output will be **red** instead of black in most IDEs.

**Code Example:**

```java
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int i = 9/0;
        }
        catch(Exception e) {
            System.out.println("Error : " + e);
        }
        finally {
            System.out.println("Bye"); // Executed every time
        }
    }
}
```

-----

### 29\. Multiple Catch Blocks

  * **Java 1.7+ Feature:** We can handle multiple exceptions in a single catch block using the pipe `|` operator. (In Java 1.6 and earlier, this was not possible).
    ```java
    catch(ArithmeticException | ArrayIndexOutOfBoundsException e)
    ```
  * **Multiple Catch Blocks:** Useful when you want to handle different exceptions differently.
  * **Order Matters:** The catch block that handles a particular (specific) exception should be placed **first**, and the generic `Exception` (master of all) should be placed **last**.

**Code Example (Hierarchy):**

```java
try {
    int arr[] = new int[5];
    arr[5] = 30; // Array Index Out Of Bounds
    int i = 9/0; // Arithmetic Exception
}
catch(ArithmeticException e) {
    System.out.println("Cannot divide by Zero");
}
catch(ArrayIndexOutOfBoundsException e) {
    System.out.println("Stay in your limit..");
}
catch(Exception e) {
    System.out.println("Something wrong");
}
finally {
    System.out.println("Bye");
}
```

-----

### 30\. User Input: BufferedReader

  * The method `readLine()` is used to get input from the user, but it returns a **String** and needs to be converted to an `int` using the `parseInt()` method of the `Integer` class.

**Code Example:**

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter a number : ");
        
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        int n = Integer.parseInt(br.readLine());
        System.out.println(n);
    }
}
```

-----

### 31\. Checked Exceptions & Try with Resources

  * **Checked Exceptions:** May occur when asking for data (e.g., `BufferedReader`) due to IO errors.
  * **Handling:** Two ways to handle them:
    1.  Using `try-catch`.
    2.  Using `throws` in the method signature.
  * **Closing Resources:** `BufferedReader` is a resource that must be closed to free up memory. Proper handling involves creating the resource, using it in `try`, and closing it in `finally`.

**Try with Resources (Java 7+):**

  * Resources declared inside the `try` parentheses are **automatically closed** as soon as the object goes out of scope.
  * We do not need a `finally` block to close them explicitly.

**Code Example:**

```java
try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
    int n = Integer.parseInt(br.readLine()); 
}
// br is automatically closed here
```

-----

### 32\. User Defined Exceptions

  * We can create our own exceptions by creating a class that extends `Exception`.
  * We pass the message from the user-defined exception class to the `Throwable` constructor using `super(message)`.

**Code Example:**

**1. The Exception Class:**

```java
// MyException.java
public class MyException extends Exception {
    public MyException(String s) {
        super(s);
    }
}
```

**2. Usage:**

```java
public class UserDefinedDemo {
    public static void main(String[] args) {
        int i = 5;
        try {
            if(i < 10) {
                // Throwing the custom exception
                throw new MyException("This is not possible");
            }
        }
        catch(MyException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
```

-----

### 33\. User Input using Scanner

  * `Scanner` is a tool used for user input in Java.
  * It is often preferred because it is **simple to use** and understand.
  * It has methods like `nextInt`, `nextLong`, `nextDouble` for parsing different data types automatically.
  * **Advantage:** Eliminates the need to manually handle IO exceptions or convert strings to integers (parsing) as required in `BufferedReader`.

**Code Example:**

```java
import java.util.Scanner;

public class UserInputScanner {
    public static void main(String[] args) {
        int n = 0;
        System.out.print("Enter a number : ");
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        System.out.println(n);
    }
}
```



## Section 7:

### 34\. Multithreading

**What is a thread?**

  * **Example:**
      * MS Word: Main Process
      * Typing: Sub Process (Thread)
      * Spell Check: Sub Process (Thread)
  * **Thread: Unit of a Process**
      * Multi-threading allows for multitasking and running multiple tasks simultaneously.
      * In Java, threads are units of a process and can be used to perform tasks concurrently.
      * The need for threads arises due to multi-core processors, where multiple threads can utilize the cores effectively.
      * Threads can be implemented in Java by extending the `Thread` class or implementing the `Runnable` interface.
      * Using threads, tasks can be divided among multiple threads to take advantage of parallel processing.
      * `sleep`, `wait`, and `notify` methods can be used in threads, but stopping a thread should be done with caution.

-----

### 35\. Thread Class

  * By default, Java has a **main thread** that executes the code.
  * The `Thread.sleep()` method is used to introduce a pause in the execution of the threads.
  * The `start()` method is used to start the threads.

**Code Example:**

```java
class A extends Thread {
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println("Hi");
            try { Thread.sleep(10); } catch(Exception e) {}
        }
    }
}

class B extends Thread {
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println("Hello");
            try { Thread.sleep(10); } catch(Exception e) {}
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        
        // Use start() to run run() in a new thread
        obj1.start();
        obj2.start();
    }
}
```

-----

### 36\. Runnable Interface

  * **Limitation of `extends Thread`:** Implementation of threads using the `Thread` class can be limited due to Java's lack of multiple inheritance.
  * **Solution:** To overcome this, the `Runnable` interface can be implemented instead.
  * The `Runnable` interface is a **Functional Interface** with a single method, `run()`.
  * **Note:** The `Runnable` interface does not have a `start()` method, so a `Thread` object must be created.
      * Pass the Runnable object to the `Thread` constructor.

**Code Example:**

```java
class A implements Runnable {
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("Hi");
            try { Thread.sleep(10); } catch(Exception e){}
        }
    }
}

class B implements Runnable {
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("Hello");
            try { Thread.sleep(10); } catch(Exception e){}
        }
    }
}

public class DemoRunnable {
    public static void main(String[] args) {
        Runnable obj1 = new A();
        Runnable obj2 = new B();
        
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        
        t1.start();
        t2.start();
    }
}
```

-----

### 37\. Using Lambda Expression

  * If we have a class which is used only once, instead of creating a separate class, we can use an **Anonymous Class** or **Lambda Expression**.
  * This reduces the number of lines and makes the code more efficient.

**Code Example:**

```java
public class ThreadLambda {
    public static void main(String[] args) {
        
        Runnable obj1 = () -> {
            for(int i=0; i<5; i++) {
                System.out.println("Hi");
                try { Thread.sleep(1000); } catch(Exception e){}
            }
        };
        
        Runnable obj2 = () -> {
            for(int i=0; i<5; i++) {
                System.out.println("Hello");
                try { Thread.sleep(1000); } catch(Exception e){}
            }
        };
        
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        
        t1.start();
        t2.start();
    }
}
```

-----

### 38\. Join and isAlive Method

  * **`join()`:** Used to make the main thread wait for `t1` and `t2` to complete their tasks before proceeding.
  * **`isAlive()`:** Used to check if a thread is currently running.
      * If `t1` is checked with `isAlive` before joining, it will return `true`. After joining (completion), it will return `false`.

**Code Example:**

```java
t1.start();
t2.start();

System.out.println(t1.isAlive()); // true

t1.join();
t2.join();

System.out.println(t1.isAlive()); // false
System.out.println("Bye");
```

-----

### 39\. Thread Name and Priority

  * **Name:**
      * Can be obtained using `Thread.getName()` and set using `Thread.setName()`.
      * By default, names are `Thread-0`, `Thread-1`, etc.
      * Threads can also be named via the constructor: `Thread(Runnable target, String name)`.
  * **Priority:**
      * Range: **1 to 10**.
      * Default priority is **5** (`NORM_PRIORITY`).
      * Constants: `Thread.MIN_PRIORITY` (1), `Thread.MAX_PRIORITY` (10).

**Code Example:**

```java
t1.setName("Hi Thread");
t2.setName("Hello Thread");

System.out.println(t1.getName());
System.out.println(t2.getPriority());

t1.setPriority(Thread.MIN_PRIORITY); // 1
t2.setPriority(Thread.MAX_PRIORITY); // 10
```

-----

### 40\. Synchronized Method

  * **Problem:** Multiple threads accessing the same method at the same time can cause interference (Race Condition).
  * **Solution:** `synchronized` methods ensure **Thread Safety** by allowing only one thread to access the method at a time.

**Code Example:**

```java
class Counter {
    int count;
    // synchronized ensures only one thread increments at a time
    public synchronized void increment() {
        count++;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();
        
        Thread t1 = new Thread(() -> {
            for(int i=1; i<=1000; i++) c.increment();
        });
        
        Thread t2 = new Thread(() -> {
            for(int i=1; i<=1000; i++) c.increment();
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("Count " + c.count); // Should be 2000
    }
}
```

-----

### 41\. Thread Safety

  * **Thread Safety** ensures that when multiple threads access shared data, they do not produce inconsistent results.
  * **Approaches:**
    1.  Use the `synchronized` keyword.
    2.  Use **Atomic Classes** (e.g., `AtomicInteger`) which provide atomic operations for thread-safe increments without explicit synchronization blocks.

**Code Example (Atomic):**

```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    AtomicInteger count = new AtomicInteger();
    
    public void increment() {
        count.incrementAndGet();
    }
}
```



## Section 8:

### 42\. Collection and Generics

  * **Core Concepts:**
      * `collection` (Topic/Concept)
      * `Collection` (Interface)
      * `Collections` (Class)
  * **Array vs ArrayList:** If we know the size is fixed, always use an array instead of `ArrayList` (collection) because arrays are faster.
  * **Version History:**
      * **1.2:** Introduced Collection Framework.
      * **1.5:** Introduced Generics `<Integer>`.
      * **1.7:** Introduced Diamond Operator `<>`.
          * `Collection<Integer> values = new ArrayList<>();` (No need to specify Integer on the right side).
  * **Hierarchy:** `Collection -> List -> ArrayList` (List extends Collection).
  * **Interfaces vs Classes:** `Collection` and `List` are Interfaces; `ArrayList` is a Class.
  * **Key Differences:** `Collection` doesn't work with index numbers, but `List` supports them as it has extra features.

**Examples:**

```java
List<Integer> values = new ArrayList<>();

Set<Integer> unique_numbers = new HashSet<>();       // Order is random
Set<Integer> unique_sorter_numbers = new TreeSet<>(); // Sorted order

Map<Integer, String> m = new HashMap<>();           // Map is also an interface
```

**Map Implementations:**

  * `HashMap` (Not Synchronized - Fast)
  * `Hashtable` (Synchronized - Thread Safe but Slower)

> *Note: Your original notes had the synchronization swapped. I have corrected it here: Hashtable is the synchronized one.*

-----

### 43\. Collection and Iterator Interface

  * To create a collection, an interface called `Collection` is used.
  * The `ArrayList` class implements the `Collection` interface.
  * Values can be added to a collection using the `add` method.
  * The `Collection` interface has methods such as `size`, `contains`, `add`, `remove`, and `toArray`.
  * **Iterator:** Since Collections (like Sets) do not always support index numbers, a special interface called `Iterator` is used to fetch values.

**Code Example:**

```java
Collection values = new ArrayList();
values.add(4);
values.add(6);
values.add(9);

Iterator it = values.iterator();
while(it.hasNext()) {
    System.out.println(it.next());
}
```

-----

### 44\. List Interface

  * `Collection` interface doesn't support index numbers.
  * `List` interface extends `Collection` and **supports index numbers**.
  * `List` can handle any type of value (Objects), not just integers or strings.

**Code Example:**

```java
List values = new ArrayList();
values.add(4); // Integer
values.add(6);
values.add(9);
values.add(1, 8); // Add 8 at index 1

for(int i=0; i<values.size(); i++) {
    System.out.println(values.get(i));
}
```

-----

### 45\. Using Generic with List

  * Generics can be used to restrict a list to a specific type (e.g., `int`, `string`) so it doesn't support anything else.

**Code Example:**

```java
List<Integer> values = new ArrayList<Integer>();
values.add(4);
values.add(6);
values.add(9);
// values.add("k"); // Error: compile time error due to generics
```

-----

### 46\. Collections Class

The `Collections` class (plural) provides static utility methods like `sort()`.

**Code Example:**

```java
List<Integer> values = new ArrayList<>();
values.add(404);
values.add(908);
values.add(639);
values.add(265);

Collections.sort(values); // Sorts the list
Collections.reverse(values); // Reverses the list
Collections.shuffle(values); // Randomly shuffles
```

-----

### 47\. Comparator Interface

  * The `Collections.sort()` method relies on the `Comparable` interface (natural ordering) or a `Comparator` for defining custom sorting logic.
  * **Custom Sorting:** To override default logic (e.g., sort by the last digit of a number), a custom `Comparator` object is created.
  * This requires implementing the `compare()` method.
  * We can use an **Anonymous Class** or **Lambda Expression** to implement this interface concisely.

**Code Example:**

```java
Comparator<Integer> c = (i, j) -> {
    // Sort based on last digit (e.g., 31 > 29 because 1 < 9 is false... wait, logic below)
    return i%10 > j%10 ? 1 : -1;
};

List<Integer> values = new ArrayList<>();
values.add(404);
values.add(908);
values.add(639);
values.add(265);

Collections.sort(values, c); // Sorts based on last digit
```

-----

### 48\. Comparable Interface

  * The `Comparable` interface has a single method called `compareTo()`, which defines the **natural ordering** of objects.
  * If a class implements `Comparable`, objects of that class can be sorted automatically by `Collections.sort()`.

**Code Example:**

```java
class Student implements Comparable<Student> {
    int rollno;
    int marks;
    
    // ... constructor ...

    public int compareTo(Student s) {
        return this.marks > s.marks ? -1 : 1; // Sort by marks descending
    }
}
```

-----

### 49\. Set Interface

  * **HashSet:** Duplicate elements are **not allowed**, and the sequence (order) is **random**.
  * **TreeSet:** Duplicate elements are **not allowed**, but the sequence is sorted in **ascending order**.

**Code Example:**

```java
Set<Integer> values = new HashSet<>();
values.add(5);
values.add(6);
values.add(9);
values.add(6); // Duplicate, will not be added

for(int i : values) {
    System.out.println(i); // Order is not guaranteed
}
```

-----

### 50\. Map Interface

  * `Map` is used to store **Key-Value** pairs.
  * Values are added using the `put` method.
  * Values are retrieved using the `get(key)` method.
  * **Keys must be unique**, but values can be duplicated.
  * `HashMap` does not guarantee insertion order.
  * `Hashtable` is thread-safe (synchronized) but less commonly used.

**Code Example:**

```java
Map<String, String> map = new HashMap<>();
map.put("myName", "Navin");
map.put("actor", "John");
map.put("ceo", "Marisa");

Set<String> keys = map.keySet(); // Get all keys

for(String key : keys) {
    System.out.println(key + " " + map.get(key));
}
```



# Section 9:

### 51\. Var Keyword (Java 10 Feature)

  * **LVTI (Local Variable Type Inference):** A feature in Java 10 that allows using local variables without explicitly declaring their data type.
  * **Scope:** It is **not applicable to instance variables**, only to local variables used within methods.
  * **Syntax:** The keyword `var` is used instead of specifying the data type.
  * **Type Safety:** The type of the variable is determined at **compile time**, so Java remains a statically typed language.
  * **Rules:**
      * Variables declared with `var` **must be initialized** with a value.
      * "var" can be used as a variable name, but **not** as a class name.
      * Can be used when creating objects or arrays (with explicit initialization).

**Code Example:**

```java
// class var { } // Error: 'var' is a restricted identifier type

class TempClass {
    // var z = 10; // Error: Cannot use var for instance variables
}

public class VarKeyword {
    public static void main(String[] args) {
        int a = 9;
        var b = 10;        // Infers int
        String var = "Raj"; // 'var' is allowed as a variable name
        
        // var c;         // Error: Must be initialized
        
        int nums[] = new int[10];
        var nums2 = new int[10]; // Works
        // var nums3 = {1, 2, 3}; // Error: Array initializer needs explicit type

        var obj = new TempClass(); // Works
    }
}
```

-----

### 52\. Updated Switch Statement and Expression

  * **Old Switch:** Required the use of `break` statements to prevent fall-through and used colons (`:`).
  * **New Switch (Java 12+):** Allows for the omission of `break` by using an arrow (`->`) syntax.
  * **Switch Expression:** Switch can now **return a value**.
  * **Yield:** If using the colon syntax inside a switch expression, the keyword `yield` is used to return the value.

**Code Example:**

```java
public class UpdatedSwitch {
    public static void main(String[] args) {
        String day = "Monday";

        // New Arrow Syntax (No break needed)
        switch(day) {
            case "Saturday", "Sunday" -> System.out.println("6am");
            case "Monday" -> System.out.println("8am");
            default -> System.out.println("7am");
        }

        // Switch as an Expression (Returning a value)
        String result = switch(day) {
            case "Saturday", "Sunday" -> "6am";
            case "Monday" -> "8am";
            default -> "7am";
        };
        System.out.println(result);

        // Using 'yield' with colon syntax
        String result2 = switch(day) {
            case "Saturday", "Sunday" : yield "6am";
            case "Monday" : yield "8am";
            default : yield "7am";
        };
    }
}
```

-----

### 53\. Record Classes (Java 17 Feature)

  * **Purpose:** Introduced to simplify data storage classes (often called DTOs or POJOs).
  * **Syntax:** Defined using the `record` keyword, followed by the class name and variables (components).
  * **Features:**
      * Automatically generates **constructor**, **getters** (named `variable()`, not `getVariable()`), **equals**, **hashCode**, and **toString**.
      * They are concise and **immutable**. Variables are `private` and `final` by default.
      * Can implement interfaces but **cannot extend** other classes (implicitly extends `java.lang.Record`).

**Code Example:**

```java
// Definition
record Alien(int id, String name) {
    // You can add a compact constructor for validation
    public Alien {
        if (id == 0)
            throw new IllegalArgumentException("id cannot be 0");
    }
}

public class RecordDemo {
    public static void main(String[] args) {
        Alien a1 = new Alien(1, "Navin");
        Alien a2 = new Alien(1, "Navin");

        System.out.println(a1.equals(a2)); // true (Value equality)
        System.out.println(a1);            // Alien[id=1, name=Navin]
        System.out.println(a1.name());     // Accessor method
    }
}
```

-----

### 54\. Sealed Classes (Java 17 Feature)

  * **Purpose:** To restrict inheritance in Java.
  * **Hierarchy Control:**
      * **Final Class:** Cannot be inherited by *any* class.
      * **Sealed Class:** explicitly specifies which subclasses are allowed to inherit from it using the `permits` keyword.
  * **Subclass Rules:** A class extending a sealed class must be either `final`, `sealed`, or `non-sealed`.

**Code Example:**

```java
// Sealed Class
sealed class A permits B, C {
}

// 1. Final: End of hierarchy
final class B extends A {
}

// 2. Non-sealed: Open for extension by anyone
non-sealed class C extends A {
}

class D extends C { // Allowed
}

// class E extends A { } // Error: E is not permitted
```
