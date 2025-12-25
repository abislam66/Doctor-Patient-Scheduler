# Doctor–Patient Scheduler

## Overview
A Java-based scheduling system that determines whether a set of patients
can be assigned to doctors without exceeding any doctor’s available
working hours.

The project uses **recursive backtracking** to explore valid scheduling
combinations while enforcing time and availability constraints.

## Problem Description
In real-world healthcare scheduling, doctors have limited availability
and patients require different amounts of care. The challenge is to
assign each patient to exactly one doctor while ensuring that no doctor
is overbooked.

This program answers the question:

> Is it possible to schedule all patients so that every required
> appointment is satisfied within doctor availability limits?

## Approach
- Doctors are modeled with a fixed number of available hours
- Patients are modeled with required appointment durations
- Each patient must be assigned to **one and only one doctor**
- A recursive backtracking algorithm attempts assignments and backtracks
  when constraints are violated

If a valid schedule exists, the program constructs it; otherwise, it
reports that no feasible schedule is possible.

## Features
- Recursive backtracking solution
- Constraint-based scheduling logic
- Uses Java collections (`HashMap`, `HashSet`)
- Deterministic and testable behavior
- Clear separation between input parsing and scheduling logic

## Project Structure
All source files and the sample input file are located in the `src/`
directory.

src/
├── Main.java
├── Scheduler.java
├── Schedule_Helper.java
├── Resultmaps.java
├── extract_names.java
├── get_doc_hours.java
├── get_patient_hours.java
├── getindex.java
└── sample_input.csv


## Sample Input File
The repository includes a CSV file used to test the scheduler.

Location:
src/test_file.csv

csharp
Copy code

The file contains doctor availability and patient time requirements in
the expected input format. Users may modify this file or replace it with
their own test cases.

## How to Run
1. Compile the source files:
   ```bash
   javac src/*.java
Run the program:
Main.java
When prompted, provide the path to the input file:
test_file.csv
Tech Stack
Java
Recursion
Backtracking
HashMap / HashSet
Constraint Satisfaction

License
MIT
