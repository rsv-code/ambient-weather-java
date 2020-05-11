/*
 * Copyright 2020 Austin Lehman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lehman.ambientweatherjava;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Java connector client class that implements remote calls
 * for listUsersDevices and queryDeviceData. Ambient Weather API
 * reference can be found at https://ambientweather.docs.apiary.io .
 */
public class AmbientWeather {
    /**
     * The base URL of the remote Ambient Weather API.
     */
    private String baseUrl = "https://api.ambientweather.net/v1/";

    /**
     * The max number of records to request. If limit isn't set in
     * the request then this value is used. This is the max number
     * according to the Ambient Weather docs.
     */
    private int maxDataRecords = 288;

    /**
     * Stores the application key.
     */
    private String applicationKey = "";

    /**
     * Stores the API key.
     */
    private String apiKey = "";

    /**
     * The Java HttpClient object to use when connecting
     * to the remote service.
     */
    private HttpClient client;

    /**
     * Constructor takes the application key and API key. The
     * constructor stores those values and creates the HttpClient
     * object. Note that the Application and API keys are provided
     * by Ambient Weather at https://ambientweather.net/account .
     * @param ApplicationKey is a String with the application key.
     * @param APIKey is a String with the API key.
     */
    public AmbientWeather(String ApplicationKey, String APIKey) {
        this.applicationKey = ApplicationKey;
        this.apiKey = APIKey;

        // Initialize the client
        this.client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
            .build()
        ;
    }

    /**
     * Lists the user's devices. This request if successful returns a list of Device
     * objects with the user's devices.
     * @return An array of Device objects.
     * @throws HttpStatusException will be thrown if a non-200 status is returned.
     * @throws IOException
     * @throws InterruptedException
     */
    public Device[] listUsersDevices() throws HttpStatusException, IOException, InterruptedException {
        Device[] devices = new Device[0];
        // Create the request URL.
        String url = this.baseUrl + "devices?"
            + "applicationKey=" + this.applicationKey
            + "&apiKey=" + this.apiKey
        ;

        // Create the request object.
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofMinutes(2))
            .header("Content-Type", "application/json")
            .GET()
            .build()
        ;

        // Send the request and handle the response.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            String responseJson = response.body();
            ObjectMapper map = new ObjectMapper();
            devices = map.readValue(responseJson, Device[].class);
        } else {
            throw new HttpStatusException(response.statusCode(), response.body());
        }

        return devices;
    }

    /**
     * Gets a list of DataRecords with the provided MAC address. This method will get the last 288 available
     * records from now. If you want to change the request end date or limit to a number smaller than 288 than
     * use one of the other methods.
     * @param MacAddress is a String with the device MAC address. (Acquired from listUsersDevices)
     * @return An array of DataRecord objects.
     * @throws HttpStatusException will be thrown if a non-200 status is returned.
     * @throws IOException
     * @throws InterruptedException
     */
    public DataRecord[] queryDeviceData(String MacAddress) throws HttpStatusException, IOException, InterruptedException {
        return this.queryDeviceData(MacAddress, this.maxDataRecords);
    }

    /**
     *
     * @param MacAddress is a String with the device MAC address. (Acquired from listUsersDevices)
     * @param Limit is an int with the max number of records to return. This value can't be greater than 288.
     * @return An array of DataRecord objects.
     * @throws HttpStatusException will be thrown if a non-200 status is returned.
     * @throws IOException
     * @throws InterruptedException
     */
    public DataRecord[] queryDeviceData(String MacAddress, int Limit) throws HttpStatusException, IOException, InterruptedException {
        return this.queryDeviceData(MacAddress, Limit, "");
    }

    /**
     *
     * @param MacAddress is a String with the device MAC address. (Acquired from listUsersDevices)
     * @param Limit is an int with the max number of records to return. This value can't be greater than 288.
     * @param EndDate is a UTC date formatted string to use in the query as the end date to select records from.
     * @return An array of DataRecord objects.
     * @throws HttpStatusException will be thrown if a non-200 status is returned.
     * @throws IOException
     * @throws InterruptedException
     */
    public DataRecord[] queryDeviceData(String MacAddress, int Limit, String EndDate) throws HttpStatusException, IOException, InterruptedException {
        DataRecord[] records = new DataRecord[0];
        // Create the request URL.
        String url = this.baseUrl + "devices/" + MacAddress + "?"
                + "applicationKey=" + this.applicationKey
                + "&apiKey=" + this.apiKey
                + "&limit=" + Limit
                ;

        if (EndDate != null && !EndDate.equals("")) {
            url += "&endDate=" + EndDate;
        }

        // Create the request object.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .GET()
                .build()
                ;

        // Send the request and handle the response.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            String responseJson = response.body();
            ObjectMapper map = new ObjectMapper();
            records = map.readValue(responseJson, DataRecord[].class);
        } else {
            throw new HttpStatusException(response.statusCode(), response.body());
        }

        // Update all records with MAC address and ID.
        for (DataRecord rec : records) {
            rec.setDeviceMac(MacAddress);
            rec.generateId();    // Must be called AFTER setting the MAC.
        }

        return records;
    }
}
