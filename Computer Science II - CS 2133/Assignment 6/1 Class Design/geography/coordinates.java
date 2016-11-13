package geography;

public class coordinates {

    private int coordinateX;
    private int coordinateY;

    //-1 coordinates means not a known location
    public coordinates() {
        coordinateX = -1;
        coordinateY = -1;
    }

    //known coordinates
    public coordinates(int x, int y) {
        coordinateX = x;
        coordinateY = y;
    }

    int getCoordinateX() {
        return coordinateX;
    }

    int getCoordinateY() {
        return coordinateY;
    }

    void setCoordinateX(int x) {
        coordinateX = x;
    }

    void setCoordinateY(int y) {
        coordinateY = y;
    }


}
