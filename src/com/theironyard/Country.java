package com.theironyard;

/**
 * Created by will on 5/26/16.
 */
public class Country {
    String abbreviation;
    String name;

    public Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
