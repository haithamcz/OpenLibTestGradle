Feature: AC test for OpenLibrary page

  Background:
    Given User is on OpenLibrary page "https://openlibrary.org/"
    And User sets website in "English"

  @MatchAPIResponse
  Scenario: Match API response
    When User searches using title option for book "Life with Picasso"
    And User chooses book published in "1973"
    And Get author from API "F+.+Gilot"
    Then Author from API matches author on book page
