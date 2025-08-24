# Section 23: Course Remaster in Progress


A **keyword** is one of the \~57 reserved words in Java that have a specific meaning to the compiler. New keywords are occasionally added in new versions of the language.

## Helpful Links & Resources

  * **List of Java Keywords:** [https://en.wikipedia.org/wiki/List\_of\_Java\_keywords](https://en.wikipedia.org/wiki/List_of_Java_keywords)
  * **Google Java Style Guide:** [https://google.github.io/styleguide/javaguide.html](https://google.github.io/styleguide/javaguide.html)
  * **Java Operator Precedence Table:** [http://www.cs.bilkent.edu.tr/\~guvenir/courses/CS101/op\_precedence.html](http://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html)

-----

## Statements

**Statements** are like sentences in natural language; they form a complete unit of execution.

There are three main types of statements in Java:

1.  **Declaration Statement:** Declares a variable.

      * Example: `int finalScore = 50;`

2.  **Expression Statements:** Expressions that can stand alone as a full instruction.

      * **Assignments:** `groupAge = 5;`, `salary *= 2;`
      * **Increment/Decrement:** `num++;`, `result--;`
      * **Method Calls:** `System.out.println("Testing");`
      * **Object Creation:** `Car ownerCar = new Car();`

3.  **Control Flow Statement:** Directs the order in which statements are executed.

      * Examples: `if-then-else`, looping statements (`for`, `while`), and branching statements (`break`, `continue`, `return`).

-----

## Methods

**Methods** are a way to organize code into reusable blocks. This reduces duplication and makes your code easier to maintain.

### Method Signature

The general format for defining a method in Java is:

```java
<MODIFIER> <RETURN TYPE> methodName(<PARAMETERS>) {
    // Method body
}
```
