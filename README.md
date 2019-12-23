# Friday

This project automate the [sales funnel](https://hello.friday.de/quote/selectPrecondition). 

#### Pre-requsit to run the test

1. Make sure you have installed [Lombok 1.18.2](https://projectlombok.org/)
2. Make sure you have `Cucumber Eclipse plugin` on your `Eclipse` or the alternative for `Intellij`

#### How to Run
There are two different ways to run the test:

1. From `src/test/resources` open the `RegisterInsurance.feature`. Right click on it, `Run as > Cucumber feature` 
This approach does not generate any report

2. From `src/test/java/runner` open the `TestRunnerJUnit` class. Right click on it, `Run as > JUnit test` 
This approach generates an HTML report in the **target folder**. 



#### Technologies

Technology  | Stack
------------- | -------------
Build Tool  | Maven
Language  | Java 1.8
UI technology  | Selenium / Cucumber / [webdrivermanager 3.7.1](https://github.com/bonigarcia/webdrivermanager)
Test framework  | Junit
Reporting  | [cucumber-extentsreport 3.1.1](https://github.com/email2vimalraj/CucumberExtentReporter)
Manage boilerplate code | [Lombok 1.18.2](https://projectlombok.org/)
IDE | STS 3.9.6.RELEASE


#### Discussion about TestCases:
