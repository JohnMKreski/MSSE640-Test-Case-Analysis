# Boundary Value Analysis (BVA) Test Case Analysis

### [Table of Contents](#table-of-contents)

- [Introduction](#introduction)
- [Test Case Analysis](#test-case-analysis)
  - [Defining Boundary Value Analysis](#defining-boundary-value-analysis)
  - [Test Cases – Student Completion Program](#test-cases--student-completion-program)
    - [Table 1: ECP Test Cases – Valid and Invalid Values](#table-1-ecp-test-cases--valid-and-invalid-values)
    - [Table 2: Grouped ECP Partitions (by Input Ranges)](#table-2-grouped-ecp-partitions-by-input-ranges)
    - [Table 3: Boundary Value Analysis (BVA) Test Cases](#table-3-boundary-value-analysis-bva-test-cases)
  - [Summary of Boundary Value Analysis Tables](#summary-of-boundary-value-analysis-tables)
  - [When Should This Type of Testing Be Used?](#when-should-this-type-of-testing-be-used)
  - [Limitations](#limitations)
- [Conclusion](#conclusion)
- [References](#references)

---

## Introduction

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Boundary Value Analysis (BVA) is the next step of testing a program after the Equivalence Class Partitioning testing (ECP) method. Similar to equivalence testing, BVA is a black-box testing methodology that tests the boundaries of the ECP partitioned classes. Since ECP tests the inputs in the middle of the classes, BVA tests the edges of those classes. Burnstein states a few rules of thumb in describing this test:

1. If an input condition for the software-under-test is specified as a range of values, develop valid test cases for the ends of the range, and invalid test cases for possibilities just above and below the ends of the range.
2. If an input condition for the software-under-test is specified as a number of values, develop valid test cases for the minimum and maximum numbers as well as invalid test cases that include one lesser and one greater than the maximum and minimum.
3. If the input or output of the software-under-test is an ordered set, such as a table or a linear list, develop tests that focus on the first and last elements of the set.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Since BVA tests the edges of the partitioned classes, these tests should be considered separately from the partitioned classes. Once we generate the ECP classes, only then can we determine the boundaries of the BVA test cases.
&nbsp; 
---

## Test Case Analysis

### Defining Boundary Value Analysis

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Boundary Value Analysis (BVA) is a testing technique that can be applied at any level of testing. It focuses on the edges—or boundaries—of input ranges identified through Equivalence Class Partitioning (ECP).

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To apply BVA, you begin by reviewing the input and output conditions defined in the ECP-based test cases from the software requirements. Each equivalence class has a starting and ending point, which helps define its boundaries. BVA test cases are then designed to include values at, just below, and just above these boundaries to ensure the system handles edge cases correctly.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A useful way to organize both ECP and BVA test cases is by creating a table. This table should include rows for each equivalence class (valid and invalid), typical values from within the partition (ECP), and corresponding boundary values (BVA). This structured approach improves clarity, ensures comprehensive coverage, and supports more effective test planning.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Below is a continuation of the Equivalence Class Partitioning (ECP) test case example introduced in Week 2, starting with a revised test case table based on the student scores scenario.

### Test Cases – Student Completion Program

#### Table 1: ECP Test Cases – Valid and Invalid Values

| Test Case ID | Input Value | Expected Result         | ECP Class       |
|--------------|-------------|--------------------------|-----------------|
| ECP1         | 25          | FAILING                  | Valid (Fail)    |
| ECP2         | 75          | PASSING                  | Valid (Pass)    |
| ECP3         | -10         | Invalid Score Message    | Invalid (<0)    |
| ECP4         | 110         | Invalid Score Message    | Invalid (>100)  |
| ECP5         | 0           | FAILING                  | Valid (Fail)    |
| ECP6         | 50          | PASSING                  | Valid (Pass)    |
| ECP7         | 49          | FAILING                  | Valid (Fail)    |
| ECP8         | 100         | PASSING                  | Valid (Pass)    |

#### Table 2: Grouped ECP Partitions (by Input Ranges)

| Partition Class         | Associated Test Cases     | Input Range       |
|-------------------------|----------------------------|-------------------|
| Class 1 – Valid (Fail)  | ECP1, ECP5, ECP7            | 0 to 49           |
| Class 2 – Valid (Pass)  | ECP2, ECP6, ECP8            | 50 to 100         |
| Class 3 – Invalid (<0)  | ECP3                        | Less than 0       |
| Class 4 – Invalid (>100)| ECP4                        | Greater than 100  |

#### Table 3: Boundary Value Analysis (BVA) Test Cases

**BVA for Valid Class 1 (Failing Range: 0 to 49)**

| Boundary Type | Value | Expected Result         |
|----------------|--------|--------------------------|
| BLB1           | -1     | Invalid Score Message    |
| LB1            | 0      | FAILING                  |
| ALB1           | 1      | FAILING                  |
| BUB1           | 48     | FAILING                  |
| UB1            | 49     | FAILING                  |
| AUB1           | 50     | PASSING                  |

**BVA for Valid Class 2 (Passing Range: 50 to 100)**

| Boundary Type | Value | Expected Result         |
|----------------|--------|--------------------------|
| BLB2           | 49     | FAILING                  |
| LB2            | 50     | PASSING                  |
| ALB2           | 51     | PASSING                  |
| BUB2           | 99     | PASSING                  |
| UB2            | 100    | PASSING                  |
| AUB2           | 101    | Invalid Score Message    |

##### [Back to TOC](#table-of-contents)

---

### Summary of Boundary Value Analysis Tables

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The BVA tables highlight how we test the edges of the partitioned input classes defined through Equivalence Class Partitioning (ECP). For each valid range we select values at the boundaries and just outside them to verify the system’s behavior.

By testing just below and above the lower and upper bounds of each class (e.g., -1, 0, 1 and 99, 100, 101), we ensure that:

- The system correctly accepts valid inputs at the edges of a class.
- The system properly rejects invalid inputs just outside the defined range.
- Any off-by-one or edge-related errors in the code are caught early.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;This technique helps to evaluate that the software behaves reliably not just under normal conditions, but also at the most critical boundary points, where errors are most likely to occur.

[_Example Continued with Source Code_](./Example.md)

### When Should This Type of Testing Be Used?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Boundary Value Analysis should be used when input values fall within a defined and ordered range, and system behavior is expected to change at specific boundary points. It is particularly effective for numeric input fields, range-based validations, conditional logic, and decision-based systems where the correctness of values at the edges is critical. BVA is best applied when equivalence partitions have clearly defined minimum and maximum values.

### Limitations

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BVA assumes defects are most likely to occur at the edges of input ranges and may overlook errors in the middle of a partition. It does not account for interactions between multiple input fields or complex logical conditions involving non-numeric data. BVA also relies on accurate identification of boundaries; if the boundaries are misunderstood or poorly defined, the tests may be ineffective.

##### [Back to TOC](#table-of-contents)

---

## Conclusion

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Equivalence Class Partitioning and Boundary Value Analysis are complementary black-box testing techniques that enhance test efficiency and coverage. ECP allows testers to group input values into partitions based on expected behavior, reducing redundancy by selecting representative values from each class. BVA builds on this by targeting the critical edge cases from the ECP values at or near the boundaries of the partitions where defects are more likely to occur.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Together, these methods provide a structured and systematic approach to designing test cases, helping ensure the software behaves correctly across a wide range of valid and invalid inputs. This is demonstrated in the accompanying Java program, which applies both ECP and BVA test cases to a student score evaluation scenario. The implementation shows how values are grouped into partitions and how boundary values are tested to verify correctness and detect potential edge-related errors.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When applied correctly, ECP and BVA improve test precision, reduce risk, and support higher software quality with fewer, more effective test cases. As Burnstein notes, focusing on the boundaries and representative values is often the most efficient way to reveal defects and validate system behavior.

##### [Back to TOC](#table-of-contents)

---

## References

Burnstein, I. (2002). *Practical Software Testing*. Springer-Verlag New York, Inc.  

Shrike, M. (2023). What is Boundary Values Analysis (BVA)? *Software Testing 101*. Retrieved March 25, 2025, from https://www.testing101.net/post/what-is-boundary-values-analysis-bva

