# Dependency Injection

Dependency Injection is a design pattern that allows us to remove the hard-coded dependencies and make our application loosely coupled, extendable and maintainable. We can implement dependency injection to move the dependency resolution from compile-time to runtime.

## About the Project

- This code is only used to see at runtime how the Dependency Injection mechanism works using basic classes and methods.
- Well-crafted and crafted code can be implemented into a future library and framework that you want to create from scratch for learning purposes.

## How can I run the project?

To run the Java project without using Maven or any other build tool, follow these steps:

1. **Compile the Java source files**:
   - Open a terminal and navigate to the root directory of the project (`java-dependency-injection`).
   - Use the `javac` command to compile the source files and specify the output directory as `bin`:
  
     ```bash
     javac -d bin src/**/*.java
     ```

2. **Run the compiled Java program**:
   - After compiling the source files, you can run the `App` class using the `java` command:

     ```bash
     java -cp bin App
     ```
