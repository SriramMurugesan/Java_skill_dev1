# Java Identifiers and Reserved Keywords

---

## 1. What is an Identifier?

In Java, an **Identifier** is any custom name given by a programmer to an element in the program, such as:
- Classes and Interfaces
- Variables and Constants
- Methods and Constructors
- Packages
- Labels (for loops/blocks)

Example:
```java
public class Employee {          // 'Employee' is a class identifier
    int empId = 101;             // 'empId' is a variable identifier
    void calculateSalary() {     // 'calculateSalary' is a method identifier
    }
}
```

---

## 2. Strict Rules for Valid Identifiers

The Java compiler enforces the following **mandatory syntax rules**. Violating any of these results in a compilation error:

| Rule # | Rule Description | Valid Examples | Invalid Examples |
| :--- | :--- | :--- | :--- |
| **1** | **Allowed Characters**: Letters (`A-Z`, `a-z`), digits (`0-9`), dollar sign (`$`), and underscore (`_`). | `score_1`, `$price`, `total` | `total#`, `user-name`, `sum%` |
| **2** | **Starting Character**: Must start with a letter, `$`, or `_`. **Cannot start with a digit**. | `_count`, `$value`, `a1` | `1count`, `2ndPlace`, `9items` |
| **3** | **Reserved Keywords**: Cannot be a Java reserved keyword or boolean/null literal. | `myClass`, `returnVal` | `class`, `int`, `return`, `null` |
| **4** | **Case Sensitivity**: Java is strictly case-sensitive. Upper and lower case are distinct identifiers. | `Total`, `total`, `TOTAL` (3 distinct variables) | — |
| **5** | **No Whitespace**: Identifiers cannot contain spaces or tabs. | `first_name`, `firstName` | `first name`, `my var` |
| **6** | **No Length Limit**: There is no theoretical limit on length, but practically it should be descriptive and concise. | `extremelyLongVariableName` | — |
| **7** | **Single Underscore Rule (Java 9+)**: A single underscore `_` **cannot** be used as an identifier name (it is a reserved keyword in Java 9+). | `_a`, `__`, `_1` | `_` (compile error!) |

---

## 3. Java Naming Conventions (Industry Best Practices)

While rules are enforced by the compiler, **conventions** ensure code readability and team standards:

| Element | Convention | Style | Examples |
| :--- | :--- | :--- | :--- |
| **Class / Interface** | Noun, start with uppercase | **PascalCase** | `Student`, `BankAccount`, `Runnable` |
| **Method** | Verb-noun pair, start with lowercase | **camelCase** | `getName()`, `calculateTax()`, `printDetails()` |
| **Variable** | Meaningful noun, start with lowercase | **camelCase** | `studentAge`, `totalMarks`, `userEmail` |
| **Constant (`final static`)** | All uppercase separated by underscore | **UPPER_SNAKE_CASE** | `MAX_CAPACITY`, `PI`, `DEFAULT_TIMEOUT` |
| **Package** | All lowercase, reversed domain name | **lowercase** | `com.company.project.service` |

---

## 4. Java Reserved Keywords

Java reserves specific words for internal language syntax. You **cannot** use these as variable, class, or method names.

### Categorized List of Java Keywords (50+ Keywords)

| Category | Keywords |
| :--- | :--- |
| **Data Types (Primitives)** | `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean` |
| **Flow Control / Branching** | `if`, `else`, `switch`, `case`, `default`, `break` |
| **Looping** | `for`, `while`, `do`, `continue` |
| **Method Return** | `return`, `void` |
| **Access Modifiers** | `public`, `protected`, `private`, *(default is not a modifier keyword)* |
| **Non-Access Modifiers** | `static`, `final`, `abstract`, `synchronized`, `volatile`, `transient`, `native`, `strictfp` |
| **Class / Object Oriented** | `class`, `interface`, `extends`, `implements`, `package`, `import`, `instanceof`, `new`, `this`, `super`, `enum` |
| **Exception Handling** | `try`, `catch`, `finally`, `throw`, `throws`, `assert` |
| **Unused / Reserved Keywords** | `goto`, `const` *(Reserved in Java, but have no functionality; cannot be used as identifiers)* |

