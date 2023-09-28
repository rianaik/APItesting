# DemoTesting

This repository contains UI and API tests for a web application using Selenium, TestNG, and RestAssured.

Project Structure

- src/test/java
  - com.example.tests
    - api
      - APITest.java
      - BaseAPITest.java
    - ui
      - BaseUITest.java
      - UITest.java
- src/test/resources
  - config.properties
- testng.xml
The src/test/java directory contains two subdirectories for API and UI tests. The API tests are located in the api directory, while the UI tests are located in the ui directory.

The src/test/resources directory contains a config.properties file which contains the configuration values used in the tests.

The testng.xml file is the TestNG configuration file that specifies the test classes to run and their parameters.

## Running the Tests

To run the tests, follow these steps:

- Clone the repository.
- Install the dependencies by running `mvn install`.
- Update the `config.properties` file with the appropriate values.
- Run the tests by running `mvn test`.
  
## API Tests

The API tests use RestAssured to make HTTP requests to the API and verify the responses.

The BaseAPITest class contains common functionality for the API tests, such as setting up the RestAssured configuration.

The APITest class contains the actual API tests. It uses the TestNG framework to define the test cases and assertions.

## UI Tests

The UI tests use Selenium to interact with the web application and verify the user interface.

The BaseUITest class contains common functionality for the UI tests, such as setting up the Selenium WebDriver.

The UITest class contains the actual UI tests. It uses the TestNG framework to define the test cases and assertions.

## Configuration

The config.properties file contains the following properties:
```
- `api.baseurl`: The base URL of the API.
- `ui.baseurl`: The base URL of the web application.
- `ui.browser`: The name of the browser to use for the UI tests (e.g. chrome, firefox).
```
## Contributing

If you find a bug or have a feature request, please open an issue or submit a pull request.
