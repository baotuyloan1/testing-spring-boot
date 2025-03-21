# JUnit Assertion

https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html





### Conditional Test Execution
https://junit.org/junit5/docs/current/user-guide/#writing-tests-conditional-execution




## Parameter Resolver

- JUnit 5 Defines a Parameter Resolver API to resolve parameters at runtime.
- Allows JUnit to inject parameters into test methods.
- While extensible, there are 3 built in resolvers:
  - TestInfo: Provides information about the test name, method, test class, test tags
  - RepetitionInfo: Provides information about the test repetition
  - TestReporter: Allows you to publish runtime information for test reporting.