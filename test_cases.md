# TEST CASES

## CREATE AN ACCOUNT IN ESPN PAGE 

```gherkin
Feature: Create Account in ESPN page
  As user want create an account to manager my espn services

  @PositiveCases
  Scenario Outline: create account
    Given that as user want create an account
    When I have filled the register form
          |firstName|lastName|email|password|
          |<firstName>|<lastName>|<email>|<password>|
    Then I should already be in my espn account
    And might close section

    Examples:
    |firstName|lastName|email|password|


  @NegativeCases
  Scenario Outline: create account negative
    Given that as user want create an account
    When I have filled the register form
      |firstName|lastName|email|password|
      |<firstName>|<lastName>|<email>|<password>|
    Then I should see already account was created message

    Examples:
      |firstName|lastName|email|password|
```

## LOG INTO ESPN PAGE

```gherkin
Feature: Log in ESPN page
  As user want log into my espn account

  @PositiveCases
  Scenario Outline: log into espn account
    Given that as user want get into my account
    When I have filled the log in form
      |userName|password|
      |<userName>|<password>|
    Then I should already be in my espn account
    And might close section

    Examples:
      |userName|password|

  @NegativeCases
  Scenario Outline: log into espn account negative
    Given that as user want get into my account
    When I have filled the log in form
      |userName|password|
      |<userName>|<password>|
    Then I should see user not registered yet message

    Examples:
      |userName|password|
```

## DELETE ESPN ACCOUNT

```gherkin
Feature: Delete ESPN account
  As user want log into my espn account to delete it

  @PositiveCases
  Scenario Outline: delete espn account
    Given that as user want delete my account
    When I have filled the log in form
      |userName|password|
      |<userName>|<password>|
    And deleted my account
    Then I should see my account closed

    Examples:
      |userName|password|

  @NegativeCases
  Scenario Outline: delete espn account negative
    Given that as user want delete my account
    When I have filled the log in form
      |userName|password|
      |<userName>|<password>|
    Then I should see already account was deleted message

    Examples:
      |userName|password|
```