---

### Reserved Literals vs Keywords
The following are **reserved literals** (not technically keywords, but treated identically—you cannot use them as identifiers):
- `true`
- `false`
- `null`

---

### Contextual / Restricted Keywords (Modern Java)
Starting from Java 9+, certain words are keywords **only in specific contexts**, meaning they can still be used as variable or method names for backward compatibility:
- `var` (Java 10: Local variable type inference — cannot be a class name, but can be a variable name!)
- `yield` (Java 14: Used in switch expressions)
- `record` (Java 16: Compact data carrier class)
- `sealed`, `non-sealed`, `permits` (Java 17: Sealed classes and interfaces)
- `module`, `requires`, `exports`, `provides`, `uses`, `to`, `with`, `open`, `opens` (Java 9: Module system)

---

## 5. Tricky Interview Questions with Explanations

### Q1: Can a single underscore `_` be used as an identifier in Java?
```java
int _ = 10; // What happens?
```
> **Answer**: 
> - In **Java 8 and earlier**: It compiled with a compiler warning.
> - In **Java 9 and later**: It causes a **compile-time error**: `as of release 9, '_' is a keyword, and may not be used as an identifier`.
> - However, `_a`, `__` (double underscore), and `_123` are still completely valid!

---

### Q2: Is `String` a reserved keyword in Java? Can I declare a variable named `String`?
```java
int String = 100;
System.out.println(String);
```
> **Answer**:
> **Yes, this compiles and prints 100!**
> `String` is a **class** (`java.lang.String`), NOT a reserved keyword. Therefore, syntactically it is a valid identifier. 
> *Warning*: While legal, doing this is considered terrible practice as it shadows the type `String` and confuses developers and IDEs.

---

### Q3: Can `var` be used as an identifier?
```java
int var = 50;                     // Line 1: Valid?
class var { }                     // Line 2: Valid?
```
> **Answer**:
> - Line 1 is **VALID**: `var` is a contextual keyword (reserved type name), not a reserved identifier. You can name variables, methods, or packages `var`.
> - Line 2 is **INVALID**: Because `var` is a reserved type name, it **cannot** be used as the name of a class or interface.

---

### Q4: Are `const` and `goto` keywords in Java? Can we use them?
> **Answer**:
> - **Yes**, both `const` and `goto` are **reserved keywords** in Java.
> - However, they are **unused** (they have no function in Java). James Gosling reserved them in the original specification to avoid C/C++ developers accidentally using them and to allow for future extensions.
> - You **cannot** use `int const = 10;` or `int goto = 20;`—both will produce compilation errors.

---

### Q5: Can Java identifiers contain non-English characters or symbols like π or emojis?
```java
int π = 3;
int age_歳 = 25;
```
> **Answer**:
> **Yes, this compiles!**
> Java uses the **Unicode character set** (UTF-16). Identifiers can contain letters from any language supported by Unicode.
> Java determines validity using:
> - `Character.isJavaIdentifierStart(char)`
> - `Character.isJavaIdentifierPart(char)`
> Symbols like Greek letters (`π`, `λ`) or Japanese characters (`歳`) are valid Java identifier parts. Emojis, however, are typically disallowed because they are classified as symbols, not letters/digits.

---

### Q6: Identifier Validity Quiz (Quick Test)

Which of the following are valid Java identifiers?

```java
1.  int 1stNumber = 10;     // INVALID: Starts with a digit
2.  int $money = 500;       // VALID: Can start with $
3.  int _status = 1;        // VALID: Can start with _
4.  int all@once = 2;       // INVALID: '@' is not allowed
5.  int goto = 5;           // INVALID: 'goto' is a reserved keyword
6.  int True = 10;          // VALID: Case-sensitive ('true' is reserved, 'True' is not)
7.  int nullValue = 0;      // VALID: Does not match 'null' exactly
8.  int runnable = 4;       // VALID: 'runnable' is not a keyword
9.  int default = 7;        // INVALID: 'default' is a keyword
10. int Public = 9;         // VALID: 'public' is lowercase, 'Public' is capitalized
```
