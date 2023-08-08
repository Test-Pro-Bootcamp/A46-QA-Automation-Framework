A46-QA-Automation-Framework


**To run smoke tests:**
gradle clean smoke


**To run on Selenium Grid:**
- navigate to your folder with selenium jar file (_cd Downloads_)
- run _java -jar selenium-server-4.11.0.jar standalone_
- open grid url
- to start tests run _gradle clean test -Dbrowser=grid-firefox_