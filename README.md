# Selenium-Java-TestNG-Automation-Framework

* Built from scratch Web Test Automation Framework with Java, Selenium Web Driver and TestNG.
* Supports cross-platform testing.

Prerequisites:
---------------
*	Java jdk-1.8 or higher
*	Apache Maven 3 or higher

Browsers supported:
---------------
*   Google Chrome (default)

Execution:
---------------

*	Clone the repository.
*	Go to project root
*   Run following commands:
```sh
$ mvn clean install
$ mvn clean test
```

Reporting:
---------------
*  The framework produce index.html report. It resides in the same 'target\surefire-reports' folder.
*  You can find emailable-report.html from target\surefire-reports to email the test reports. As this is a html report you can open it with browser.


