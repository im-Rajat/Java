# Section 18: Debugging and Unit Testing


## Debugging 🐛

Debugging is the process of finding and fixing problems in a program. It's made much easier by using tools like **breakpoints** and **watchpoints**.

* A **watchpoint** stops execution whenever the value of a specific variable or expression changes. This is useful when you don't know exactly *where* in the code the value is changing.
* A **breakpoint** is set on a specific line of code, causing the program to pause its execution right before that line is run.

In short, a **breakpoint** marks a *place* to pause, while a **watchpoint** watches a *piece of data* and pauses when it changes.

---

## Unit Testing ✅

Testing is a crucial phase in the application development lifecycle. **Unit testing** is a specific type of testing, usually performed by the development team, that focuses on testing individual components or "units" of code in isolation. In Java, a unit usually refers to a single **method**.

### JUnit

**JUnit** is a popular, free-to-use testing framework for Java that helps developers write and run repeatable, automated tests on their code.

### Parameterized Testing

This is a feature in testing frameworks like JUnit that allows you to run the same test method multiple times with different input data. It's an efficient way to test a bunch of different scenarios on the same method.
