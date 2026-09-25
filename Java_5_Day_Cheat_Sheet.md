# Java 5-Day OOP + Core Concepts Cheat Sheet

> **Purpose:** Fast revision before interviews and before continuing the main project.  
> Keep this as a quick reference — focus on understanding the idea, syntax, and common interview traps.

---

# Day 1 — Java Basics

## 1. Java

- Java is a **high-level, object-oriented, class-based programming language**.
- Java follows **Write Once, Run Anywhere (WORA)** through the JVM.

### Java flow

```text
.java
  ↓ javac
.class (Bytecode)
  ↓ JVM
Machine code
```

- **JDK** → Develop Java applications
- **JRE** → Runs Java applications
- **JVM** → Executes Java bytecode
- **JIT** → Converts frequently executed bytecode into native machine code for faster execution

---

## 2. Basic Java program

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

### `main()` breakdown

- `public` → accessible to JVM
- `static` → JVM can call it without creating an object
- `void` → returns nothing
- `main` → entry point
- `String[] args` → command-line arguments

---

## 3. Variables and Data Types

### Primitive types

```text
byte
short
int
long
float
double
char
boolean
```

Example:

```java
int age = 20;
double salary = 30000.5;
char grade = 'A';
boolean active = true;
```

### Why `10.5f`?

```java
float price = 10.5f;
```

Decimal literals are normally `double`; `f` tells Java it is a `float`.

---

## 4. Type Casting

### Widening — automatic

```java
int a = 10;
double b = a;
```

### Narrowing — explicit

```java
double a = 10.5;
int b = (int) a;
```

---

## 5. Operators

```text
Arithmetic   + - * / %
Relational   == != > < >= <=
Logical      && || !
Assignment   = += -= *= /=
Unary        ++ --
```

---

## 6. Conditions

```java
if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

Also know:

```text
if
if-else
else-if
switch
ternary ?:
```

---

## 7. Loops

### for

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

### while

```java
while (condition) {
}
```

### do-while

```java
do {
} while (condition);
```

### Enhanced for

```java
for (int mark : marks) {
    System.out.println(mark);
}
```

### Interview traps

- `break` → exits loop/switch
- `continue` → skips current iteration
- `return` → exits method

---

# Day 2 — Arrays, Methods, Classes & Objects

## 1. Array

Stores multiple values of the same type.

```java
int[] marks = {80, 90, 70};
```

Access:

```java
marks[0]
```

Important:

- Index starts at `0`
- `marks.length` gives size
- `ArrayIndexOutOfBoundsException` occurs for invalid index

---

## 2. Array methods

```java
Arrays.sort(arr);
Arrays.toString(arr);
Arrays.fill(arr, 0);
Arrays.binarySearch(arr, 50);
```

### Important

`binarySearch()` expects a **sorted array** for meaningful results.

---

## 3. 2D Array

```java
int[][] matrix = {
    {1, 2},
    {3, 4}
};
```

Access:

```java
matrix[0][1]
```

---

## 4. Method

```java
static int add(int a, int b) {
    return a + b;
}
```

Parts:

```text
static → belongs to class
int    → return type
add    → method name
a,b    → parameters
return → sends result back
```

---

## 5. Method Overloading

Same method name, different parameters.

```java
add(int a, int b)
add(double a, double b)
```

Also called **compile-time polymorphism**.

---

## 6. Varargs

```java
static int sum(int... numbers) {
    return 0;
}
```

Allows variable number of arguments.

```java
sum(10, 20);
sum(10, 20, 30);
```

Inside the method, `numbers` behaves like an array.

---

## 7. Class and Object

### Class

Blueprint.

```java
class Student {
    String name;
}
```

### Object

Actual instance.

```java
Student s = new Student();
```

Remember:

```text
Class  = blueprint
Object = real instance
```

---

## 8. Constructor

```java
class Student {

    Student() {
        System.out.println("Created");
    }
}
```

Constructor:

- Has same name as class
- Has no return type
- Runs when object is created
- Can be overloaded

---

## 9. `this`

Refers to the current object.

```java
Student(String name) {
    this.name = name;
}
```

---

## 10. `static`

Belongs to the **class**, not individual objects.

```java
static int count;
```

Access:

```java
Student.count;
```

Static members can be accessed without creating an object.

---

# Day 3 — OOP Fundamentals

## 1. Four pillars of OOP

```text
Encapsulation
Inheritance
Polymorphism
Abstraction
```

Interface is also an important Java OOP concept.

---

# Encapsulation

Protect data and control access.

```java
class Student {

