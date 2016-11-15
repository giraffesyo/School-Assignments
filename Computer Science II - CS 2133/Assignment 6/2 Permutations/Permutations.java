import java.util.ArrayList;
import java.util.List;

public class Permutations<E> {

    List<E> currentList; //list of permutations
    boolean haveNext;

    public int size()
    {
        return currentList.size();
    }

    public boolean isEmpty()
    {
        return currentList.isEmpty();
    }


    public Permutations(List<E> list) {



    }

    public boolean hasNext() {

    }

    public List<E> next() {


    }

    //should return a list of permutations, receives a list of items originally
    private void generatePermutations(Permutations original)
    {
        if (isEmpty()) {
            haveNext = false;
        } else {

        }
    }
}
