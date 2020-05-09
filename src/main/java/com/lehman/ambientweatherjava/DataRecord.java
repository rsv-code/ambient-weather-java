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
 * DataRecord class holds the data record info returned from the
 * Ambient Weather queryDeviceData API call. The result JSON data is mapped
 * into this object. This object extends BaseDtaRecords and most
 * of it's fields are defined there.
 */
public class DataRecord extends BaseDataRecord {
    /**
     * A String with the data location the data came from. (ambient-prod-2020-19)
     */
    private String loc = "";

    /**
     * Default constructor.
     */
    public DataRecord() { }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
