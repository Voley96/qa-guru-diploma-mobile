# Wikipedia (mobile app) automated tests

## Test Cases:

- Pass walkthrough
- Search by query

### Libraries have been used in this project

<p  align="left">
<code>
<img width="5%" title="IntelliJ IDEA" src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg">
<img width="5%" title="Java" src="https://starchenkov.pro/qa-guru/img/skills/Java.svg">
<img width="5%" title="JUnit5" src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg">
<img width="5%" title="Appium" src="https://starchenkov.pro/qa-guru/img/skills/Appium.svg">
<img width="5%" title="Browserstack" src="https://starchenkov.pro/qa-guru/img/skills/Browserstack.svg">
<img width="5%" title="Gradle" src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg">
<img width="5%" title="Selenoid" src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg">
<img width="5%" title="Github" src="https://starchenkov.pro/qa-guru/img/skills/Github.svg">
<img width="5%" title="Jenkins" src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg">
<img width="5%" title="Allure Report" src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg">
<img width="5%" title="Telegram" src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg">
</code>
</p>

# USAGE examples

### For run tests need to select build params:

* running server (browserstack or selenoid)
* environment
* comment (for telegram notification)
* 
Run tests on browserstack:

```bash
gradle clean test -DdeviceHost=browsertack
```

Run tests on selenoid:

```bash
gradle clean test -DdeviceHost=selenoid
```

Run test with not filled browserstack properties:

```bash
gradle -DdeviceHost=browserstack -Duser={put here browserstack user} -Dkey={put here browserstack access key} -Dapp={put here your browserstack app id} clean test
```

Usually, tests run on Browserstack or Selenoid via Appium.
>Appium is an open source test automation framework for use with native, hybrid and mobile web apps. It drives iOS, Android, and Windows apps using the WebDriver protocol.
>Browserstack is cloud web and mobile testing platform that provides developers with the ability to test their websites and mobile applications across on-demand browsers, operating systems and real mobile devices.
>Selenoid is one of implementation of original Selenium hub. It is using Docker to launch browsers. 

# Jenkins
>Jenkins – an open source automation server which enables developers around the world to reliably build, test, and deploy their software

## Jenkins job
Example of Jenkins job that executes tests
<a target="_blank" href="https://jenkins.autotests.cloud/job/09-Oleynik_Vladimir-mobile/">click here to open jenkins job</a>

## Jenkins parameters
You can change this params to run test on different environments, servers, etc...

<p  align="left">
<code>
<img width="80%" title="Jenkins-params" src="images/jenkins.png">
</code>
</p>

# Allure
> Allure Framework is a flexible lightweight multi-language test report tool that not only shows a very concise representation of what have been tested in a neat web report form, but allows everyone participating in the development process to extract maximum of useful information from everyday execution of tests.

## Allure TestOps
> Allure TestOps is a refined Test Operations Swiss army knife which allows you to manage all test related stuff in one place.

## Test Cases
> Test case management
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/testcases.png">
</code>
</p>

## Dashboard
> Dashboard with statuses of testcases on Allure TestOps
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/dashboard.png">
</code>
</p>

## Allure overview
> Different charts, metrics and statistic to easily analyze tests result
<p  align="left">
<code>
<img width="80%" title="Allure overview" src="images/allure.png">
</code>
</p>

## Allure test result
> Here is a result of test executing.  
<p  align="left">
<code>
<img width="80%" title="Allure test result" src="images/result.png">
</code>
</p>

## Allure video result
> You can see a short video how tests executes on Selenoid server
<p  align="left">
<code>
<img width="80%" title="Allure video" src="images/allure-record.gif">
</code>
</p>

## Jira Integration
> All test integrated with jira to check statuses and activity
<p  align="left">
<code>
<img width="80%" title="Allure video" src="images/jira.png">
</code>
</p>

# Telegram notification
> We use telegram bot to send test result to specified telegram channel
<p  align="left">
<code>
<img width="80%" title="Telegram notification" src="images/telegram.png">
</code>
</p>
