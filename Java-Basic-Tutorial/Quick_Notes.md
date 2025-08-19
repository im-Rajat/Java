# Quick Notes


### Java Class and Method Rules

  * If a class is `public`, it must be in a file with the same name as the class.
  * **Static functions** don't require an object to be created to call them.


### Abstract Classes

To prevent object creation from a class, we make it `abstract`.

```java
public abstract class Account {

}
```

  * You cannot create an object directly from the `Account` class.
  * However, you can create objects from classes that inherit the `Account` class.
  * **Abstract methods** must be implemented in derived (child) classes.


### Code Examples

  * **Interface:**

    ```java
    public interface IBaseRate {

    }
    ```

  * **Child Class:**

    ```java
    public class Savings extends Account {

    }
    ```

  * **Parent Class** (cannot create an object from this):

    ```java
    public abstract class Account implements IBaseRate {

    }
    ```
