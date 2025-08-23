# Section 3: First Steps


  * **JRE**: Java Runtime Environment enables Java code execution.
  * **JDK**: Java Development Kit is the software used to create and run/execute Java Programs.
  * **IDE**: Integrated Development Environment. Used to edit, build, run, and debug.

**Execution Flow:**
`IDE -> JDK -> (Java App -> JRE -> Host Environment)`

**Keywords** are case-sensitive.

```java
public class Hello {
}
```

  * `public` and `class` are two Java keywords.

-----

## Core Concepts

  * **Method**: A collection of statements that performs an operation.
  * **Main method**: The entry point of any Java code.
  * `"Hello World"`: This is a **literal string**.
  * **Strings**: A data type in Java that is not a primitive type; it's a **Class**.
      * If you add a string with an integer, Java will convert the integer to a string.
      * Strings in Java are **immutable**.

-----

## Data Types

### Primitive Types

There are 8 primitive types: `int`, `boolean`, `byte`, `char`, `short`, `long`, `float`, and `double`.

  * **Wrapper Classes**: For each primitive type, there is a corresponding wrapper class (e.g., `Integer` for `int`).

### Size and Precision

| Type | Size | Width | Notes |
| :--- | :--- | :--- | :--- |
| **Byte** | 8 bits | 8 | |
| **Short** | 16 bits | 16 | |
| **Int** | 32 bits | 32 | Generally the best data type for whole numbers. |
| **Char** | 16 bits | 16 | Stores Unicode characters (65,535 possibilities). |
| **Boolean** | - | - | Represents `true` or `false`. |
| **Float** | 32 bits | 32 | Single-precision floating-point number. |
| **Double** | 64 bits | 64 | Double-precision floating-point number. |

### Casting

Casting means to treat or convert a number from one type to another. Java uses `int` by default for whole number values in expressions.
*Example:* `(byte) (myMinByteValue / 2);`

-----

## Operators

  * **Operator**: A symbol that performs a specific operation (e.g., `+`, `-`, `*`, `/`).
  * **Operand**: The object that is manipulated by an operator.
  * **Expression**: A combination of operators, operands, variables, and literals.

### Abbreviating Operators

  * `a + 1` can be written as `a++`.
  * `a = a + 2` can be written as `a += 2`.

### Other Operators

  * **Logical AND & OR**: `&&` and `||`, which operate on boolean operands.
  * **Ternary Operator**: `? :` is a shortcut for an `if-then-else` statement.

**Note**: Operator Precedence is also important to understand the order of operations.
