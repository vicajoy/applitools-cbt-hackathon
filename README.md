This repository has been designed for `Applitools Cross Browser Testing Hackathon` 
and includes automated tests for the [Version 1](https://demo.applitools.com/gridHackathonV1.html)
and [Version 2](https://demo.applitools.com/gridHackathonV2.html) applications.


## Packages
The project uses the following packages:
* Selenium WebDriver 3.141.59
* ChromeDriver 83.0.4103.97 
* GeckoDriver 0.26.0
* Java JDK 11 or higher
* Apache Maven 3.6.3
* TestNG 7.1.0
* AssertJ 3.16.1
* Applitools Eyes SDK 3.162.0


## Setup and Running Tests
* Applitools API Key is being read from the environment variables.
* To execute traditional tests against Version 1, run `TraditionalTestV1.xml` suite. To run them against Version 2, 
use `TraditionalTestV2.xml` suite. The same applies for the modern tests.
* The suites for traditional tests include all tests which will be running on Chrome and Firefox browsers 
with viewport sizes of 1200x700, 768x700 and 500x700.


## Notes
* As there were some differences in locators between V1 and V2, separate files have been created for each version of tests. 
For Version 1, traditional test results will be written in `traditional-V1-TestResults.txt` file, and for Version 2 
they will be recorded in `traditional-V2-TestResults.txt` file.
* Used Chrome v83.0.4 and Firefox v77.0.1 browsers (the latest ones that Linux supports).
* Edge Chromium is not available on Linux, that's why it's missing in these tests.


## Author
Vica Markosyan