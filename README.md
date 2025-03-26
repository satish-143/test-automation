# POS Malaysia Rate Calculator Test Automation

This repository contains solutions for the POS Malaysia API testing and UI automation assessment.

## Requirements
- Java 1.8
- Maven
- Chrome browser

## Setup
1. Clone the repository
2. Run `mvn clean install` to download dependencies

## Running Tests
- API Tests: Import the Postman collection from `postman/` directory
- UI Tests: Run `mvn test` to execute the Cucumber tests

## Project Structure
- `src/main/java/com/pos`: Contains all Java code including page objects and step definitions
- `src/test/resources/features`: Contains BDD feature files
- `postman`: Contains Postman collection for API testing

## Test Scenario
The UI automation test verifies that a user can calculate shipping rates from Malaysia to India and see multiple quote options.