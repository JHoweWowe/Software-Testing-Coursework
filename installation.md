## Installation Process
This section includes how to generate EvoSuite tests and running them along with existing tests

### Pre-Installation
Place the **evosuite-1.1.0.jar** file inside the desired directory location.

### Generating Tests from Scratch
1. At current directory with evosuite jar, create an environment variable to point to EvoSuite. So type in `export EVOSUITE="java -jar $(pwd)/evosuite-1.1.0.jar"`
2. Now can type in `$EVOSUITE -target ST_COURSEWORK.jar`

Executing EvoSuite test cases where it handles branch coverage (Task 2.2): `$EVOSUITE -target ST_COURSEWORK.jar -criterion branch`

### Generating Tests with Existing Tests
This command can be executed with existing tests along with JUnit tests created in Task 1: `$EVOSUITE -target ST_COURSEWORK.jar -Djunit=st.Task1_functional -criterion branch`

## Resources
https://www.evosuite.org/documentation/tutorial-part-1/