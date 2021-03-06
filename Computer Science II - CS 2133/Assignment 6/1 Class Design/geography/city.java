package geography;

import java.util.ArrayList;

public class city extends geographical {


    boolean isCapitalCity;
    state State;
    ArrayList<river> Rivers;


    /**
     * city will have -1 in both X and Y coordinates
     */
    city() {
        super();
        isCapitalCity = false;
        Rivers = new ArrayList<>();
    }

    /**
     * @param location create city with coordinates
     */
    city(coordinates location) {
        super(location);
        isCapitalCity = false;
        Rivers = new ArrayList<>();
    }


    /**
     * @param name create a city with just name
     */
    city(String name) {
        super(name);
        isCapitalCity = false;
        Rivers = new ArrayList<>();
    }


    /**
     * @param name     create city with this name
     * @param location create city with this location as @coordinates
     */
    city(String name, coordinates location) {
        super(name, location);
        isCapitalCity = false;
        Rivers = new ArrayList<>();
    }

    /**
     * create city with name, coordinates, and knowledge of it being the capital
     */
    city(String name, coordinates location, boolean isCapitalCity) {
        super(name, location);
        this.isCapitalCity = isCapitalCity;
        Rivers = new ArrayList<>();
    }

    /**
     * Create city with name, state, location, and knowledge of it being the capital
     */
    city(state State, String name, coordinates location, boolean isCapitalCity) {
        super(name, location);
        this.State = State;
        this.isCapitalCity = isCapitalCity;
        Rivers = new ArrayList<>();
    }

    /**
     * create city with all parameters used
     */
    city(state State, String name, coordinates location, boolean isCapitalCity, double area) {
        super(name, location, area);
        this.State = State;
        this.isCapitalCity = isCapitalCity;
        Rivers = new ArrayList<>();
    }


    /**
     *
     * @return Returns distance between city A and B
     */
    public static double distance(city A, city B) {
        double dist;

        geography.coordinates coordinatesA = A.getCoordinates();
        geography.coordinates coordinatesB = B.getCoordinates();
        int X1 = coordinatesA.getCoordinateX();
        int X2 = coordinatesB.getCoordinateX();
        int Y1 = coordinatesA.getCoordinateY();
        int Y2 = coordinatesB.getCoordinateY();


        dist = Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));

        return dist;
    }

    /**
     *
     * @return returns true if it is the capital of the state it belongs to
     */
    public boolean Capital() {
        return isCapitalCity;
    }

    /**
     *
     * @param isCapitalCity Sets capital true/false
     */
    public void Capital(boolean isCapitalCity) {
        this.isCapitalCity = isCapitalCity;
    }


    /**
     *
     * @return Gets state this city belongs to
     */
    public state getState() {
        return this.State;
    }

    /**
     *
     * @param parentState Set state that this city belogns to
     */
    public void setState(state parentState) {
        this.State = parentState;
    }

    /**
     *
     * @param River Add river to city and city to river.
     */
    public void addRiver(river River) {
        River.addCity(this);
        Rivers.add(River);
    }

    /**
     *
     * @return Get rivers that run through city
     */
    public ArrayList<river> getRivers() {
        return Rivers;
    }


    /**
     *
     * @return Return area
     */
    @Override
    public double area() {
        return super.area();
    }

    /**
     *
     * @param area Sets area to this
     */
    @Override
    public void area(double area) {
        super.area(area);
    }


}
