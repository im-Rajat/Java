# Section 5: Control Flow Statements


In Java, there are four key control flow statements used for looping and selection. 🔄

1.  **Switch** statement
2.  **For** statement
3.  **While** statement
4.  **Do-while** statement

-----

## Switch Statement

The `switch` statement executes a block of code depending on the value of a variable or an expression.

```java
int switchValue = 5;
switch(switchValue) {
    case 1:
        System.out.println("Value was 1");
        break;
    case 2:
    case 3:
    case 4:
        System.out.println("was a 2, or a 3, or a 4");
        System.out.println("Actually it was a " + switchValue);
        break;
    default:
        System.out.println("Was not 1, 2, 3, or 4");
        break; // Technically don't need this break at the end
}
```

-----

## For Statement

The `for` loop is used to iterate over a range of values or a collection. Its syntax consists of initialization, a termination condition, and an increment/decrement step.

**Syntax:** `for(initialization; termination_condition; increment)`

-----

## While Statement

A `while` loop executes a block of code as long as its condition is true. The condition is checked *before* the loop body is executed.

**Syntax & Example:**

```java
// Syntax
while(condition) {
    // statements
}

// Example
int count = 0;
while(count != 5) {
    System.out.println("Count value is " + count);
    count++;
}
```

-----

## Do-While Statement

A `do-while` loop is similar to a `while` loop, but it checks the condition *after* executing the loop body. This means the loop will always run at least once.

**Syntax & Example:**

```java
// Syntax
do {
    // statements
} while(condition);

// Example
int count = 1;
do {
    System.out.println("Count value is " + count);
    count++;
} while (count != 6);
```

-----

## Loop Control: `continue` & `break`

  * **continue**: Skips the current iteration of a loop and proceeds to the next one. Any code below the `continue` statement in the current iteration will not be executed.
  * **break**: Exits the loop entirely, regardless of the loop's condition.

-----

## Reading User Input ⌨️

You can read input from the user using the `Scanner` class.

```java
import java.util.Scanner;

// Create a scanner object
Scanner scanner = new Scanner(System.in);

System.out.println("Enter your name: ");
String name = scanner.nextLine(); // Reads a line of text

// Note: If reading numbers before a string, you might need an extra scanner.nextLine()
// to handle the newline character left by the previous read.
// scanner.nextLine();

// Close the scanner to prevent resource leaks
scanner.close();
```
