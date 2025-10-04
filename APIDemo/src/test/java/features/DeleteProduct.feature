Feature: Delete Product using Delete API

  Scenario Outline: validate Delete product api status code works correctly
    Given I hit the url of delete product api endpoint
    When I pass the url of delete product in the request with<Productnumber>
    Then I receive responce code as 200
    Examples:
      | Productnumber  |
      |  1             |
