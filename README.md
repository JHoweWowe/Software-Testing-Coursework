# STCOURSEWORK2021

## Overview
For coursework purposes, EvoSuite will be used to automate testing and enhance finding additional bugs not met properly in the specifications and show coverage.

## Developer Notes
Java 8 SDK, Maven and EvoSuite should all be installed
EvoSuite will be executed using the command line but Eclipse  will be used for running JUnit 4 tests alongside with the corresponding classes. The EvoSuite plugin for Eclipse is only for experimental purposes.

## Installation Process
This section includes how to generate EvoSuite tests and running them along with existing tests

### Pre-Installation
Place the **evosuite-1.1.0.jar** file inside the desired directory location.

### Generating Tests from Scratch
1. At current directory with evosuite jar, create an environment variable to point to EvoSuite. So type in `export EVOSUITE="java -jar $(pwd)/evosuite-1.1.0.jar"`
2. Now can type in `$EVOSUITE -target ST_COURSEWORK.jar `

### Generating Tests with Existing Tests
COMING SOON

## Resources
https://www.evosuite.org/documentation/tutorial-part-1/