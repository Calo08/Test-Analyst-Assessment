Feature: Loan API

  Background:
    * url 'http://localhost:8080/api'

  Scenario: Valid Request
    Given request { idNumber: '9405240087083', name: 'John', surname: 'Doe', bank: 'Scrum Bank', bankAccountNumber: '1234567890' }
    When method post
    Then status 200

  Scenario: Invalid ID Number
    Given request { idNumber: 'invalid', name: 'John', surname: 'Doe', bank: 'Scrum Bank', bankAccountNumber: '1234567890' }
    When method post
    Then status 400

  Scenario: Molewa Bank Warning
    Given request { idNumber: '9405240087083', name: 'John', surname: 'Doe', bank: 'Molewa Bank', bankAccountNumber: '1234567890' }
    When method post
    Then status 200
    And match response.warning == 'refer to compliance'