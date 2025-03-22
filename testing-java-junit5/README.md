JUnit Platform - The foundation for lauching testing frameworks on the JVM. Allows tests to be run from a Console Laucher, or build tools such as Maven and Gradle.

JUnit Jupiter - Programming model for writing tests and extensions to JUnit

JUnit Vintage - Provides a test engine for running JUnit3 and JUnit 4 tests.

## JUnit Annotations

- @Test : marks a method as a test method
- @ParameterizedTest: Marks method as a parameterized test.
- @RepeatedTest: Repeat test N times
- @TestFactory: Test Factory method for dynamic tests.
- @TestInstance: used to configure test instance lifecycle.
- @TestTemplate: Creates a template to be used by multiple test cases.
- @DisplayName: Human friendly name for test.
- @BeforeEach: Method to run before each test case.
- @AfterEach: Method to run after each test case.
- @BeforeAll: Static method to run before all test cases in current class.
- @AfterAll: Static method to run after all test cases in current class.
- @Nested: Creates a nested test class.
- @Tag: Declare `tags` for filtering tests.
- @Disabled: Disable test or test class.
- @ExtendWith: Used to register extensions.


JUnit Test Lifecycle
@BeforeAll => @BeforeEach => @Test => @AfterEach => @AfterAll

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




# Mockito


Mockito is the most popular mocking framework for testing Java
Mocks (also known as Test Doubles) are alternatve implementations of objects to replace real objects in tests.
Works well with Dependency Injection
For the class under test, injected dependencies can be mocks.


## Types of Mocks (aka Test Doubles)

Dummy: Object used just to get the code to compile.

Fake: An object that has an implementation, but not production ready.

Stub: An obbject with pre-defined answers to method calls.

Mock: An object with pre-defined answers to method calls, and has expections of execution. Can throw an exception if an expected invocation is detected.

Spy: In Mockito Spies are Mock like wrappers around the actual object.


## Important Terminology

Verify:  Used to verify number of times a mocked method has been called.

Argument Matcher: Matches arguments passed to Mocked Method & will allow or disallow

Argyment Captor:  Captures argument passed to a Mocked Method. Allows you to perform assertions of what was passed into method.


## Mockito Annorations

@Mock: Used to create a mock

@Spy:  Used to create a spy.

@InjectMocks: Injkkect mocks/spys into a class under test.

@Captor: Captures arguments to Mock.

## Initializing mock

There are 3 ways to initialize a mock

1. Inline: Map mapMock = mock(Map.class);
2. Annotation: @Mock; MockitoAnnotations.initMocks(this);
3. JUnit Extention: @Mock; @ExtendWith(MockitoExtension.class)