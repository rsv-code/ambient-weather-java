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
 * CoordsPair class holds the coordinate info of the deivce from data
 * returned from the Ambient Weather API call. The result JSON data
 * is mapped into this object.
 */
public class CoordsPair {
    /**
     * A double with the latitude coordinate value.
     */
    private double lat;

    /**
     * A double with the longitude coordinate value.
     */
    private double lon;

    /**
     * Default constructor.
     */
    public CoordsPair() { }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
