/*public class HuffmanNode implements Comparable {

    public HuffmanNode parent;
    public HuffmanNode zero;
    public HuffmanNode one;

    public int frequency;

    public byte particularByte;

    HuffmanNode()
    {
        frequency = 0;
        parent =
    }


}
<<<<<<< Updated upstream
*/
=======
*/

public class HuffmanNode implements Comparable<HuffmanNode> {


    //if no parents, we are root
    //if no children, we are leaf
    //if have children and parents, we are internal node

    //left and right children of this HuffmanNode
    HuffmanNode zero = null;
    HuffmanNode one = null;
    HuffmanNode parent = null;

    //this is the value of the HuffmanNode
    private byte value;
    private int freq;

    //creates HuffmanNode from byte and value
    HuffmanNode(final byte b, final int f) {
        this.value = b;
        this.freq = f;
    }

    //create new HuffmanNode from two nodes
    HuffmanNode(HuffmanNode left, HuffmanNode right) {
        this.zero = left;
        this.one = right;
        this.freq = (left.freq + right.freq);
        zero.parent = this;
        one.parent = this;
    }

    @Override
    public int compareTo(HuffmanNode n) {
        if (this.freq < n.freq) {
            return -1; //weighs less
        } else if (this.freq > n.freq) {
            return +1; //weighs more
        } else {
            return 0; //the same weight as this
        }
    }

    public byte getValue() {
        return value;
    }
    public int getFreq() {
        return freq;
    }
}
>>>>>>> Stashed changes
