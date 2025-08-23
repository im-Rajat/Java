# Section 10: Java Generics


**Generics** provide compile-time type safety, allowing you to create classes, interfaces, and methods that operate on types as parameters. This helps programmers catch invalid type errors during compilation rather than at runtime. 🛡️

-----

## Generic Methods

You can write a single generic method that can be called with arguments of different types. The compiler will handle each method call appropriately based on the argument types provided.

> **Syntax Rule**: All generic method declarations have a **type parameter section** delimited by angle brackets (`<` and `>`) that comes *before* the method's return type.

### Example: `printArray` Method

This example shows a single generic method `printArray` that can print arrays of different types (Integer, Double, Character).

```java
public class GenericMethodTest {
    // Generic method printArray
    public static <E> void printArray(E[] inputArray) {
        // Display array elements
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create arrays of Integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("Array integerArray contains:");
        printArray(intArray); // Pass an Integer array

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); // Pass a Double array

        System.out.println("\nArray characterArray contains:");
        printArray(charArray); // Pass a Character array
    }
}
```

-----

## Bounded Type Parameters

Sometimes you may want to restrict the types that can be used as type arguments in a generic method or class. **Bounded type parameters** allow you to do this by specifying that the type must be a subtype of a particular class or implement a specific interface.

### Example: `maximum` Method

This method finds the largest of three objects. By using `<T extends Comparable<T>>`, we guarantee that any object passed to this method will have a `compareTo` method, making them comparable.

```java
public class MaximumTest {
    // Determines the largest of three Comparable objects
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; // Assume x is initially the largest

        if (y.compareTo(max) > 0) {
            max = y; // y is the largest so far
        }

        if (z.compareTo(max) > 0) {
            max = z; // z is the largest now
        }
        return max; // Returns the largest object
    }
}
```

-----

## Generic Classes

A generic class is declared similarly to a non-generic class, but its name is followed by a type parameter section. This allows the class to work with different data types without sacrificing type safety.

### Example: `Box` Class

The `Box` class can be used to store an object of any type. By specifying the type at instantiation (e.g., `Box<Integer>` or `Box<String>`), you ensure that the box will only hold objects of that specific type.

```java
public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add("Hello World");

        System.out.printf("Integer Value: %d\n", integerBox.get());
        System.out.printf("String Value: %s\n", stringBox.get());
    }
}
```
