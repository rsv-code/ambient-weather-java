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
 * DeviceDataRecord class holds the data record info returned from the
 * Ambient Weather listUsersDevices API call. The result JSON data is mapped
 * into this object. This object extends BaseDtaRecords and most
 * of it's fields are defined there.
 */
public class DeviceDataRecord extends BaseDataRecord {
    /**
     * Is a String with the device timezone. (America/Los_Angeles)
     */
    private String tz = "";

    /**
     * Default constructor.
     */
    public DeviceDataRecord() { }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }
}
