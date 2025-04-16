# Pairwise Testing – Test Case Analysis

## Table of Contents
- [Introduction](#introduction)
- [Pairwise Test Matrix](#pairwise-test-matrix)
- [When Should This Type of Testing Be Used?](#when-should-this-type-of-testing-be-used)
- [Limitations](#limitations)
- [Conclusion](#conclusion)
- [References](#references)

---

## Introduction

Pairwise testing is a black-box testing technique that focuses on covering all possible combinations of pairs of input parameters. It is especially useful in systems where multiple input variables interact, and exhaustive testing of every combination would be too time-consuming or costly.

In this analysis, we apply Pairwise Testing to the same **student score evaluation program** used in previous test techniques. To simulate multiple inputs, we introduce a secondary variable — **course type** (e.g., "Core" or "Elective").

---

## Pairwise Test Matrix

The following table represents a minimal set of test cases selected using pairwise analysis:

| Score Input | Course Type | Expected Output |
|-------------|-------------|------------------|
| -5          | Core        | Invalid score    |
| 30          | Elective    | FAILING          |
| 50          | Core        | PASSING          |
| 85          | Elective    | PASSING          |
| 120         | Core        | Invalid score    |

These test cases ensure that **all possible pairs** between the two parameters (score and course type) are covered at least once, improving efficiency without compromising coverage.

---

## When Should This Type of Testing Be Used?

Pairwise testing is best used when:
- The program involves **multiple input fields or configuration options**.
- You need to **reduce the number of test cases** while maintaining solid coverage.
- **Input combinations are logically independent**, and pair interactions represent meaningful conditions.

---

## Limitations

- Not ideal for systems with **strong dependencies between inputs** or **complex business rules**.
- **Rare edge-case bugs** that require three or more interacting variables may go undetected.
- Requires input parameter identification and tool support for efficient case generation in larger systems.

---

## Conclusion

Pairwise Testing is an efficient way to maximize test coverage across multiple input variables with fewer test cases. By focusing on pairs of inputs, it finds most bugs caused by input interaction without requiring full combinatorial testing. In the student score evaluation scenario, combining **score** and **course type** reveals whether the program correctly handles all pairings of score validity and contextual course rules.

---

## References

Burnstein, I. (2002). *Practical Software Testing*. Springer-Verlag New York, Inc.  
Software Testing 101. (2023). Top 10 Test Design Techniques. https://www.testing101.net/post/top-10-test-design-techniques  
QATestLab. (2018). *Pairwise Testing*. https://en.training.qatestlab.com/blog/technical-articles/pairwise-testing/  

---

---

## Example

For a complete view of the Java implementation and JUnit test cases used for Pairwise Testing, see the accompanying example file:

👉 [View Example.md](./Example.md)
