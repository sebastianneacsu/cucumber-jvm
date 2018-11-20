Feature: Google Searching
  As a web surfer,
  I want to search Google,
  So that I can learn new things.

  @automated @web @google @panda
  Scenario: Simple Google search
    Given a web browser is on the Google page
    When the search phrase "quota" is entered
    Then results for "quota" are shown
