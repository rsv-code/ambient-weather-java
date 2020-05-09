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

/**
 * Device class holds the device data returned from the
 * Ambient Weather API call. The result JSON data is mapped
 * into this object.
 */
public class Device {
    /**
     * A String with the device MAC address.
     */
    private String macAddress;

    /**
     * This is a DeviceDataRecord with the last data
     * captured from the device.
     */
    private DeviceDataRecord lastData;

    /**
     * Info is a DeviceInfo object with things like the device
     * name and location.
     */
    private DeviceInfo info;

    /**
     * Default constructor.
     */
    public Device() { }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public DeviceDataRecord getLastData() {
        return lastData;
    }

    public void setLastData(DeviceDataRecord lastData) {
        this.lastData = lastData;
    }

    public DeviceInfo getInfo() {
        return info;
    }

    public void setInfo(DeviceInfo info) {
        this.info = info;
    }
}
