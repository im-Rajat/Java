# Java Programming Course

Following Java Programming Masterclass for Software Developers (Udemy):  
https://www.udemy.com/course/java-the-complete-java-developer-course/



## Section 1: Course Introduction


## Section 2: Software Tools Setup


## Section 3: First Steps

### Core Concepts

  * **JRE (Java Runtime Environment)**: Enables Java code execution.
  * **JDK (Java Development Kit)**: Software used to create and run/execute Java programs.
  * **IDE (Integrated Development Environment)**: A tool to edit, build, run, and debug code.

**Execution Flow:** `IDE` -\> `JDK` -\> (`Java App` -\> `JRE` -\> `Host Environment`)

Keywords in Java are **case-sensitive**.

```java
public class Hello {
}
```

> `public` and `class` are two Java keywords.

-----

### Methods and Literals

  * **Method**: A collection of statements that performs an operation.
  * **Main method**: The entry point of any Java code.
  * **Literal String**: A sequence of characters, like `"Hello World"`.

-----

### Data Types

#### Primitive Types

There are 8 primitive types: `int`, `boolean`, `byte`, `char`, `short`, `long`, `float`, and `double`.

#### Wrapper Classes

For primitive types, there are corresponding Wrapper classes. For example, the `int` primitive type has the `Integer` Wrapper class.

#### Size of Primitive Types

  * **Byte**: 8 bits
  * **Short**: 16 bits
  * **Int**: 32 bits
  * **Char**: 16 bits (stores Unicode characters, representing 65,535 different characters)
  * **Boolean**: In Java, this is `true` or `false`.

> The `Integer` (`int`) is generally the best data type for whole numbers.

#### Single and Double Precision

  * **Float**: Single precision, 32 bits
  * **Double**: Double precision, 64 bits

#### Strings

A **String** is a data type in Java, but it's not a primitive type; it's a **Class**. Strings in Java are **immutable**. If you add a string with an integer, Java will convert the integer to a string and create a new string.

-----

### Casting

Casting means to treat or convert a number from one type to another.
**Example**: `(byte) (myMinByteValue / 2)`

-----

### Operators

  * **Operator**: Performs a specific operation (e.g., `+`, `-`, `*`, `/`).
  * **Operand**: The object that is manipulated by an operator.
  * **Expression**: A combination of operators and operands.

#### Abbreviating Operators

  * `a + 1` can be written as `a++`.
  * `a = a + 2` can be written as `a += 2`.

#### Logical Operators

  * **Logical AND (`&&`)** and **Logical OR (`||`)** operate on boolean operands.

#### Ternary Operator

  * The ternary operator (`?:`) is a shortcut for an if-then-else statement.

> **Operator Precedence** is an important concept to understand the order in which operations are performed.


