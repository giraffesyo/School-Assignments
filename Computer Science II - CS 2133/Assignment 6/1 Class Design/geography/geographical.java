package geography;


import java.util.ArrayList;

abstract class geographical {


    private geography.coordinates coordinates;
    private String name;
    public ArrayList<boundary> Boundaries;

    geographical() {
        coordinates = new coordinates();
        name = null;
    }

    geographical(coordinates location) {
        this.coordinates = location;
        name = null;
    }

    geographical(String name) {
        coordinates = null;
        this.name = name;
    }

    geographical(String name, coordinates location) {
        this.coordinates = location;
        this.name = name;
    }

    public coordinates getCoordinates()
    {
        return this.coordinates;
    }

    public void setCoordinates(coordinates Coordinates)
    {
        coordinates = Coordinates;
    }


    //returns old coordinateX and sets new coordinates X
    int setCoordinateX(int x) {
        int oldCoordinateX = coordinates.getCoordinateX();
        coordinates.setCoordinateX(x);
        return oldCoordinateX;
    }

    //returns old coordinateY and sets new coordinates Y
    int setCoordinatesY(int y) {
        int oldCoordinateY = coordinates.getCoordinateX();
        coordinates.setCoordinateY(y);
        return oldCoordinateY;
    }


    //returns name of geographical object
    String getName() {
        return name;
    }

    //sets name of geographical object and returns old name.
    String setName(String name) {
        String oldName = this.name;
        this.name = name;
        return oldName;
    }

    //Add boundaries to this place
    public void addBoundary(boundary Boundary) {
        Boundary.addPlace(this);
        Boundaries.add(Boundary);
    }

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

    //area()

}
