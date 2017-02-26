# 2 Permutations (30 points)
Implement a class that works like an iterator and generates all possible permutations of a list.

It cannot actually be an Iterator, because the official Java Iterator interface looks like the following:

```java
public interface Iterator<E> {
public boolean hasNext();
public E next();
public void remove();
}
```

The `next()` method of a Java iterator returns an element of a collection, but our permutation generator must return a whole list.
Nevertheless, we will adopt the mechanics of iterators.

Create a Permutations object that implements the following three methods (at least):
```java
public class Permutations<E> {
public Permutations(List<E> list);
public boolean hasNext();
public List<E> next();
}
```

Notice the difference? We should be able to call the constructor with an arbitrary list. Then,
as long as `hasNext()` returns `true`, we should be able to call `next()` and get a new permutation of
our list.

The easiest way to generate permutations is (not surprisingly) recursively. 

The algorithm for creating a Permutations object is as follows:
- (Base case) If I am a **P**ermutations object of list length 0, do nothing, except to note that I
should always return false when `hasNext()` is called.
- (Recursive case) Remove and remember the first element (**c**) from the list.
- Create and remember a new Permutations object (**P**) with the leftover list.
- Obtain and remember the first permutation (**L**) from this new object, or an empty list if it
has none (because it is size 0).
- Initialize an index counter (**i**) to 0.

Each time the next() method is called on a Permutations object, it should do the following:
- Return a copy of **L** with **c** inserted at position **i**. Increment **i**.
- Once i becomes too large, set **L** to `P.next()` and reset **i** to 0.
- If **P** has no next permutation, then this object is finished as well. `hasNext()` should return
`false` from here on out.
Here's how it works for the list [0, 1, 2]:
- For each permutation of [1, 2],
- Insert 0 into each position in the list.

Thus successive calls to next() return [0, 1, 2], [1, 0, 2], [1, 2, 0], [0, 2, 1], [2, 0, 1] and [2, 1, 0].

After this last list is returned, `hasNext()` should return `false`.

Hint: The list you return should be a newly-created one, either a LinkedList or an ArrayList
(your choice), with elements copied over. 

Don't try to use the same list that you were given in the constructor, because you'd be disassembling it and reassembling it at multiple levels of recursion,
and it's almost impossible to keep it straight and do it right.

Extra Credit: You should really think about doing this one, because it's a great way to test
your Permutations object. Use your Permutations object to implement the exponential NP sort
that we talked about in class. Generate all of the permutations of a list in turn, checking each one
to see if it's sorted. Stop when you find the sorted list. How long a list can you sort using this
algorithm, before the time it takes becomes intolerable?
