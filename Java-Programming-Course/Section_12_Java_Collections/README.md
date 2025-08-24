# Section 12: Java Collections


We can declare collections using their interface type, which allows for flexibility in choosing the specific implementation.

```java
// Using the Collection interface provides flexibility
private Collection<Seat> seats = new ArrayList<>();
private Collection<Seat> seats = new LinkedList<>();
private Collection<Seat> seats = new HashSet<>();
private Collection<Seat> seats = new LinkedHashSet<>();
```

-----

## Shallow Copy vs. Deep Copy

  * **Shallow Copy**: Creates a new collection, but it points to the **same objects** as the original collection. Changes to the shared objects will be reflected in both collections.
  * **Deep Copy**: Creates a new collection and also creates **new copies of the objects** within it. The two collections are completely independent.

-----

## Core Collection Interfaces

  * **[Interfaces Java Docs](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)**: The official documentation for core collection interfaces.

### `Comparable` and `Comparator`

These interfaces are used to define the ordering of objects.

  * **`Comparable`**: An object's class implements this interface to define its "natural ordering". It has a single method, `compareTo()`.
  * **`Comparator`**: This is an external object that can define custom or multiple orderings for objects. It's useful when you can't modify the class or need to sort in different ways. It has a single method, `compare()`.

-----

## Maps

Maps store data in **(Key, Value)** pairs. Keys must be unique; if you insert a new value with an existing key, the old value will be **overridden**. 🗺️

  * **[Maps Interface Java Docs](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)**

### Using `HashMap`

A `HashMap` does not guarantee any specific order for its elements.

```java
// Creating and populating a HashMap
Map<String, String> languages = new HashMap<>();
languages.put("first language", "hindi");
languages.put("second language", "english");

// To get a value by its key
System.out.println(languages.get("first language")); // Outputs: hindi

// To check if a key exists
if (languages.containsKey("first language")) {
    System.out.println("Key found!");
}

// putIfAbsent() only adds the entry if the key is not already present
languages.putIfAbsent("first language", "punjabi"); // This will do nothing

// To iterate over a map
for (String key : languages.keySet()) {
    System.out.println(key + " : " + languages.get(key));
}
```

Other useful methods include `.remove()`, `.replace()`, etc.

-----

## Immutable Classes

Immutable classes are a great way to improve encapsulation and create more robust, thread-safe code.

**Rules for creating an immutable class:**

1.  Don't provide "setter" methods.
2.  Make all fields `final` and `private`.
3.  Don't allow subclasses to override methods. The simplest way is to declare the class as `final`.

<!-- end list -->

  * **[Immutability Strategy Docs](https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html)**

> **Note**: Marking a method as `final` means it **cannot be overridden** in a subclass.

-----

## Sets

A `Set` is a collection that **cannot contain duplicate elements** and does not define a specific ordering for them.

  * **[Performance Enhancements Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/performance-enhancements-7.html)**
  * **[Set Interface Docs](https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html)**

### `HashSet`, `equals()`, and `hashCode()`

To prevent object duplication in a `HashSet`, you must override both the `equals()` and `hashCode()` methods in your custom class. The `Set` uses `hashCode()` to quickly check for potential duplicates before confirming with `equals()`.

  * **[Object Class Docs (`equals()` and `hashCode()`)](https://www.google.com/search?q=%5Bhttps://docs.oracle.com/javase/8/docs/api/java/lang/Object.html%23equals-java.lang.Object-%5D\(https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html%23equals-java.lang.Object-\))**

Here's an example of overriding `hashCode()`:

```java
@Override
public int hashCode() {
    System.out.println("hashCode called");
    // Combine the object's hashcode with another number (e.g., 57)
    // to create a better hash distribution.
    return this.name.hashCode() + 57;
}
```

### Set Theory: Symmetric & Asymmetric Difference

  * **Symmetric Difference**: The set of elements that are in either of the sets, but not in their intersection (Union - Intersection).
  * **Asymmetric Difference**: The set of elements that are in one set but not the other.

Java's `Set` interface has methods for union, intersection, and asymmetric difference (`removeAll`), but not directly for symmetric difference.

-----

## Other Map & Set Implementations

  * **`LinkedHashMap` / `LinkedHashSet`**: Stores elements in **insertion order**.
  * **`TreeMap` / `TreeSet`**: Stores elements in **sorted order** (natural order or by a `Comparator`).
  * **Unmodifiable Wrappers**: You can create read-only versions of your collections using methods like `Collections.unmodifiableMap()` to prevent further changes.
