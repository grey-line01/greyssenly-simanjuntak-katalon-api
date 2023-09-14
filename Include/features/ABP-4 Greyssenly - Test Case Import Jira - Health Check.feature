@Ping

Feature: HealthCheck

As a user, I want to confirm whether the API is up and running.

@Valid 

Scenario: Get HealthCheck

Given URL https://restful-booker.herokuapp.com/ping

When I send a GET request

Then the response status code should be 201 