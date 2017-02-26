package geography;

import java.util.ArrayList;

public class state extends geographical {

    ArrayList<city> cities;
    city CapitalCity;
    country parentCountry;


    /**
     * constructs new state object with empty list of cities and null name
     */
    state() {
        cities = new ArrayList<>();
    }

    /**
     * Constructs new state with specified name and empty list of cities
     * @param name Name of state
     */
    state(String name) {
        super(name);
        cities = new ArrayList<>();
    }

    /**
     * Add a new city to this state
     * @param name Name of city
     * @param location Location of city
     * @param isCapitalCity Is this the capital city?
     */
    public void addCity(String name, coordinates location, boolean isCapitalCity) {
        city newCity = new city(this, name, location, isCapitalCity);
        if (isCapitalCity) {
            CapitalCity = newCity;
            this.setCoordinates(newCity.getCoordinates());
        }
        cities.add(newCity);
    }

    /**
     * Add Existing city to this state
     * @param City existing @city object
     * @param isCapitalCity is this the capital?
     */
    public void addCity(city City, boolean isCapitalCity) {
        City.Capital(isCapitalCity);
        City.setState(this);
        if (isCapitalCity) {
            CapitalCity = City;
            this.setCoordinates(City.getCoordinates());
        }
        cities.add(City);

    }

    /**
     *
     * @param CapitalCity Sets Capital City
     */
    public void Capital(city CapitalCity)
    {
        this.CapitalCity = CapitalCity;
    }

    /**
     *
     * @return returns Capital City
     */
    public city Capital()
    {
        return CapitalCity;
    }


    /**
     *
     * @param parentCountry sets parent country
     */
    public void setCountry(country parentCountry)
    {
        this.parentCountry = parentCountry;
    }

    /**
     *
     * @return Gets list of cities in this state
     */
    public ArrayList<city> getCities()
    {
        return cities;
    }

    /**
     *
     * @return Get country this state is in
     */
    public country getCountry()
    {
        return parentCountry;
    }

    /**
     *
     * @return Return area of state
     */
    @Override
    public double area()
    {
        return super.area();
    }

    /**
     *
     * @param area Sets area to this
     */
    @Override
    public void area(double area)
    {
        super.area(area);
    }

}
