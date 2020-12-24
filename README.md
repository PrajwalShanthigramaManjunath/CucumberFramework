# Declined Payment- test automation

Automation project on booking up to a declined payment on https://www.ryanair.com/ie/en.

# Tools

  - Maven
  - Cucumber- JVM
  - Junit
  - Selenium Webdriver
  - TestNG
  # Requirements
- Maven 3.6.3
- jdk-15.0.1
- Firefox

# Webdriver
Gecko driver is used to connect Firefox browser to the selenium scripts in steps file. It is not required to install to run the project as it is stored in ***/resources*** directory along with chrome driver.   

  # Usage
surefire plugins are used to target the ***testng.xml*** file from **POM file** which in turn targets the **Main Runner class** so that the project run in the command line(Can also be used to run and target multiple Runner files).

To run the project from windows command line,

    cd current directory\CucumberFramework mvn clean compile test 
To run the project from Eclipse IDE,
>    CucumberFramework\src\test\java\CucumberFramework\MainRunner.Java > Run as > JUnit Test  


### Reporting
Reports are written to the ***/target*** directory. 
* HTML report  -     ***target/cucumber***
* JSON - ***target/cucumber.json***
* Extent HTML Report - ***target/report.html***

### Development

> Used Cucumber to create Feature files using Gherkin detailing how the behavior is implemented.

> Step definitions to connect feature file with the Java code along with selenium webdriver.

> Initially tried using Firefox dev tools and Chropath extensions to get the element selectors but later switched to ***Ranorex salocity*** extension as it saved lot of time by providing the list of matching selectors.

> I have used **CSS** selectors for major part of the elements but had to use few **xpath** selectors after running multiple tests where certain elements required multiple attempts and provided relaible results using **xpath**.

> Although Selenium is able to use DOM in accessing page elements, couple of initial pages required me to automate scrolling in step files to eliminate some of the element search issues. 

> Multiple automative tests on the production page would buffer me out of the search results for few hours, probably because of listing my IP address as bot for continous web requests.  




