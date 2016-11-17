import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations<E> {
    private List<E> list;
    private Permutations<E> child;
    private final int size;
    private final E first;
    private int index = 0;

    public Permutations(final List<E> oList) {
        final LinkedList<E> copy = new LinkedList<>(oList);
        this.size = copy.size();
        if (size > 0) {
            this.first = copy.removeFirst();
            this.child = new Permutations<>(copy);
            this.list = this.child.next();
        } else this.first = null;
    }

    public boolean hasNext() {
        return size != 0 && index < size;
    }

    public List<E> next() {
        if (!hasNext()) return null;
        if (list == null) {
            ++index;
            return Collections.singletonList(first);
        }
        final LinkedList<E> n = new LinkedList<>(list);
        n.add(index++, first);
        if (index == size && child.hasNext()) {
            this.list = child.next();
            index = 0;
        }
        return n;
    }

    public static <E extends Comparable<E>> List<E> sort(final List<E> list) {
        if (list == null || list.size() == 1) return list;
        final Permutations<E> p = new Permutations<>(list);
        loop:
        while (p.hasNext()) {
            final List<E> l = p.next();
            for (int index = 1; index < l.size(); ++index) {
                if (l.get(index - 1).compareTo(l.get(index)) > 0) continue loop;
            }
            return l;
        }
        return null;
    }
}
