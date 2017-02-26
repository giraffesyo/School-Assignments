package geography;

public class coordinates {

    private int coordinateX;
    private int coordinateY;

    /**
     * -1 coordinates means not a known location
     */
    public coordinates() {
        coordinateX = -1;
        coordinateY = -1;
    }

    /**
     * known coordinates
     * @param x x coordinate
     * @param y y coordinate
     */
    public coordinates(int x, int y) {
        coordinateX = x;
        coordinateY = y;
    }

    /**
     *
     * @return Getter for X
     */
    int getCoordinateX() {
        return coordinateX;
    }

    /**
     *
     * @return Getter for Y
     */
    int getCoordinateY() {
        return coordinateY;
    }

    /**
     *
     * @param x Setter for X
     */
    void setCoordinateX(int x) {
        coordinateX = x;
    }

    /**
     *
     * @param y Setter for Y
     */
    void setCoordinateY(int y) {
        coordinateY = y;
    }


}
