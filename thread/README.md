# Java Thread Examples 

Simple, easy-to-understand demonstrations of Java Threading concepts.

---

## 1. Thread Creation & Intro — [`ThreadCreationDemo.java`](file:///home/billa/Sriram_repos/Java_skill_dev1/thread/ThreadCreationDemo.java)
Shows the ways to create a thread:
1. **`extends Thread`**: Inheriting from Java's `Thread` class and overriding `run()`.
2. **`implements Runnable`**: Implementing the `Runnable` interface (recommended because Java supports implementing multiple interfaces).
3. **Lambda**: Modern, concise way using Java 8+ lambda.

```bash
javac ThreadCreationDemo.java
java ThreadCreationDemo
```

---

## 2. States of Threads (Lifecycle) — [`ThreadStatesDemo.java`](file:///home/billa/Sriram_repos/Java_skill_dev1/thread/ThreadStatesDemo.java)
Shows how a thread transitions between states using `getState()`:
- **`NEW`**: Created, but `start()` has not been called.
- **`RUNNABLE`**: Ready or actively executing in JVM.
- **`TIMED_WAITING`**: Paused for a specified time via `Thread.sleep()`.
- **`TERMINATED`**: Task execution in `run()` is complete.

```bash
javac ThreadStatesDemo.java
java ThreadStatesDemo
```

---

## 3. Multithreading & Functions — [`ThreadFunctionsDemo.java`](file:///home/billa/Sriram_repos/Java_skill_dev1/thread/ThreadFunctionsDemo.java)
Shows how multiple threads run concurrently and how key thread methods work:
- **`sleep(ms)`**: Temporarily pauses the current thread.
- **`yield()`**: Gives a hint to the CPU scheduler to let other waiting threads run.
- **`join()`**: Forces the calling thread (`main`) to wait until the worker threads finish before proceeding.

```bash
javac ThreadFunctionsDemo.java
java ThreadFunctionsDemo
```
