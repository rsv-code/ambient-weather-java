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

import org.apache.commons.codec.digest.DigestUtils;

/**
 * DataRecord class holds the data record info returned from the
 * Ambient Weather queryDeviceData API call. The result JSON data is mapped
 * into this object. This object extends BaseDtaRecords and most
 * of it's fields are defined there.
 */
public class DataRecord extends BaseDataRecord {
    /**
     * A String with the ID of the device. This is created by
     * calling setId() and will use a hash of the deviceMac
     * and dateutc fields.
     */
    private String id = "";

    /**
     * A String with the device MAC address.
     */
    private String deviceMac = "";

    /**
     * A String with the data location the data came from. (ambient-prod-2020-19)
     */
    private String loc = "";

    /**
     * Default constructor.
     */
    public DataRecord() { }

    /**
     * Generates the ID with a 256 hashed string containing the current
     * time in milliseconds since epoch (dateutc field) and the
     * deviceMac field. Note, the deviceMac needs to be manually
     * set before calling this function, otherwise the hash will
     * only include the date.
     */
    public void generateId() {
        this.id = DigestUtils.sha256Hex(this.getDateutc().getTime() + this.deviceMac);
    }

    public void setId(String Id) { this.id = Id; }

    public String getId() { return this.id; }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }
}
