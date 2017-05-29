# booking-app


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You must have a Java JDK 7 or above installed, you can download it from [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and install it following the [official documentation](http://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html).

You must have Eclipse Mars or above installed, you can download it from [here](http://www.eclipse.org/downloads/) and you can install it following the [official documentation](https://wiki.eclipse.org/Eclipse/Installation#Eclipse_4.5_.28Mars.29).

You must have Apache Tomcat 8 installed, you can download it from [here](https://tomcat.apache.org/download-80.cgi) and you can install it following the [official documentation](https://tomcat.apache.org/tomcat-8.0-doc/index.html).

You must have Apache Maven 3 or above installed, you can download it from [here](https://maven.apache.org/download.cgi) and you can install it following the [official documentation](https://maven.apache.org/install.html) or use the embedded maven installation inside eclipse.

### Installing

To get a development env running you should follow the next steps:

1. Download or clone the git repository into your local machine.
[https://github.com/alexisdejesusdev/booking-app.git](https://github.com/alexisdejesusdev/booking-app.git)

2. Open the eclipse executable and import the maven project from the filesystem where it was downloaded or cloned.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nMkpIcGdXRTFZRlU)

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7ndFRMR1hHaFRVRkE)

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nR2xERWJMNC05c2s)

3. The project will then appear as a maven project in the project explorer.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nQmhWMTdDblF0dEE)

4. Right click the Servers view to add a new server.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nUVJDWVVUSVJGdTA)

5. Select Apache -> Tomcat v8.0 Server and click next.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7nR3dMa0k2cHFqM28)

6. Select the Tomcat installation directory from the file system and click next.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7ndFlDUGVUMDVvQU0)

7. Select the Tomcat installation directory from the file system and click next.

Image [here](https://drive.google.com/open?id=0B0VKN70UtF7ndFlDUGVUMDVvQU0)

8. Select the booking-app project, click Add > and then click Finish.

9. IMPORTANT: Before starting up the app, you MUST download and copy the database files in any local file system folder. It's recommended to put them both inside the temp folder of the tomcat installation folder: E.g. "C:\\apache-tomcat-8.0.32\\temp", please note that the file separators differ depending on the operating system.

[hotelRecords.json](https://drive.google.com/open?id=0B0VKN70UtF7nTDYzZlBTN3VIa1k)

[tripRecords.json](https://drive.google.com/open?id=0B0VKN70UtF7nUnFnOUNFM2VHVTg)

10. IMPORTANT: After copying both files, you MUST modify the file persistence.properties and update the property "persistence.path" to the path value where the files where put. 

E.g. "persistence.path = C:\\apache-tomcat-8.0.32\\temp"

11. The project will appear on the servers view, click on the Tomcat v8.0 server name and click the Start Server button the server will start after that.

12. Open the Chrome browser and enter to the following URL into the address bar. [http://localhost:8080/booking-app/index.html](http://localhost:8080/booking-app/index.html)

## Unit tests

The test will automatically run while building the maven project, however you can find them in the folder: src/text/java. 

The provided tests are just a reference of the main validations that the service layer performs, they're meant to exemplify how the full test will be done.  


## Deployment

To build and deploy the whole project and test it outside eclipse the next steps should be followed:

1. From the command line or maven console, move to the folder where the pom.xml file is saved.

2. Run the command mvn clean install.

3. After the process is finished move to the target folder created as a result of the previous step and copy the file called booking-app.war.

4. Paste the copied file to the webapps folder of the tomcat installation directory.

5. Start the tomcat service as told in the [official documentation] (https://tomcat.apache.org/tomcat-8.0-doc/setup.html).

6. Open the Chrome browser and enter to the following URL into the address bar. [http://localhost:8080/booking-app/index.html](http://localhost:8080/booking-app/index.html)

## Built Version

* Latest built version: [download](https://drive.google.com/open?id=0B0VKN70UtF7nNjV6VmNYMTUyTUk).

  It's currently pointing to the default file system folder, to change the value you MUST build it again with maven. 
  "persistence.path = C:\\apache-tomcat-8.0.32\\temp".

* Built with [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Alexis De Jesús Bautista** - *Initial work* -

## License

This project is not licensed.

