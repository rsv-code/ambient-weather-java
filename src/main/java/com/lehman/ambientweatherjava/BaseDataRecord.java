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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * BaseDataRecord class holds the base data record info returned from the
 * Ambient Weather API call. The result JSON data is mapped
 * into this object. This object is meant to be extended by DataRecord and
 * DeviceDataRecord as most of their fields are the same but a few are different.
 */
public class BaseDataRecord {
    /**
     * The date in UTC format. This comes across as epoch time
     * in a long int format but is converted to Java Date object
     * by the custom DateHandler class.
     */
    @JsonDeserialize(using = DateHandler.class)
    private Date dateutc;

    /**
     * Temperature indoors Fahrenheit.
     */
    private double tempinf;

    /**
     * Humidity indoors as percentage.
     */
    private int humidityin;

    /**
     * Barometric pressure in Hg/hr indoors relative.
     */
    private double baromrelin;

    /**
     * Barometric pressure in Hg/hr indoors absolute.
     */
    private double baromabsin;

    /**
     * Temperature outdoors Fahrenheit.
     */
    private double tempf;

    /**
     * Battery outdoors status.
     */
    private int battout;

    /**
     * Humidity outdoors as percentage.
     */
    private int humidity;

    /**
     * Wind direction outdoors azimuth in degrees.
     */
    private int winddir;

    /**
     * Wind speed outdoors in mph.
     */
    private double windspeedmph;

    /**
     * Wind gust speed outdoors in mph.
     */
    private double windgustmph;

    /**
     * Maximum daily gust speed outdoors in mph.
     */
    private double maxdailygust;

    /**
     * Hourly rain outdoors in inches.
     */
    private double hourlyrainin;

    /**
     * Event rain outdoors in inches.
     */
    private double eventrainin;

    /**
     * Daily rain outdoors in inches.
     */
    private double dailyrainin;

    /**
     * Weekly rain outdoors in inches.
     */
    private double weeklyrainin;

    /**
     * Monthly rain outdoors in inches.
     */
    private double monthlyrainin;

    /**
     * Total rain outdoors in inches.
     */
    private double totalrainin;

    /**
     * Solar radiation outdoors in w/m^2.
     */
    private double solarradiation;

    /**
     * UV index outdoors.
     */
    private int uv;

    /**
     * Feels like temperature outdoors in Fahrenheit.
     */
    private double feelsLike;

    /**
     * Dew point temperature outdoors in Fahrenheit.
     */
    private double dewPoint;

    /**
     * Feels like temperature indoors in Fahrenheit.
     */
    private double feelsLikein;

    /**
     * Dew point temperature indoors in Fahrenheit.
     */
    private double dewPointin;

    /**
     * A String with a UTC timestamp with the last recorded rain time. (2020-04-06T23:53:00.000Z)
     */
    private String lastRain = "";

    /**
     * A String with a UTC timestamp with the current datetime. (2020-05-09T04:05:00.000Z)
     */
    private String date = "";

    /**
     * Default constructor.
     */
    public BaseDataRecord() { }

    public Date getDateutc() {
        return dateutc;
    }

    public void setDateutc(Date dateutc) {
        this.dateutc = dateutc;
    }

    public double getTempinf() {
        return tempinf;
    }

    public void setTempinf(double tempinf) {
        this.tempinf = tempinf;
    }

    public int getHumidityin() {
        return humidityin;
    }

    public void setHumidityin(int humidityin) {
        this.humidityin = humidityin;
    }

    public double getBaromrelin() {
        return baromrelin;
    }

    public void setBaromrelin(double baromrelin) {
        this.baromrelin = baromrelin;
    }

    public double getBaromabsin() {
        return baromabsin;
    }

    public void setBaromabsin(double baromabsin) {
        this.baromabsin = baromabsin;
    }

    public double getTempf() {
        return tempf;
    }

    public void setTempf(double tempf) {
        this.tempf = tempf;
    }

    public int getBattout() {
        return battout;
    }

    public void setBattout(int battout) {
        this.battout = battout;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWinddir() {
        return winddir;
    }

    public void setWinddir(int winddir) {
        this.winddir = winddir;
    }

    public double getWindspeedmph() {
        return windspeedmph;
    }

    public void setWindspeedmph(double windspeedmph) {
        this.windspeedmph = windspeedmph;
    }

    public double getWindgustmph() {
        return windgustmph;
    }

    public void setWindgustmph(double windgustmph) {
        this.windgustmph = windgustmph;
    }

    public double getMaxdailygust() {
        return maxdailygust;
    }

    public void setMaxdailygust(double maxdailygust) {
        this.maxdailygust = maxdailygust;
    }

    public double getHourlyrainin() {
        return hourlyrainin;
    }

    public void setHourlyrainin(double hourlyrainin) {
        this.hourlyrainin = hourlyrainin;
    }

    public double getEventrainin() {
        return eventrainin;
    }

    public void setEventrainin(double eventrainin) {
        this.eventrainin = eventrainin;
    }

    public double getDailyrainin() {
        return dailyrainin;
    }

    public void setDailyrainin(double dailyrainin) {
        this.dailyrainin = dailyrainin;
    }

    public double getWeeklyrainin() {
        return weeklyrainin;
    }

    public void setWeeklyrainin(double weeklyrainin) {
        this.weeklyrainin = weeklyrainin;
    }

    public double getMonthlyrainin() {
        return monthlyrainin;
    }

    public void setMonthlyrainin(double monthlyrainin) {
        this.monthlyrainin = monthlyrainin;
    }

    public double getTotalrainin() {
        return totalrainin;
    }

    public void setTotalrainin(double totalrainin) {
        this.totalrainin = totalrainin;
    }

    public double getSolarradiation() {
        return solarradiation;
    }

    public void setSolarradiation(double solarradiation) {
        this.solarradiation = solarradiation;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getFeelsLikein() {
        return feelsLikein;
    }

    public void setFeelsLikein(double feelsLikein) {
        this.feelsLikein = feelsLikein;
    }

    public double getDewPointin() {
        return dewPointin;
    }

    public void setDewPointin(double dewPointin) {
        this.dewPointin = dewPointin;
    }

    public String getLastRain() {
        return lastRain;
    }

    public void setLastRain(String lastRain) {
        this.lastRain = lastRain;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
