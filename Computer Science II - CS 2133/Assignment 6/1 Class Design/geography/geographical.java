package geography;


import java.util.ArrayList;

/**
 * Parent class for all geographical objects
 */
abstract class geographical {


    private geography.coordinates coordinates;
    private String name;
    private ArrayList<boundary> Boundaries;
    private double area;

    /**
     * Default constructor creates geographical object with null data
     */
    geographical() {
        coordinates = new coordinates();
        name = null;
    }

    /**
     * Constructs geographical with name, location and area
     * @param name store into private name
     * @param location stored into private location
     * @param area stored into private area
     */
    geographical(String name, coordinates location, double area)
    {
        this.coordinates = location;
        this.name = name;
        this.area = area;
    }

    /**
     * Constructs geographical with name and area
     * @param name name stored into private name
     * @param area area stored into private area
     */
    geographical(String name, double area)
    {
        this.coordinates = null;
        this.name = name;
        this.area = area;
    }

    /**
     * Constructs geographical with location
     * @param location pass a coordinate value for use with looking up location of geopgrahical
     */
    geographical(coordinates location) {
        this.coordinates = location;
        this.name = null;
        this.area = -1;
    }

    /**
     * Constructs geographical with only name
     * @param name Name of geographical object
     */
    geographical(String name) {
        this.coordinates = null;
        this.name = name;
        this.area = -1;
    }

    /**
     * Constructs geographical with name and location
     * @param name Name of geographical object
     * @param location Location as @coordinates
     */
    geographical(String name, coordinates location) {
        this.coordinates = location;
        this.name = name;
        this.area = -1;
    }

    /**
     * Getter for coordinates
     * @return Returns coordinates known by geographical
     */
    public coordinates getCoordinates()
    {
        return this.coordinates;
    }

    /**
     * Set new coordinates
     * @param Coordinates Pass coordinate object to set location of geographical
     */
    public void setCoordinates(coordinates Coordinates)
    {
        coordinates = Coordinates;
    }


    /**
     *     returns old coordinateX and sets new coordinates X
     */
    int setCoordinateX(int x) {
        int oldCoordinateX = coordinates.getCoordinateX();
        coordinates.setCoordinateX(x);
        return oldCoordinateX;
    }

    /**
     *
     * @param y sets new coordinates Y
     * @return returns old coordinateY
     */
    int setCoordinatesY(int y) {
        int oldCoordinateY = coordinates.getCoordinateX();
        coordinates.setCoordinateY(y);
        return oldCoordinateY;
    }


    /**
     *
     * @return returns name of geographical object
     */
    String getName() {
        return name;
    }

    /**
     *
     * @param name sets name of geographical object
     * @return returns old name.
     */
    String setName(String name) {
        String oldName = this.name;
        this.name = name;
        return oldName;
    }

    /**
     *
     * @param Boundary Add boundaries to this place
     */
    public void addBoundary(boundary Boundary) {
        Boundary.addPlace(this);
        Boundaries.add(Boundary);
    }

    /**
     * Creates an array list by doing a loop
     Loop loop passes through all Places and and checks to see if they have
     boundary with same ID as the boundaries in this object, (using this.Boundaries.getId()). If they do they are added to a new ArrayList which will be returned.
     * @return Returns neighbors connected to this
     */
    public ArrayList<geographical> neighbors(ArrayList<geographical> Places)
    {
        ArrayList<geographical> Neighbors = new ArrayList<>();
        /*
        Creates an array list by doing a loop
        Loop loop passes through all Places and and checks to see if they have
        boundary with same ID as the boundaries in this object, (using this.Boundaries.getId()). If they do they are added to a new ArrayList which will be returned.
         */
        return Neighbors;
    }

    /**
     *
     * @return Returns area for geographical
     */
    double area()
    {
        return area;
    }

    /**
     *
     * @param area Sets area to this
     */
    void area(double area)
    {
        this.area = area;
    }


}
