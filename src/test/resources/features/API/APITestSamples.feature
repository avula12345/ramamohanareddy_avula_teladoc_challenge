Feature: API Tests

  Scenario Outline: Get All the movie title and sort it in respective manner
    Given Get the API Url
    Then Make a Rest Call to "<uriPath>" having query string "<movieName>" with "GET" method
    And Verify if the status code is "200"
    Then Get the no of pages from the response and sort the movie titles
    And Get all the movies names matching with "<movieName>" in all the pages

    Examples:
      | movieName | uriPath                    |
      | Spiderman | /api/movies/search/?Title= |