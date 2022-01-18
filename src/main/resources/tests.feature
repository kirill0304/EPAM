Feature: TestLorem
  As a user
  I want to check functionality of a site
  To confirm it works correctly

  Scenario: User checks the word "fish" correctly appears in the paragraph
    Given User opens homepage page
    When User changes language to Russian
    Then Use finds word in the first paragraph and verifies

  Scenario: User checks first paragraph starts with "Lorem.."
    Given User opens homepage page
    When User clicks on button Generate
    Then Use checks first paragraph starts with expected sentence

  Scenario: User checks Lorem Ipsum IsGenerated with correctSize
    Given User opens homepage page
    And User chooses radiobutton Words
    And User enters amount of the word they need
    When User clicks on button Generate
    And User checks the message has expected amount of words
    Then Use checks generated words amount

  Scenario: User unchecks checkbox and verifies that paragraph no longer starts with Lorem ipsum
    Given User opens homepage page
    And User unchecks checkbox
    When User clicks on button Generate
    Then Use checks that generated first paragraph no longer starts with Lorem ipsum

  Scenario: User checks that randomly generated text paragraphs contain the word "lorem"
    Given User opens homepage page
    And User clicks on button Generate
    And User checks random generated text contains Lorem
    When User opens, clicks, checks nine more times
    Then User checks average amount of Lorem is less than two
