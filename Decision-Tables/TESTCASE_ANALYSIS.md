# Decision Tables – Test Case Analysis

## Table of Contents
- [Introduction](#introduction)
- [Decision Table Example](#decision-table-example)
- [When Should This Type of Testing Be Used?](#when-should-this-type-of-testing-be-used)
- [Limitations](#limitations)
- [Conclusion](#conclusion)
- [References](#references)

---

## Introduction

Decision table testing is a black-box testing technique used to represent and analyze combinations of input conditions and their corresponding actions or outputs. It is especially helpful for systems where business logic or rule-based decision-making is involved. Unlike Equivalence Class Partitioning (ECP) and Boundary Value Analysis (BVA), which focus on input ranges and boundaries, decision tables help map logical relationships and conditions to expected behaviors.

In the context of the student score evaluation program, a decision table can clearly lay out the rules determining whether a student **passes**, **fails**, or receives an **invalid** result based on their score.

---

## Decision Table Example

Below is a sample decision table for the student score program:

| Condition                            | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
|-------------------------------------|--------|--------|--------|--------|
| Score < 0                           |   Y    |   N    |   N    |   N    |
| Score between 0 and 49 (inclusive)  |   N    |   Y    |   N    |   N    |
| Score between 50 and 100 (inclusive)|   N    |   N    |   Y    |   N    |
| Score > 100                         |   N    |   N    |   N    |   Y    |
| **Action**                          | Invalid | Fail   | Pass   | Invalid |

Each rule in the table represents a possible scenario, and the associated action defines the expected system output. This method ensures that all decision logic in the program is accounted for.

---

## When Should This Type of Testing Be Used?

Decision table testing should be used when:
- The system requires different outputs for various combinations of conditions.
- Business rules and logic-based decisions are critical.
- There is a need to verify that all rules have been implemented and behave correctly.
- You want to ensure complete test coverage for all combinations of inputs and outputs.

---

## Limitations

- Decision tables can become large and complex with many input conditions.
- Not suitable for testing numeric ranges or boundary conditions (BVA is better suited).
- Can be time-consuming to construct and maintain if business rules change frequently.
- Redundant or infeasible combinations may appear and require manual elimination.

---

## Conclusion

Decision tables offer a structured way to model and test complex decision-making logic. When used alongside ECP and BVA, they provide comprehensive coverage of functional requirements. In the student score evaluation program, the decision table confirms that the system correctly maps score ranges to PASS, FAIL, or INVALID results based on logical conditions.

This technique is especially useful when testing systems with multiple rules or conditional outcomes and helps identify any missing or conflicting logic in the software.

---

## References

Burnstein, I. (2002). *Practical Software Testing*. Springer-Verlag New York, Inc.

Software Testing 101. (2023). *What is Decision Table testing?*. https://www.testing101.net/post/what-is-decision-table-testing