    private int marks;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        }
    }
}
```

### Remember

```text
private data
    +
public methods
    =
controlled access
```

**Interview:** Encapsulation is more than just `private`; it is controlling access to an object's internal state.

---

# Inheritance

Child reuses parent functionality.

```java
class Student {
    void attendClass() {}
}

class CodingStudent extends Student {
    void code() {}
}
```

```text
Student
   ↑
CodingStudent
```

Keyword:

```java
extends
```

### `super`

```java
super(name);
```

Calls the parent constructor.

---

# Polymorphism

"Many forms."

## Overloading

```java
show()
show(String)
show(String, int)
```

Same name, different parameters.

→ Compile-time polymorphism

## Overriding

Parent:

```java
void achievement() {}
```

Child:

```java
@Override
void achievement() {}
```

→ Runtime polymorphism

Example:

```java
Student s = new CodingStudent();
s.achievement();
```

The overridden child method runs.

### Interview rule

```text
Overloading  → different parameters
Overriding   → child changes parent method behavior
```

---

# Abstraction

Hide implementation details and expose necessary behavior.

```java
abstract class Student {

    abstract void achievement();

    void attendClass() {
        System.out.println("Class");
    }
}
```

### Important

An abstract class:

- Can have abstract methods
- Can have normal methods
- Can have constructors
- Cannot be instantiated directly

This is invalid:

```java
new Student();
```

---

# Abstract method — compulsory implementation

```java
abstract void achievement();
```

Child must implement it:

```java
class CodingStudent extends Student {

    @Override
    void achievement() {
        System.out.println("Coding award");
    }
}
```

If the child does not implement it:

```text
Compile-time error
```

The child must either:

1. Implement the abstract method, or
2. Also be declared `abstract`.

---

# Interface

Interface = contract.

```java
interface Achievement {
    void achieve();
}
```

Implementation:

```java
class Student implements Achievement {

    public void achieve() {
        System.out.println("Achievement");
    }
}
```

Keyword:

```java
implements
```

---

# Multiple Interfaces

Java does not allow:

```java
class C extends A, B
```

But allows:

```java
class C implements A, B
```

This is one reason interfaces are important.

---

# Abstract Class vs Interface

| Abstract Class | Interface |
|---|---|
| `extends` | `implements` |
| Can have constructors | No normal constructor |
| Can have instance state | Usually defines a contract |
| Can have abstract + concrete methods | Can define abstract/default/static methods |
| Class can extend only one class | Class can implement multiple interfaces |

### Easy memory

```text
Abstract class = partial blueprint
Interface      = contract
```

---

# Access Modifiers

```text
public
protected
default
private
```

### Visibility

```text
public     → everywhere
protected  → same package + subclasses
default    → same package
private    → same class
```

---

# `final`

### Variable

```java
final int MAX = 100;
```

Cannot reassign.

### Method

```java
final void show() {}
```

Cannot override.

### Class

```java
final class Student {}
```

Cannot extend.

---

# Day 4 — Collections, Strings & Common Java Utilities

## 1. String

```java
String name = "Java";
```

String is:

- A class
- Immutable

Common methods:

```text
length()
charAt()
substring()
contains()
equals()
equalsIgnoreCase()
toUpperCase()
toLowerCase()
trim()
replace()
split()
```

---

# `==` vs `.equals()`

```java
String a = new String("Java");
String b = new String("Java");

a == b       // false
a.equals(b)  // true
```

```text
==        → reference comparison
equals()  → content comparison
```

For String content, normally use:

```java
a.equals(b)
```

---

# String Immutability

```java
String s = "Java";

s.concat(" Programming");

System.out.println(s);
```

Still:

```text
Java
```

Because String cannot be changed.

Correct:

```java
s = s.concat(" Programming");
```

A new String object is created.

---

# Why String is immutable

Important interview reasons:

- Security
- String Pool optimization
- Hashcode stability
- Safe sharing between threads

---

# StringBuilder

Mutable string-like object.

```java
StringBuilder sb = new StringBuilder("Java");

