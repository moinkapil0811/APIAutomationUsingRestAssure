Feature: Update Product using PUT API

  Scenario Outline: validate put product api status code works correctly
    Given I hit the url of put product api endpoint
    When I pass the url of put product in the request with<Productnumber>

    Then I receive responce code as 200
    Examples:
      | Productnumber  |
      | 4              |
