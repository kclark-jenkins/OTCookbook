[Synopsis](#synopsis)

[Screenshots](#screenshots)

[Installation](#installation)

[Usage](#usage)

[Endpoints](#endpoints)

[Deployment](#deployment)

[BIRT](#birt)

[Contributors](#contributors)

[License](#license)

## [Synopsis](#synopsis)

This is a spring boot application built to hold a growing collection of servlets I use with the iHub.

## Screenshots
![alt tag](https://github.com/kclark-jenkins/OTCookbook/blob/master/Screenshots/swag1.png)
![alt tag](https://github.com/kclark-jenkins/OTCookbook/blob/master/Screenshots/swag2.png)
![alt tag](https://github.com/kclark-jenkins/OTCookbook/blob/master/Screenshots/swag3.png)
![alt tag](https://github.com/kclark-jenkins/OTCookbook/blob/master/Screenshots/swag4.png)

## [Installation](#installation)

java -jar -Dserver.port=8080 OTCookbook-0.0.1-SNAPSHOT.jar

## [Usage](#usage)

`http://localhost:8080/otcookbook`

## [Endpoints](#endpoints)

### /saveConnectionDetails

#### Usage

`http://localhost:8700/otcookbook/saveConnectionDetails?username=delegate&volume=Default%20Volume&connectionString=jdbc%3Aclassicmodels%3Asampledb&extendedProperties=%7B%22password%22%3A%22%22%2C%22username%22%3A%22Classic%20Models%22%7D`

#### Output

```
{
  "id": 1,
  "result": "success"
}
```

### /getConnectionDetails

#### Usage

`http://localhost:8700/otcookbook/getConnectionDetails?username=delegate&volume=Default%20Volume`

#### Output

```json[
  {
    "id": 1,
    "username": "delegate",
    "volume": "Default Volume",
    "connectionString": "jdbc:classicmodels:sampledb",
    "extendedProperties": {
      "password": "",
      "username": "Classic Models"
    }
  }
]
```

## [Deployment](#deployment)

When compiled to a WAR, this will deploy fine to Tomcat 7.  If you would like to use this as a web service from inside of the iHub follow the following steps.

1. Compile as a WAR.
2. Rename the output to a ZIP.
3. Create the folder "otcookbook" in C:\OpenText\InformationHub\modules\BIRTiHub\iHub\web\webapps\
4. Extract the ZIP to C:\OpenText\InformationHub\modules\BIRTiHub\iHub\web\webapps\otcookbook\
5. Navigate to C:\OpenText\InformationHub\modules\BIRTiHub\iHub\web\webapps\otcookbook\WEB-INF
6. Create a new web.xml with the following

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>

<!DOCTYPE web-app
    PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.2//EN"
    "http://java.sun.com/j2ee/dtds/web-app_2.2.dtd">

<web-app>
  <display-name>OT Cookbook</display-name>
  <servlet>
    <servlet-name>otcookbook</servlet-name>
    <display-name>OT Cookbook</display-name>
    <servlet-class>
        org.krisbox.cookbook.Application
    </servlet-class>
  </servlet>

  </web-app>
```

7. Open a browser and navigate to http://localhost:8700/otcookbook

## [BIRT](#birt)
BIRT uses the rhino engine allowing you to use both Java and JavaScript when writing script for your report so there are several ways to call a RESTful service.  I wrote a simple REST Client using java.io.  

1. Download DynamicConnections.jar
2. Place DynamicConnection.jar in the root of your BIRT Project
3. Go to the properties editor > Resources > Jar Files > Add File...
4. Slect DynamicConnections.jar it should be in the project root.
5. Either publish DynamicConnections.jar as a resource from the designer or upload it manually to the iHub to "Resources"
6. You can now use the following example code.  For my use, I placed it in a parameter

```
JSON.parse(new Packages.org.krisbox.cookbook.restclient.DynamicConnections().getConnectionDetails("http://localhost:8700/otcookbook/getConnectionDetails?username=anonymous&volume=Default%20Volume"))[0].extendedProperties.password;
```

[Download DynamicConnections.jar](https://github.com/kclark-jenkins/OTCookbook/releases)

## [Contributors](#contributors)

Kristopher Clark

## [License](#license)

[MIT License](https://github.com/kclark-jenkins/OTCookbook/blob/master/LICENSE)
