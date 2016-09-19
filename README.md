# TagCloudApi2
TagCloudApi

![image](/dd5aaa8b-25f1-4755-afe3-39e41bdb2678.jpg)

* Make sure that Java 1.8 and Maven is installed correctly
* Clone or download the repo from github!
* Go to http://dev.twitter.com
* Create an account if you dont already have one.
* Go to https://apps.twitter.com/ and create a new app (follow the guide)
* Open the app, and click "manage keys and access tokens"
* Copy the API key and API secret in to the application.properties. (The file is located project-root\src\main\resources)
* Open a command window, run mvn spring-boot:run, depending on your hardware it shoud take 2-5 seconds.
* Enjoy the site on http://localhost:8080/

# Deploy

* Go to your command tool, in the project-root.
* Make a mvn clean install
* Go to /target
* You can now run java -jar TagCloudApi-1.0-SNAPSHOT.jar
* This will start up the server on most platforms.
