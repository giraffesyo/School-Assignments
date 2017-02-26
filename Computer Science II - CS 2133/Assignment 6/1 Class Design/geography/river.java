package geography;


import java.util.ArrayList;

public class river extends geographical {

    ArrayList<city> cities; //cities that the water flows through

    /**
     * default river object, knows null
     */
    public river()
    {
        super();
    }

    /**
     * River object with name
     * @param name Name of river
     */
    public river(String name)
    {
        super(name);
    }

    /**
     * City list holds all cities river passes through
     * @param City City river passes through
     */
    void addCity(city City)
    {
        cities.add(City);
    }

    /**
     *
     * @return get cities river runs through
     */
    public ArrayList<city> getCities()
    {
        return cities;
    }




}