sb.append(" Programming");

System.out.println(sb);
```

Use when repeatedly modifying/building text.

### String vs StringBuilder

```text
String        → immutable
StringBuilder → mutable
```

---

# StringBuffer

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" Programming");
```

```text
StringBuilder → mutable, generally faster
StringBuffer  → mutable, synchronized/thread-safe
```

---

# String Manipulation

### Reverse

```java
String reversed =
    new StringBuilder("Java")
        .reverse()
        .toString();
```

### Replace

```java
"Java".replace("a", "o");
```

### Split

```java
"a,b,c".split(",");
```

Produces multiple parts.

---

# Wrapper Classes

Primitive → Wrapper

```text
int     → Integer
double  → Double
char    → Character
boolean → Boolean
```

### Autoboxing

```java
Integer x = 10;
```

### Unboxing

```java
int y = x;
```

---

# ArrayList

Resizable array.

```java
ArrayList<String> names = new ArrayList<>();

names.add("Arun");
names.add("Kumar");

names.remove("Arun");
```

Useful methods:

```text
add()
get()
set()
remove()
contains()
size()
clear()
```

---

# HashSet

Stores unique values.

```java
Set<Integer> numbers = new HashSet<>();

numbers.add(10);
numbers.add(10);
```

Only one `10` is stored.

```text
Set → unique values
```

---

# HashMap

Key-value pairs.

```java
Map<Integer, String> students = new HashMap<>();

students.put(101, "Arun");
students.put(102, "Kumar");
```

Get:

```java
students.get(101);
```

Remember:

```text
List → ordered collection
Set  → unique values
Map  → key-value
```

---

# Day 5 — Exception Handling & Multithreading

# Exception Handling

An exception is an event that disrupts normal program execution.

Example:

```java
int x = 10 / 0;
```

Produces:

```text
ArithmeticException
```

---

# try-catch

```java
try {
    int x = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

Remember:

```text
try   → risky code
catch → handle error
```

---

# finally

```java
try {
    // risky code
}
catch (Exception e) {
    // handle
}
finally {
    // cleanup
}
```

Common purpose:

- Close resources
- Release resources
- Cleanup

---

# Multiple catch

```java
try {
    // code
}
catch (ArithmeticException e) {
}
catch (ArrayIndexOutOfBoundsException e) {
}
```

Different exceptions can have different handling.

---

# `throw`

Manually create/throw an exception.

```java
if (age < 18) {
    throw new IllegalArgumentException("Invalid age");
}
```

Remember:

```text
throw → actually throws an exception
```

---

# `throws`

Declare that a method may throw an exception.

```java
void readFile() throws IOException {
}
```

Remember:

```text
throw  → throw exception
throws → declare exception
```

---

# Checked vs Unchecked

### Checked

Compiler requires handling or declaration.

Examples:

```text
IOException
SQLException
FileNotFoundException
```

### Unchecked

Usually runtime exceptions.

Examples:

```text
NullPointerException
ArithmeticException
ArrayIndexOutOfBoundsException
```

---

# Custom Exception

```java
class InvalidMarksException extends Exception {

    InvalidMarksException(String message) {
        super(message);
    }
}
```

Use it when your application needs a meaningful domain-specific error.

---

# Thread

A thread is a unit of execution.

Example idea:

```text
Application
 ├── Download thread
 ├── Upload thread
 └── Processing thread
```

---

# Creating a Thread

```java
class MyThread extends Thread {

    public void run() {
        System.out.println("Running");
    }
}
```

Start:

```java
MyThread t = new MyThread();
t.start();
```

### Critical interview point

```text
start() → starts a new thread
run()   → contains the task
```

Calling:

```java
t.run();
```

does not start a new thread in the normal `Thread` API sense; it is just a normal method call.

---

# Thread Life Cycle (Thread States)

A thread in Java always exists in one of the 6 states (defined in `Thread.State`):

```text
       NEW
        │ start()
        ▼
    RUNNABLE ◄────────────────────────┐
        │                             │
        ├── sleep(ms) / wait(ms) ──► TIMED_WAITING
        ├── wait() / join() ───────► WAITING
        └── lock unavailable ──────► BLOCKED
        │
        ▼ run() finishes
   TERMINATED
