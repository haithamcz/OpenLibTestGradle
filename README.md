# OpenLibTestGradle

The automation BDD Framework for the testing of web applications and REST APi using Cucumber, and Selenium WebDriver
with TestNG and okhttp3.
This framework consists of:-

- Cucumber Java- 7.6.0
- Cucumber TestNG – 7.6.0
- Java 11
- TestNG – 7.6.0
- Gradle – 7.5.1
- Selenium – 4.3.0
- Okhttp3 - 5.0

## Pre Requisite:

- Java 8 or above installed
- Eclipse or IntelliJ IDE installed
- Gradle Installed
- Environment variables JAVA_HOME and GRADLE_HOME are correctly configured
- ChromeDriver based on the chrome browser version download the project dir

## Project Structure

in main/java the org.openlib package contains, page action, page locators and utils classes

- OpenLibPageActions this action class contain all the methods needed by the step definitions
- OpenLibPageLocator this class hold page object for the web application
- HttpServiceHandler this class handles http calls to the api
- TestBaseClass this class initialize the web driver, initializing the web driver wait and chrome options, defining the
  timeouts, and creating a private constructor of the class, </br>
  it will declare the web driver, so whenever we create an object of this class, a new web browser is invoked.
  </br>
- org.openlib.com.BaseClass is class where I initialize the browser as well as close the browser at the end of the
  execution and some screenshot handling.
- org.openlib.com.CucumberRunnerTests TestRunner class to run the feature files
- org.openlib.com.OpenLibWebStepDefinitions is the step definitions for the feature file

## Running tests

- either as cucumber java tests in the feature file (OpenLib.feature) in test/resources
- or in terminal go to project dir and type: ./gradlew cucumberCli

## Reports

cucumber report link will be displayed in console at the end of execution with screenshot</br>
Example :- </br>
View your Cucumber Report at:                                            │
│ https://reports.cucumber.io/reports/d23b0722-f594-4656-8acc-77fe0f9975c9 
