This repository has been designed for `Applitools Cross Browser Testing Hackathon` 
and includes automated tests for the hackathon website.


## Packages
The project uses the following packages:
* Selenium WebDriver 3.141.59
* ChromeDriver 81.0.4044.138, GeckoDriver v0.26.0
* Java JDK 14
* TestNG 7.1.0
* Applitools Eyes SDK 3.162.0


## Project Structure
* `EyesManager` is a wrapper class for Applitools Eyes configuration. 
`BaseTests` class serve for the setup and teardown of traditional tests.
* `pages` folder contains BasePage that includes common methods and page objects which represent pages of the website.
* `tests` folder includes two types of tests - traditional and modern. As there were some differences in locators 
between V1 and V2, separate files have been created for each version of tests. For Version 1, 
traditional test results will be written in `traditional-V1-TestResults.txt` file, and for Version 2 
they will be recorded in `traditional-V2-TestResults.txt` file.


## Setup and Running Tests
* Applitools API Key is being read from the environment variables.
* To execute traditional tests against Version 1, run `TraditionalTestsV1.xml` file. To run them against Version 2, 
use `TraditionalTestsV2.xml` file. The same applies for the modern tests.
* The suites for traditional tests include all tests which will be running on Chrome and Firefox browsers 
with viewport sizes of 1200x700, 768x700 and 500x700.

## Notes
* As I use Linux platform as my working environment, Edge Chromium was not available to me. 
* Currently, Linux supports Chrome version 81, that's why I ran modern tests on that version as well 
(I was having some issues with version 83 and was not able to debug them locally).


## Author
Vica Markosyan