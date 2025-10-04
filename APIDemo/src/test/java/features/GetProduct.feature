Feature: Get All Product From Api

  Scenario: verify the get api for the product
    Given I hit the get product api endpoint
    When I pass the url of product in the request
    Then I receive responce code as 200

  Scenario Outline: verify the rate of the first product is correct
    Given I hit the get product api endpoint
    When I pass the url of product in the request
    Then I verify that the rate of first product is <FirstProductRate>
    Examples:
      | FirstProductRate |
      | 3.9              |