Feature: Order a product from online shopping site
  Background: Precondition of all scenarios
    Given This is the precondition for this feature
@smokeTest
  Scenario: Order product using add to cart
    Given User is on home page of the site
    When User log into the application
    And User adds the product into the cart
    And User checks out the order
    And User fills the require details and places the order
    Then Success message is displayed

  @UAT
  Scenario: Sign up and login to application
    Given User is on home page of the site
    When User sign up into application with username "rajp2" and password "password"
    Then User log into the application with username "rajp2" and password "password"

    @smokeTest
  Scenario: Order product using add to cart data from feature
    Given User is on home page of the site
    When User log into the application
    And User adds the product "Nexus 6" into the cart
    And User checks out the order of product "Nexus 6"
    And User fills the given require details and places the order
      |Rajpal  |
      |Colombia|
      |Bogota  |
      |232323232|
      |02       |
      |2028     |
    Then Success message is displayed

  @DataDriven
  Scenario Outline: Order product using add to cart data driven
    Given User is on home page of the site
    When User log into the application
    And User adds the product "<product>" into the cart
    And User checks out the order of product "<product>"
    And User fills the require details and places the order
    Then Success message is displayed

    Examples:
    |product|
    |Nexus 6|
    |Samsung galaxy s6|
