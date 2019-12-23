# Friday

This project automate the [sales funnel](https://hello.friday.de/quote/selectPrecondition). 

------
#### Pre-requsit to run the test

1. Install [Lombok 1.18.2](https://projectlombok.org/) 
2. Install `Cucumber Eclipse plugin` on your `Eclipse` or the alternative for `Intellij`

#### How to Run
There are two different ways to run the test:

1. From `src/test/resources` open the `RegisterInsurance.feature`. Right click on it, `Run as > Cucumber feature` 
This approach does not generate any report

2. From `src/test/java/runner` open the `TestRunnerJUnit` class. Right click on it, `Run as > JUnit test` 
This approach generates an HTML report in the **target folder**. 


------
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

------
#### Discussion about TestCases:

We have selected 12 different cars from 3 different brands. We considered different parameters such `model`, `body-type`, `fuel`, `enginer-power` and `engine` as below:

      | brand    | model    | body-type | fuel   | engine-power    | engine              |

      | TOYOTA   | Auris    | Kombi     | Benzin | 73 kW / 99 PS   | HSN: 5013, TSN: AIA |
      | TOYOTA   | Camry    | Kombi     | Diesel | 63 kW / 86 PS   | HSN: 7104, TSN: 494 |
      | BMW      | 3er      | Kombi     | Benzin | 95 kW / 129 PS  | HSN: 0005, TSN: 874 |
      | BMW      | 1er      | Cabrio    | Benzin | 105 kW / 143 PS | HSN: 0005, TSN: AMP |
      | BMW      | 2er      | Coupe     | Diesel | 110 kW / 150 PS | HSN: 0005, TSN: CCX |
      | CADILLAC | BLS      | Limousine | Benzin | 129 kW / 175 PS | HSN: 9116, TSN: AAM |
      | TOYOTA   | Auris    | Kombi     | Benzin | 73 kW / 99 PS   | HSN: 5013, TSN: AIA |
      | TOYOTA   | GT86     | Kombi     | Benzin | 73 kW / 99 PS   | HSN: 5013, TSN: AHS |
      | CADILLAC | ATS      | Limousine | Benzin | 129 kW / 175 PS | HSN: 9116, TSN: AAM |
      | CADILLAC | Eldorado | Limousine | Benzin | 224 kW / 305 PS | HSN: 1006, TSN: 971 |
      
The last 3 test cases are failing, because the app is not following the normal steps. For example `TOYOTA | GT86` skip from levels. Usually, for each single car the following option are selected:

`select brand > select model > select body-type > select fuel > select engine-power > select engine` 

but in case of `TOYOTA | GT86` it does the following steps: `select brand > select model > select engine`. Therefore, the test is failing.
      
 #### Getting test data using Postman
 
 In order to make sure, that the data is receiving in a proper structure do the following:
 
 1. Use *Postman* to send a *POST* request to `https://lookup-service.k8s.green.friday-prod.de/vehicleinfo/lookup`
 2. Set the json body of the request as below:
 
 `{
   "method":"findDetails_Ext",
   "params":[
      {
         "make":"CADILLAC",
         "model":"ATS"
      }
   ],
   "id":"0812b2f6-2081-4496-befe-2eff772d6f6c",
   "jsonrpc":"2.0"
}`

3. When you submit the request the *response* is:

![](https://user-images.githubusercontent.com/4312244/71355261-c33ec800-257e-11ea-8788-f03b5a01b52b.png)

Therefore, it seems that the Cars laready has the essential fields such as `engine`, `body-type` and so on, so it is a surprise why the last 3 testcases are not following the norrmal steps. 

Me, as a tester, I wish to talk with developers about the potential problems.
