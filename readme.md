Using Java, Spring Boot, MySQL DB, Postman
Postman to send POST & GET requests

<b>Repository</b> > Direct interaction with the database. Use predefined and custom query methods.
<b>Service</b> > Abstraction over the Repository. Single point of access for data manipulation.
<b>Controller</b> > Handles HTTP requests and uses Service to work with data.

Start DB on port 3306 and DB name is weatherapi
spring.datasource.url=jdbc:mysql://localhost:3306/weatherapi
spring.datasource.username= {{your_username}}
spring.datasource.password= {{your_password}}

<h2>Things to do or Improve</h2>
Add handling to not overwhelm bulk adding data to DB
Add Unit testing, validate in and output, data types, etc.
Add a CLI menu for user to pick from selection of actions
Add input sanitation and validation, null handling

<h2>Postman Collection Included</h2>

<h2>GET</h2> 
all data http://localhost:8080/api/get-all-data
By sensor http://localhost:8080/api/sensor/sensor_1
Between Date Range http://localhost:8080/api/get-date-range?start=2024-01-01T00:00:00&end=2024-12-31T00:00:00
Get avg by metric and sensor id http://localhost:8080/api/average/sensor/sensor_2/metric/temperature
Get avg by metric http://localhost:8080/api/average/metric/humidity
Get average of all sensors http://localhost:8080/api/average/sensors
Get average by sensor for last week http://localhost:8080/api/average/sensor_1/last-week

<h2>POST</h2>
Add Data http://localhost:8080/api/add-data
Bulk Add Data http://localhost:8080/api/bulk-add-data

<h3>Sample Bulk Add Data</h3>

[
{
"sensorId": "sensor_1",
"metric": "Humidity",
"value": 32.95,
"timestamp": "2024-06-02T19:41:31"
},
{
"sensorId": "sensor_3",
"metric": "Wind Speed",
"value": -1.55,
"timestamp": "2024-06-18T08:04:23"
},
{
"sensorId": "sensor_5",
"metric": "Humidity",
"value": 20.35,
"timestamp": "2024-06-02T03:30:22"
},
{
"sensorId": "sensor_5",
"metric": "Humidity",
"value": 12.29,
"timestamp": "2024-06-28T09:15:37"
},
{
"sensorId": "sensor_2",
"metric": "Wind Speed",
"value": 39.24,
"timestamp": "2024-06-08T12:06:32"
},
{
"sensorId": "sensor_4",
"metric": "Temperature",
"value": 24.28,
"timestamp": "2024-06-10T21:16:41"
},
{
"sensorId": "sensor_5",
"metric": "Wind Speed",
"value": -8.16,
"timestamp": "2024-06-13T07:18:52"
},
{
"sensorId": "sensor_2",
"metric": "Temperature",
"value": 9.99,
"timestamp": "2024-06-04T02:35:48"
},
{
"sensorId": "sensor_5",
"metric": "Wind Speed",
"value": -18.58,
"timestamp": "2024-06-16T05:49:55"
},
{
"sensorId": "sensor_2",
"metric": "Temperature",
"value": 36.88,
"timestamp": "2024-06-12T04:41:59"
},
{
"sensorId": "sensor_2",
"metric": "Wind Speed",
"value": 15.36,
"timestamp": "2024-06-25T10:39:15"
},
{
"sensorId": "sensor_5",
"metric": "Wind Speed",
"value": -9.37,
"timestamp": "2024-06-28T02:15:36"
},
{
"sensorId": "sensor_5",
"metric": "Temperature",
"value": 20.67,
"timestamp": "2024-06-08T14:54:18"
},
{
"sensorId": "sensor_1",
"metric": "Temperature",
"value": 40.98,
"timestamp": "2024-06-11T11:17:34"
},
{
"sensorId": "sensor_5",
"metric": "Humidity",
"value": -16.11,
"timestamp": "2024-06-16T22:30:26"
},
{
"sensorId": "sensor_5",
"metric": "Wind Speed",
"value": 19.63,
"timestamp": "2024-06-10T09:48:25"
},
{
"sensorId": "sensor_4",
"metric": "Humidity",
"value": -1.83,
"timestamp": "2024-06-13T18:03:36"
},
{
"sensorId": "sensor_5",
"metric": "Wind Speed",
"value": 44.42,
"timestamp": "2024-06-05T06:25:47"
},
{
"sensorId": "sensor_1",
"metric": "Humidity",
"value": 47.66,
"timestamp": "2024-06-13T06:35:50"
},
{
"sensorId": "sensor_3",
"metric": "Humidity",
"value": -8.97,
"timestamp": "2024-06-04T19:14:30"
}
]
