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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Device class holds the device info data returned from the
 * Ambient Weather API call. The result JSON data is mapped
 * into this object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInfo {
    /**
     * A String with the name given to this device.
     */
    private String name = "";

    /**
     * Location is a string with the location name.
     */
    private String location = "";

    /**
     * Default constructor.
     */
    public DeviceInfo() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
