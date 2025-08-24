# Section 15: Concurrency in Java


## Core Concepts: Process vs. Thread

  * **Process**: A unit of execution that has its own dedicated memory space (heap). When you run two separate Java applications, the JVM starts two processes, each with its own heap.

  * **Thread**: A unit of execution *within* a process. Each process can have multiple threads. All threads within a single process share the same heap, but each thread has its own **thread stack**, which is a memory area only that specific thread can access.

> **Concurrency** refers to an application doing more than one thing at a time. Essentially, it means that one task doesn't have to complete before another one can start. 🚀

-----

## Creating and Running Threads

There are two primary ways to create threads in Java.

### Method 1: Subclassing the `Thread` Class

1.  **Create a class that extends `Thread` and override the `run()` method.**
    ```java
    public class AnotherThread extends Thread {
        @Override
        public void run() {
            System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());
        }
    }
    ```
2.  **Create an instance of the class and call the `start()` method.**
    ```java
    Thread anotherThread = new AnotherThread();
    anotherThread.setName("== Another Thread ==");
    anotherThread.start(); // This invokes the run() method on a new thread.
    ```
    > **Note**: Don't call `run()` directly\! This will execute the code on the current (e.g., `main`) thread, not on a new one. You **must** call `start()`.

<!-- end list -->

  * **Anonymous Class Variation:**
    ```java
    new Thread() {
        public void run() {
            System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
        }
    }.start();
    ```

### Method 2: Implementing the `Runnable` Interface

This is the **recommended and more flexible** approach because it separates the task (`Runnable`) from the execution mechanism (`Thread`), and it allows your class to extend another class if needed.

1.  **Create a class that implements `Runnable` and the `run()` method.**
    ```java
    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run()");
        }
    }
    ```
2.  **Create an instance of `Thread`, passing your `Runnable` object to its constructor, then call `start()`**
    ```java
    Thread myRunnableThread = new Thread(new MyRunnable());
    myRunnableThread.start();
    ```

<!-- end list -->

  * **Anonymous `Runnable` Variation:**
    ```java
    Thread myRunnableThread = new Thread(new MyRunnable() {
        @Override
        public void run() {
            System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
        }
    });
    myRunnableThread.start();
    ```

-----

## Basic Thread Management

  * **Sleeping a thread**: Pauses the thread's execution for a specified amount of time.
    ```java
    try {
        Thread.sleep(3000); // Sleep for 3 seconds (3000 milliseconds)
    } catch(InterruptedException e) {
        System.out.println(ANSI_BLUE +  "Another thread woke me up");
    }
    ```
  * **Interrupting a thread**: A way to signal to a thread that it should stop what it's doing. The thread must have code to check for the interrupted status and react accordingly.
    ```java
    anotherThread.interrupt();
    ```
  * **Joining a thread**: Causes the current thread to wait until the thread it's joining on has completed its execution.
    ```java
    anotherThread.join(); // The current thread will pause here until anotherThread finishes.
    ```

-----

## Synchronization and Race Conditions

Local variables are stored on the **thread stack**, meaning each thread gets its own copy. In contrast, object instances are stored on the **heap**, which is shared by all threads in a process.

When multiple threads access and modify a shared resource on the heap, it can lead to a **race condition** (also called thread interference).

> **Synchronization** is the process of controlling when threads can execute code, ensuring that only one thread at a time can access a shared resource.

### How to Synchronize Code

1.  **Synchronized Method**: Add the `synchronized` keyword to the method signature. Only one thread can execute *any* synchronized method on a given object instance at a time.
    ```java
    public synchronized void doCountdown() { /* ... */ }
    ```
2.  **Synchronized Block**: Synchronize only a specific block of statements rather than an entire method. This is more granular and often preferred.
    ```java
    public void doCountdown() {
        // ... non-critical code ...
        synchronized(this) {
            // This is the critical section
        }
        // ... other non-critical code ...
    }
    ```

<!-- end list -->

  * **Critical Section**: The part of the code that accesses a shared resource and must be protected from concurrent access.
  * **Thread-Safe**: A class or method is considered thread-safe if its critical sections are properly synchronized, protecting developers from having to manage thread interference themselves.

-----

## Advanced Concurrency Tools and Problems

