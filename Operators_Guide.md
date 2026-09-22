# Java Operators: Comprehensive Guide, Missing Concepts & Tricky Questions

---

## 1. Overview of Operators in Java

Operators are special symbols used to perform operations on variables and values. 
While basic arithmetic (`+`, `-`, `*`, `/`, `%`) and simple comparisons are straightforward, Java has critical **subtleties, type-promotion rules, and shift operators** that frequently appear in technical interviews and production bugs.

---

## 2. Concepts Missed in Basic Demonstrations

### A. Short-Circuit vs. Bitwise Logical Operators

Java provides two sets of AND/OR operators:
- **Bitwise / Boolean Logical**: `&` (AND), `|` (OR), `^` (XOR)
- **Short-Circuit Logical**: `&&` (AND), `||` (OR)

#### How Short-Circuiting Works:
1. In `expr1 && expr2`: If `expr1` is `false`, Java **skips** evaluating `expr2` because the entire expression is guaranteed to be `false`.
2. In `expr1 || expr2`: If `expr1` is `true`, Java **skips** evaluating `expr2` because the entire expression is guaranteed to be `true`.
3. In `expr1 & expr2` or `expr1 | expr2`: Java **always evaluates both sides**, regardless of the outcome of the left side.

#### Critical Code Example (Side Effects):
```java
int x = 10;
int y = 20;

// Short-circuit: (x > 15) is false, so (++y) is NEVER executed!
if (x > 15 && ++y > 20) {
    System.out.println("True branch");
}
System.out.println("y after &&: " + y); // y is still 20!

// Non-short-circuit: both sides ALWAYS execute!
if (x > 15 & ++y > 20) {
    System.out.println("True branch");
}
System.out.println("y after &: " + y);  // y is now 21!
```

> **Interview Tip**: Always use `&&` and `||` for boolean logic, especially to prevent `NullPointerException`:
> ```java
> if (str != null && str.length() > 0) // SAFE: length() not called if str is null
> if (str != null & str.length() > 0)  // CRASH: throws NullPointerException if str is null!
> ```

---

### B. Bitwise Shift Operators

Java provides three shift operators operating on binary representations of integers:

| Operator | Name | Behavior | Mathematical Meaning |
| :--- | :--- | :--- | :--- |
| `<<` | **Left Shift** | Shifts bits left, fills rightmost bits with `0` | Multiplies by $2^n$ (`x << n == x * 2^n`) |
| `>>` | **Signed Right Shift** | Shifts bits right, preserves sign bit (fills with `0` for positive, `1` for negative) | Divides by $2^n$ (`x >> n == x / 2^n`) |
| `>>>` | **Unsigned Right Shift** | Shifts bits right, **always fills leftmost bits with `0`** regardless of sign | Logical shift; turns negative numbers into large positive numbers! |

#### Visual Comparison:
```java
int a = 8;     // Binary: 00001000
System.out.println(a << 1);  // 16  (00010000) -> 8 * 2^1
System.out.println(a >> 1);  // 4   (00000100) -> 8 / 2^1

int b = -8;    // Binary (Two's complement): 11111000
System.out.println(b >> 1);  // -4  (11111100: sign bit '1' preserved)
System.out.println(b >>> 1); // 2147483644 (01111100... zero shifted into sign bit!)
```

---

### C. Compound Assignment Operators & Implicit Type Casting

Compound assignment operators (`+=`, `-=`, `*=`, `/=`, `%=`, `<<=`, `>>=`, `&=`, `|=`, `^=`) have a hidden feature: **Automatic Type Casting**.

According to the Java Language Specification (JLS §15.26.2):
> A compound assignment expression of the form `E1 op= E2` is equivalent to:
> `E1 = (T)((E1) op (E2))` where `T` is the type of `E1`.

#### Comparison:
```java
short s = 10;
// Regular assignment:
s = s + 5;    // COMPILE ERROR: (s + 5) evaluates to 'int'; cannot assign int to short!

// Compound assignment:
s += 5;       // COMPILES CLEANLY! Java automatically emits: s = (short)(s + 5);
```

#### The Overflow Trap with Compound Operators:
```java
byte b = 127;
b += 1; // Compiles without error, but overflows silently to -128!
System.out.println(b); // -128
```

---

### D. Binary Numeric Promotion Rules

In any binary arithmetic expression (`+`, `-`, `*`, `/`, `%`), Java automatically promotes the operand types following this hierarchy:

1. If either operand is `double`, the other is promoted to `double`.
2. Else, if either operand is `float`, the other is promoted to `float`.
3. Else, if either operand is `long`, the other is promoted to `long`.
4. **Else, BOTH operands are promoted to `int`!**

#### The `byte + byte` Pitfall:
```java
byte b1 = 10;
byte b2 = 20;
byte b3 = b1 + b2; // COMPILE ERROR: Both b1 and b2 are promoted to int! Result is int.

// Fix:
byte b3 = (byte)(b1 + b2); // Explicit cast required
```

---

### E. The `instanceof` Operator

