package geography;

import java.util.ArrayList;

public class country extends geographical {

    ArrayList<state> states;


    country(String name)
    {
        super(name);
    }

    public void addState(state State)
    {
        State.setCountry(this);
        states.add(State);
    }

    public ArrayList<state> getStates()
    {
        return states;
    }




}
