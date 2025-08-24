# Section 21: Java 9 Module System


Java 9 introduced a new program component known as a **module** through **Project Jigsaw**. A Java application can be seen as a collection of modules.

A **Module** is a named collection of data and code. Every module includes a **module descriptor file** named `module-info.java`, which is located in the module's root folder and contains metadata about the module.

---

## Normal vs. Open Modules

There are two main types of modules:

* A **Normal Module** (without the `open` modifier) grants access at compile-time and run-time *only* to types in packages that are explicitly exported.

* An **Open Module** (with the `open` modifier) grants compile-time access *only* to explicitly exported packages, but it grants run-time access to types in *all* its packages, as if they were all exported. This is particularly useful for reflection.

---

## Project Jigsaw

Project Jigsaw had four primary goals:

1.  **Scalable Platform:** Make Java more scalable for smaller devices.
2.  **Security and Maintainability:** Improve security and make the platform easier to maintain.
3.  **Improved Application Performance:** Enhance application performance.
4.  **Easier Developer Experience:** Simplify the development process.

---

## Module Terminology

Project Jigsaw and the community use several terms to describe different types of modules:

* **Named Modules:** An informal term for a standard module that has a `module-info.java` descriptor file and isn't an automatic module.

* **Unnamed Modules:** A module that does not have a name and is not explicitly declared.

* **Automatic Module:** Created when a regular JAR file (one without a `module-info.java` file) is placed on the module path.

* **Basic Modules:** An informal term for any module that is not an `open` module.

* **Aggregator Modules:** Convenience modules that usually contain no code of their own. They simply have a module descriptor that collects and re-exports the contents of other modules.

---

## Module Path vs. Class Path

* A **Module Path** is used by the compiler to find and resolve modules. Every module on the module path must have a module declaration (`module-info.java`).

* A **Class Path** represents a sequence of JAR files, used in pre-modular Java for locating classes.
