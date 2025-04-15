# Program Setup and Execution Guide

## Requirements
- Java 17 or later
- Gradle 8.x (configured with Kotlin DSL)
- JUnit 5 for testing

## How to Run the Program
1. Clone or download the project.
2. Open a terminal in the project directory.
3. Compile and run the application manually:

```bash
javac Main.java studentScore.java
java Main
```

## How to Run Tests
Run the unit tests using Gradle:

```bash
./gradlew test
```

To show test logs and console output:

```bash
./gradlew test --info
```

Ensure this is included in `build.gradle.kts` to see printed output:

```kotlin
tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "failed", "skipped")
        showStandardStreams = true
    }
}
```


---

## 📂 Project Structure
```
├── src
│   ├── main
│   │   └── java
│   │       ├── Main.java
│   │       └── studentScore.java
│   └── test
│       └── java
│           └── studentScoreTest.java
├── build.gradle.kts
├── gradle/
│   └── wrapper/
├── gradlew
├── gradlew.bat
└── TESTCASE_ANALYSIS.md
```

---
