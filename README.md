# ambient-weather-java
Ambient Weather API for Java is a client connector that interfaces 
with the Ambient Weather web API. Returned data is bound to Java objects 
that are returned from each call. Currently the API only supports two calls, 
listUsersDevices and queryDeviceData. These calls handle everything needed 
to get a list of devices and query metrics.

### Requirements
- Ambient Weather Application Key
- Ambient Weather API Key
- Java 14 or later. (Could probably get away with 11 but not tested.)
- Maven ito build.

You can acquire Application and API keys by logging into your account at 
the Ambient Weather website and navigating to the account page at 
[https://ambientweather.net/account](https://ambientweather.net/account).

### Buiding
When building you shoud skip the unit tests since they'll bomb out because 
there's no Ambient Weather Application and API keys set. Once built the jar 
will be in the target directory naturally.
```
mvn clean package -DskipTests
```

### Using
Once you have the connector setup for use in your project and have 
 a App/API keys you can create an instance of the connector and 
 go to town.

```
// Create an instance of the connector with the 
// appKey and apiKey.
AmbientWeather aw = new AmbientWeather(appKey, apiKey);

// Get an array of Device objects. (See Device for fields and sub objects.)
Device[] devices = aw.listUsersDevices();

// Get records for the provided device MAC address. Note that there's a 
// user rate limit set by Ambient Weather allowing only 1 call a second.
// You will need to space out the calls by doing something like a 
// Thread.sleep(1000) in between calls if you are making more than one.
DataRecord[] records = aw.queryDeviceData(devices[0].getMacAddress());
```

There are 2 other variations on queryDeviceData. Please have a look at the 
source code comments for these in the AmbientWeather.java class.
```
public DataRecord[] queryDeviceData(String MacAddress, int Limit)
public DataRecord[] queryDeviceData(String MacAddress, int Limit, String EndDate)
```

For more usage examples you can have a look at the unit tests in.
/test/java/com/lehman/ambientweatherjava/AmbientWeatherTest.java. 

### License
Copyright 2020 Austin Lehman. Licensed under the Apache License, Version 2.0
