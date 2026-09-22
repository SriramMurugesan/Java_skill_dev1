# Control Structures and Loops: Deep Dive, Pitfalls & Tricky Interview Questions

---

## 1. Overview

Control structures determine the execution flow of a program. Java provides three main categories:
1. **Selection / Decision Making**: `if`, `if-else`, `switch`
2. **Iteration / Looping**: `for`, enhanced `for-each`, `while`, `do-while`
3. **Jump / Transfer**: `break`, `continue`, `return`

---

## 2. Decision Making Statements

### A. The `if` and `if-else` Statement

#### 1. Dangling Else Problem:
In Java, an `else` clause always binds to the **nearest preceding unmatched `if`**, regardless of indentation!

```java
int x = 5, y = 10;
if (x > 10) 
    if (y > 5) 
        System.out.println("A");
else 
    System.out.println("B"); // Which if does this belong to?
```
> **Output**: Nothing is printed!
> **Why**: The `else` belongs to `if (y > 5)`, not `if (x > 10)`. Since `x > 10` is false, the entire inner block is skipped.
> **Best Practice**: Always use curly braces `{}`.

#### 2. Assignment vs Equality Trap:
```java
boolean isAvailable = false;

// Common typo: = (assignment) instead of == (comparison)
if (isAvailable = true) { 
    System.out.println("Available!"); // This PRINTS!
}
```
> **Explanation**: Unlike numeric types where `if (x = 5)` causes a compiler error (`incompatible types: int cannot be converted to boolean`), with booleans `isAvailable = true` assigns `true` to the variable and evaluates to `true`!

---

### B. The `switch` Statement

#### 1. Permitted Data Types in `switch`:
Java permits only specific types in a `switch(expression)`:
- Primitive integers: `byte`, `short`, `char`, `int`
- Wrapper classes: `Byte`, `Short`, `Character`, `Integer`
- `String` (Supported since Java 7)
- `enum` (Supported since Java 5)

> **IMPORTANT**: `long`, `float`, `double`, and `boolean` are **NOT allowed** in a `switch` statement.
> - `float` and `double` are disallowed because floating-point numbers have rounding inaccuracies, making exact equality comparison unreliable.
> - `long` is disallowed because the JVM's `tableswitch` and `lookupswitch` bytecode instructions are limited to 32-bit values.

#### 2. Fallthrough Behavior:
If a `case` block does not end with `break`, execution continues unconditionally into the subsequent cases until a `break` or the end of the `switch` is encountered.

#### 3. Placement of `default`:
The `default:` label does **not** have to be at the bottom. It can be placed at the top or in the middle. If no match is found, control jumps to `default`, and if there is no `break`, it falls through into subsequent cases!

#### 4. Modern Java Switch Expressions (Java 14+):
Modern Java introduced arrow syntax (`->`), which eliminates fallthrough and returns values:
```java
String dayName = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 6, 7 -> "Weekend";
    default -> {
        System.out.println("Invalid day");
        yield "Unknown"; // 'yield' returns a value from a block
    }
};
```

---

## 3. Looping Statements Deep Dive

### A. The Classic `for` Loop
Syntax:
```java
for (initialization; termination_condition; update) {
    // body
}
```
- **Multiple declarations**: You can declare multiple variables in the initialization part **only if they are of the same type**:
  ```java
  for (int i = 0, j = 10; i < j; i++, j--) {
      System.out.println(i + " - " + j);
  }
  ```
- **Empty loop components**: All three parts are optional. An empty `for(;;)` creates a valid infinite loop equivalent to `while(true)`.

---

### B. `while` vs. `do-while`

| Feature | `while` Loop | `do-while` Loop |
| :--- | :--- | :--- |
| **Control Type** | Entry-controlled (Pre-test) | Exit-controlled (Post-test) |
| **Minimum Executions** | **0** (If condition is initially false) | **1** (Condition checked after first run) |
| **Syntax Requirement** | `while (cond) { }` | `do { } while (cond);` (Mandatory `;` at end) |

---

### C. Enhanced `for-each` Loop
Introduced in Java 5 to iterate over arrays and `Iterable` collections.
```java
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}
```
**Limitations**:
1. Read-only traversal: You cannot modify array elements directly (e.g., `num = 10` does not change the array).
2. No access to the index.
3. Cannot iterate backwards.
4. Modifying a Collection's structure during a `for-each` loop throws `ConcurrentModificationException`.

---

### D. Labeled `break` and `continue`

In nested loops, standard `break` and `continue` only affect the innermost loop.
**Labeled statements** allow you to break or continue an **outer** loop from within an inner loop.