### Deadlocks, `wait()`, `notify()`, `notifyAll()`

These are core concepts for inter-thread communication, where threads might need to wait for a certain condition to be met before proceeding.

  * **[Collections Docs (synchronizedList)](https://www.google.com/search?q=https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html%23synchronizedList-java.util.List-)**
  * **[ArrayList Docs (Not thread-safe)](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)**

### Using `ReentrantLock` instead of Synchronization

The `java.util.concurrent.locks` package provides a more flexible and powerful alternative to `synchronized` blocks.

  * **[Lock Interface Docs](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Lock.html)**

<!-- end list -->

```java
ReentrantLock bufferLock = new ReentrantLock();

// ...
bufferLock.lock();
try {
    // This is the critical section
} finally {
    bufferLock.unlock(); // IMPORTANT: Always unlock in a finally block!
}
```

### Thread Pools with `ExecutorService`

Creating new threads is computationally expensive. A **thread pool** reuses a fixed number of threads to execute tasks.

```java
// Create a thread pool with 3 threads
ExecutorService executorService = Executors.newFixedThreadPool(3);

// Submit a task to the pool instead of creating a new thread
executorService.execute(myRunnableTask);

// Always shut down the service when you're done with it
executorService.shutdown();
```

  * **[ExecutorService Docs](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html)**

-----

## Common Multithreading Problems

### 1\. Deadlock

A deadlock occurs when two or more threads are blocked forever, each waiting for a lock held by another thread in the group.

  * **Example**: Thread 1 holds Lock A and is waiting for Lock B. Thread 2 holds Lock B and is waiting for Lock A. Neither can proceed.

**How to Prevent Deadlock:**

1.  **Acquire locks in the same order**: Ensure all threads acquire the multiple locks they need in a consistent, predefined order.
2.  Avoid nested locks where possible.
3.  Use a `ReentrantLock` with a timeout to prevent indefinite waiting.

### 2\. Starvation

Starvation occurs when a thread is perpetually denied access to a resource because other "greedier" threads are constantly using it. This often happens due to thread priorities, where low-priority threads rarely get a chance to run.

  * **Setting Priority**: `t1.setPriority(10);` (Range is 1-10). Note that this is only a suggestion to the OS scheduler.
  * **Solution: Fair Locks**: A `ReentrantLock` can be made "fair," meaning it grants access to the longest-waiting thread first (FIFO). This prevents starvation but can reduce performance (throughput).
    ```java
    private static ReentrantLock lock = new ReentrantLock(true); // true = fair
    ```

### 3\. Livelock

A livelock is similar to a deadlock, but the threads are not blocked. Instead, they are constantly active, but are unable to make progress because they are continuously reacting to each other's state changes.

### 4\. Slipped Condition (Race Condition)

This occurs when a thread checks a condition (e.g., `if (x == 5)`) and is then suspended *before* it can act on that condition. By the time it resumes, the condition may no longer be true, leading to incorrect behavior.

  * **Solution**: Synchronize the block of code that includes both the check and the action.

-----

## Atomic Actions and the `volatile` Keyword

An **atomic action** is an operation that completes in a single step without interruption.

**The following are atomic in Java:**

1.  Reading and writing **reference variables**.
2.  Reading and writing **primitive variables**, *except* for `long` and `double`.
3.  Reading and writing all variables declared as **`volatile`**.

<!-- end list -->

  * **`volatile` Keyword**: Guarantees that any write to a volatile variable is written directly to main memory, and any read retrieves the latest value from main memory. This ensures visibility of changes across threads.
  * **[Atomic Package Docs](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html)**
  * **[AtomicInteger Docs](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/AtomicInteger.html)**
  * JavaFX Background Tasks :- https://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/Task.html

-----

## Final Troubleshooting Checklist

  * **Local variables are inherently thread-safe** because they reside on the thread stack.
  * When debugging a deadlock, look for the following:
    1.  Is a set of locks being obtained in a **different order** by multiple threads? Can you force them to use the same order?
    2.  Are you **over-synchronizing** the code? Can you reduce the scope of your synchronized blocks?
    3.  Can you rewrite the code to break any **circular call patterns**?
    4.  Would using a `ReentrantLock` object with a timeout help?
