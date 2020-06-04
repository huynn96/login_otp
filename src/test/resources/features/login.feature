Feature: Testmaster login with OTP confirmation code

  Scenario: Show Homepage with valid credential
    Given The login page is showed
    When The User attempt to login with "huynnhu1996@gmail.com" and "abc123"
    And The User confirmed with OTP code from his Email
    Then The Homepage will be showed up