```java
outerLoop:
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        if (i == 2 && j == 2) {
            break outerLoop; // Terminates the outer loop completely!
        }
        System.out.println("i=" + i + ", j=" + j);
    }
}
```

---

## 4. Critical Pitfalls & Missed Concepts

### Pitfall 1: Accidental Semicolon after Loop Condition
```java
for (int i = 0; i < 5; i++); // Notice the semicolon!
{
    System.out.println("Hello");
}
```
> **What happens**: The semicolon forms an empty loop statement. The loop runs 5 times doing nothing. Then the block `{ System.out.println("Hello"); }` runs **once**.

---

### Pitfall 2: Unreachable Code — `while(false)` vs. `if(false)`

This is one of the most famous Java compiler quirks:

```java
// Snippet A:
if (false) {
    System.out.println("Unreachable"); // COMPILES FINE!
}

// Snippet B:
while (false) {
    System.out.println("Unreachable"); // COMPILE ERROR: unreachable statement!
}
```
> **Why?**:
> The Java Language Specification explicitly allows `if (false)` to support **conditional compilation** (debugging flags or feature toggling). 
> However, for loops (`while`, `for`, `do-while`), unreachable bodies are strictly forbidden by the compiler!

---

## 5. Tricky Interview Questions & Explanations

### Q1: What is the output of this switch statement?
```java
int number = 20;
switch (number) {
    default:
        System.out.print("Default ");
    case 10:
        System.out.print("Ten ");
        break;
    case 30:
        System.out.print("Thirty ");
}
```
> **Output**: `Default Ten `
> **Explanation**:
> `number` is 20, which matches neither `10` nor `30`.
> Execution jumps to `default:`, printing `"Default "`.
> Because there is no `break` statement inside `default`, execution **falls through** into `case 10:`, printing `"Ten "`.
> Then it encounters `break;` and exits.

---

### Q2: What happens if the `switch` selector variable is `null`?
```java
String fruit = null;
switch (fruit) {
    case "Apple":
        System.out.println("Apple");
        break;
    default:
        System.out.println("Other");
}
```
> **Output**: Throws **`java.lang.NullPointerException`** at runtime!
> **Explanation**:
> Internally, `switch` on a String calls `fruit.hashCode()` and `fruit.equals()`. Calling a method on a `null` reference immediately throws `NullPointerException` before evaluating any cases or `default`.

---

### Q3: What is the exact sequence of outputs from this loop?
```java
static boolean print(char c) {
    System.out.print(c);
    return true;
}

public static void main(String[] args) {
    int i = 0;
    for (print('A'); print('B') && (i < 2); print('C')) {
        i++;
        print('D');
    }
}
```
> **Output**: `ABDCBDCB`
> **Explanation step-by-step**:
> 1. **Initialization**: `print('A')` runs once -> prints `A`.
> 2. **Condition 1**: `print('B')` runs, `0 < 2` is true -> prints `B`.
> 3. **Body 1**: `i++` becomes 1, `print('D')` runs -> prints `D`.
> 4. **Update 1**: `print('C')` runs -> prints `C`.
> 5. **Condition 2**: `print('B')` runs, `1 < 2` is true -> prints `B`.
> 6. **Body 2**: `i++` becomes 2, `print('D')` runs -> prints `D`.
> 7. **Update 2**: `print('C')` runs -> prints `C`.
> 8. **Condition 3**: `print('B')` runs, `2 < 2` is false -> prints `B`, terminates.
> Total string: `ABDCBDCB`.

---

### Q4: Infinite Loop Comparisons in Java
```java
// Approach 1:
for (;;) { }

// Approach 2:
while (true) { }

// Approach 3:
while (1) { } // Does this work in Java?
```
> **Answer**:
> - `for (;;)` and `while (true)` both generate **identical bytecode** in modern compilers (`goto` instruction) and are infinite loops.
> - `while (1)` causes a **compile error** in Java: `incompatible types: int cannot be converted to boolean`. Unlike C/C++, integers are NOT booleans in Java!

---

### Q5: Post-Increment in Loop Condition
```java
int count = 0;
while (count++ < 3) {
    System.out.print(count + " ");
}
```
> **Output**: `1 2 3 `
> **Explanation**:
> - Iteration 1: `count` (0) is checked (`0 < 3` -> true), then incremented to `1`. Prints `1`.
> - Iteration 2: `count` (1) is checked (`1 < 3` -> true), then incremented to `2`. Prints `2`.
> - Iteration 3: `count` (2) is checked (`2 < 3` -> true), then incremented to `3`. Prints `3`.
> - Iteration 4: `count` (3) is checked (`3 < 3` -> false), then incremented to `4`. Loop terminates.
