# Section 11: Naming Conventions, Packages, `static` and `final` keywords


## Naming Conventions

1.  **Packages**: Lower case, unique, and should not start with a number. Can start with `com`.
    * *Example*: `com.rj`
2.  **Class Names**: `CamelCase`, typically nouns, and start with a capital letter.
    * *Examples*: `ArrayList`, `LinkedList`
3.  **Interface Names**: `CamelCase`.
    * *Examples*: `List`, `Comparable`, `Serializable`
4.  **Method Names**: `mixedCase` (camel case starting with a lowercase letter), often verbs.
    * *Examples*: `size()`, `getName()`, `addPlayer()`
5.  **Constants**: `ALL_UPPER_CASE`, with words separated by an underscore (`_`). Declared using the `final` keyword.
    * *Example*: `static final int MAX_INT`
6.  **Variable Names**: `mixedCase`, should be meaningful and indicative, starting with a lowercase letter. Do not use underscores.
    * *Examples*: `i`, `league`, `boxLength`
7.  **Type Parameters**: Single, capital letters (used in Generics).
    * *Examples*: `E` (Element), `K` (Key), `T` (Type), `V` (Value)

---

## Packages

Packages make it easy to locate classes and interfaces, organizing code into a logical structure. 📦

We can create our own code package (saved as a `.jar` file) and import it into another project as a library. This allows us to reuse functions across different projects.

### Creating Your Package (Library)

1.  Select the desired package (e.g., `com.your.package`) in your project structure.
2.  Navigate to **File** -> **Project Structure** -> **Artifacts**.
3.  Click the **+** icon, select **JAR**, and then choose **From modules with dependencies...**.
4.  Confirm the settings and default location, then click **OK**.
5.  To build the file, go to **Build** -> **Build Artifacts...** and select the **Build** action from the menu.

The `.jar` file will be created in the `out/artifacts/ProjectName_jar/` directory.

### Using a Created Package (Library) in Other Projects

1.  Navigate to **File** -> **Project Structure** -> **Libraries**.
2.  Click the **+** icon and select **Java**.
3.  Locate and select your created `.jar` file.
4.  Click **OK** through the dialogs to confirm.

The library is now added to the project and can be found under "External Libraries".

---

## Scope

Scope refers to the **visibility** of a class, member, or variable.

> **Note:** To call a base class method from an inner class when the inner class has a method with the same name, use the following syntax:
> `MainClass.this.functionName();`

---

## Access Modifiers

### At Top Level

At the top level of a source file, only classes, interfaces, and enums can exist.

* **`public`**: The object is visible to all classes everywhere.
* **Package-private (default)**: The object is only available within its own package. This is the default access level if you don't specify a modifier (like `public`). There is no `package-private` keyword.

### At Member Level

This applies to variables and methods within a class.

* **`public`**: Visible everywhere.
* **Package-private (default)**: Visible only to classes within the same package.
* **`private`**: The member is only visible **within the class** it is declared in. It is not accessible anywhere else, including subclasses.
* **`protected`**: The member is visible within its own package (like package-private) and also in subclasses, even if they are in a different package.

> **Interface Exception**: All methods and variables in an interface are implicitly **`public`**. The lack of an access modifier here does *not* mean package-private. It is not possible to have `private` or `protected` methods in an interface.

---

## `static` Keyword

**Static members belong to the class, not to an instance of the class.** This means you can access them using the class name directly, without creating an object.

* **Accessing static members**: `ClassName.staticMethodName();`
* The `main` method must be `static` so the Java Virtual Machine (JVM) can call it without creating an instance of the class.

**Key Rules:**
* Non-static methods and fields **cannot** be referenced from a static context (like the `main` method). This is because non-static members require an object instance to exist, but a static context is not tied to any specific object.
* However, you can call static methods from a non-static method without any issues.
* Static methods *can* access non-static fields and methods of *another* class, but only by creating an instance of that class first.

---

## `final` Keyword

The `final` keyword is used to create constants and restrict modification.

* **`final` variables**: Used to define constant values. A `final` variable can only be assigned a value **once**. This assignment must happen either at declaration or within the class constructor.
* **`final` classes**: A class marked as `final` **cannot be subclassed** (extended).
* **`final` methods**: A method marked as `final` in a superclass **cannot be overridden** by its subclasses.

> **Execution Order Note**: `static` initialization blocks are executed first, in the order they appear in the code. The constructor is called only after all static initializers have completed.
