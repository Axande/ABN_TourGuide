package com.example.andrei.abn_tourguidev3;

/**
 * Created by Andrei on 3/1/2018.
 */

public class Location {

    private int art = -1;
    private String name = "";
    private String details = "";
    private String location = "";
    private String phone = "";
    private int category = 0; // the category it should be displayed
    private String website = "";

    public Location(String name, String details, String location, String phone, int category, int art) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.phone = phone;
        this.category = category;
        this.art = art;
    }

    public Location(String name, String details, String location, String phone, int category) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.phone = phone;
        this.category = category;
    }

    public Location(String name, String details, String location, String phone, int category, int art, String website) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.phone = phone;
        this.category = category;
        this.art = art;
        this.website = website;
    }

    /**
     * Return the Id of the art resource for the current location object.
     *
     * @return art
     */
    public int getArt() {
        return this.art;
    }

    /**
     * Return the name of the location.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the details about the location.
     *
     * @return details
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * Return the location coordinates.
     *
     * @return location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Return the phone details of the location.
     *
     * @return phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Return the category of the current location.
     *
     * @return category
     */
    public int getCategory() {
        return this.category;
    }

    /**
     * Return the website of the current location.
     *
     * @return website
     */
    public String getWebsite() {
        if (!website.isEmpty()) return website;
        return null;
    }
}
