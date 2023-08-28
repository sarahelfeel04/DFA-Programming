# Finite Automata Implementation in Java

This repository contains a Java implementation of finite automata, focusing on exploring the concepts through programming. The project involves three classes: `Main`, `DFA`, and `Transition`, each with predefined attributes and constructors. The goal is to implement specific functions within the `Main` and `DFA` classes while maintaining the integrity of the provided classes.

## Introduction
The objective of this assignment is to delve into finite automata implementation using Java. The project provides a foundation with the `Main`, `DFA`, and `Transition` classes, accompanied by their attributes and constructors. Your task is to implement specific methods within the `Main` and `DFA` classes, ensuring adherence to the provided method signatures and specifications.

## Main Class
### `generateDFA` Method
Implement the following method in the `Main` class:
```java
public static DFA generateDFA(String parse)
```
This method takes a `parse` String as input and returns a DFA object with the following attributes: `states`, `alphabet`, `transitions`, `startState`, and `acceptStates`.

## DFA Class
### `isLanguageDFA` Method
Implement the following method in the `DFA` class:
```java
public String isLanguageDFA(String input)
```
This method takes a `String` input and returns one of the following:
- `"InvalidString"`: If the input String contains invalid characters according to the alphabet.
- `"accepted"`: If the DFA accepts the input string.
- `"rejected"`: If the DFA rejects the input string.

### `mergeDFA` Method
Implement the following method in the `DFA` class:
```java
public DFA mergeDFA(DFA secondDFA, boolean isUnion)
```
This method merges two DFAs using either an intersection or union, based on the value of `isUnion`. If `isUnion` is `true`, the DFAs are merged using union; otherwise, they are merged using intersection. The method returns a new DFA object.

## Usage
To run this code, import the java files to your IDE and run your code on any test case.


## Contributing
Contributions to this project are welcome. If you encounter any issues or have improvements to suggest, please feel free to open an issue or submit a pull request.
