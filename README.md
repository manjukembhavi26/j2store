# j2store
Coding Assignment Details
Using any automation tool(framework approach) please write tests that will do the following:
1. Open "http://j2store.net/demo/" site browse a couple of categories(any) for items
2. Open a couple of blogs randomly (data driven)
3. Add a couple of products (random category) to shopping and check out as a new customer
4. A report(any) of test execution
Note- The test scripts should follow coding standards, compile and run from the command line and within IDE.




Steps to Execute : 

Download the project or clone the project to IDE 
Do mvn clean install(make sure proper internet connection for automatic downloads of dependencies and make the build is success)
Run textng.xml from IDE 

or Run it from commond promt using "mvn clean install -DskipTests=false"

Defaulty it will get executed in chrome browser and extent report will generated and stored in workspace as j2storeReport.html 

