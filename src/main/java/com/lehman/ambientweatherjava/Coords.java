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
 * Coords class holds the location info data returned from the
 * Ambient Weather API call. The result JSON data is mapped
 * into this object.
 */
public class Coords {
    /**
     * A CoordsPair object with the coordinate pair of the device.
     */
    private CoordsPair coords;

    /**
     * A String with the device address.
     */
    private String address = "";

    /**
     * A String with the device location. (City)
     */
    private String location = "";

    /**
     * A double with the elevation in feet above sea level.
     */
    private double elevation;

    /**
     * A Geo object with the geography data.
     */
    private Geo geo;

    /**
     * Default constructor.
     */
    public Coords() { }

    public CoordsPair getCoords() {
        return coords;
    }

    public void setCoords(CoordsPair coords) {
        this.coords = coords;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