```

### The 6 States

```text
NEW            → Thread created using new, but start() not called yet
RUNNABLE       → Ready to run or executing in JVM
BLOCKED        → Waiting to acquire a monitor lock (synchronized)
WAITING        → Waiting indefinitely for another thread (wait / join)
TIMED_WAITING  → Waiting for a specified time (sleep / timed wait)
TERMINATED     → run() method execution completed
```

### Check Thread State

```java
Thread t = new Thread(() -> System.out.println("Running"));

System.out.println(t.getState()); // NEW
t.start();
System.out.println(t.getState()); // RUNNABLE
```

---

# Multithreading

Multiple threads can execute concurrently.

```java
Thread t1 = new Task1();
Thread t2 = new Task2();

t1.start();
t2.start();
```

Output order may change.

---

# `sleep()`

```java
Thread.sleep(1000);
```

Pauses the current thread for approximately:

```text
1000 milliseconds = 1 second
```

It can throw `InterruptedException`.

---

# `join()`

```java
t1.start();
t1.join();
t2.start();
```

Means:

> Wait for `t1` to finish before continuing.

---

# Runnable

Alternative to extending `Thread`.

```java
class Task implements Runnable {

    public void run() {
        System.out.println("Task");
    }
}
```

Run:

```java
Thread t = new Thread(new Task());
t.start();
```

Why useful?

A Java class can extend only one class, but it can implement interfaces.

---

# Lambda + Runnable

Short modern syntax:

```java
Thread t = new Thread(() -> {
    System.out.println("Running");
});

t.start();
```

---

# Race Condition

When multiple threads access/change shared data and the result depends on timing.

Example:

```text
Thread 1 → count++
Thread 2 → count++
```

Both access the same `count`.

The result can become inconsistent.

---

# synchronized

Protects critical sections from concurrent access.

```java
synchronized void increment() {
    count++;
}
```

Simple idea:

```text
Thread 1 → 🔒 enters
Thread 2 → waits
Thread 1 → 🔓 exits
Thread 2 → enters
```

---

# Day 5 Interview Quick Questions

1. Why is String immutable?
2. String vs StringBuilder?
3. `==` vs `.equals()`?
4. What is an exception?
5. Checked vs unchecked exception?
6. `throw` vs `throws`?
7. Why use `finally`?
8. What is a custom exception?
9. What is a thread?
10. `start()` vs `run()`?
11. What is multithreading?
12. What does `sleep()` do?
13. What does `join()` do?
14. What is Runnable?
15. What is a race condition?
16. Why use `synchronized`?
17. What are the states in Thread Life Cycle?

---

# ⭐ 5-Day Super-Fast Revision

```text
DAY 1
Java basics
JDK / JRE / JVM / JIT
main()
variables
data types
operators
conditions
loops
casting

DAY 2
Arrays
Methods
Overloading
Varargs
Classes
Objects
Constructors
this
static

DAY 3
Encapsulation
Inheritance
Polymorphism
Abstraction
Interfaces
Overloading vs Overriding
super
Access modifiers
final

DAY 4
String
String immutability
StringBuilder
StringBuffer
String methods
Arrays utilities
Wrapper classes
ArrayList
HashSet
HashMap

DAY 5
Exception handling
try/catch/finally
throw/throws
Custom exceptions
Checked/Unchecked
Thread
Thread life cycle / States
Multithreading
start/run
sleep
join
Runnable
Race condition
synchronized
```

# Golden Interview Memory

```text
private       → Encapsulation
extends       → Inheritance
override      → Polymorphism
abstract      → Abstraction
implements    → Interface
static        → Class-level
final         → Cannot change/override/extend
this          → Current object
super         → Parent
try/catch     → Handle exception
throw         → Throw exception
throws        → Declare exception
start()       → Start thread
run()         → Thread task
join()        → Wait for thread
synchronized  → Control shared access
```

**One-line OOP memory:**

> **Encapsulation = Protect | Inheritance = Reuse | Polymorphism = Many forms | Abstraction = Hide | Interface = Contract**
