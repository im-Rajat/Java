# Section 8: Arrays, Java Inbuilt Lists, Autoboxing, and Unboxing


## Arrays

An **array** is a data structure that allows you to store multiple values of the same type in a single variable. Arrays have a fixed size once created.

### Declaration and Initialization

There are several ways to declare and initialize an array:

```java
// Declare an array and then allocate memory
int[] myIntArray;
myIntArray = new int[10];
```

```java
// Declare and allocate memory in one line
int[] myIntArray = new int[10];
```

```java
// Declare and initialize with values (literal syntax)
int[] myNumbers = {1, 2, 3, 4, 5};
```

```java
// Declare and initialize with values (alternative syntax)
int[] anotherArray = new int[]{1, 2, 3, 4, 5};
```

### Accessing and Storing Values

You access elements using their zero-based index.

```java
// Saving a value
myIntArray[5] = 50;

// Creating an array of Double objects
Double[] myDoubleArray = new double[10];
```

### Printing an Array

To print the contents of an array, use the `Arrays.toString()` static method.

```java
System.out.println("array= " + Arrays.toString(myIntArray));
```

> **Note on `static`**: The `toString()` method is **static**, which means you can call it on the `Arrays` class itself without needing to create an instance of the class.

-----

## ArrayList

An **ArrayList** is a resizable array. It provides more flexibility than a standard array as it can grow and shrink in size dynamically. It's similar to a `vector` in C++.

### Defining an ArrayList

You must use wrapper classes (e.g., `Integer`, `Double`) for primitive types, as generics do not work with primitives (e.g., `int`, `double`).

```java
// Correct: Defining an ArrayList of Strings
private ArrayList<String> myArrayList = new ArrayList<String>();

// Incorrect: This will not work because 'int' is a primitive type
// private ArrayList<int> myArrayList = new ArrayList<int>();

// Correct: Use the 'Integer' wrapper class for int values
private ArrayList<Integer> myArrayList = new ArrayList<Integer>();
```

-----

## Iterator

An **Iterator** is an object that enables you to traverse through a collection (like an `ArrayList` or `LinkedList`) and access its elements sequentially.

```java
Iterator<String> iterator = list.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

-----

## Autoboxing and Unboxing

### Autoboxing

**Autoboxing** is the automatic conversion that the Java compiler makes between a primitive type (e.g., `int`) and its corresponding object wrapper class (e.g., `Integer`).

```java
// The compiler converts the primitive 'int' to an 'Integer' object.
Integer myIntegerObject = 100; // This is autoboxing

// The above is shorthand for the explicit conversion:
Integer anotherIntegerObject = Integer.valueOf(100);
```

### Unboxing

**Unboxing** is the reverse process, where the compiler automatically converts an object of a wrapper class back to its corresponding primitive type.

```java
// The compiler converts the 'Integer' object back to a primitive 'int'.
int myPrimitiveInt = myIntegerObject; // This is unboxing

// The above is shorthand for the explicit conversion:
int anotherPrimitiveInt = myIntegerObject.intValue();
```

-----

## Linked List

A **LinkedList** is a data structure that stores elements in a sequence of nodes. Java's implementation is a **doubly linked list**, meaning each node has a reference to both the next and the previous element in the list.

```java
LinkedList<String> list = new LinkedList<String>();
```

### List Iterator

A **ListIterator** is a more powerful type of iterator available for lists. It supports bidirectional traversal (forward and backward) and element modification.

```java
ListIterator<String> listIterator = list.listIterator();
```

### Traversing with ListIterator

To move backward using `hasPrevious()` and `previous()`, the iterator's cursor must first be moved forward. A common pattern is to use a flag to manage the direction of traversal.

```java
boolean goingForward = true;

// Example traversal logic
if (!goingForward) {
    if (listIterator.hasNext()) {
        listIterator.next(); // Nudge the cursor forward
    }
    goingForward = true;
}

if (listIterator.hasNext()) {
    System.out.println("Output: " + listIterator.next());
} else {
    System.out.println("Reached the end of the list.");
    goingForward = false; // Switch direction
}
```

-----

## General Tips

> **psvm**: This is a common IDE shortcut (like in IntelliJ or Eclipse) for quickly generating the main method declaration: `public static void main(String[] args)`.
