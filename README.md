# Solita_Academy_BikeJourney_Project_Backend

# Bike Journeys Application 

## Setup and Run Application

This guide will help you set up and run **Bike Journeys** project on your machine. <br>
The project uses a database, and you will need to change the database properties in the **application.properties** file to match your database settings.

<br/>

### Prerequisites
- Java Development Kit (JDK) version 11 installed on your server.
- A database installed on your server, such as MySQL

<br>

### Database Configuration

- In the src/main/resources directory, locate the application.properties file.
- Modify the following properties in the application.properties file to match your server's database settings:
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
    spring.datasource.username=myusername
    spring.datasource.password=mypassword
    server.port=8080
    cors.allowed.origins=http://localhost:myport

    ```

    Replace mydatabase, myusername, and mypassword with the name of your database, your database username, and your database password, respectively.

- Save the application.properties file.

<br>

### Running the Application

- Open terminal in a project root directory
- Build and start the application using the following command

    ```
    nohup mvn spring-boot:run > logs.out &
    ```
<br>

### Calling APIs from link

- Use the link to call API from browser or javascript request
    ```
    http://your-server-ip-address:8080/HTTPMethod
    ```

<br>

## Entities

- ### BikeStation

    | Property         | Type                  | Description                                                   |
    | ---------------- | --------------------- | ------------------------------------------------------------- |
    | id               | Integer               |                                                               |
    | name             | String                |                                                               |
    | address          | String                |                                                               |
    | city             | String                |                                                               |
    | operator         | String                |                                                               |
    | capacity         | Integer               |                                                               |
    | xCoordinate      | Float                 |                                                               |
    | yCoordinate      | Float                 |                                                               |
    | depatureBikeTrip | List &lt;BikeTrip&gt; | OneToMany, Mapped By BikeTrip.depatureBikeStation, JsonIgnore |
    | returnBikeTrip   | List&lt;BikeTrip&gt;  | OneToMany, Mapped By BikeTrip.returnBikeStation, JsonIgnore   |
<br>

- ### BikeTrip
    | Property               | Type        | Description                                                       |
    | ---------------------- | ----------- | ----------------------------------------------------------------- |
    | id                     | Integer     |                                                                   |
    | departureTime          | Timestamp   |                                                                   |
    | returnTime             | Timestamp   |                                                                   |
    | departureStationId     | Integer     |                                                                   |
    | departureStationName   | String      |                                                                   |
    | returnStationId        | Integer     |                                                                   |
    | returnStationName      | String      |                                                                   |
    | coveredDistanceInMeter | Float       |                                                                   |
    | durationInSec          | Float       |                                                                   |
    | depatureBikeStation    | BikeStation | ManyToOne, JoinColumn(BikeTrip.departureStationId=BikeStation.id) |
    | returnBikeStation      | BikeStation | ManyToOne, JoinColumn(BikeTrip.returnStationId=BikeStation.id)    |

<br>
<br>

## API Requests

Append the Endpoint with root url of the application

| Endpoint                               | Method | Parameters                                                                                                                                                                                                                       | Response                                                                                                                                                                                                                                                                                                                          |
| -------------------------------------- | ------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| /getalltrips                           | GET    | pagenumber(Integer), numberoftrips(Integer),<br> sortingcolumn(String), isascending(Boolean)                                                                                                                                     | totalPages(Integer), <br>pageContent(List&lt; BikeTrip&gt;)                                                                                                                                                                                                                                                                       |
| /gettripbyid                           | GET    | id(Integer)                                                                                                                                                                                                                      | Object&lt;BikeTrip&gt;                                                                                                                                                                                                                                                                                                            |
| /getcountoftrips                       | GET    |                                                                                                                                                                                                                                  | Count(List&lt;BikeTrip&gt;)(Integer) <br> *returns count of all BikeTrips                                                                                                                                                                                                                                                         |
| /getallstations                        | GET    |                                                                                                                                                                                                                                  | List&lt;BikeStation&gt;                                                                                                                                                                                                                                                                                                           |
| /getstationbyid                        | GET    | stationid(Integer)                                                                                                                                                                                                               | Object&lt;BikeStation&gt;                                                                                                                                                                                                                                                                                                         |
| /getstationsbyname                     | GET    | stationname(String), pagenumber(Integer), numberofstations(Integer)                                                                                                                                                              | totalPages(Integer), <br>pageContent(List&lt; BikeStation&gt;)<br> *returns BikeStation where name **starting** from requested **stationname**                                                                                                                                                                                    |
| /getstationdetailsbyname               | GET    | stationname(String)                                                                                                                                                                                                              | stationName(String), stationAddress(String),<br> departureStationAggregate{noOfStartingTrips(Integer), avgDistanceOfStartingTrips(Double)}, <br>returnStationAggregate{noOfEndingTrips(Integer), avgDistanceOfEndingTrips(Double)}, <br>  topFiveDepartureStations(List&lt;String&gt;), topFiveReturnStations(List&lt;String&gt;) |
| /getstationdetailsbynamewithdatefilter | GET    | stationname(String), startdate(Timestamp), enddate(Timestamp)                                                                                                                                                                    | stationName(String), stationAddress(String),<br> departureStationAggregate{noOfStartingTrips(Integer), avgDistanceOfStartingTrips(Double)}, <br>returnStationAggregate{noOfEndingTrips(Integer), avgDistanceOfEndingTrips(Double)}, <br>  topFiveDepartureStations(List&lt;String&gt;), topFiveReturnStations(List&lt;String&gt;) |
| /savebiketrip                          | POST   | departureTime(Timestamp), returnTime(Timestamp),<br> departureStationId(Integer), departureStationName(String),<br> returnStationId(Integer), returnStationName(String),<br> coveredDistanceInMeter(Float), durationInSec(Float) | Object&lt;BikeTrip&gt;                                                                                                                                                                                                                                                                                                            |
| /savebikestation                       | POST   | id(Integer), name(String),<br> address(String), city(String),<br> operator(String), capacity(Integer),<br> xCoordinate(Float), yCoordinate(Float)                                                                                | Object&lt;BikeStation&gt;                                                                                                                                                                                                                                                                                                         |

<br>
<br>
<br>
### Snippets
#### TESTS
![image](https://github.com/MohHajri/Solita_Academy_BikeJourney_Project_Backend/assets/89851240/f6308bc0-0aa3-42e0-855b-1459412d4c16)

