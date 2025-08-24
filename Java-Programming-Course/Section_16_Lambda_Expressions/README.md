# Section 16: Lambda Expressions


Every lambda expression has three parts:

1.  Argument list
2.  Arrow token (`->`)
3.  Body

Because the compiler needs to match the lambda expression to a method, lambda expressions can only be used with interfaces that contain only one method that has to be implemented. These interfaces are also referred to as **functional interfaces**.

-----

## Using Lambdas

### Creating a Thread

You can use a lambda expression to provide the implementation for the `Runnable` functional interface.

```java
new Thread(()-> {
    System.out.println("Printing from the Runnable");
    System.out.println("Line 2");
    System.out.format("This is line %d\n", 3);
}).start();
```

### Lambdas and Local Variables

Local variables used within a lambda expression must be **final** or **effectively final**. This is because the lambda doesn't own the variable, and the runtime needs a consistent value when the expression is evaluated.

Lambda expressions are treated as nested blocks, so they are within the enclosing block's scope and can access its local variables.

-----

## Functional Programming

Functional programming is a programming paradigm where programs are constructed by applying and composing functions.

  * **Wikipedia:** [Functional programming](https://en.wikipedia.org/wiki/Functional_programming)
  * **Java `Consumer` Interface:** [Consumer Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)

-----

## Functional Interfaces & Predicates

The `java.util.function` package provides many built-in functional interfaces.

  * **Package Documentation:** [`java.util.function`](https://www.google.com/search?q=%5Bhttps://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html%5D\(https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html\))

### Predicate

A `Predicate` is a functional interface that represents a function that takes an argument and returns a boolean.

```java
private static void printEmployeesByAge(List<Employee> employees,
                                      String ageText,
                                      Predicate<Employee> ageCondition) {

    System.out.println(ageText);
    System.out.println("==================");
    for(Employee employee : employees) {
        if (ageCondition.test(employee)) {
            System.out.println(employee.getName());
        }
    }
}
```

**Calling the method with lambdas:**

```java
printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);
```

This can also be done with a more verbose anonymous class:

```java
printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() < 25;
    }
});
```

You can also chain predicates:

```java
IntPredicate greaterThan15 = i -> i > 15;
System.out.println(greaterThan15.test(10)); // output: false

IntPredicate lessThan100 = i -> i < 100;
System.out.println(greaterThan15.and(lessThan100).test(50)); // output: true
```

### Function

A `Function` is a functional interface that takes an argument of one type and returns a result of another type.

**Get last name:**

```java
Function<Employee, String> getLastName = (Employee employee) -> {
    return employee.getName().substring(employee.getName().indexOf(' ') + 1);
};

String lastName = getLastName.apply(employees.get(1));
System.out.println(lastName);
```

**Chaining Functions:**

```java
Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
Function chainedFunction = upperCase.andThen(firstName);
System.out.println(chainedFunction.apply(employees.get(0)));
```

-----

## Streams

A stream is a sequence of object references from a source, which supports aggregate operations. Streams were added in Java 8 and can be created from collections.

  * **`Stream<T>` Interface:** [Stream Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)

### Stream Operations Example

Stream operations are chained together to form a pipeline.

```java
List<String> someBingoNumbers = Arrays.asList(
    "N40", "N36",
    "B12", "B6",
    "G53", "G49", "G60", "G50", "g64",
    "I26", "I17", "I29",
    "O71");

someBingoNumbers
    .stream()
    .map(String::toUpperCase) // `::` is a method reference
    .filter(s->s.startsWith("G"))
    .sorted()
    .forEach(System.out::println);
```

### `flatMap`

When you want to map a single object to more than one object in the output stream, you can use the `flatMap` method. It accepts a function that returns a stream.

```java
// public class Employee { ... }
// public class Department {
//     private String name;
//     private List<Employee> employees;
//     ...
// }

departments.stream()
    .flatMap(department -> department.getEmployees().stream())
    .forEach(System.out::println);
```

### Stream Laziness

Stream chains are evaluated lazily. Nothing happens until a **terminal operation** (like `forEach` or `count`) is added to the chain. At that point, the entire chain is executed.

```java
Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

System.out.println("-----------------------");
System.out.println(concatStream
    .distinct()
    .peek(System.out::println) // executes as part of the terminal operation
    .count()); // terminal operation
```

-----

## Method References

A **method reference** is a shorthand syntax for a lambda expression that executes just ONE method. You use the `::` (colon-colon) notation.

  * **Tutorial:** [Method References](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html)

-----

## Other Useful Interfaces

  * **`Callable<V>`:** [`Callable` Documentation](https://www.google.com/search?q=%5Bhttps://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Callable.html%5D\(https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Callable.html\))
  * **`Comparator<T>`:** [`Comparator` Documentation](https://www.google.com/search?q=%5Bhttps://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html%5D\(https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html\))
