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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Test class for AmbientWeather connector. When running
 * the following Java options need to be passed in:
 *
 * -DappKey=c2978e...cd246d
 * -DapiKey=0e613c...2389b7
 */
public class AmbientWeatherTest {
    private static AmbientWeather aw;

    /**
     * Setup gets the application and API keys passed in the
     * VM arguments and performs instantiation of the AmbientWeather object.
     */
    @BeforeClass
    public static void setup() {
        String appKey = System.getProperty("appKey");
        String apiKey = System.getProperty("apiKey");

        System.out.println("Creating instance of AmbientWeather.");
        aw = new AmbientWeather(appKey, apiKey);
    }

    /**
     * Cleans up the AmbientWeather object.
     */
    @AfterClass
    public static void tearDown() {
        System.out.println("Cleaning up instance of AmbientWeather.");
        aw = null;
    }

    /**
     * Tests the listUsersDevices API call. This test makes a call
     * to Ambient Weather and it assumes that the number of devices
     * returned is greater than 0.
     * @throws IOException
     * @throws InterruptedException
     * @throws HttpStatusException
     */
    @Test
    public void listUsersDevices() throws IOException, InterruptedException, HttpStatusException {
        Device[] devices = this.aw.listUsersDevices();
        // Sleep for 1 second between requests or Ambient Weather will return a 429 (above-user-rate-limit).
        Thread.sleep(1000);
        assertTrue(devices != null && devices.length > 0);
    }

    /**
     * Tests the queryDeviceData API call. This test first gets the
     * lists of devices. It expects to find at least one device. It then
     * uses the first device to then query the device data. It expects
     * the result to contain 1 or more data records.
     * @throws InterruptedException
     * @throws HttpStatusException
     * @throws IOException
     */
    @Test
    public void queryDeviceData() throws InterruptedException, HttpStatusException, IOException {
        Device[] devices = this.aw.listUsersDevices();
        // Sleep for 1 second between requests or Ambient Weather will return a 429 (above-user-rate-limit).
        Thread.sleep(1000);

        if (devices != null && devices.length > 0) {
            DataRecord[] records = this.aw.queryDeviceData(devices[0].getMacAddress());
            // Sleep for 1 second between requests or Ambient Weather will return a 429 (above-user-rate-limit).
            Thread.sleep(1000);
            assertTrue(records != null && records.length > 0);
        } else {
            assertTrue(false);
        }
    }
}