Used to test whether an object is an instance of a specific class, subclass, or interface.

```java
String text = "Hello";
System.out.println(text instanceof String); // true
System.out.println(text instanceof Object); // true

// Null check rule:
String nullStr = null;
System.out.println(nullStr instanceof String); // ALWAYS false (no NullPointerException)
```

#### Modern Java (Java 16+) Pattern Matching for `instanceof`:
```java
// Traditional:
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.toUpperCase());
}

// Pattern Matching (Java 16+):
if (obj instanceof String s) {
    System.out.println(s.toUpperCase()); // No manual cast needed!
}
```

---

### F. String Concatenation Operator (`+`) Rules

When `+` is used with a `String`, it acts as a concatenation operator. It evaluates **left to right**:

```java
System.out.println(10 + 20 + "Java");   // Prints: "30Java" (10+20=30 first, then "30"+"Java")
System.out.println("Java" + 10 + 20);   // Prints: "Java1020" ("Java10" + 20 -> "Java1020")
System.out.println("Java" + (10 + 20)); // Prints: "Java30" (Parentheses force addition first)
```

---

## 3. Operator Precedence and Associativity Table

From highest precedence (evaluated first) to lowest:

| Category | Operators | Associativity |
| :--- | :--- | :--- |
| **Postfix** | `expr++`, `expr--` | Left-to-right |
| **Unary** | `++expr`, `--expr`, `+expr`, `-expr`, `~`, `!` | Right-to-left |
| **Multiplicative** | `*`, `/`, `%` | Left-to-right |
| **Additive** | `+`, `-` | Left-to-right |
| **Shift** | `<<`, `>>`, `>>>` | Left-to-right |
| **Relational** | `<`, `>`, `<=`, `>=`, `instanceof` | Left-to-right |
| **Equality** | `==`, `!=` | Left-to-right |
| **Bitwise AND** | `&` | Left-to-right |
| **Bitwise XOR** | `^` | Left-to-right |
| **Bitwise OR** | `|` | Left-to-right |
| **Logical AND** | `&&` | Left-to-right |
| **Logical OR** | `\|\|` | Left-to-right |
| **Ternary** | `? :` | Right-to-left |
| **Assignment** | `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `<<=`, `>>=`, `&=`, `^=`, `\|=` | Right-to-left |

---

## 4. Tricky Interview Questions & Explanations

### Q1: What does `i = i++` print?
```java
int i = 5;
i = i++;
System.out.println(i);
```
> **Output**: `5`
> **Explanation**:
> The post-increment operator `i++`:
> 1. Evaluates to the **original value** (`5`).
> 2. Increments `i` to `6` internally.
> 3. The assignment operator `=` assigns the evaluated original value (`5`) back to `i`, overwriting the incremented `6`!
> Therefore, `i` remains `5`.

---

### Q2: What happens when dividing by zero in integer vs floating point?
```java
System.out.println(10 / 0);      // Line 1
System.out.println(10.0 / 0);    // Line 2
System.out.println(0.0 / 0.0);   // Line 3
```
> **Output**:
> - Line 1: Throws **`java.lang.ArithmeticException: / by zero`** at runtime.
> - Line 2: Prints **`Infinity`** (IEEE 754 standard for floating-point).
> - Line 3: Prints **`NaN`** (Not a Number).
> **Rule**: Integers throw `ArithmeticException`; floating-point types (`float`, `double`) follow IEEE 754 and return `Infinity` or `NaN`.

---

### Q3: What is the output of character arithmetic?
```java
System.out.println('A' + 'B');
System.out.println("" + 'A' + 'B');
System.out.println((char)('A' + 1));
```
> **Output**:
> `131`  
> `AB`  
> `B`  
> **Explanation**:
> - `'A'` has ASCII code `65` and `'B'` has ASCII code `66`.
> - `'A' + 'B'` performs integer addition: `65 + 66 = 131`.
> - `"" + 'A' + 'B'` is string concatenation: `"" + 'A' -> "A" + 'B' -> "AB"`.
> - `(char)('A' + 1)` casts `66` back to char: `'B'`.

---

### Q4: Ternary Operator Type Promotion Mystery
```java
Object obj = true ? new Integer(1) : new Double(2.0);
System.out.println(obj);
```
> **Output**: `1.0`
> **Explanation**:
> In a ternary expression `condition ? expr1 : expr2`, if one expression is numeric (like `Integer`) and the other is a higher-precision numeric type (like `Double`), Java applies binary numeric promotion to the entire ternary expression.
> Therefore, the integer `1` is promoted to `1.0` (Double), so `obj` holds `Double.valueOf(1.0)`!

---

### Q5: Can the modulo operator `%` be used on floating point numbers?
```java
System.out.println(10.5 % 3.0);
```
> **Output**: `1.5`
> **Explanation**:
> Unlike C/C++ where `%` only works on integers, Java's `%` operator is fully supported on `float` and `double`.
> Calculation: $10.5 - (3.0 \times 3) = 1.5$.
