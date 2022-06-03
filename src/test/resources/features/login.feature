@
  Feature:

    Background: Application initialization
      Given user launches the application
      And he lets the application to make call
      And he lets the application to access medias
      And he skip the authentication screen
      When user chooses his(her) country "Cameroon"
      And he authorizes the application to get position
      Then he should access home page

    @login
    Scenario: Login
      Given User is on profile page
      And user opens the form
      And user choose to connect
      When user fills the form with "693842356" "Kikuu2000"
      And submit the form
      Then user is redirected to home page
      And user backs on profile page
      And user sees his code