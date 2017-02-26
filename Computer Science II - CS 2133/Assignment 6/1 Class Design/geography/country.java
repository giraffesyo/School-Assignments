package geography;

import java.util.ArrayList;

public class country extends geographical {

    ArrayList<state> states;

    /**
     *
     * @param name Country name
     */
    country(String name) {
        super(name);
    }

    /**
     *
     * @param name Country name
     * @param area Country area
     */
    country(String name, double area) {
        super(name, area);
    }

    /**
     *
     * @param State Adds this state to country
     */
    public void addState(state State) {
        State.setCountry(this);
        states.add(State);
    }

    /**
     *
     * @return returns states
     */
    public ArrayList<state> getStates() {
        return states;
    }

    /**
     *
     * @return returns area
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
