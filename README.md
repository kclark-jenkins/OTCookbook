## Synopsis

This is a spring boot application built to hold a growing collection of servlets I use with the iHub.

## Screenshots
![alt tag](https://github.com/kclark-jenkins/OTCookbook/blob/master/Screenshots/swag1.png)
![alt tag](https://github.com/kclark-jenkins/OTCookbook/blob/master/Screenshots/swag2.png)
![alt tag](https://github.com/kclark-jenkins/OTCookbook/blob/master/Screenshots/swag3.png)
![alt tag](https://github.com/kclark-jenkins/OTCookbook/blob/master/Screenshots/swag4.png)

## Code Example

http://{HOSTNAME}:8080/DynCon/saveOrUpdate/volumeName/userName/connectionURL/someextrastuff

Expected output:

`{result: 'success'}`

http://{HOSTNAME}:8080/DynCon/getConnection/volumeName/userName

Expected output:

`[{"volume":"volumeName","connectionstring":"jdbc:mysql:%252%252localhost:3306%252mydatabase","extendedconnectionproperties":"someextrastuff","id":23,"username":"userName"}]`

## Installation

java -jar -Dserver.port=8080 OTCookbook-0.0.1-SNAPSHOT.jar

## Usage

http://localhost:8080/otcookbook

## Endpoints currently implemented

### /saveConnectionDetails

#### Usage

http://localhost:8080/otcookbook/saveConnectionDetails?username=test&volume=test&connectionString=test&extendedProperties=test

#### Output

`
{
  "id": 1,
  "result": "success"
}
`

### /getConnectionDetails

#### Usage

http://localhost:8080/otcookbook/getConnectionDetails?username=test&volume=test

#### Output

`
[
  {
    "id": 1,
    "username": "test",
    "volume": "test",
    "connectionString": "test",
    "extendedProperties": "test"
  }
]

## Contributors

Kristopher Clark

## License