package geography;


import java.util.ArrayList;

public class river extends geographical {

    ArrayList<city> cities; //cities that the water flows through

    public river()
    {
        super();
    }

    public river(String name)
    {
        super(name);
    }

    void addCity(city City)
    {
        cities.add(City);
    }

    //get cities river runs through
    public ArrayList<city> getCities()
    {
        return cities;
    }




}
