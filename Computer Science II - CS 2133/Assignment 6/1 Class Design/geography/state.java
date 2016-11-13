package geography;

import java.util.ArrayList;

public class state extends geographical {

    ArrayList<city> cities;
    city CapitalCity;
    country parentCountry;



    //Constructs new state object with empty list of cities and null name
    state() {
        cities = new ArrayList<>();
    }

    //Constructs new state with specified name and empty list of cities
    state(String name) {
        super(name);
        cities = new ArrayList<>();
    }

    //Add a new city to this state;
    public void addCity(String name, coordinates location, boolean isCapitalCity) {
        city newCity = new city(this, name, location, isCapitalCity);
        if (isCapitalCity) {
            CapitalCity = newCity;
            this.setCoordinates(newCity.getCoordinates());
        }
        cities.add(newCity);
    }

    //Add Existing city to this state
    public void addCity(city City, boolean isCapitalCity) {
        City.Capital(isCapitalCity);
        City.setState(this);
        if (isCapitalCity) {
            CapitalCity = City;
            this.setCoordinates(City.getCoordinates());
        }
        cities.add(City);

    }

    //Sets Capital City
    public void Capital(city CapitalCity)
    {
        this.CapitalCity = CapitalCity;
    }

    //returns Capital City
    public city Capital()
    {
        return CapitalCity;
    }


    public void setCountry(country parentCountry)
    {
        this.parentCountry = parentCountry;
    }

    public ArrayList<city> getCities()
    {
        return cities;
    }

    public country getCountry()
    {
        return parentCountry;
    }



}
