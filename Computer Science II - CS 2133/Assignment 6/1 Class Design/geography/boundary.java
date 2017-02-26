package geography;

import java.util.ArrayList;

/**
 * Boundary Class represents boundaries between other @geographical objects
 *
 */
public class boundary {

    private coordinates beginning;
    private coordinates end;
    private static int count = 0;
    private int id;

    ArrayList<geographical> Places;

    /**
     *
     * @param beginning This will mark the coordinates for the beginning of the boundary
     * @param end This will mark the coordinates for the end of the boundary
     */
    boundary(coordinates beginning, coordinates end)
    {
        this.beginning = beginning;
        this.end = end;
        count++;
        this.id = count;
    }

    /**
     *
     * @return Returns distance of boundary using @beginning and @end
     */
    public double boundaryLength()
    {
        double dist;


        int X1 = beginning.getCoordinateX();
        int X2 = end.getCoordinateX();
        int Y1 = beginning.getCoordinateY();
        int Y2 = end.getCoordinateY();


        dist = Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));

        return dist;
    }

    /**
     *
     * @return getter for Places, returns list of places which use this object as boundary
     */
    public ArrayList<geographical> borderOf()
    {
        return Places;
    }

    /**
     *
     * @param Place Place to be added to this object, used when adding boundary
     */
    void addPlace(geographical Place)
    {
     Places.add(Place);
    }

    /**
     *
     * @return getter for id, used to identify boundary by number
     */
    int getId()
    {
        return id;
    }

}
