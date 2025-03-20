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