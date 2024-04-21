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
    When I provide a first integer number 4
    And I provide a second integer number 5
    Then the operation evaluates to the integer 9

  Scenario: Subtracting two integer numbers
    Given an integer operation '-'
    When I provide a first integer number 7
    And I provide a second integer number 5
    Then the operation evaluates to the integer 2

  Scenario: Multiplying two integer numbers
    Given an integer operation '*'
    When I provide a first integer number 7
    And I provide a second integer number 5
    Then the operation evaluates to the integer 35

  Scenario: Dividing two integer numbers
    Given an integer operation '/'
    When I provide a first integer number 7
    And I provide a second integer number 5
    Then the operation evaluates to the integer 1

  Scenario: Boolean And two integer numbers
    Given an integer operation '&'
    When I provide a first integer number 1
    And I provide a second integer number 0
    Then the operation evaluates to the integer 0

  Scenario: Boolean Or two integer numbers
    Given an integer operation '|'
    When I provide a first integer number 1
    And I provide a second integer number 0
    Then the operation evaluates to the integer 1

  Scenario: Boolean Xor two integer numbers
    Given an integer operation '^'
    When I provide a first integer number 1
    And I provide a second integer number 1
    Then the operation evaluates to the integer 0

  Scenario: Power two integer numbers
    Given an integer operation '**'
    When I provide a first integer number 2
    And I provide a second integer number 4
    Then the operation evaluates to the integer 16

  Scenario: Logarithm on one real numbers
    Given a real operation 'log'
    When I provide a first decimal number 100.0
    Then the operation evaluates to the decimal 2

  Scenario: Natural log on one real numbers
    Given a real operation 'ln'
    When I provide a first decimal number 2.71828182845
    Then the operation evaluates to the decimal 1

  Scenario: Square root on one real numbers
    Given a real operation 'sqrt'
    When I provide a first decimal number 9.
    Then the operation evaluates to the decimal 3

  Scenario: Cos on one real numbers
    Given a real operation 'cos'
    When I provide a first decimal number 1.57079632679
    Then the operation evaluates to the decimal 0

  Scenario: Sin on one real numbers
    Given a real operation 'sin'
    When I provide a first decimal number 1.57079632679
    Then the operation evaluates to the decimal 1

  Scenario: Tan on one real numbers
    Given a real operation 'tan'
    When I provide a first decimal number 0.78539816339744
    Then the operation evaluates to the decimal 1

  Scenario: Acos on one real numbers
    Given a real operation 'acos'
    When I provide a first decimal number 0.
    Then the operation evaluates to the decimal 1.57079632679

  Scenario: Asin on one real numbers
    Given a real operation 'asin'
    When I provide a first decimal number 1.
    Then the operation evaluates to the decimal 1.57079632679

  Scenario: Atan on one real numbers
    Given a real operation 'atan'
    When I provide a first decimal number 1.
    Then the operation evaluates to the decimal 0.78539816339744

  Scenario: Not on one real numbers
    Given a real operation '!'
    When I provide a first decimal number 1.
    Then the decimal operation evaluates to NaN

  Scenario: And on one real numbers
    Given a real operation '&'
    When I provide a first decimal number 1.
    And I provide a second decimal number 1.
    Then the decimal operation evaluates to NaN

  Scenario: Xor on one real numbers
    Given a real operation '^'
    When I provide a first decimal number 1.
    And I provide a second decimal number 1.
    Then the decimal operation evaluates to NaN

  Scenario: Impl on one real numbers
    Given a real operation '=>'
    When I provide a first decimal number 1.
    And I provide a second decimal number 1.
    Then the decimal operation evaluates to NaN

  Scenario: Or on one real numbers
    Given a real operation '|'
    When I provide a first decimal number 1.
    And I provide a second decimal number 1.
    Then the decimal operation evaluates to NaN

  Scenario: Mod on one real numbers
    Given a real operation 'mod'
    When I provide a first decimal number 1.
    And I provide a second decimal number 1.
    Then the decimal operation evaluates to NaN

  Scenario: Adding two integer numbers
    Given an integer operation 'mod'
    When I provide a first integer number 17
    And I provide a second integer number 5
    Then the operation evaluates to the integer 2

  Scenario: Random integer numbers
    Given an integer operation 'rand'
    When I provide a first integer number 17
    Then the operation evaluates to the integer 1

  Scenario: Random real one real numbers
    Given a real operation 'rand'
    When I provide a first decimal number 1.0
    Then the operation evaluates to the decimal 0.81149

  Scenario: Power two real numbers
    Given a real operation '**'
    When I provide a first decimal number 2.0
    And I provide a second decimal number 4.0
    Then the operation evaluates to the decimal 16.0
    
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
    When I provide a first integer number <n1>
    And I provide a second integer number <n2>
    Then the operation evaluates to the integer <result>

    Examples:
      | n1 | n2 | result |
      | 4  | 5  | 9      |
      | 5  | 3  | 8      |

  Scenario Outline: Dividing two integer numbers
    Given an integer operation '/'
    When I provide a first integer number <n1>
    And I provide a second integer number <n2>
    Then the operation evaluates to the integer <result>

    Examples:
      | n1 | n2 | result |
      | 35 | 5  | 7      |
      | 7  | 5  | 1      |
      | 5  | 7  | 0      |

  Scenario Outline: Evaluating arithmetic operations with two integer parameters
    Given an integer operation <op>
    When I provide a first integer number <n1>
    And I provide a second integer number <n2>
    Then the operation evaluates to the integer <result>

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
    Then the operation evaluates to the integer 1

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

  Scenario Outline: Evaluating arithmetic operations with two integer parameters should return NaN
    Given an integer operation <op>
    When I provide a first integer number <n1>
    Then the operation evaluates to NaN

    Examples:
      | op     | n1 |
      | "log"  | 4  |
      | "ln"   | 8  |
      | "sqrt" | 7  |
      | "cos"  | 6  |
      | "sin"  | 1  |
      | "tan"  | 0  |
      | "acos" | 0  |
      | "asin" | 0  |
      | "atan" | 0  |

  Scenario Outline: Evaluating arithmetic operations with two NaN should return NaN
    Given an integer operation <op>
    When I provide a NaN
    Then the operation evaluates to NaN

    Examples:
      | op     |
      | "log"  |
      | "ln"   |
      | "sqrt" |
      | "cos"  |
      | "sin"  |
      | "tan"  |
      | "acos" |
      | "asin" |
      | "atan" |
      | "!"    |


  Scenario Outline: Evaluating arithmetic operations with a NaN and an integer should return NaN
    Given an integer operation <op>
    When I provide a NaN
    And I provide a second integer number <n2>
    Then the operation evaluates to NaN

    Examples:
      | op   | n2 |
      | "+"  | 1  |
      | "-"  | 2  |
      | "*"  | 3  |
      | "/"  | 4  |
      | "&"  | 5  |
      | "\|" | 6  |
      | "**" | 7  |
      | "=>" | 7  |
      | "mod" | 7  |
