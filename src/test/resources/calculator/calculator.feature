Feature: Integer Arithmetic Expressions
  This feature provides a range of scenarios corresponding to the
  intended external behaviour of arithmetic expressions on integers.

  # This is just a comment.
  # You can start with a Background: that will be run before executing each scenario.

  Background:
    Given I initialise a calculator

  # Each scenario can be seen as a test that can be executed with JUnit,
  # provided that each of the steps (Given, When, And and Then) are
  # implemented in a Java mapping file (CalculatorSteps.Java)

  Scenario: Adding two integer numbers
    Given an integer operation '+'
    When I provide a first number 4
    And I provide a second number 5
    Then the operation evaluates to 9

  Scenario: Subtracting two integer numbers
    Given an integer operation '-'
    When I provide a first number 7
    And I provide a second number 5
    Then the operation evaluates to 2

  Scenario: Multiplying two integer numbers
    Given an integer operation '*'
    When I provide a first number 7
    And I provide a second number 5
    Then the operation evaluates to 35

  Scenario: Dividing two integer numbers
    Given an integer operation '/'
    When I provide a first number 7
    And I provide a second number 5
    Then the operation evaluates to 1

  Scenario: Boolean And two integer numbers
    Given an integer operation '&'
    When I provide a first number 1
    And I provide a second number 0
    Then the operation evaluates to 0

  Scenario: Boolean Or two integer numbers
    Given an integer operation '|'
    When I provide a first number 1
    And I provide a second number 0
    Then the operation evaluates to 1

  Scenario: Boolean Xor two integer numbers
    Given an integer operation '^'
    When I provide a first number 1
    And I provide a second number 1
    Then the operation evaluates to 0

  # This is an example of a scenario in which we provide a list of numbers as input.
  # (In fact, this is not entirely true, since what is given as input is a table of
  # strings. In this case, the table is of dimension 1 * 3 (1 line and three columns).
  Scenario: Evaluation arithmetic operations over a list of integer numbers
    Given the following list of integer numbers
      | 8 | 2 | 2 |
    Then the sum is 12
    And the product is 32
    And the difference is 4
    And the quotient is 2

  # A scenario outline (or template) is a scenario that is parameterised
  # with different values. The outline comes with a set of examples.
  # The scenario will be executed with each of the provided inputs.
  Scenario Outline: Adding two integer numbers
    Given an integer operation '+'
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then the operation evaluates to <result>

    Examples:
      | n1 | n2 | result |
      | 4  | 5  | 9      |
      | 5  | 3  | 8      |

  Scenario Outline: Dividing two integer numbers
    Given an integer operation '/'
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then the operation evaluates to <result>

    Examples:
      | n1 | n2 | result |
      | 35 | 5  | 7      |
      | 7  | 5  | 1      |
      | 5  | 7  | 0      |

  Scenario Outline: Evaluating arithmetic operations with two integer parameters
    Given an integer operation <op>
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then the operation evaluates to <result>

    Examples:
      | op   | n1 | n2 | result |
      | "+"  | 4  | 5  | 9      |
      | "-"  | 8  | 5  | 3      |
      | "*"  | 7  | 2  | 14     |
      | "/"  | 6  | 2  | 3      |
      | "&"  | 1  | 0  | 0      |
      | "\|" | 0  | 1  | 1      |
      | "^"  | 0  | 0  | 0      |


  Scenario: Printing the sum of two integer numbers
    Given the sum of two numbers 8 and 6
    Then its INFIX notation is (8 + 6)
    And its PREFIX notation is +(8, 6)
    And its POSTFIX notation is (8, 6)+

  Scenario: Printing the difference of two integer numbers
    Given the difference of two numbers 8 and 6
    Then its INFIX notation is (8 - 6)
    And its PREFIX notation is -(8, 6)
    And its POSTFIX notation is (8, 6)-

  Scenario: Printing the product of two integer numbers
    Given the product of two numbers 8 and 6
    Then its INFIX notation is (8 * 6)
    And its PREFIX notation is *(8, 6)
    And its POSTFIX notation is (8, 6)*

  Scenario: Printing the quotient of two integer numbers
    Given the quotient of two numbers 8 and 6
    Then its INFIX notation is (8 / 6)
    And its PREFIX notation is /(8, 6)
    And its POSTFIX notation is (8, 6)/

  Scenario: Printing the NOT of an integer number
    Given the negation of a number 0
    Then the operation evaluates to 1

  Scenario Outline: Evaluating boolean expressions
    Given I initialise a calculator
    When I provide an expression <expr>
    Then the expression evaluates to <result>

    Examples:
      | expr                            | result |
      | !true                           | 0      |
      | !false                          | 1      |
      | true & false                    | 0      |
      | true \| false                   | 1      |
      | true ^ false                    | 1      |
      | true & true                     | 1      |
      | false \| false                  | 0      |
      | false ^ false                   | 0      |
      | true ^ false ^ false            | 1      |
      | true ^ true ^ false             | 0      |
      | true ^ true ^ true              | 1      |
      | !(true & false) ^ true => false | 1      |
      | (true & false) \| true => true  | 1      |
      | true & false \| true ^ true     | 0      |