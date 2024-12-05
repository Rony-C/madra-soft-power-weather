<p>
I used Java, Maeven, Spring Boot, MySQL and Postman for this assignment. I would say I am roughly equally skilled at Java and Python. I have been meaning to give Spring Boot a good try and this seemed like a good opportunity to use and learn a bit about it.<br>

MySQL Server is running locally to store the db info.
I used Postman to test my API calls.<br>

I generated JavaDocs with <strong>mvn javadoc:javadoc</strong><br>

</p>
<p>
<h4>Postman API Call Collection Included in project files</h4>
<b>Ronan GET and POST for Weather App.postman_collection.json</b>
</p>
<p>
<b>Repository</b> > Direct interaction with the database. Use predefined and custom query methods.<br>
<b>Service</b> > Abstraction over the Repository. Single point of access for data manipulation.<br>
<b>Controller</b> > Handles HTTP requests and uses Service to work with data.<br>
<b>Entity</b> > Defines columns and JPA entity to be used with data calls<br>
</p>
<p>
Start MySQL DB on port 3306 and create schema with name <b>weatherapi</b><br>

Info below is from application.properties file<br>
spring.datasource.url=jdbc:mysql://localhost:3306/weatherapi<br>
spring.datasource.username= {{your_username}}<br>
spring.datasource.password= {{your_password}}<br>

</p>

<h2>Things to do or Improve</h2>
<p>
<ul>
<li>Add handling to not overwhelm bulk adding data to DB. On more than one occasion I crashed my DB bulk adding data via API.</li>
<li>Add Unit testing, validate in and output, data types, etc.</li>
<li>Add a CLI menu for user to pick from selection of actions</li>
<li>Add input sanitation and validation, null handling</li>
<li>Add more relevant and nuanced queries that can be manipulated by end user</li>
<li>Add Exception handing, try catch blocks</li>
</ul>
The main reason I didn't add any of these was down to time, I wanted to stick to about 5/6 hours for the project including some study time.
<p>

<h2>GET</h2> 
<ul>
<li>all data http://localhost:8080/api/get-all-data</li>
<li>By sensor http://localhost:8080/api/sensor/sensor_1</li>
<li>Between Date Range http://localhost:8080/api/get-date-range?start=2024-01-01T00:00:00&</li>end=2024-12-31T00:00:00
<li>Get avg by metric and sensor id http://localhost:8080/api/average/sensor/sensor_2/metric/temperature</li>
<li>Get avg by metric http://localhost:8080/api/average/metric/humidity</li>
<li>Get average of all sensors http://localhost:8080/api/average/sensors</li>
<li>Get average by sensor for last week http://localhost:8080/api/average/sensor_1/last-week</li>
</ul>

<h2>POST</h2>
<ul>
<li>Add Data http://localhost:8080/api/add-data</li>
<li>Bulk Add Data http://localhost:8080/api/bulk-add-data</li>
</ul>

<h3>Sample Bulk Add Data</h3>
<code>
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
</code>
