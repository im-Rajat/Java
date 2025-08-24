# Section 14: Basic Input & Output including `java.util`


## Exceptions: `try`, `catch`, `throw`

Exception handling is crucial for writing robust applications. There are two main philosophical approaches:

1.  **LBYL (Look Before You Leap)**: You check for potential errors *before* performing an operation. This involves using conditional statements to avoid exceptions.

    ```java
    private static int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0; // Return a default value on failure
        }
    }
    ```

2.  **EAFP (Easier to Ask for Forgiveness than Permission)**: You assume the operation will succeed and handle the exception if it fails. This is often considered more idiomatic in Java.

    ```java
    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0; // Handle the exception and return a default value
        }
    }
    ```

### Throwing an Exception

Instead of just catching an exception, you can `throw` a new, more specific one to be handled by the calling code.

```java
try {
    return x / y;
} catch (ArithmeticException e) {
    throw new ArithmeticException("Attempt to divide by zero");
}
```

-----

## Writing and Reading Files (`java.io`)

### Writing Content with `FileWriter` and the `finally` Block

Before Java 7, ensuring that file resources were closed was done using a `try-catch-finally` block. The **`finally`** block **always executes**, whether an exception occurs or not, making it the ideal place for cleanup code like closing a file.

```java
FileWriter locFile = null;
try {
    locFile = new FileWriter("locations.txt");
    for (Location location : locations.values()) {
        locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
    }
} catch (IOException e) {
    System.out.println("In catch block");
    e.printStackTrace();
} finally {
    System.out.println("In finally block");
    try {
        if (locFile != null) {
            System.out.println("Attempting to close locfile");
            locFile.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

### Try-With-Resources (Java 7+)

Java 7 introduced the **try-with-resources** statement, which automatically closes any resources that implement the `AutoCloseable` interface. This makes the code much cleaner and less error-prone.

  * **[Official Docs: Try-with-resources Statement](https://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html)**

<!-- end list -->

```java
// The FileWriter is automatically closed at the end of the block
try (FileWriter locFile = new FileWriter("locations.txt")) {
    for (Location location : locations.values()) {
        locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Reading Data from a File

You can use classes like `Scanner` or `BufferedReader` to read data.

```java
// Using Scanner
try (Scanner scanner = new Scanner(new FileReader("locations.txt"))) {
    scanner.useDelimiter(",");
    while (scanner.hasNextLine()) {
        int loc = scanner.nextInt();
        scanner.skip(scanner.delimiter());
        String description = scanner.nextLine();
        System.out.println("Imported loc: " + loc + ": " + description);
        // ... process data
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Using BufferedReader (often more efficient for reading lines)
try (BufferedReader dirFile = new BufferedReader(new FileReader("directions.txt"))) {
    String input;
    while ((input = dirFile.readLine()) != null) {
        // ... process line
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

-----

## Serialization

> The process of translating a data structure or object state into a format that can be stored (for example, in a file) and later reconstructed is called **Serialization**.

-----

## Java NIO (New I/O)

In Java 1.4, the `java.nio` package was introduced. It provides an improved I/O framework, featuring non-blocking I/O operations, which can lead to better performance and scalability.

### Reading Data with NIO

```java
try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
    String input;
    while ((input = dirFile.readLine()) != null) {
        String[] data = input.split(",");
        int loc = Integer.parseInt(data[0]);
        String direction = data[1];
        // ... process data
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Reading and Writing with NIO's `Files` Class

```java
Path dataPath = FileSystems.getDefault().getPath("data.txt");

// Writing (appending a new line)
Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);

// Reading all lines into a List
List<String> lines = Files.readAllLines(dataPath);
for (String line : lines) {
    System.out.println(line);
}
```

### Writing Binary Data with `FileChannel` and `ByteBuffer`

For high-performance binary I/O, you can use channels and buffers.

```java
try (FileOutputStream binFile = new FileOutputStream("data.dat");
     FileChannel binChannel = binFile.getChannel()) {

    byte[] outputBytes = "Hello World!".getBytes();
    ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
    int numBytes = binChannel.write(buffer);
    System.out.println("numBytes written was: " + numBytes);
    // ... more buffer operations
} catch (IOException e) {
    e.printStackTrace();
}
```

-----

## Working with the File System (NIO)

### Paths: Absolute vs. Relative

  * **Absolute Path**: A full path that specifies the location of a file or directory from the root of the file system (e.g., `C:\Users\YourUser\Documents\file.txt`).
  * **Relative Path**: A path that is relative to the current working directory. It doesn't contain enough information on its own to locate the file (e.g., `documents/file.txt`).

### Common Path and File Operations

NIO provides a powerful and convenient API for interacting with the file system.

  * **Getting Paths**:

    ```java
    // Path relative to the project's working directory
    Path path = FileSystems.getDefault().getPath("FileName.txt");

    // Path from an absolute location
    Path filePath = Paths.get("C:\\full\\path\\to\\fileName.txt");

    // Get the current working directory path
    Path currentPath = Paths.get(".");
    System.out.println(currentPath.toAbsolutePath());
    ```

  * **File Manipulation**:

    ```java
    // Copy a file
    Files.copy(sourceFilePath, copyFilePath);

    // Move a file
    Files.move(fileToMove, destinationPath);

    // Delete a file
    Files.deleteIfExists(fileToDelete);

    // Create a file or directory
    Files.createFile(fileToCreate);
    Files.createDirectory(dirToCreate);
    ```

  * **Further Reading**:

      * **[`Files` Class API](https://www.google.com/search?q=%5Bhttps://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html%5D\(https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html\))**
      * **[`BasicFileAttributes` API](https://www.google.com/search?q=%5Bhttps://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/BasicFileAttributes.html%5D\(https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/BasicFileAttributes.html\))**

### Traversing Directories

You can easily list the contents of a directory or "walk" an entire directory tree.

```java
// List contents of a single directory
Path directory = FileSystems.getDefault().getPath("DirectoryName" + File.separator + "Folder");
try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory)) {
    for (Path file : contents) {
        System.out.println(file.getFileName());
    }
} catch (IOException | DirectoryIteratorException e) {
    System.out.println(e.getMessage());
}
```

> **Tip**: You can pass a filter (a "glob") to `Files.newDirectoryStream()` to select files that match a certain pattern, like `*.txt`.
> `Files.newDirectoryStream(directory, "*.{dat,txt}")`

**Walking the Directory Tree**: Use `Files.walkFileTree()` to recursively visit all files and directories starting from a given path. This is powerful for tasks like searching for a file or deleting an entire directory structure.

-----

## Takeaway

> It's best to use **`java.nio`** when working with the file system (managing paths, copying/moving files, etc.). However, when it comes to reading and writing file *contents*, the older **`java.io`** streams are sometimes still a simpler and better choice.
